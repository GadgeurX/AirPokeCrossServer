package managers

import com.smartfoxserver.v2.entities.User
import config.ConfigSFSVariable

/**
 * This class handle all User related things
 */
object UserManager {

    /**
     * Retrieve the user id store in user object at connection time
     */
    fun getUserId(user: User?):Int {
        return if (user?.getProperty(ConfigSFSVariable.USER_ID) != null)
            user.getProperty(ConfigSFSVariable.USER_ID) as Int
        else
            -1
    }
}