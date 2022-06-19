package com.kata.roverCommands

import com.kata.Direction
import com.kata.Rover

class MoveForwardCommand(private val rover: Rover) : IRoverMovementCommand {

    override fun execute(): Rover {
        return when (rover.direction){
            Direction.NORTH -> rover.increasePosY()
            Direction.SOUTH -> rover.decreasePosY()
            Direction.WEST -> rover.decreasePosX()
            Direction.EAST -> rover.increasePosX()
        }
    }

}
