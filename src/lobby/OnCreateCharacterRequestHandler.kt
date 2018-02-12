package lobby

import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler
import config.ConfigSFSPacketKey
import managers.CharacterManager

/**
 * This class handle the request of create a new character
 */
class OnCreateCharacterRequestHandler : BaseClientRequestHandler() {
    override fun handleClientRequest(user: User?, param: ISFSObject?) {
        CharacterManager.createCharacterOfUser(user, param!!.getInt(ConfigSFSPacketKey.STARTER_INDEX), param!!.getUtfString(ConfigSFSPacketKey.STARTER_NICKNAME))
    }
}