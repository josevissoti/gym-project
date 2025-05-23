package com.project.domains.enums;

public enum PersonRole {

    ADMIN(0, "ROLE_ADMIN"),
    USER(1, "ROLE_USER"),
    EMPLOYEE(2, "ROLE_EMPLOYEE");

    private Integer id;
    private String personType;

    PersonRole(Integer id, String personType) {
        this.id = id;
        this.personType = personType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public static PersonRole toEnum(Integer id) {
        if (id == null) return null;
        for (PersonRole personRole : PersonRole.values()) {
            if (id.equals(personRole.getId())) {
                return personRole;
            }
        }
        throw new IllegalArgumentException("Invalid Profile");
    }
}
