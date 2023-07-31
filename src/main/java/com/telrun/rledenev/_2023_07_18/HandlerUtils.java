package com.telrun.rledenev._2023_07_18;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class HandlerUtils {

    private HandlerUtils() {
    }

    public static List<Developer> getMalesWithSportCar(List<Developer> developers) {
        return developers.stream()
                .filter(developer -> developer.getGender() == 'm'
                        && developer.getCar().isSportCar())
                .collect(Collectors.toList());
    }

    public static Map<Character, List<Car>> groupCarsByDevelopersGender(List<Developer> developers) {
        return developers.stream()
                .collect(Collectors.groupingBy(Developer::getGender,
                        Collectors.mapping(Developer::getCar, Collectors.toList())));
    }

    public static Map<Developer, Integer> getMapDeveloperMaxSpeed(List<Developer> developers) {
        return developers.stream()
                .collect(Collectors.toMap(developer -> developer, developer -> developer.getCar().getMaxSpeed()));
    }

    public static void generateTextFileDevelopersByRows(String filename, List<Developer> developers) {
        try (FileWriter writer = new FileWriter(filename)){
            StringBuilder stringBuilder = new StringBuilder();
            developers.forEach(developer -> stringBuilder.append(developer.getName())
                    .append("-[auto: ")
                    .append(developer.getCar().getBrand().name())
                    .append(" ::: salary: ")
                    .append(developer.getSalary())
                    .append("] \n"));
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            throw new WriteFileException(e.getMessage());
        }
    }
}
