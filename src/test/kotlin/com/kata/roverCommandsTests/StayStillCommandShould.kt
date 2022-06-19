package com.kata.roverCommandsTests

import com.kata.Direction
import com.kata.Rover
import com.kata.roverCommands.IRoverMovementCommand
import com.kata.roverCommands.service.RoverCommandsService
import com.kata.roverCommands.StayStillCommand
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class StayStillCommandShould {
    private lateinit var command: IRoverMovementCommand
    private lateinit var originalRover: Rover
    private val mapSize = Pair(10, 10)

    @Test
    fun `return an equal rover`() {

        originalRover= Rover(mapSize, Pair(3,3), Direction.SOUTH, RoverCommandsService())

        command = StayStillCommand(originalRover)

        val newRover = command.execute()

        assertTrue(originalRover.isEqual(newRover))
    }
}