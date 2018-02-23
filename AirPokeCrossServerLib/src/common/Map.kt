package common

import java.io.File

class Map(filename: String) {
    var width: Int = 0
    var height: Int = 0
    lateinit var tileArray: Array<Array<Int>>
    lateinit var colliderArray: Array<Array<Int>>

    init {
        loadFromFile(filename)
    }

    fun loadFromFile(filename: String) {
        try {
            val bufferedReader = File(filename).bufferedReader()

            val mapSize = bufferedReader.readLine().split(" ")
            width = mapSize[0].toInt()
            height = mapSize[1].toInt()
            tileArray = Array(width, { _ -> Array(height, { _ -> -1 }) })
            colliderArray = Array(width, { _ -> Array(height, { _ -> -1 }) })
            bufferedReader.useLines { lines ->
                lines.forEach {
                    val blockLine = it.split(" ")
                    val x = blockLine[0].toInt()
                    val y = blockLine[1].toInt()
                    val tile = blockLine[2].toInt()
                    val collider = blockLine[3].toInt()
                    tileArray[x][y] = tile
                    colliderArray[x][y] = collider
                }
            }
        } catch (e: Exception) {

        }
    }
}