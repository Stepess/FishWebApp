package model.entity;

public enum RoleEnum {
    GUEST("guest"), USER("user"), ADMIN("admin");

    private String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
