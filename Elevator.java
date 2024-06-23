package com.elevator;

//The Elevator class simulates the behavior of an elevator.
public class Elevator {
	    // The current floor the elevator is on.
	    private int currentFloor;
	    // The current direction the elevator is moving in.
	    private Direction direction;
	    // Indicates whether the elevator door is open or closed.
	    private boolean doorOpen;

	    // Constructor initializes the elevator on the ground floor with IDLE direction and door closed.
	    public Elevator() {
	        this.currentFloor = 0;
	        this.direction = Direction.IDLE;
	        this.doorOpen = false;
	    }

	    // Getter method to get the current floor of the elevator.
	    public int getCurrentFloor() {
	        return currentFloor;
	    }
	    
	    // Getter method to get the current direction of the elevator.
	    public Direction getDirection() {
	        return direction;
	    }

	    // Getter method to check if the elevator door is open.
	    public boolean isDoorOpen() {
	        return doorOpen;
	    }

	    // Method to move the elevator up one floor, if the door is closed.
	    public void moveUp() {
	        if (!doorOpen) {
	            currentFloor++;
	            direction = Direction.UP;
	        }
	    }

	    // Method to move the elevator down one floor, if the door is closed.
	    public void moveDown() {
	        if (!doorOpen) {
	            currentFloor--;
	            direction = Direction.DOWN;
	        }
	    }

	    // Method to open the elevator door.
	    public void openDoor() {
	        doorOpen = true;
	    }

	    // Method to close the elevator door.
	    public void closeDoor() {
	        doorOpen = false;
	    }

	    // Method to set the direction of the elevator.
	    public void setDirection(Direction direction) {
	        this.direction = direction;
	    }

	    // Method to set the elevator's direction to IDLE.
	    public void setIdle() {
	        direction = Direction.IDLE;
	    }
	}



