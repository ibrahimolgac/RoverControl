package com.rovercontrol;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Plato {

    private int maxX;
    private int maxY;
    private List<Rover> rovers = new ArrayList<>();

    public Plato(String fileName) {

        try {

            URL url = this.getClass().getResource(fileName);
            final String FILE_NAME = url.getFile();
            File file = new File(FILE_NAME);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            boolean isRoverCoordinate = true;
            if (line == null) {
                return;
            }

            setCoordinates(line);
            Rover rover = null;

            while ((line = br.readLine()) != null) {

                if (isRoverCoordinate) {
                    rover = new Rover(line);
                    isRoverCoordinate = false;
                } else {
                    rover.setCommands(line);
                    isRoverCoordinate = true;
                    addRover(rover);
                }
            }

            fr.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setCoordinates(String coordinates) {
        maxX = Character.getNumericValue(coordinates.charAt(0));
        maxY = Character.getNumericValue(coordinates.charAt(2));
    }


    public void addRover(Rover rover) {
        rovers.add(rover);
    }

    public void applyCommands() {
        for (Rover rover : rovers) {
            rover.applyCommands(maxX, maxY);
        }
    }

    public void showRoverPlaces() {
        for (Rover rover : rovers) {
            System.out.println(rover);
        }
    }


}
