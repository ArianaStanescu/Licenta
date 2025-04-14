package com.app.licenta.controllers;

import com.app.licenta.dtos.TrainerReviewDTO;
import com.app.licenta.entities.TrainerReview;
import com.app.licenta.mappers.TrainerReviewMapper;
import com.app.licenta.services.TrainerReviewService;
import com.app.licenta.services.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer-reviews")
public class TrainerReviewController {

    private final TrainerReviewMapper trainerReviewMapper;
    private final TrainerReviewService trainerReviewService;
    private final TrainerService trainerService;

    public TrainerReviewController(TrainerReviewMapper trainerReviewMapper,
                                   TrainerReviewService trainerReviewService,
                                   TrainerService trainerService) {
        this.trainerReviewMapper = trainerReviewMapper;
        this.trainerReviewService = trainerReviewService;
        this.trainerService = trainerService;
    }

    @PostMapping("/{trainerId}/{parentId}")
    public TrainerReviewDTO create(@PathVariable Integer trainerId,
                                   @PathVariable Integer parentId,
                                   @RequestBody TrainerReviewDTO trainerReviewDTO) {

        TrainerReview trainerReviewToCreate = trainerReviewMapper.trainerReviewDTO2TrainerReview(trainerReviewDTO);
        TrainerReview createdTrainerReview = trainerReviewService.create(trainerId, parentId, trainerReviewToCreate);

        trainerService.updateTrainerReviews(trainerId);
        return trainerReviewMapper.trainerReview2TrainerReviewDTO(createdTrainerReview);
    }

    @PutMapping("/{trainerReviewId}/{parentId}")
    public TrainerReviewDTO update(@PathVariable Integer trainerReviewId,
                                   @PathVariable Integer parentId,
                                   @RequestBody TrainerReviewDTO trainerReviewDTO) {

        TrainerReview trainerReviewToUpdate = trainerReviewMapper.trainerReviewDTO2TrainerReview(trainerReviewDTO);
        TrainerReview createdTrainerReview = trainerReviewService.update(trainerReviewId, parentId, trainerReviewToUpdate);

        trainerService.updateTrainerReviews(createdTrainerReview.getTrainer().getId());
        return trainerReviewMapper.trainerReview2TrainerReviewDTO(createdTrainerReview);
    }

    @GetMapping("/{trainerId}")
    public List<TrainerReviewDTO> findForTrainer(@PathVariable Integer trainerId,
                                                 @RequestParam() int pageNumber,
                                                 @RequestParam() int pageSize,
                                                 @RequestParam(required = false) String sortBy,
                                                 @RequestParam(required = false) String sortDirection) {

        List<TrainerReview> trainerReviews = trainerReviewService.findForTrainer(trainerId, pageNumber, pageSize, sortBy, sortDirection);

        return trainerReviewMapper.trainerReviewList2TrainerReviewListDTO(trainerReviews);
    }

    @DeleteMapping("/{trainerReviewId}/{parentId}")
    public ResponseEntity<?> findForTrainer(@PathVariable Integer trainerReviewId,
                                            @PathVariable Integer parentId) {

        Integer trainerId = trainerReviewService.delete(trainerReviewId, parentId);
        trainerService.updateTrainerReviews(trainerId);

        return ResponseEntity.noContent().build();
    }
}
