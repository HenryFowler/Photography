package com.henry.fowler.Photography.photodata.repository;

import com.henry.fowler.Photography.photodata.model.PhotoData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface PhotoDataRepository extends MongoRepository<PhotoData, String> {
    PhotoData findByFilename(String filename);

    List<PhotoData> findAllByOrderByFilesizeDesc();
}
