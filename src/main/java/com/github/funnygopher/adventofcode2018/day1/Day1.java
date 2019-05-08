package com.github.funnygopher.adventofcode2018.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.github.funnygopher.adventofcode2018.Day;

public class Day1 extends Day {
    
    public static void main(String[] args) {
        Day1 day1 = new Day1();
        day1.part1();
        day1.part2();
    }

    public Day1() {
        super("resources/day1/input.txt");
    }


    /**
     * Part 1 - https://adventofcode.com/2018/day/1
     * 
     * Time Complexity: O(n)
     * 
     * Problem: Starting with a frequency of zero, what is the resulting
     * frequency after all of the changes in frequency have been applied?
     */
    @Override
    public void part1() {
        try(BufferedReader br = this.getInput()) {
            int frequency = br.lines().mapToInt(Integer::parseInt).sum();
            System.out.println("The frequency is: " + frequency);
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Part 2 - https://adventofcode.com/2018/day/1#part2
     * 
     * Time Complexity: infinite
     * 
     * Problem: What is the first frequency your device reaches twice?
     */
    @Override
    public void part2() {
        Set<Integer> frequencySet = new HashSet<>();
        Integer[] frequencies = new Integer[0];

        try(BufferedReader br = this.getInput()) {
            frequencies = br.lines().mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
        } catch(IOException ex) {
            ex.printStackTrace();
            return;
        }
        
        int totalFrequency = 0;
        frequencySet.add(totalFrequency); // 0 is a valid frequency
        
        LoopingArrayIterator<Integer> iter = new LoopingArrayIterator<Integer>(frequencies);
        while(iter.hasNext()) {
            totalFrequency += iter.next();
            
            if(frequencySet.contains(totalFrequency)) {
                System.out.println("The first reoccuring frequency is: " + totalFrequency);
                break;
            } else {
                frequencySet.add(totalFrequency);
            }
        }
    }
}