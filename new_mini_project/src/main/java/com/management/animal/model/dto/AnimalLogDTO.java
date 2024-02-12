package com.management.animal.model.dto;

public class AnimalLogDTO {
    private int logCode;
    private String logDate;
    private String logRemark;
    private int statusCode;
    private StatusDTO statusDTO;
    private AnimalDTO animalDTO;
    private int animalCode;

    private String admissionStatus;
    public AnimalLogDTO() {
    }

    public AnimalLogDTO(int logCode, String logDate, String logRemark, int statusCode, StatusDTO statusDTO, AnimalDTO animalDTO, int animalCode ,String admissionStatus) {
        this.logCode = logCode;
        this.logDate = logDate;
        this.logRemark = logRemark;
        this.statusCode = statusCode;
        this.statusDTO = statusDTO;
        this.animalDTO = animalDTO;
        this.animalCode = animalCode;
        this.admissionStatus = admissionStatus;
    }

    public int getLogCode() {
        return logCode;
    }

    public void setLogCode(int logCode) {
        this.logCode = logCode;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }

    public String getLogRemark() {
        return logRemark;
    }

    public void setLogRemark(String logRemark) {
        this.logRemark = logRemark;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) { this.statusCode = statusCode;}


    public StatusDTO getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(StatusDTO statusDTO) {
        this.statusDTO = statusDTO;
    }

    public AnimalDTO getAnimalDTO() {
        return animalDTO;
    }

    public void setAnimalDTO(AnimalDTO animalDTO) {
        this.animalDTO = animalDTO;
    }

    public int getAnimalCode() {
        return animalCode;
    }
    public String getAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(String admissionStatus) {
        this.admissionStatus = admissionStatus;
    }
    public void setAnimalCode(int animalCode) {
        this.animalCode = animalCode;
    }

    @Override
    public String toString() {
        return "동물정보 " +
                //"logCode=" + logCode +
                 animalDTO +
                ", [상태 : 처리상태=" + statusDTO +
                ", 처리날짜='" + logDate + '\'' +
                ", 상세내용='" + logRemark + '\'' +
                ", 입소상태=" + admissionStatus +
                ']';
    }
}

// AnimalLogDTO
