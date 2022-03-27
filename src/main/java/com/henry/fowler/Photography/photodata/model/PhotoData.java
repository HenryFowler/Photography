package com.henry.fowler.Photography.photodata.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "photoDataCollection")
public class PhotoData {
    @Id
    private String id;
    private String filename;
    private float filesize;
    private String location;
    private String description;
    private String title;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public float getFilesize() {
        return filesize;
    }

    public void setFilesize(float filesize) {
        this.filesize = filesize;
    }

    public PhotoData(){

    }

    public PhotoData(String filename, float filesize, String location, String description, String title){
        this.filename = filename;
        this.filesize = filesize;
        this.location = location;
        this.description = description;
        this.title = title;
    }


    @Override
    public String toString(){
        return "PhotoData{" +
                "id=" + id + '\'' +
                ", filename=" + filename + '\'' +
                ", title=" + title + '\'' +
                ", filesize=" + filesize +
                ", location=" + location +  '\'' +
                ", description=" + description + '\'' +
                ", title=" + title + '\'' +
                "}";
    }


}
