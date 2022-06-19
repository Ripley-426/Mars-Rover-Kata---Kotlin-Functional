package com.kata

import com.kata.roverCommands.service.RoverCommandsService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RoverShould {

    private lateinit var rover: Rover
    private lateinit var startingCoordinates: Pair<Int, Int>
    private lateinit var startingDirection: Direction
    private lateinit var mapSize: Pair<Int, Int>
    private val startingXCoordinate: Int = 6
    private val startingYCoordinate: Int = 2
    private val roverCommandsService = RoverCommandsService()

    @BeforeEach
    fun setup(){
        startingCoordinates = Pair(startingXCoordinate, startingYCoordinate)
        startingDirection = Direction.SOUTH
        mapSize = Pair(10,10)
        rover = Rover(mapSize, startingCoordinates, startingDirection, roverCommandsService)
    }

    @Test
    fun `start with user defined position`() {
        assertEquals(startingCoordinates, rover.position)
    }

    @Test
    fun `start with user defined direction`() {
        assertEquals(startingDirection, rover.direction)
    }

    @Test
    fun `start with user defined map size`() {
        assertEquals(mapSize, rover.mapSize)
    }

    @Test
    fun `set default position if starting position is outside map bounds`(){
    val newRover = Rover(Pair(5,5), Pair(8,8), Direction.NORTH, roverCommandsService)

        assertEquals(Pair(0,0), newRover.position)
    }

    @Test
    fun `be able to recognize an equal rover`(){
        val newRover = Rover(rover.mapSize, rover.position, rover.direction, roverCommandsService)

        assertTrue(rover.isEqual(newRover))
    }

    @Test
    fun `be able to move forward`(){
        val newCoordinate = Pair(6,1)
        val commands = "f"

        val newRover = rover.inputCommands(commands)

        assertEquals(newCoordinate, newRover.position)
    }

    @Test
    fun `be able to move backwards`(){
        val newCoordinate = Pair(6,3)
        val commands = "b"

        val newRover = rover.inputCommands(commands)

        assertEquals(newCoordinate, newRover.position)
    }

    @Test
    fun `be able to turn left`(){
        val newFacingDirection = Direction.EAST
        val commands = "l"

        val newRover = rover.inputCommands(commands)

        assertEquals(newFacingDirection, newRover.direction)
    }

    @Test
    fun `be able to turn right`(){
        val newFacingDirection = Direction.WEST
        val commands = "r"

        val newRover = rover.inputCommands(commands)

        assertEquals(newFacingDirection, newRover.direction)
    }

    @Test
    fun `be able to wrap the map from the top edge`(){
        val commands = "llfffffffff"

        val newRover = rover.inputCommands(commands)

        assertEquals(Pair(6,1), newRover.position)
    }

    @Test
    fun `be able to wrap the map from the lower edge`(){
        val commands = "ffff"

        val newRover = rover.inputCommands(commands)

        assertEquals(Pair(6,8), newRover.position)
    }

    @Test
    fun `be able to wrap the map from the right edge`(){
        val commands = "lfffff"

        val newRover = rover.inputCommands(commands)

        assertEquals((Pair(1,2)), newRover.position)
    }

    @Test
    fun `be able to wrap the map from the left edge`(){
        val commands = "rffffffff"

        val newRover = rover.inputCommands(commands)

        assertEquals((Pair(8,2)), newRover.position)
    }
}