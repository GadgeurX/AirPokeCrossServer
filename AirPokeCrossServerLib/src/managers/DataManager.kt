package managers

import com.smartfoxserver.v2.db.IDBManager
import com.smartfoxserver.v2.entities.User
import com.smartfoxserver.v2.entities.data.ISFSArray
import com.smartfoxserver.v2.entities.data.SFSObject
import config.ConfigSQLCmd
import common.Character

/**
 * This class is use a interface to the db
 */
object DataManager {

    /**
     * Get all user's characters from db
     */
    fun getUserCharacters(dbManager:IDBManager,user: User?): ISFSArray {
        val query = ConfigSQLCmd.getUserCharactersByUserId(UserManager.getUserId(user))
        return dbManager.executeQuery(query, arrayOf<SFSObject>())
    }

    /**
     * Create a new character on db
     */
    fun createCharacter(dbManager: IDBManager, character:Character) {
        dbManager.executeInsert(ConfigSQLCmd.createUserCharacter(character), arrayOf<SFSObject>())
    }

    fun loadUserCharacter(user: User, characterId: Int?): Character? {
        val query = ConfigSQLCmd.getUserCharacterByUserIdAndCharacterId(UserManager.getUserId(user), characterId!!)
        val characterArray = user.zone.dbManager.executeQuery(query, arrayOf<SFSObject>())
        return if (characterArray.size() == 1)
            Character(characterArray.getSFSObject(0))
        else
            null
    }
}