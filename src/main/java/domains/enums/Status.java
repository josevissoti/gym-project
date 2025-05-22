package domains.enums;

public enum Status {

    DISABLED(0, "DISABLED"), ACTIVATED(1, "ACTIVATED");

    private Integer id;
    private String description;

    Status(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Status toEnum(Integer id) {
        if(id==null) return null;
        for (Status x : Status.values()) {
            if (id.equals(x.getId())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Invalid Status");
    }
}
