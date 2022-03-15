package com.henry.fowler.Photography.controller;


import com.henry.fowler.Photography.dto.PhotoDataDTO;
import com.henry.fowler.Photography.model.PhotoData;
import com.henry.fowler.Photography.service.PhotoDataService;
import com.henry.fowler.Photography.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping(value = "/photos")
@RestController
public class PhotographyRestController {

        @Autowired
        private PhotoDataService photoDataService;

        @GetMapping(value = "/")
    public List<PhotoDataDTO> getAllPhotoData() {
            return ObjectMapperUtils.mapAll(photoDataService.findAll(), PhotoDataDTO.class);
        }

        @GetMapping(value = "/byFileName/{filename}")
        public PhotoDataDTO getPhotoByFileName(@PathVariable("filename") String filename) {
            return ObjectMapperUtils.map(photoDataService.findByFilename(filename), PhotoDataDTO.class);
        }

        @GetMapping(value = "/byLocation/{location}")
        public List<PhotoDataDTO> findAllByLocationLike(@PathVariable("location") String location){
            return ObjectMapperUtils.mapAll(photoDataService.findAllByLocationLike(location), PhotoDataDTO.class);
        }

        @GetMapping(value = "/byDate/{dateTaken}")
        public PhotoDataDTO getPhotoByDateTaken(@PathVariable("dateTaken") Date dateTaken){
            return ObjectMapperUtils.map(photoDataService.findByDateTaken(dateTaken), PhotoDataDTO.class);
        }

        @GetMapping (value = "/orderByFileSize")
        public List<PhotoDataDTO> findAllByOrderByFilesizeDesc() {
            return ObjectMapperUtils.mapAll(photoDataService.findAllByOrderByFilesizeDesc(), PhotoDataDTO.class);
        }

        @PostMapping (value = "/save")
        public ResponseEntity<?> saveOrUpdatePhotoData(@RequestBody PhotoDataDTO photoDataDTO) {
            photoDataService.saveOrUpdatePhotoData(ObjectMapperUtils.map(photoDataDTO, PhotoData.class));
            return new ResponseEntity("Photo data added successfully", HttpStatus.OK);
        }

        @DeleteMapping (value = "/delete/{filename}")
        public ResponseEntity<?> deletePhotoByFileName(@PathVariable String filename) {
            photoDataService.deletePhotoDataById(photoDataService.findByFilename(filename).getId());
            return new ResponseEntity("Photo data deleted successfully", HttpStatus.OK);
        }

}
