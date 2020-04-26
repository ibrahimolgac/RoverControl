package com.rovercontrol;

public class Rover {


    private int x;
    private int y;
    private char direction;
    private String commands;

    public Rover(String coordinates) {

        x = Character.getNumericValue(coordinates.charAt(0));
        y = Character.getNumericValue(coordinates.charAt(2));
        direction = coordinates.charAt(4);
    }

    public void applyCommands(int platoMaxX, int platoMaxY) {

        for (int i = 0; i < commands.length(); ++i) {
            if (Consts.LEFT == commands.charAt(i) || Consts.RIGHT == commands.charAt(i)) {
                changeDirection(commands.charAt(i));
            } else if (Consts.MOVE == commands.charAt(i)) {
                moveRover(platoMaxX, platoMaxY);
            }

        }
    }

    public void moveRover(int platoMaxX, int platoMaxY) {

        if (Consts.EAST == direction) {
            if (x > 0) {
                --x;
            }
        } else if (Consts.WEST == direction) {
            if (x < platoMaxX) {
                ++x;
            }
        } else if (Consts.SOUTH == direction) {
            if (y > 0) {
                --y;
            }
        } else if (Consts.NORTH == direction) {
            if (y < platoMaxY) {
                ++y;
            }
        }
    }

    public void changeDirection(char newDirection) {

        switch (direction) {

            case Consts.EAST:
                if (Consts.LEFT == newDirection) {
                    direction = Consts.SOUTH;
                } else if (Consts.RIGHT == newDirection) {
                    direction = Consts.NORTH;
                }
                break;

            case Consts.WEST:
                if (Consts.LEFT == newDirection) {
                    direction = Consts.NORTH;
                } else if (Consts.RIGHT == newDirection) {
                    direction = Consts.SOUTH;
                }
                break;

            case Consts.NORTH:
                if (Consts.LEFT == newDirection) {
                    direction = Consts.EAST;
                } else if (Consts.RIGHT == newDirection) {
                    direction = Consts.WEST;
                }
                break;

            case Consts.SOUTH:
                if (Consts.LEFT == newDirection) {
                    direction = Consts.WEST;
                } else if (Consts.RIGHT == newDirection) {
                    direction = Consts.EAST;
                }
                break;

            default:
                break;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + direction;
    }
}
