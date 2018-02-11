package lobby

import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.entities.data.SFSArray
import com.smartfoxserver.v2.entities.data.SFSObject
import com.smartfoxserver.v2.extensions.BaseClientRequestHandler
import config.ConfigGame
import config.ConfigSFSPacketKey
import config.ConfigSFSVariable
import config.ConfigServerRequest
import java.util.Random

class OnRequestBeginCharacterListHandler : BaseClientRequestHandler() {

    override fun handleClientRequest(user: User?, param: ISFSObject?) {
        val rand = Random()
        var starters = SFSArray()

        if (user!!.properties.containsKey(ConfigSFSVariable.USER_STARTERS))
            starters = user.properties[ConfigSFSVariable.USER_STARTERS] as SFSArray
        else {
            var index = rand.nextInt(ConfigGame.START_CHARACTER.size)
            starters.addInt(ConfigGame.START_CHARACTER[index].ordinal)
            index = rand.nextInt(ConfigGame.START_CHARACTER.size)
            starters.addInt(ConfigGame.START_CHARACTER[index].ordinal)
            index = rand.nextInt(ConfigGame.START_CHARACTER.size)
            starters.addInt(ConfigGame.START_CHARACTER[index].ordinal)
            index = rand.nextInt(ConfigGame.START_CHARACTER.size)
            starters.addInt(ConfigGame.START_CHARACTER[index].ordinal)
            user.properties.put(ConfigSFSVariable.USER_STARTERS, starters)
        }

        val payload = SFSObject()
        payload.putSFSArray(ConfigSFSPacketKey.STARTERS, starters)
        send(ConfigServerRequest.userStartersListRequest, payload, user)
    }
}