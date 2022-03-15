package com.henry.fowler.Photography.service;

import com.henry.fowler.Photography.model.PhotoData;

import java.util.Date;
import java.util.List;

public interface PhotoDataService {

    List<PhotoData> findAll();

    PhotoData findByFilename(String filename);

    List<PhotoData> findAllByLocationLike(String location);

    PhotoData findByDateTaken(Date dateTaken);

    List<PhotoData> findAllByOrderByFilesizeDesc();

    PhotoData saveOrUpdatePhotoData(PhotoData photoData);

    void deletePhotoDataById(String id);
}
