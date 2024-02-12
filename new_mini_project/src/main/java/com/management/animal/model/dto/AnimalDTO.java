package com.management.animal.model.dto;

public class AnimalDTO {
    private int animalCode;
    private String animalGender;
    private String animalColor;
    private String animalAge;
    private String animalWeight;
    private String builtInChip;
    private String neuteringSurgery;
    private String animalCollar;
    private String rescueDate;
    private String capturePlace;
    private String healthCondition;
    private int categoryCode;
    private CategoryDTO categoryDTO;

    public AnimalDTO() {
    }

    public AnimalDTO(int animalCode, String animalGender, String animalColor, String animalAge, String animalWeight, String builtInChip, String neutering_surgery, String animalCollar, String rescueDate, String capturePlace, String healthCondition, int categoryCode, CategoryDTO categoryDTO) {
        this.animalCode = animalCode;
        this.animalGender = animalGender;
        this.animalColor = animalColor;
        this.animalAge = animalAge;
        this.animalWeight = animalWeight;
        this.builtInChip = builtInChip;
        this.neuteringSurgery = neuteringSurgery;
        this.animalCollar = animalCollar;
        this.rescueDate = rescueDate;
        this.capturePlace = capturePlace;
        this.healthCondition = healthCondition;
        this.categoryCode = categoryCode;
        this.categoryDTO = categoryDTO;
    }

    public int getAnimalCode() {
        return animalCode;
    }

    public void setAnimalCode(int animalCode) {
        this.animalCode = animalCode;
    }

    public String getAnimalGender() {
        return animalGender;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public String getAnimalColor() {
        return animalColor;
    }

    public void setAnimalColor(String animalColor) {
        this.animalColor = animalColor;
    }

    public String getAnimalAge() {
        return animalAge;
    }

    public void setAnimalAge(String animalAge) {
        this.animalAge = animalAge;
    }

    public String getAnimalWeight() {
        return animalWeight;
    }

    public void setAnimalWeight(String animalWeight) {
        this.animalWeight = animalWeight;
    }

    public String getBuiltInChip() {
        return builtInChip;
    }

    public void setBuiltInChip(String builtInChip) {
        this.builtInChip = builtInChip;
    }

    public String getNeuteringSurgery() {
        return neuteringSurgery;
    }

    public void setNeuteringSurgery(String neuteringSurgery) {
        this.neuteringSurgery = neuteringSurgery;
    }

    public String getAnimalCollar() {
        return animalCollar;
    }

    public void setAnimalCollar(String animalCollar) {
        this.animalCollar = animalCollar;
    }

    public String getRescueDate() {
        return rescueDate;
    }

    public void setRescueDate(String rescueDate) {
        this.rescueDate = rescueDate;
    }

    public String getCapturePlace() {
        return capturePlace;
    }

    public void setCapturePlace(String capturePlace) {
        this.capturePlace = capturePlace;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    @Override
    public String toString() {
        return //"AnimalDTO{" +
                categoryDTO +
                ", [동물 : 동물번호=" + animalCode +
                ", 성별=" + animalGender +
                ", 모색='" + animalColor + '\'' +
                ", 나이='" + animalAge + '\'' +
                ", 체중(kg)='" + animalWeight + '\'' +
                ", 내장칩=" + builtInChip +
                ", 중성화=" + neuteringSurgery +
                ", 목걸이=" + animalCollar +
                ", 구조날짜='" + rescueDate + '\'' +
                ", 포획장소='" + capturePlace + '\'' +
                ", 건강상태='" + healthCondition + '\'' +
               // ", " +  +
                ']';
    }
}
//AnimalDTO