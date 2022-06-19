package com.kata.roverCommands

import com.kata.Rover

interface IRoverMovementCommand {
    fun execute(): Rover
}
