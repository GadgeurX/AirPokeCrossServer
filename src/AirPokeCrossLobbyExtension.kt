import com.smartfoxserver.v2.core.SFSEventType
import com.smartfoxserver.v2.extensions.SFSExtension
import config.ConfigClientRequest
import lobby.OnJoinHandler
import lobby.OnRequestBeginCharacterListHandler

class AirPokeCrossLobbyExtension : SFSExtension() {
    override fun init() {
        addEventHandler(SFSEventType.USER_JOIN_ROOM, OnJoinHandler())

        addRequestHandler(ConfigClientRequest.userStartersListRequest, OnRequestBeginCharacterListHandler())
    }
}