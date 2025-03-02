package com.app.licenta.controllers;

import com.app.licenta.dtos.AdDto;
import com.app.licenta.dtos.AdUpdateDto;
import com.app.licenta.entities.Activity;
import com.app.licenta.entities.ActivityCategory;
import com.app.licenta.entities.Ad;
import com.app.licenta.entities.Gender;
import com.app.licenta.mappers.ActivityMapper;
import com.app.licenta.mappers.AdMapper;
import com.app.licenta.services.ActivityService;
import com.app.licenta.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

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
    public AdDto create(@PathVariable Integer activityId, @RequestBody AdDto adDto) {
        Activity activity = activityService.getById(activityId);
        adDto.setActivity(activityMapper.activityToActivityDto(activity));
        Ad adToCreate = adMapper.adDtoToAd(adDto);
        adToCreate.setActivity(activity);
        activity.getAds().add(adToCreate);
        Ad createdAd = adService.createAd(adToCreate);

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
