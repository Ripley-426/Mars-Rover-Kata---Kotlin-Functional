package com.kata.services

import com.kata.Rover
import com.kata.roverCommands.*

class RoverCommandsService {

    fun getCommand(command: Char, rover: Rover): IRoverMovementCommand {
        return when (command){
            'f' -> MoveForwardCommand(rover)
            'b' -> MoveBackwardsCommand(rover)
            'l' -> TurnLeftCommand(rover)
            'r' -> TurnRightCommand(rover)
            else -> StayStillCommand(rover)
        }
    }

}
