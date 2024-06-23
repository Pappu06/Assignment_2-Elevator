package com.elevator;

//The Request class represents an elevator request made by a user.
public class Request implements Comparable<Request> {
	// The floor where the request was made.
    private int floor;
    // The direction in which the user wants to go.
    private Direction direction;

    // Constructor initializes the floor and direction of the request.
    public Request(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }

    // Getter method to get the floor of the request.
    public int getFloor() {
        return floor;
    }

    // Getter method to get the direction of the request.
    public Direction getDirection() {
        return direction;
    }

    // Overriding the compareTo method to compare requests based on floor numbers.
    @Override
    public int compareTo(Request other) {
        return Integer.compare(this.floor, other.floor);
    }
}

