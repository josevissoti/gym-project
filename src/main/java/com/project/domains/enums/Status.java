package com.project.domains.enums;

public enum Status {

    DISABLED(0, "DISABLED"),
    ACTIVATED(1, "ACTIVATED");

    private Integer idStatus;
    private String description;

    Status(Integer idStatus, String description) {
        this.idStatus = idStatus;
        this.description = description;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Status toEnum(Integer idStatus) {
        if (idStatus == null) return null;
        for (Status status : Status.values()) {
            if (idStatus.equals(status.getIdStatus())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Status");
    }
}
