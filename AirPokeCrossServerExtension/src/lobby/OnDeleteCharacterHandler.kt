package lobby

import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler

/**
 * This class handle the request of delete a character
 */
class OnDeleteCharacterHandler : BaseClientRequestHandler() {
    override fun handleClientRequest(user: User?, param: ISFSObject?) {
    }
}