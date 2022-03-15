package com.henry.fowler.Photography.service.impl;

import com.henry.fowler.Photography.model.PhotoData;
import com.henry.fowler.Photography.repository.PhotoDataRepository;
import com.henry.fowler.Photography.service.PhotoDataService;
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
    public List<PhotoData> findAllByLocationLike(String location) {
        return photoDataRepository.findAllByLocationLike(location);
    }

    @Override
    public PhotoData findByFilename(String filename) { return photoDataRepository.findByFilename(filename);}

    @Override
    public PhotoData findByDateTaken(Date dateTaken) {return photoDataRepository.findByDateTaken(dateTaken);}

    @Override
    public List<PhotoData> findAllByOrderByFilesizeDesc() { return photoDataRepository.findAllByOrderByFilesizeDesc();}

    @Override
    public PhotoData saveOrUpdatePhotoData(PhotoData photoData) { return photoDataRepository.save(photoData); }

    @Override
    public void deletePhotoDataById(String id){photoDataRepository.deleteById(id);}
}
