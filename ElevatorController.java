package com.elevator;

import java.util.PriorityQueue;
import java.util.Queue;

//The ElevatorController class manages the operations of the elevator.
public class ElevatorController {
	// The elevator instance controlled by this controller.
    private Elevator elevator;
    // Priority queue for handling up requests.
    private Queue<Request> upRequests;
    // Priority queue for handling down requests.
    private Queue<Request> downRequests;

    // Constructor initializes the elevator and request queues.
    public ElevatorController() {
        this.elevator = new Elevator();
        // Up requests are handled in natural order (lowest to highest).
        this.upRequests = new PriorityQueue<>();
        // Down requests are handled in reverse order (highest to lowest).
        this.downRequests = new PriorityQueue<>((a, b) -> b.compareTo(a));
    }

    // Method to request the elevator to a specific floor in a given direction.
    public void requestElevator(int floor, Direction direction) {
        Request request = new Request(floor, direction);
        if (direction == Direction.UP) {
            upRequests.offer(request);
        } else if (direction == Direction.DOWN) {
            downRequests.offer(request);
        }
    }

    // Method to run the elevator and process all requests.
    public void run() {
    	// Continue processing while there are any requests.
        while (!upRequests.isEmpty() || !downRequests.isEmpty()) {
        	// Process up requests if available.
            if (!upRequests.isEmpty()) {
                processRequests(upRequests, Direction.UP);
            }
            // Process down requests if available.
            if (!downRequests.isEmpty()) {
                processRequests(downRequests, Direction.DOWN);
            }
        }
        // Set the elevator to idle when all requests are processed.
        elevator.setIdle();
        System.out.println("Elevator is idle at floor " + elevator.getCurrentFloor());
    }

    // Method to process requests in the given direction.
    private void processRequests(Queue<Request> requests, Direction direction) {
        while (!requests.isEmpty()) {
            Request request = requests.poll();
            moveElevator(request.getFloor());
            elevator.openDoor();
            System.out.println("Elevator door opened at floor " + elevator.getCurrentFloor());
            elevator.closeDoor();
            System.out.println("Elevator door closed at floor " + elevator.getCurrentFloor());
        }
    }

    // Method to move the elevator to the target floor.
    private void moveElevator(int targetFloor) {
        while (elevator.getCurrentFloor() != targetFloor) {
            if (elevator.getCurrentFloor() < targetFloor) {
                elevator.moveUp();
            } else {
                elevator.moveDown();
            }
            System.out.println("Elevator is at floor " + elevator.getCurrentFloor());
        }
    }

    // Main method to test the ElevatorController functionality.
    public static void main(String[] args) {
        ElevatorController controller = new ElevatorController();
        // Request elevator to floor 2 to go up.
        controller.requestElevator(2, Direction.UP);
        // Request elevator to floor 3 to go down.
        controller.requestElevator(3, Direction.DOWN);
        // Request elevator to floor 7 to go up.
        controller.requestElevator(7, Direction.UP);
        // Run the elevator controller to process all requests.
        controller.run();
    }
}

