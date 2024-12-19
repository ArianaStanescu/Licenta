package com.app.licenta.mappers;

import com.app.licenta.dtos.TrainerDto;
import com.app.licenta.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrainerMapper {
//    @Autowired
//    private ActivityMapper activityMapper;

    public Trainer trainerDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
//        trainer.setId(trainerDto.getId());
//        trainer.setFirstName(trainerDto.getFirstName());
//        trainer.setLastName(trainerDto.getLastName());
//        trainer.setEmail(trainerDto.getEmail());
//        trainer.setPhoneNumber(trainerDto.getPhoneNumber());
//        trainer.setGender(trainerDto.getGender());
//        trainer.setBirthDate(trainerDto.getBirthDate());
//        trainer.setActivities(activityMapper.activityDtoListToActivityList(trainerDto.getActivities()));
        return trainer;
    }

    public TrainerDto trainerToTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
//        trainerDto.setId(trainer.getId());
//        trainerDto.setFirstName(trainer.getFirstName());
//        trainerDto.setLastName(trainer.getLastName());
//        trainerDto.setEmail(trainer.getEmail());
//        trainerDto.setPhoneNumber(trainer.getPhoneNumber());
//        trainerDto.setGender(trainer.getGender());
//        trainerDto.setBirthDate(trainer.getBirthDate());
//        trainer.setActivities(activityMapper.activityListToActivityDtoList(trainer.getActivities()));
        return trainerDto;
    }
}
