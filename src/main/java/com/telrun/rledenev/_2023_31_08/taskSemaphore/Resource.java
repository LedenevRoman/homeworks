package com.telrun.rledenev._2023_31_08.taskSemaphore;

import java.util.Set;

public class Resource {
    private Set<String> dataBase = Set.of("1", "2", "3", "4", "5");

    public Set<String> getDataBase() {
        return dataBase;
    }
}
