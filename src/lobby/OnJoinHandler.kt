package lobby

import com.smartfoxserver.v2.core.ISFSEvent
import com.smartfoxserver.v2.core.SFSEventParam
import com.smartfoxserver.v2.extensions.BaseServerEventHandler
import com.smartfoxserver.v2.entities.SFSUser
import com.smartfoxserver.v2.entities.data.SFSArray
import com.smartfoxserver.v2.entities.data.SFSObject
import common.Character
import config.ConfgSQLCmd
import config.ConfigSFSPacketKey
import config.ConfigSFSVariable
import config.ConfigServerRequest


class OnJoinHandler : BaseServerEventHandler() {
    override fun handleServerEvent(event: ISFSEvent?) {
        val dbManager = parentExtension.parentZone.dbManager
        var user = event?.getParameter(SFSEventParam.USER)
        if (user != null) {
            val query = ConfgSQLCmd.getUserCharactersByUserId((user as SFSUser).getProperty(ConfigSFSVariable.USER_ID) as Int)
            val res = dbManager.executeQuery(query, arrayOf<SFSObject>())
            val payload = SFSObject()
            val payloadArray = SFSArray()
            (0 until res.size())
                    .map { Character(res.getSFSObject(it)).toPacket() }
                    .forEach { payloadArray.addSFSObject(it) }
            payload.putSFSArray(ConfigSFSPacketKey.CHARACTERS, payloadArray)
            send(ConfigServerRequest.userCharacterListRequest, payload, user)
        }
    }
}