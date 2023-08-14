package com.telrun.rledenev._2023_08_10;

import java.util.Objects;

public class Role {
    private final int id;
    private final String roleName;
    private final String description;

    public Role(int id, String roleName, String description) {
        this.id = id;
        this.roleName = roleName;
        this.description = description;
    }

    public String getRoleInfo() {
        return "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id
                && Objects.equals(roleName, role.roleName)
                && Objects.equals(description, role.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName, description);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
