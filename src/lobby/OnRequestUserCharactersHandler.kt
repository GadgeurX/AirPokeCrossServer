package lobby

import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler
import managers.CharacterManager

/**
 * This class handle the request of user to get his character (same as join event)
 */
class OnRequestUserCharactersHandler : BaseClientRequestHandler() {
    override fun handleClientRequest(user: User?, param: ISFSObject?) {
        CharacterManager.sendUserCharacters(user)
    }
}