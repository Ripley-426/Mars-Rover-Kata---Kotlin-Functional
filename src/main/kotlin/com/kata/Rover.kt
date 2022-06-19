package com.kata

import com.kata.roverCommands.service.RoverCommandsService

class Rover(val mapSize: Pair<Int, Int>,  expectedPosition: Pair<Int, Int>, val direction: Direction, private val roverCommandsService: RoverCommandsService) {

    var position: Pair<Int, Int>

    init {
        val newPositionX = calculateXEdgesWrapping(expectedPosition.first)
        val newPositionY = calculateYEdgesWrapping(expectedPosition.second)
        position = Pair(newPositionX, newPositionY)
    }

    //region Edge Calculation
    private fun calculateXEdgesWrapping(positionX: Int): Int {
        return leftEdgeLogic(rightEdgeLogic(positionX))
    }

    private fun leftEdgeLogic(position: Int): Int =
        if (crossedLowerEdge(position)) {
            getTopXCoordinate()
        } else{
            position
        }

    private fun crossedLowerEdge(position: Int) = position < 0

    private fun rightEdgeLogic(position: Int) =
        if (crossedRightEdge(position)) {
            getBottomCoordinate()
        } else {
            position
        }

    private fun crossedRightEdge(expectedPosition: Int) = expectedPosition >= mapSize.first

    private fun calculateYEdgesWrapping(positionY: Int): Int {
        return lowerEdgeLogic(topEdgeLogic(positionY))
    }

    private fun lowerEdgeLogic(position: Int)=
        if (crossedLowerEdge(position)) {
            getTopYCoordinate()
        } else {
            position
        }

    private fun topEdgeLogic(position: Int) =
        if (crossedTopEdge(position)) {
            getBottomCoordinate()
        } else {
            position
        }

    private fun crossedTopEdge(position: Int) = position >= mapSize.second

    private fun getTopXCoordinate() = mapSize.first - 1

    private fun getTopYCoordinate() = mapSize.second - 1

    private fun getBottomCoordinate() = 0



    //endregion

    fun inputCommands(commands: String): Rover {
        var newRover = Rover(mapSize, position, direction, roverCommandsService)
        for (command in commands){
            newRover = roverCommandsService.getCommand(command, newRover).execute()
        }
        return newRover
    }

    fun isEqual(newRover: Rover): Boolean {
        if (newRover.position != position) return false
        if (newRover.direction != direction) return false
        if (newRover.mapSize != mapSize) return false
        return true
    }

    fun decreasePosY(): Rover {
        return Rover(mapSize, Pair(position.first, position.second-1), direction, roverCommandsService)
    }

    fun increasePosY(): Rover {
        return Rover(mapSize, Pair(position.first, position.second+1), direction, roverCommandsService)
    }

    fun decreasePosX(): Rover {
        return Rover(mapSize, Pair(position.first-1, position.second), direction, roverCommandsService)
    }

    fun increasePosX(): Rover {
        return Rover(mapSize, Pair(position.first+1, position.second), direction, roverCommandsService)
    }

    fun turnLeft(): Rover {
        val newDirection = when (direction){
            Direction.NORTH -> Direction.WEST
            Direction.SOUTH -> Direction.EAST
            Direction.WEST -> Direction.SOUTH
            Direction.EAST -> Direction.NORTH
        }

        return Rover(mapSize, position, newDirection, roverCommandsService)
    }

    fun turnRight(): Rover {
        val newDirection = when (direction){
            Direction.NORTH -> Direction.EAST
            Direction.SOUTH -> Direction.WEST
            Direction.WEST -> Direction.NORTH
            Direction.EAST -> Direction.SOUTH
        }

        return Rover(mapSize, position, newDirection, roverCommandsService)
    }

}

