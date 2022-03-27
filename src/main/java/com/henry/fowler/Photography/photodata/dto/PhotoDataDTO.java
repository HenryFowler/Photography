package com.henry.fowler.Photography.photodata.dto;

import org.bson.types.Binary;

import java.util.Date;

public class PhotoDataDTO {

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


    private String id;
    private String filename;
    private float filesize;
    private String location;
    private String description;
    private String title;

    public PhotoDataDTO() {

    }

    public PhotoDataDTO(String id, String filename, float filesize, String location, String description, String title) {
        this.filename = filename;
        this.filesize = filesize;
        this.location = location;
        this.description = description;
        this.title = title;
    }

        public String getTitle () {
            return title;
        }

        public void setTitle (String title){
            this.title = title;
        }

}