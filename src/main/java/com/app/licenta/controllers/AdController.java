package com.app.licenta.controllers;

import com.app.licenta.dtos.AdDto;
import com.app.licenta.dtos.AdUpdateDto;
import com.app.licenta.entities.*;
import com.app.licenta.mappers.ActivityMapper;
import com.app.licenta.mappers.AdMapper;
import com.app.licenta.services.ActivityService;
import com.app.licenta.services.AdImageService;
import com.app.licenta.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/ads")
public class AdController {

    @Autowired
    private AdService adService;

    @Autowired
    private AdMapper adMapper;

    @Autowired
    private ActivityMapper activityMapper;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private AdImageService adImageService;

    @GetMapping("/{id}")
    public AdDto get(@PathVariable Integer id) {
        Ad ad = adService.getById(id);
        return adMapper.adToAdDto(ad);
    }

    @GetMapping("/list/{activityId}")
    public Set<AdDto> findAllByActivityId(@PathVariable Integer activityId) {
        return adMapper.adListToAdDtoList(adService.findAllByActivityId(activityId));
    }

    @GetMapping("/search")
    public List<AdDto> searchAds(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) ActivityCategory category,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) Gender gender,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam() int pageNumber,
            @RequestParam() int pageSize,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDirection) {
        return adService.searchAds(title, category, minAge, maxAge, gender, minPrice, maxPrice, pageNumber, pageSize, sortBy, sortDirection)
                .stream()
                .map(adMapper::adToAdDto)
                .toList();
    }

    @PostMapping("/create/{activityId}")
    public AdDto create(@PathVariable Integer activityId,
                        @RequestPart("ad") AdDto adDto,
                        @RequestPart("image") MultipartFile imageFile) throws IOException {
        Ad adToCreate = adMapper.adDtoToAd(adDto);
        Ad createdAd = adService.createAd(adToCreate, activityId, imageFile.getBytes());

        return adMapper.adToAdDto(createdAd);
    }

    @PutMapping("/{id}")
    public AdUpdateDto update(@RequestBody AdUpdateDto adUpdateDto, @PathVariable Integer id) {
        return adMapper.adToAdUpdateDto(adService.update(id, adMapper.adUpdateDtoToAd(adUpdateDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id) {
        adService.deleteById(id);
    }
}
