import com.smartfoxserver.v2.extensions.SFSExtension
import config.ConfigClientRequest
import game.OnRequestMap
import game.OnRequestMapChecksum

/**
 * This class handle the game room (map / character move / character attack / etc)
 */
class AirPokeCrossGameExtension: SFSExtension() {
    override fun init() {
        addRequestHandler(ConfigClientRequest.GAME_MAP_CHECKSUM, OnRequestMapChecksum())
        addRequestHandler(ConfigClientRequest.GAME_MAP, OnRequestMap())
    }
}