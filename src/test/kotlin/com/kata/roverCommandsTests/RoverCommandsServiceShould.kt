package com.kata.roverCommandsTests

import com.kata.Direction
import com.kata.Rover
import com.kata.roverCommands.service.RoverCommandsService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RoverCommandsServiceShould {
    private lateinit var _roverCommandsService: RoverCommandsService
    private lateinit var originalRover: Rover
    private val mapSize = Pair(10, 10)

    @BeforeEach
    fun setup(){
        _roverCommandsService = RoverCommandsService()
        originalRover= Rover(mapSize, Pair(3,3), Direction.NORTH, _roverCommandsService)
    }

    @Test
    fun `return an equal rover if the command was not recognized`() {
        val commands = "z"
        val newRover = originalRover.inputCommands(commands)

        assertTrue(originalRover.isEqual(newRover))
    }

    @Test
    fun `return a rover that moved forward if the command was forward`(){
        val newPosition = Pair(3,4)
        val command = 'f'

        val newRover = _roverCommandsService.getCommand(command, originalRover).execute()

        assertEquals(newPosition, newRover.position)
    }

    @Test
    fun `return a rover that moved backwards if the command was backwards`(){
        val newPosition = Pair(3,2)
        val command = 'b'

        val newRover = _roverCommandsService.getCommand(command, originalRover).execute()

        assertEquals(newPosition, newRover.position)
    }

    @Test
    fun `return a rover that turned left if the command was left`(){
        val newFacingDirection = Direction.WEST
        val command = 'l'

        val newRover = _roverCommandsService.getCommand(command, originalRover).execute()

        assertEquals(newFacingDirection, newRover.direction)
    }

    @Test
    fun `return a rover that turned right if the command was right`(){
        val newFacingDirection = Direction.EAST
        val command = 'r'

        val newRover = _roverCommandsService.getCommand(command, originalRover).execute()

        assertEquals(newFacingDirection, newRover.direction)
    }
}