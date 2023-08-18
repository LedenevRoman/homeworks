package com.telrun.rledenev.summary_0818.task1;

import java.util.List;
import java.util.Objects;

public class EvenAndOddLists {
    private final List<Integer> evenList;
    private final List<Integer> oddList;

    public EvenAndOddLists(List<Integer> evenList, List<Integer> oddList) {
        this.evenList = evenList;
        this.oddList = oddList;
    }

    public List<Integer> getEvenList() {
        return evenList;
    }

    public List<Integer> getOddList() {
        return oddList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvenAndOddLists that = (EvenAndOddLists) o;
        return Objects.equals(evenList, that.evenList) && Objects.equals(oddList, that.oddList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(evenList, oddList);
    }

    @Override
    public String toString() {
        return "EvenAndOddLists{" +
                "evenList=" + evenList +
                ", oddList=" + oddList +
                '}';
    }
}
