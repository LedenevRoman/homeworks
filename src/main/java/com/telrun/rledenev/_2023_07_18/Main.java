package com.telrun.rledenev._2023_07_18;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Generator generator = new Generator();
        List<Developer> developers = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            developers.add(generator.generateDeveloper());
        }

        System.out.println(HandlerUtils.getMalesWithSportCar(developers));
        System.out.println(HandlerUtils.getMapDeveloperMaxSpeed(developers));
        System.out.println(HandlerUtils.groupCarsByDevelopersGender(developers));
        HandlerUtils.generateTextFileDevelopersByRows("result", developers);
    }
}
