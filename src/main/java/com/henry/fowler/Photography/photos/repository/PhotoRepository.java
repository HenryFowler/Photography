package com.henry.fowler.Photography.photos.repository;

import com.henry.fowler.Photography.photos.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> {

    Photo findByDataId(String dataId);

}
