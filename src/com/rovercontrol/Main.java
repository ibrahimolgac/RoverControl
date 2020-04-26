package com.rovercontrol;

/**
 * @author ibrahim olgac 26.04.2020
 */
public class Main {

    public static void main(String args[]) throws Exception {
        // test for Rover actions
        //RoverTest.testRoverDirectionCommands();
        //RoverTest.testRoverMoveCommand();

        Plato plato = new Plato("rovers.txt");
        plato.applyCommands();
        plato.showRoverPlaces();

    }


}
