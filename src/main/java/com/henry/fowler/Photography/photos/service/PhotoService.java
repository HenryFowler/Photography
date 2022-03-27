package com.henry.fowler.Photography.photos.service;

import com.henry.fowler.Photography.photodata.model.PhotoData;
import com.henry.fowler.Photography.photos.model.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {

    public Photo getPhoto(String id);

    public String addPhoto(String title, String description, String location, MultipartFile file) throws IOException;

    public Photo findByFilename(String filename);

    public void deletePhotoById(String id);

    public void deletePhotoByFilename(String filename);
}
