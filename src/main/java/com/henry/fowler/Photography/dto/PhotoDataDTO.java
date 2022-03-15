package com.henry.fowler.Photography.dto;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public Date getTimeTaken() {
        return timeTaken;
    }

    public void setTimeTaken(Date timeTaken) {
        this.timeTaken = timeTaken;
    }

    private String id;
    private String filename;
    private String path;
    private float filesize;
    private String location;
    private String description;
    private Date timeTaken;

    public PhotoDataDTO(){

    }

    public PhotoDataDTO(String id, String filename, String path, float filesize, String location, String description, Date timeTaken){
        this.id = id;
        this.filename = filename;
        this.path = path;
        this.filesize = filesize;
        this.location = location;
        this.description = description;
        this.timeTaken = timeTaken;
    }


}
