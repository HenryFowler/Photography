package com.henry.fowler.Photography.repository;

import com.henry.fowler.Photography.model.PhotoData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface PhotoDataRepository extends MongoRepository<PhotoData, String> {
    PhotoData findByFilename(String filename);

    List<PhotoData> findAllByLocationLike(String location);

    List<PhotoData> findAllByOrderByFilesizeDesc();

    PhotoData findByDateTaken(Date dateTaken);
}
