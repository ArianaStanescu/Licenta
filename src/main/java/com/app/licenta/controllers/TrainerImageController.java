package com.app.licenta.controllers;

import com.app.licenta.entities.TrainerImage;
import com.app.licenta.services.TrainerImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trainer-images")
public class TrainerImageController {

    @Autowired
    private TrainerImageService trainerImageService;

    @GetMapping("/{trainerId}")
    public ResponseEntity<byte[]> getImageByTrainerId(@PathVariable Integer trainerId) {
        TrainerImage trainerImage = trainerImageService.getByTrainerId(trainerId);

        byte[] imageData = trainerImage.getImageData();

        HttpHeaders hetrainerers = new HttpHeaders();
        hetrainerers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageData, hetrainerers, HttpStatus.OK);
    }

    @DeleteMapping("/{trainerId}")
    public void deleteByTrainerId(@PathVariable Integer trainerId) {
        trainerImageService.deleteByTrainerId(trainerId);
    }
}