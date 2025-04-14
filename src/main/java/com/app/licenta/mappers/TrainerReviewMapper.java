package com.app.licenta.mappers;

import com.app.licenta.dtos.TrainerReviewDTO;
import com.app.licenta.entities.TrainerReview;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TrainerReviewMapper {

    private final ParentMapper parentMapper;
    private final TrainerMapper trainerMapper;

    public TrainerReviewMapper(ParentMapper parentMapper, TrainerMapper trainerMapper) {
        this.parentMapper = parentMapper;
        this.trainerMapper = trainerMapper;
    }

    public TrainerReview trainerReviewDTO2TrainerReview(TrainerReviewDTO trainerReviewDTO) {
        TrainerReview trainerReview = new TrainerReview();
        trainerReview.setComment(trainerReviewDTO.getComment());
        trainerReview.setTrainerReviewGrade(trainerReviewDTO.getTrainerReviewGrade());

        return trainerReview;
    }

    public TrainerReviewDTO trainerReview2TrainerReviewDTO(TrainerReview trainerReview) {
        TrainerReviewDTO trainerReviewDTO = new TrainerReviewDTO();
        trainerReviewDTO.setId(trainerReview.getId());
        trainerReviewDTO.setComment(trainerReview.getComment());
        trainerReviewDTO.setTrainerReviewGrade(trainerReview.getTrainerReviewGrade());
        trainerReviewDTO.setParentDto(parentMapper.parentToParentDto(trainerReview.getParent()));
        trainerReviewDTO.setTrainerDto(trainerMapper.trainerToTrainerDto(trainerReview.getTrainer()));
        trainerReviewDTO.setCreatedAt(trainerReview.getCreatedAt());

        return trainerReviewDTO;
    }

    public List<TrainerReviewDTO> trainerReviewList2TrainerReviewListDTO(List<TrainerReview> trainerReviewList) {
        return trainerReviewList.stream()
                .map(this::trainerReview2TrainerReviewDTO)
                .toList();
    }

}
