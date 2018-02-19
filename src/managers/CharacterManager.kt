package managers

import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.SFSArray
import com.smartfoxserver.v2.entities.data.SFSObject
import common.Character
import config.*
import java.util.*

/**
 * This class handle all character related things
 */
object CharacterManager {

    /**
     * Send all the user's characters
     */
    fun sendUserCharacters(user: User?) {
        if (user != null) {
            val res = DataManager.getUserCharacters(user.zone.dbManager, user)
            val payload = SFSObject()
            val payloadArray = SFSArray()
            (0 until res.size())
                    .map { Character(res.getSFSObject(it)).toPacket() }
                    .forEach { payloadArray.addSFSObject(it) }
            payload.putSFSArray(ConfigSFSPacketKey.CHARACTERS, payloadArray)
            user.zone.extension.send(ConfigServerRequest.USER_CHARACTERS_LIST_REQUEST, payload, user)
        }
    }

    /**
     * Send to user the list of his starter
     */
    fun sendStarterCharacter(user: User?) {
        if (user != null) {
            val payload = SFSObject()
            payload.putSFSArray(ConfigSFSPacketKey.STARTERS, user.properties[ConfigSFSVariable.USER_STARTERS] as SFSArray)
            user.zone.extension.send(ConfigServerRequest.USER_STARTERS_LIST_REQUEST, payload, user)
        }
    }

    /**
     * Set a new starter list for an user if no list was already set
     */
    fun setStarterOfUser(user: User?) {
        if (user != null && !userHasStarterSet(user)) {
            val rand = Random()
            val starters = SFSArray()

            var index = rand.nextInt(ConfigGame.START_CHARACTER.size)
            starters.addInt(ConfigGame.START_CHARACTER[index].ordinal)
            index = rand.nextInt(ConfigGame.START_CHARACTER.size)
            starters.addInt(ConfigGame.START_CHARACTER[index].ordinal)
            index = rand.nextInt(ConfigGame.START_CHARACTER.size)
            starters.addInt(ConfigGame.START_CHARACTER[index].ordinal)
            index = rand.nextInt(ConfigGame.START_CHARACTER.size)
            starters.addInt(ConfigGame.START_CHARACTER[index].ordinal)
            user.properties[ConfigSFSVariable.USER_STARTERS] = starters
        }
    }

    /**
     * Check if the user has a starter list already set
     */
    fun userHasStarterSet(user: User?): Boolean {
        return user!!.properties.containsKey(ConfigSFSVariable.USER_STARTERS)
    }

    /**
     * Create a new character on db from user starter list (store in user object) (indexUserStarter is the index of the starter in that list)
     */
    fun createCharacterOfUser(user: User?, indexUserStarter: Int, nickname:String) {
        if (user != null && userHasStarterSet(user)) {
            val indexStarter = (user.properties[ConfigSFSVariable.USER_STARTERS] as SFSArray).getInt(indexUserStarter)
            val starterSpecies = Character.Species.values()[indexStarter]
            DataManager.createCharacter(user.zone.dbManager, Character(starterSpecies, UserManager.getUserId(user), nickname))
        }
    }
}