package com.henry.fowler.Photography.photodata.service.impl;

import com.henry.fowler.Photography.photodata.model.PhotoData;
import com.henry.fowler.Photography.photodata.service.PhotoDataService;
import com.henry.fowler.Photography.photodata.repository.PhotoDataRepository;
import com.henry.fowler.Photography.photos.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PhotoDataServiceImpl implements PhotoDataService {

    @Autowired
    private PhotoDataRepository photoDataRepository;

    @Override
    public List<PhotoData> findAll() {
        return photoDataRepository.findAll();
    }

    @Override
    public PhotoData findByFilename(String filename) { return photoDataRepository.findByFilename(filename);}

    @Override
    public List<PhotoData> findAllByOrderByFilesizeDesc() { return photoDataRepository.findAllByOrderByFilesizeDesc();}

    @Override
    public PhotoData saveOrUpdatePhotoData(PhotoData photoData) { return photoDataRepository.save(photoData); }

    @Override
    public PhotoData savePhotoDataFromFrontEnd(String filename, float filesize, String location, String description, String title) {
        PhotoData photoData = new PhotoData(filename, filesize, location, description, title);
        photoData = photoDataRepository.insert(photoData);
        return photoData;
    }

    @Override
    public void deletePhotoDataById(String id){
        photoDataRepository.deleteById(id);}
}
