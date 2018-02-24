package managers

import com.smartfoxserver.v2.SmartFoxServer
import com.smartfoxserver.v2.api.CreateRoomSettings
import com.smartfoxserver.v2.entities.Room
import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.Zone
import com.smartfoxserver.v2.mmo.CreateMMORoomSettings
import com.smartfoxserver.v2.mmo.Vec3D
import config.ConfigGame
import config.ConfigRoom

object RoomManager {
    fun joinGameRoom(user: User, roomMap: Int) {
        var room = user.zone.getRoomByName(roomMap.toString())
        if (room == null)
            room = createGameRoom(user.zone, roomMap)
        SmartFoxServer.getInstance().apiManager.sfsApi.joinRoom(user, room)
    }

    fun createGameRoom(zone: Zone, roomMap: Int): Room {
        val cfg = CreateMMORoomSettings()
        cfg.defaultAOI = Vec3D(ConfigGame.DEFAULT_AOI_X,ConfigGame.DEFAULT_AOI_Y,0)
        cfg.maxUsers = ConfigGame.GAME_MAP_MAX_USER
        cfg.maxSpectators = ConfigGame.GAME_MAP_SPECTATOR
        cfg.userMaxLimboSeconds = ConfigGame.USER_MAX_LIMBO_SECONDS
        cfg.isGame = true
        cfg.name = roomMap.toString()
        cfg.extension = CreateRoomSettings.RoomExtensionSettings(ConfigRoom.GAME_ROOM_EXTENSION, ConfigRoom.GAME_ROOM_EXTENSION_CLASS)

        return SmartFoxServer.getInstance().apiManager.sfsApi.createRoom(zone, cfg, null)
    }
}