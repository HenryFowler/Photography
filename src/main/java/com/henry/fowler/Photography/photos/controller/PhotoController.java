package com.henry.fowler.Photography.photos.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import com.henry.fowler.Photography.photodata.dto.PhotoDataDTO;
import com.henry.fowler.Photography.photodata.model.PhotoData;
import com.henry.fowler.Photography.photodata.util.ObjectMapperUtils;
import com.henry.fowler.Photography.photos.model.Photo;
import com.henry.fowler.Photography.photos.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class PhotoController {

    @Autowired
    private PhotoService photoService;


    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
        try{
            Photo photo = photoService.getPhoto(id);
            model.addAttribute("title", photo.getPhotoData().getTitle());
            model.addAttribute("description", photo.getPhotoData().getDescription());
            model.addAttribute("location", photo.getPhotoData().getLocation());
            model.addAttribute("filename", photo.getPhotoData().getFilename());
            model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
            return "photos";
        } catch (Exception e) {
            return"redirect:/main";
        }
    }

    @GetMapping("/photos/upload")
    public String uploadPhoto(Model model) {
        model.addAttribute("message", "hello");
        return "uploadPhoto";
    }

    @PostMapping("/photos/add")
    public String addPhoto(@RequestParam("title") String title, @RequestParam("description") String description, @RequestParam("location") String location, @RequestParam("image") MultipartFile image, Model model) throws IOException {
        String id = photoService.addPhoto(title, description, location, image);
        return "redirect:/photos/" + id;
    }

    @DeleteMapping("/photos/delete")
    public String deletePhoto(@RequestParam("filename") String filename, Model model) {
        String id = photoService.findByFilename(filename).getId();
        System.out.println(id);
        System.out.println(photoService.findByFilename(filename));
        photoService.deletePhotoById(id);
        return "redirect:/main/";
    }


    @GetMapping("/photos/getByFileName")
    public String getPhotoByFileName(@RequestParam("filename") String filename, Model model){
        Photo photo = photoService.findByFilename(filename);
        return "redirect:/photos/" + photo.getId();
    }
}