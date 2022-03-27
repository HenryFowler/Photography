package com.henry.fowler.Photography.photodata.service;

import com.henry.fowler.Photography.photodata.model.PhotoData;

import java.util.Date;
import java.util.List;

public interface PhotoDataService {

    List<PhotoData> findAll();

    PhotoData findByFilename(String filename);

    List<PhotoData> findAllByOrderByFilesizeDesc();

    PhotoData saveOrUpdatePhotoData(PhotoData photoData);

    PhotoData savePhotoDataFromFrontEnd(String filename, float filesize, String location, String description, String title);

    void deletePhotoDataById(String id);

}
