package com.app.licenta.services;

import com.app.licenta.entities.Ad;
import com.app.licenta.entities.AdImage;
import com.app.licenta.repositories.AdImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class AdImageService {

    @Autowired
    private AdImageRepository adImageRepository;

    public AdImage saveImage(Ad ad, MultipartFile file) throws IOException {
        AdImage image = new AdImage();
        image.setAd(ad);
        image.setImageData(file.getBytes());
        return adImageRepository.save(image);
    }

    public Optional<AdImage> findByAdId(Integer adId) {
        return adImageRepository.findByAdId(adId);
    }

}