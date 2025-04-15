package com.app.licenta.entities;

public enum TrainerReviewGrade {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
    private Integer grade;

    TrainerReviewGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getGrade() {
        return this.grade;
    }
}
