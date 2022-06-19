package com.kata.roverCommands

import com.kata.Rover

class TurnRightCommand(val rover: Rover) : IRoverMovementCommand {
    override fun execute(): Rover {
        return rover.turnRight()
    }

}
