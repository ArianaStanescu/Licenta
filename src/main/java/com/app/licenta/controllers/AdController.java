package com.app.licenta.controllers;

import com.app.licenta.dtos.AdDto;
import com.app.licenta.dtos.AdUpdateDto;
import com.app.licenta.emails.EmailService;
import com.app.licenta.entities.*;
import com.app.licenta.mappers.AdMapper;
import com.app.licenta.notifications.FirebaseNotificationSender;
import com.app.licenta.services.AdService;
import com.app.licenta.services.EnrollmentRequestService;
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
    private EnrollmentRequestService enrollmentRequestService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private FirebaseNotificationSender firebaseNotificationSender;

    @GetMapping("/{id}")
    public AdDto get(@PathVariable Integer id) {
        Ad ad = adService.getById(id);
        return adMapper.adToAdDto(ad);
    }

    @GetMapping("/list/{activityId}")
    public Set<AdDto> findAllByActivityId(@PathVariable Integer activityId) {
        return adMapper.adListToAdDtoList(adService.findAllByActivityId(activityId));
    }

    @GetMapping("/list-by-trainer/{trainerId}")
    public Set<AdDto> findAllByTrainerId(@PathVariable Integer trainerId) {
        return adMapper.adListToAdDtoList(adService.findAllByTrainerId(trainerId));
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
            @RequestParam(required = false) AdStatus status,
            @RequestParam() int pageNumber,
            @RequestParam() int pageSize,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDirection) {
        return adService.searchAds(title, category, minAge, maxAge, gender, minPrice, maxPrice, status, pageNumber, pageSize, sortBy, sortDirection)
                .stream()
                .map(adMapper::adToAdDto)
                .toList();
    }

    @GetMapping("/search-by-trainer/{trainerId}")
    public List<AdDto> searchAdsByTrainerId(
            @PathVariable Integer trainerId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) ActivityCategory category,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) Gender gender,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) AdStatus status,
            @RequestParam() int pageNumber,
            @RequestParam() int pageSize,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String sortDirection) {

        List<AdDto> ads = adService.searchAdsByTrainerId(trainerId, title, category, minAge, maxAge, gender, minPrice, maxPrice, status, pageNumber, pageSize, sortBy, sortDirection)
                .stream()
                .map(adMapper::adToAdDto)
                .toList();
        for (AdDto ad : ads) {
            int pendingEnReqCount = enrollmentRequestService.findAllByAdId(ad.getId())
                    .stream()
                    .filter(er -> er.getStatus() == EnrollmentStatus.PENDING).toList().size();
            ad.setPendingEnrollmentRequestsCount(pendingEnReqCount);
        }

        return ads;
    }

    @PostMapping("/create/{activityId}")
    public AdDto create(@PathVariable Integer activityId,
                        @RequestPart("ad") AdDto adDto,
                        @RequestPart("image") MultipartFile imageFile) throws IOException {
        Ad adToCreate = adMapper.adDtoToAd(adDto);
        Ad createdAd = adService.createAd(adToCreate, activityId, imageFile.getBytes());

        Trainer trainer = createdAd.getActivity().getTrainer();
        trainer.getFollowersParents().forEach(parent -> {
            emailService.sendEmailForNewlyCreatedAd(parent.getEmail(), trainer.getFullName());
            firebaseNotificationSender.sendNotificationForNewlyCreatedAd(parent.getId(), trainer.getFullName());
        });
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
