package com.github.funnygopher.adventofcode2018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class Day {

    protected String inputPath;

    public Day(String inputPath) {
        this.inputPath = inputPath;
    }

    abstract protected void part1();
    abstract protected void part2();

    protected BufferedReader getInput() throws FileNotFoundException {
        return new BufferedReader(new FileReader(this.inputPath));
    }
}