package com.telrun.rledenev._2023_06_22.classStructure1;

public enum Position {
    JUNIOR_DEVELOPER,
    MIDDLE_DEVELOPER,
    SENIOR_DEVELOPER,
    TEAM_LEAD,
    DEVOPS_ENGINEER,
    BUSINESS_ANALYST,
    PROJECT_MANAGER,
    PRODUCT_MANAGER,
    CEO;

    @Override
    public String toString() {
        return this.name();
    }
}
