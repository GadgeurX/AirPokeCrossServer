import com.smartfoxserver.v2.components.login.ILoginAssistantPlugin
import com.smartfoxserver.v2.components.login.LoginAssistantComponent
import com.smartfoxserver.v2.core.ISFSEvent
import com.smartfoxserver.v2.core.SFSEventParam
import com.smartfoxserver.v2.core.SFSEventType
import com.smartfoxserver.v2.entities.SFSUser
import com.smartfoxserver.v2.extensions.BaseServerEventHandler
import com.smartfoxserver.v2.extensions.SFSExtension
import config.ConfigDB
import config.ConfigRoom
import config.ConfigSFSVariable
import java.util.*

/**
 * This class handle the zone logic (Custom login for now)
 */
class AirPokeCrossZoneExtension : SFSExtension() {

    val mLoginManager:LoginAssistantComponent = LoginAssistantComponent(this)

    override fun init() {
        trace("[Info] Start " + this.javaClass.simpleName)

        mLoginManager.config.loginTable = ConfigDB.DATABASE_LOGIN_TABLE
        mLoginManager.config.userNameField = ConfigDB.DATABASE_EMAIL_FIELD
        mLoginManager.config.passwordField = ConfigDB.DATABASE_PWD_FIELD
        mLoginManager.config.userNameField = ConfigDB.DATABASE_USER_FIELD

        mLoginManager.config.useCaseSensitiveNameChecks = true


        mLoginManager.config.extraFields = Arrays.asList(ConfigDB.DATABASE_ID_FIELD)

        mLoginManager.config.postProcessPlugin = ILoginAssistantPlugin { loginData ->
            loginData.session.setProperty(ConfigSFSVariable.USER_ID, loginData.extraFields.getInt(ConfigDB.DATABASE_ID_FIELD))
        }

        addEventHandler(SFSEventType.USER_JOIN_ZONE, EventHandler())
    }

    /**
     * When the user successful login, it is transfer to the Lobby room
     * @see AirPokeCrossLobbyExtension
     */
    class EventHandler : BaseServerEventHandler() {
        override fun handleServerEvent(event: ISFSEvent?) {
            val user: SFSUser = event?.getParameter(SFSEventParam.USER) as SFSUser
            api.joinRoom(user, user.zone.getRoomByName(ConfigRoom.LOBBY_ROOM_NAME))
        }
    }
}