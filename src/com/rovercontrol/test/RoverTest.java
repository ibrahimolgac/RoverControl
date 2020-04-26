package com.rovercontrol.test;

import com.rovercontrol.Rover;

/***
 * For testing rover commands, we dont use junit because this is simple project
 * we dont need to create by maven or graddle etc..
 */
public class RoverTest {


    public static void testRoverDirectionCommands() throws Exception {

        Rover rover = new Rover("2 4 N");
        rover.changeDirection('L');

        // check Norh
        if ( rover.getDirection()!='E'){
            throw new Exception("North to left doesn't work !!!");
        }

        rover.setDirection('N');
        rover.changeDirection('R');
        if ( rover.getDirection()!='W'){
            throw new Exception("North to right doesn't work !!!");
        }

        // check South
        rover.setDirection('S');
        rover.changeDirection('L');
        if ( rover.getDirection()!='W'){
            throw new Exception("South to left doesn't work !!!");
        }

        rover.setDirection('S');
        rover.changeDirection('R');
        if ( rover.getDirection()!='E'){
            throw new Exception("South to right doesn't work !!!");
        }


        // check East
        rover.setDirection('E');
        rover.changeDirection('L');
        if ( rover.getDirection()!='S'){
            throw new Exception("East to left doesn't work !!!");
        }

        rover.setDirection('E');
        rover.changeDirection('R');
        if ( rover.getDirection()!='N'){
            throw new Exception("East to right doesn't work !!!");
        }


        // check West
        rover.setDirection('W');
        rover.changeDirection('L');
        if ( rover.getDirection()!='N'){
            throw new Exception("West to left doesn't work !!!");
        }

        rover.setDirection('W');
        rover.changeDirection('R');
        if ( rover.getDirection()!='S'){
            throw new Exception("West to right doesn't work !!!");
        }

        System.out.println("Rover change direction ok !");

    }


    public static void testRoverMoveCommand() throws Exception {

        Rover rover = new Rover("2 4 N");
        rover.moveRover(5,5);

        // check up
        if ( rover.getY()!=5){
            throw new Exception("Move to North  doesn't work !!!");
        }

        // check down
        rover.setDirection('S');
        rover.moveRover(5,5);
        if ( rover.getY()!=4){
            throw new Exception("Move to South doesn't work !!!");
        }

        // check left
        rover.setDirection('E');
        rover.moveRover(5,5);
        if ( rover.getX()!=1){
            throw new Exception("Move to East doesn't work !!!");
        }

        // check right
        rover.setDirection('W');
        rover.moveRover(5,5);
        if ( rover.getX()!=2){
            throw new Exception("Move to West doesn't work !!!");
        }

        System.out.println("Rover move commands ok !");

    }


}
