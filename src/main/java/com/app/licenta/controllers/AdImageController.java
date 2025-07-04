package com.app.licenta.controllers;

import com.app.licenta.entities.AdImage;
import com.app.licenta.services.AdImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ad-images")
public class AdImageController {

    @Autowired
    private AdImageService adImageService;

    @GetMapping("/{adId}")
    public ResponseEntity<byte[]> getImageByAdId(@PathVariable Integer adId) {
        AdImage adImage = adImageService.getByAdId(adId);

        byte[] imageData = adImage.getImageData();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }

    @DeleteMapping("/{adId}")
    public void deleteByAdId(@PathVariable Integer adId) {
        adImageService.deleteByAdId(adId);
    }
}