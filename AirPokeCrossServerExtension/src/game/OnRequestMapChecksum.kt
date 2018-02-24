package game

import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.entities.data.SFSObject
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler
import config.ConfigSFSPacketKey
import config.ConfigServerRequest
import managers.MapManager

class OnRequestMapChecksum : BaseClientRequestHandler() {
    override fun handleClientRequest(user: User, param: ISFSObject) {
        val payload = SFSObject()
        payload.putInt(ConfigSFSPacketKey.MAP_CHECKSUM, MapManager.getMapChecksum(user.lastJoinedRoom.name.toInt()))
        user.zone.extension.send(ConfigServerRequest.GAME_MAP_CHECKSUM, payload, user)
    }
}