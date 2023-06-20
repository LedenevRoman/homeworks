package _2023_06_20.enums;


public class Security {
    private String name;
    private Permission permissionLevel;

    public String getName() {
        return name;
    }

    public Permission getPermissionLevel() {
        return permissionLevel;
    }

    public Security(String name, Permission permissionLevel) {
        this.name = name;
        this.permissionLevel = permissionLevel;
    }


}
