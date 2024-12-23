package com.app.licenta.controllers;

import com.app.licenta.dtos.AdDto;
import com.app.licenta.entities.Activity;
import com.app.licenta.entities.Ad;
import com.app.licenta.mappers.ActivityMapper;
import com.app.licenta.mappers.AdMapper;
import com.app.licenta.services.ActivityService;
import com.app.licenta.services.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //update


//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Integer id) {
//        activityService.deleteById(id);
//    }
}
