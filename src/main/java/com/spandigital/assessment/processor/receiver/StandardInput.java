package com.spandigital.assessment.processor.receiver;

import com.spandigital.assessment.contract.Reader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StandardInput implements Reader {

    @Override
    public Iterable<String> read(InputStream inputStream) {
        //show example of how the input must be formatted
        showExample();

        ArrayList<String> scores = new ArrayList<>();
        try (var scanner = new Scanner(inputStream)) {
            String input;
            //quit loop if input is a q irrespective of the case
            System.out.println("Enter score line: ");
            while ((input = scanner.nextLine()).compareToIgnoreCase("q") != 0) {
                if (input.isEmpty()){
                    System.out.println("Please enter valid input");
                }else {
                    scores.add(input);
                }
                System.out.println("Enter score line: ");
            }
        }
        return scores;
    }

    private void showExample(){
        System.out.print("Input   format: TeamA Score , TeamB Score\n");
        System.out.print("Example format: Kaizer Chiefs  3 , Mamelodi Sundowns 5\n");
        System.out.print("Type q to quit\n\n");
    }
}
