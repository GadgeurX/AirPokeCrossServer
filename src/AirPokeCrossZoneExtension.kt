import com.smartfoxserver.v2.components.login.ILoginAssistantPlugin
import com.smartfoxserver.v2.components.login.LoginAssistantComponent
import com.smartfoxserver.v2.extensions.SFSExtension
import config.Config
import java.util.*

class AirPokeCrossZoneExtension : SFSExtension() {

    val mLoginManager:LoginAssistantComponent = LoginAssistantComponent(this)

    override fun init() {
        trace("[Info] Start " + this.javaClass.simpleName)

        mLoginManager.config.loginTable = Config.DATABASE_LOGIN_TABLE
        mLoginManager.config.userNameField = Config.DATABASE_EMAIL_FIELD
        mLoginManager.config.passwordField = Config.DATABASE_PWD_FIELD
        mLoginManager.config.userNameField = Config.DATABASE_USER_FIELD

        mLoginManager.config.useCaseSensitiveNameChecks = true


        mLoginManager.config.extraFields = Arrays.asList("id")

        mLoginManager.config.postProcessPlugin = ILoginAssistantPlugin { loginData ->
            loginData.session.setProperty("idUser", loginData.extraFields.getInt("id"))
        }
    }
}