package lobby

import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler
import config.ConfigGame
import config.ConfigSFSPacketKey
import managers.CharacterManager
import managers.DataManager
import managers.RoomManager

/**
 * This class handle the request of user to a character
 */
class OnRequestUserSelectCharacterHandler : BaseClientRequestHandler() {
    override fun handleClientRequest(user: User, param: ISFSObject) {
        val character = DataManager.loadUserCharacter(user, param.getInt(ConfigSFSPacketKey.CHARACTER_ID)) ?: return
        CharacterManager.setUserCharacter(user, character)
        RoomManager.joinGameRoom(user, ConfigGame.USER_JOIN_DEFAULT_MAP)
    }
}