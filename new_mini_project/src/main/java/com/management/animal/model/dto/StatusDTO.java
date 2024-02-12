package com.management.animal.model.dto;

public class StatusDTO {
    private int statusCode;
    private String statusName;

    public StatusDTO() {
    }

    public StatusDTO(int statusCode, String statusName) {
        this.statusCode = statusCode;
        this.statusName = statusName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return //"StatusDTO{" +
                //"statusCode=" + statusCode +
                statusName + '\'' ;
               // '}';
    }
}
//StatusDTO