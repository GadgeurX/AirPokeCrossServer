package game

import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.entities.data.SFSObject
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler
import config.ConfigSFSPacketKey
import config.ConfigServerRequest
import managers.MapManager

class OnRequestMap : BaseClientRequestHandler() {
    override fun handleClientRequest(user: User, param: ISFSObject) {
        user.zone.extension.send(ConfigServerRequest.GAME_MAP, MapManager.getMap(user.lastJoinedRoom.name.toInt()).toSFSObject(), user)
    }
}