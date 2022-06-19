package com.kata.services

import com.kata.services.RoverObstacleDetectionService
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class RoverObstacleDetectionServiceShould {

    @Test
    fun `return boolean position status`(){
        val mapSize = Pair(10,10)
        val roverObstacleDetectionService = RoverObstacleDetectionService(mapSize)

        roverObstacleDetectionService.obstacleMap[3][3] = true

        assertTrue(roverObstacleDetectionService.isObstacleIn(Pair(3,3)))
    }
}