package lobby

import com.smartfoxserver.v2.core.ISFSEvent
import com.smartfoxserver.v2.core.SFSEventParam
import com.smartfoxserver.v2.extensions.BaseServerEventHandler
import com.smartfoxserver.v2.entities.User
import managers.CharacterManager

/**
 * This claas handle the on join event. it send the list of character to user
 */
class OnJoinHandler : BaseServerEventHandler() {
    override fun handleServerEvent(event: ISFSEvent?) {
        CharacterManager.sendUserCharacters(event?.getParameter(SFSEventParam.USER) as User)
    }
}