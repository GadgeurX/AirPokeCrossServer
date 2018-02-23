import com.smartfoxserver.v2.core.SFSEventType
import com.smartfoxserver.v2.extensions.SFSExtension
import config.ConfigClientRequest
import lobby.*
import managers.MapManager

/**
 * This class handle the lobby room (character creation / selection / world join). it redirect to
 * @see AirPokeCrossGameExtension
 */
class AirPokeCrossLobbyExtension : SFSExtension() {
    override fun init() {
        addEventHandler(SFSEventType.USER_JOIN_ROOM, OnJoinHandler())

        addRequestHandler(ConfigClientRequest.USER_STARTERS_LIST_REQUEST, OnRequestStarterCharacterListHandler())
        addRequestHandler(ConfigClientRequest.USER_CHARACTERS_LIST_REQUEST, OnRequestUserCharactersHandler())
        addRequestHandler(ConfigClientRequest.USER_CREATE_CHARACTER_REQUEST, OnCreateCharacterRequestHandler())
        addRequestHandler(ConfigClientRequest.USER_DELETE_CHARACTER_REQUEST, OnDeleteCharacterHandler())
        addRequestHandler(ConfigClientRequest.USER_SELECT_CHARACTER_REQUEST, OnRequestUserSelectCharacterHandler())
    }
}