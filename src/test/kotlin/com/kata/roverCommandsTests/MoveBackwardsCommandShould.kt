package com.kata.roverCommandsTests

import com.kata.Direction
import com.kata.Rover
import com.kata.roverCommands.IRoverMovementCommand
import com.kata.roverCommands.MoveBackwardsCommand
import com.kata.roverCommands.service.RoverCommandsService
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnit
import kotlin.test.assertEquals

class MoveBackwardsCommandShould {
    private lateinit var command: IRoverMovementCommand
    private lateinit var originalRover: Rover
    private val mapSize = Pair(10, 10)

    @Test
    fun `return a rover that moved backwards when facing south`() {

        originalRover= Rover(mapSize, Pair(3,3), Direction.SOUTH, RoverCommandsService())

        command = MoveBackwardsCommand(originalRover)

        val newRover = command.execute()

        assertEquals(Pair(3,4), newRover.position)
    }

    @Test
    fun `return a rover that moved backwards when facing north`() {

        originalRover= Rover(mapSize, Pair(3,3), Direction.NORTH, RoverCommandsService())

        command = MoveBackwardsCommand(originalRover)

        val newRover = command.execute()

        assertEquals(Pair(3,2), newRover.position)
    }

    @Test
    fun `return a rover that moved backwards when facing west`() {

        originalRover= Rover(mapSize, Pair(3,3), Direction.WEST, RoverCommandsService())

        command = MoveBackwardsCommand(originalRover)

        val newRover = command.execute()

        assertEquals(Pair(4,3), newRover.position)
    }

    @Test
    fun `return a rover that moved backwards when facing east`() {

        originalRover= Rover(mapSize, Pair(3,3), Direction.EAST, RoverCommandsService())

        command = MoveBackwardsCommand(originalRover)

        val newRover = command.execute()

        assertEquals(Pair(2,3), newRover.position)
    }
}