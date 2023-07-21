package com.telrun.rledenev._2023_07_18;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        List<Developer> developers = generator.generateDevelopers(20);

        System.out.println(HandlerUtils.getMalesWithSportCar(developers));
        System.out.println(HandlerUtils.getMapDeveloperMaxSpeed(developers));
        System.out.println(HandlerUtils.groupCarsByDevelopersGender(developers));
        HandlerUtils.generateTextFileDevelopersByRows("result", developers);
    }
}
