package com.henry.fowler.Photography.photos.service.impl;

import com.henry.fowler.Photography.photodata.model.PhotoData;
import com.henry.fowler.Photography.photodata.service.PhotoDataService;
import com.henry.fowler.Photography.photos.model.Photo;
import com.henry.fowler.Photography.photos.repository.PhotoRepository;
import com.henry.fowler.Photography.photos.service.PhotoService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Autowired
    private PhotoDataService photoDataService;

    @Override
    public Photo getPhoto(String id) {
        if (id != null)
        {
            Photo photo = photoRepository.findById(id).get();
            photo.setPhotoData(photoDataService.findByFilename(photo.getPhotoData().getFilename()));
            return photo;
        }
        else
            return new Photo();

    }

    @Override
    public String addPhoto(String title, String description, String location, MultipartFile file) throws IOException{
        String filename = file.getOriginalFilename();
        long filesize = file.getSize();
        PhotoData photoData = photoDataService.savePhotoDataFromFrontEnd(filename, filesize, location, description, title);
        String dataId = photoData.getId();
        Photo photo = new Photo(photoData, dataId);
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = photoRepository.insert(photo);
        return photo.getId();
    }

    @Override
    public Photo findByFilename(String filename){
        PhotoData photoData = photoDataService.findByFilename(filename);
            String dataId = photoData.getId();
            return photoRepository.findByDataId(dataId);
    }

    @Override
    public void deletePhotoById(String id){
        photoDataService.deletePhotoDataById(getPhoto(id).getDataId());
        photoRepository.deleteById(id);
    }

    @Override
    public void deletePhotoByFilename(String filename){
        PhotoData photoData = photoDataService.findByFilename(filename);
        String dataId = photoData.getId();
        System.out.println(dataId);
        Photo photo = photoRepository.findByDataId(dataId);
        photoDataService.deletePhotoDataById(dataId);
        photoRepository.deleteById(photo.getId());
    }

}
