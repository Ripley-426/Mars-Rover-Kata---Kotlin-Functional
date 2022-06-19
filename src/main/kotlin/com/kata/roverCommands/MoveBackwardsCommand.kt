package com.kata.roverCommands

import com.kata.Direction
import com.kata.Rover

class MoveBackwardsCommand(val rover: Rover) : IRoverMovementCommand {

    override fun execute(): Rover {
        return when (rover.direction){
            Direction.NORTH -> rover.decreasePosY()
            Direction.SOUTH -> rover.increasePosY()
            Direction.WEST -> rover.increasePosX()
            Direction.EAST -> rover.decreasePosX()
        }
    }

}
