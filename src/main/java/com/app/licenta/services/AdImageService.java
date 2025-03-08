package com.app.licenta.services;

import com.app.licenta.entities.Ad;
import com.app.licenta.entities.AdImage;
import com.app.licenta.repositories.AdImageRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class AdImageService {

    @Autowired
    private AdImageRepository adImageRepository;

    public AdImage save(Ad ad, MultipartFile file) throws IOException {
        AdImage image = new AdImage();
        image.setAd(ad);
        image.setImageData(file.getBytes());
        return adImageRepository.save(image);
    }

    public AdImage getByAdId(Integer adId) {
        return adImageRepository.findByAdId(adId)
                .orElseThrow(() -> new EntityNotFoundException("Image not found"));
    }

    public void deleteByAdId(Integer adId) {
        adImageRepository.deleteByAdId(adId);
    }
}