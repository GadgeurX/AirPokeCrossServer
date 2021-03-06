package managers

import com.smartfoxserver.v2.extensions.SFSExtension
import common.Map
import config.ConfigGame
import java.io.File

object MapManager {
    val maps: MutableMap<Int, Map> = mutableMapOf()

    fun loadMaps(extension: SFSExtension) {
        extension.trace("Loading Maps ....")
        try {
            File(ConfigGame.MAP_DIRECTORY).list().forEach {
                var dir = ConfigGame.MAP_DIRECTORY
                if (!dir.endsWith('/'))
                    dir += "/"
                try {
                    extension.trace("Loading Map: ", it)
                    maps[it.split(".")[0].toInt()] = Map(dir + it)

                } catch (e: Exception) {
                    extension.trace("Cannot load map " + dir + it)
                }
            }
        } catch (e: Exception) {
            extension.trace("Cannot load map folder")
        }
    }

    fun getMapChecksum(index : Int): Int {
        val tileArray = maps[index]!!.tileArray
        var checksum = 0
        var x = 0
        while (x < maps[index]!!.width) {
            var y = 0
            while (y < maps[index]!!.height) {
                checksum = (checksum + tileArray[x][y]) % 10000000
                y++
            }
            x++
        }
        return checksum
    }

    fun getMap(index : Int): Map {
        return maps[index]!!
    }
}