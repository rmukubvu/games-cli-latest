package com.spandigital.assessment;

import com.spandigital.assessment.helper.Commands;
import com.spandigital.assessment.model.InvalidCommandException;
import com.spandigital.assessment.processor.process.Compute;
import com.spandigital.assessment.processor.receiver.BaseReceiver;
import com.spandigital.assessment.store.InMemory;

import java.io.FileNotFoundException;

public class Application {
    public static void main(String... args)  {
        try{
            //get score lines
            var baseReceiver = new BaseReceiver();
            var scores = baseReceiver.processInput(args);
            //calculate scores and display the output
            var compute = new Compute(new InMemory<>());
            System.out.println(compute.printLogTable(scores));
        }catch (InvalidCommandException | FileNotFoundException ice){
            //display the commands
            System.out.println(Commands.showAll());
            //show the error
            System.out.println(ice.getMessage());
        }
    }
}
