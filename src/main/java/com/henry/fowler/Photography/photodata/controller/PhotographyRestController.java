package com.henry.fowler.Photography.photodata.controller;


import com.henry.fowler.Photography.photodata.dto.PhotoDataDTO;
import com.henry.fowler.Photography.photodata.model.PhotoData;
import com.henry.fowler.Photography.photodata.service.PhotoDataService;
import com.henry.fowler.Photography.photodata.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/api")
@RestController
public class PhotographyRestController {

        @Autowired
        private PhotoDataService photoDataService;

        @GetMapping(value = "/getPhotoData")
    public List<PhotoDataDTO> getAllPhotoData() {
            return ObjectMapperUtils.mapAll(photoDataService.findAll(), PhotoDataDTO.class);
        }

        @GetMapping(value = "/byFileName/{filename}")
        public PhotoDataDTO getPhotoByFileName(@PathVariable("filename") String filename) {
            return ObjectMapperUtils.map(photoDataService.findByFilename(filename), PhotoDataDTO.class);
        }

        @GetMapping (value = "/orderByFileSize")
        public List<PhotoDataDTO> findAllByOrderByFilesizeDesc() {
            return ObjectMapperUtils.mapAll(photoDataService.findAllByOrderByFilesizeDesc(), PhotoDataDTO.class);
        }

        @PostMapping (value = "/savePhotoData")
        public ResponseEntity<?> saveOrUpdatePhotoData(@RequestBody PhotoDataDTO photoDataDTO) {
            photoDataService.saveOrUpdatePhotoData(ObjectMapperUtils.map(photoDataDTO, PhotoData.class));
            return new ResponseEntity("Photo data added successfully", HttpStatus.OK);
        }

        @DeleteMapping (value = "/delete/{filename}")
        public ResponseEntity<?> deletePhotoByFileName(@PathVariable String filename) {
            photoDataService.deletePhotoDataById(photoDataService.findByFilename(filename).getId());
            return new ResponseEntity("Photo data deleted successfully", HttpStatus.OK);
        }

        @RequestMapping (value = "/help")
        public ResponseEntity<?> requestHelp(){
            return new ResponseEntity("HELP - Get all photo data: /getPhotoData - delete Photo Data: /delete/{filename} - Save or update Photo Data: /savePhotoData", HttpStatus.OK);
        }

}
