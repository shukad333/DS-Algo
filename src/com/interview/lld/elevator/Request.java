package com.interview.lld.elevator;

public class Request {

    int currentFloor,desiredFloor ;
    Direction direction;
    Location location;

    public Request(int currentFloor, int desiredFloor, Direction direction, Location location) {
        this.currentFloor = currentFloor;
        this.desiredFloor = desiredFloor;
        this.direction = direction;
        this.location = location;
    }

}



