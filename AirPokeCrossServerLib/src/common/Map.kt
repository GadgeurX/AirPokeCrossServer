package common

import com.smartfoxserver.v2.entities.data.SFSArray
import com.smartfoxserver.v2.entities.data.SFSObject
import config.ConfigSFSPacketKey
import config.ConfigServerRequest
import java.io.File

class Map(filename: String) {
    var width: Int = 0
    var height: Int = 0
    lateinit var tileArray: Array<Array<Int>>
    lateinit var tilesetArray: Array<Array<Pair<Int, Int>>>
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
            tilesetArray = Array(width, { _ -> Array(height, { _ -> Pair(-1, -1) }) })
            bufferedReader.useLines { lines ->
                lines.forEach {
                    val blockLine = it.split(" ")
                    val x = blockLine[0].toInt()
                    val y = blockLine[1].toInt()
                    val tile = blockLine[2].toInt()
                    val collider = blockLine[3].toInt()
                    tileArray[x][y] = tile
                    colliderArray[x][y] = collider
                    tilesetArray[x][y] = Pair(blockLine[4].toInt(), blockLine[5].toInt())
                }
            }
        } catch (e: Exception) {

        }
    }

    fun toSFSObject() : SFSObject {
        val obj = SFSObject()
        obj.putInt(ConfigSFSPacketKey.MAP_WIDTH, width)
        obj.putInt(ConfigSFSPacketKey.MAP_HEIGHT, height)

        val mapTile = SFSArray()
        val mapTileset = SFSArray()
        var x = 0
        while (x < width) {
            var y = 0
            mapTile.addSFSArray(SFSArray())
            mapTileset.addSFSArray(SFSArray())
            while (y < height) {
                mapTile.getSFSArray(x).addInt(tileArray[x][y])
                val tilesetObj = SFSObject()
                tilesetObj.putInt(ConfigSFSPacketKey.MAP_GLOBAL_TILESET, tilesetArray[x][y].first)
                tilesetObj.putInt(ConfigSFSPacketKey.MAP_LOCAL_TILESET, tilesetArray[x][y].second)
                mapTileset.getSFSArray(x).addSFSObject(tilesetObj)
                y++
            }
            x++
        }
        obj.putSFSArray(ConfigSFSPacketKey.MAP_TILESET, mapTileset)
        obj.putSFSArray(ConfigSFSPacketKey.MAP_TILES, mapTile)
        return obj
    }
}