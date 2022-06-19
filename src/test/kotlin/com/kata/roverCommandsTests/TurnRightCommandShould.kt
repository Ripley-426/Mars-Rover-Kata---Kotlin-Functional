package com.kata.roverCommandsTests

import com.kata.Direction
import com.kata.Rover
import com.kata.roverCommands.IRoverMovementCommand
import com.kata.roverCommands.service.RoverCommandsService
import com.kata.roverCommands.TurnRightCommand
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TurnRightCommandShould {
    private lateinit var command: IRoverMovementCommand
    private lateinit var originalRover: Rover
    private val mapSize = Pair(10, 10)

    @Test
    fun `return a rover that turned right when facing south`() {
        originalRover= Rover(mapSize, Pair(3,3), Direction.SOUTH, RoverCommandsService())

        command = TurnRightCommand(originalRover)

        val newRover = command.execute()

        assertEquals(Direction.WEST, newRover.direction)
    }

    @Test
    fun `return a rover that turned right when facing west`() {
        originalRover= Rover(mapSize, Pair(3,3), Direction.WEST, RoverCommandsService())

        command = TurnRightCommand(originalRover)

        val newRover = command.execute()

        assertEquals(Direction.NORTH, newRover.direction)
    }

    @Test
    fun `return a rover that turned right when facing north`() {
        originalRover= Rover(mapSize, Pair(3,3), Direction.NORTH, RoverCommandsService())

        command = TurnRightCommand(originalRover)

        val newRover = command.execute()

        assertEquals(Direction.EAST, newRover.direction)
    }

    @Test
    fun `return a rover that turned right when facing east`() {
        originalRover= Rover(mapSize, Pair(3,3), Direction.EAST, RoverCommandsService())

        command = TurnRightCommand(originalRover)

        val newRover = command.execute()

        assertEquals(Direction.SOUTH, newRover.direction)
    }
}