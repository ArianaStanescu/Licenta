package com.app.licenta.controllers;

import com.app.licenta.entities.AdImage;
import com.app.licenta.services.AdImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/ad-images")
public class AdImageController {

    @Autowired
    private AdImageService adImageService;

    @GetMapping("/{adId}")
    public ResponseEntity<byte[]> getImageByAdId(@PathVariable Integer adId) {
        Optional<AdImage> adImage = adImageService.findByAdId(adId);

        if (adImage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        byte[] imageData = adImage.get().getImageData();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); // Change to IMAGE_PNG if necessary

        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }
}