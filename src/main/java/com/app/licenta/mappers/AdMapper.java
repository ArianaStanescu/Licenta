package com.app.licenta.mappers;

import com.app.licenta.dtos.AdDto;
import com.app.licenta.dtos.AdUpdateDto;
import com.app.licenta.entities.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AdMapper {

    @Autowired
    private ActivityMapper activityMapper;

    public Ad adDtoToAd(AdDto adDto) {
        Ad ad = new Ad();
        //ad.setId(adDto.getId());
        ad.setTitle(adDto.getTitle());
        ad.setDescription(adDto.getDescription());
        ad.setPrice(adDto.getPrice());
        ad.setCategory(adDto.getCategory());
        ad.setMinAge(adDto.getMinAge());
        ad.setMaxAge(adDto.getMaxAge());
        ad.setGender(adDto.getGender());
        ad.setStartDate(adDto.getStartDate());
        ad.setEndDate(adDto.getEndDate());
        ad.setStatus(adDto.getStatus());
        ad.setTotalSpots(adDto.getTotalSpots());
        ad.setDurationRules(adDto.getDurationRules());
        return ad;
    }

    public AdDto adToAdDto(Ad ad) {
        AdDto adDto = new AdDto();
        adDto.setId(ad.getId());
        adDto.setTitle(ad.getTitle());
        adDto.setDescription(ad.getDescription());
        adDto.setPrice(ad.getPrice());
        adDto.setCategory(ad.getCategory());
        adDto.setMinAge(ad.getMinAge());
        adDto.setMaxAge(ad.getMaxAge());
        adDto.setGender(ad.getGender());
        adDto.setStartDate(ad.getStartDate());
        adDto.setEndDate(ad.getEndDate());
        adDto.setStatus(ad.getStatus());
        adDto.setTotalSpots(ad.getTotalSpots());
        adDto.setDurationRules(ad.getDurationRules());
        adDto.setActivity(activityMapper.activityToActivityDto(ad.getActivity()));
        return adDto;
    }

    public Set<AdDto> adListToAdDtoList(Set<Ad> adList) {
        return adList.stream().map(this::adToAdDto).collect(Collectors.toSet());
    }

    public Ad adUpdateDtoToAd(AdUpdateDto adUpdateDto) {
        Ad ad = new Ad();
        ad.setTitle(adUpdateDto.getTitle());
        ad.setDescription(adUpdateDto.getDescription());
        ad.setPrice(adUpdateDto.getPrice());
        ad.setCategory(adUpdateDto.getCategory());
        ad.setMinAge(adUpdateDto.getMinAge());
        ad.setMaxAge(adUpdateDto.getMaxAge());
        ad.setGender(adUpdateDto.getGender());
        ad.setStartDate(adUpdateDto.getStartDate());
        ad.setEndDate(adUpdateDto.getEndDate());
        ad.setStatus(adUpdateDto.getStatus());
        ad.setTotalSpots(adUpdateDto.getTotalSpots());
        ad.setDurationRules(adUpdateDto.getDurationRules());
        return ad;
    }

    public AdUpdateDto adToAdUpdateDto(Ad ad) {
        AdUpdateDto adUpdateDto = new AdUpdateDto();
        adUpdateDto.setId(ad.getId());
        adUpdateDto.setTitle(ad.getTitle());
        adUpdateDto.setDescription(ad.getDescription());
        adUpdateDto.setPrice(ad.getPrice());
        adUpdateDto.setCategory(ad.getCategory());
        adUpdateDto.setMinAge(ad.getMinAge());
        adUpdateDto.setMaxAge(ad.getMaxAge());
        adUpdateDto.setGender(ad.getGender());
        adUpdateDto.setStartDate(ad.getStartDate());
        adUpdateDto.setEndDate(ad.getEndDate());
        adUpdateDto.setStatus(ad.getStatus());
        adUpdateDto.setTotalSpots(ad.getTotalSpots());
        adUpdateDto.setDurationRules(ad.getDurationRules());
        return adUpdateDto;
    }
}
