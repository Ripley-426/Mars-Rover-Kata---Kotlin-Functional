package com.kata.services

class RoverObstacleDetectionService(mapSize: Pair<Int, Int>) {

    val obstacleMap: Array<BooleanArray>

    init {
        obstacleMap = Array(mapSize.first) { BooleanArray(mapSize.second)}
    }

    fun isObstacleIn(position: Pair<Int, Int>): Boolean{
        return if (obstacleMap[position.first][position.second]){
            println("Obstacle found at (${position.first}, ${position.second})")
            true
        } else {
            false
        }
    }

}
