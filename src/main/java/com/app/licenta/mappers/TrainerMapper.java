package com.app.licenta.mappers;

import com.app.licenta.dtos.TrainerDto;
import com.app.licenta.entities.Trainer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TrainerMapper {

    public Trainer trainerDtoToTrainer(TrainerDto trainerDto) {
        Trainer trainer = new Trainer();
        //trainer.setId(trainerDto.getId());
        trainer.setFirstName(trainerDto.getFirstName());
        trainer.setLastName(trainerDto.getLastName());
        trainer.setEmail(trainerDto.getEmail());
        trainer.setPhoneNumber(trainerDto.getPhoneNumber());
        trainer.setGender(trainerDto.getGender());
        trainer.setBirthDate(trainerDto.getBirthDate());
        return trainer;
    }

    public TrainerDto trainerToTrainerDto(Trainer trainer) {
        TrainerDto trainerDto = new TrainerDto();
        trainerDto.setId(trainer.getId());
        trainerDto.setFirstName(trainer.getFirstName());
        trainerDto.setLastName(trainer.getLastName());
        trainerDto.setEmail(trainer.getEmail());
        trainerDto.setPhoneNumber(trainer.getPhoneNumber());
        trainerDto.setGender(trainer.getGender());
        trainerDto.setBirthDate(trainer.getBirthDate());
        return trainerDto;
    }
}
