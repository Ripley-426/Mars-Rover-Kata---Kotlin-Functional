package com.kata.roverCommands

import com.kata.Direction
import com.kata.Rover

class TurnLeftCommand(val rover: Rover) : IRoverMovementCommand {

    override fun execute(): Rover {
        return rover.turnLeft()
    }

}
