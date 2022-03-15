package com.henry.fowler.Photography.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "photoDataCollection")
public class PhotoData {
    @Id
    private String id;
    private String filename;
    private String path;
    private float filesize;
    private String location;
    private String description;
    private Date dateTaken;

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

    public Date getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }

    public PhotoData(){

    }

    public PhotoData(String filename, String path, float filesize, String location, String description, Date dateTaken){
        this.filename = filename;
        this.path = path;
        this.filesize = filesize;
        this.location = location;
        this.description = description;
        this.dateTaken = dateTaken;
    }


    @Override
    public String toString(){
        return "PhotoData{" +
                "id=" + id + '\'' +
                ", filename=" + filename + '\'' +
                ", path=" + path + '\'' +
                ", filesize=" + filesize +
                ", location=" + location + '\'' +
                ", description=" + description + '\'' +
                ", timeTaken=" + dateTaken +
                "}";
    }


}
