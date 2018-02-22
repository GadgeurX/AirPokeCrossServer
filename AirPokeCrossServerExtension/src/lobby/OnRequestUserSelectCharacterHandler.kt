package lobby

import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler
import config.ConfigSFSPacketKey
import managers.CharacterManager
import managers.DataManager

/**
 * This class handle the request of user to a character
 */
class OnRequestUserSelectCharacterHandler : BaseClientRequestHandler() {
    override fun handleClientRequest(user: User, param: ISFSObject) {
        val character = DataManager.loadUserCharacter(user, param.getInt(ConfigSFSPacketKey.CHARACTER_ID))
        if (character != null)
            CharacterManager.setUserCharacter(user, character)
    }
}