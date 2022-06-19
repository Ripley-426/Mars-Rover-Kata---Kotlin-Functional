package com.kata.roverCommands

import com.kata.Rover

class StayStillCommand(private val rover: Rover) : IRoverMovementCommand {

    override fun execute(): Rover {
        return rover
    }

}
