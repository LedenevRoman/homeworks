package com.telrun.rledenev._2023_08_29;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
class Dish {
    private String name;
    private long preparationTime; // in milliseconds
    private Status statusDish;

}
