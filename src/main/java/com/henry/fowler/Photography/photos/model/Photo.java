package com.henry.fowler.Photography.photos.model;

import com.henry.fowler.Photography.photodata.model.PhotoData;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
public class Photo {

    @Id
    private String id;

    public Photo() {

    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    private String dataId;
    private Binary image;
    private PhotoData photoData;

    public Photo(PhotoData photoData, String dataId) {
        super();
        this.photoData = photoData;
        this.dataId = dataId;
    }

    public String getId() {
        return id;
    }

    public PhotoData getPhotoData() {return photoData;}

    public void setPhotoData(PhotoData photoData){this.photoData = photoData; }

    public void setId(String id) {
        this.id = id;
    }

    public Binary getImage() {
        return image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Photo [id=" + id + ", title=" + photoData.getTitle() + ", image=" + image + ", description=" + photoData.getDescription() + ", location=" + photoData.getLocation() + "]";
    }

}