package config

object ConfgSQLCmd {

    fun getUserCharactersByUserId(id: Int) : String {
        return "SELECT * FROM " + ConfigDB.DATABASE_CHARACTER_TABLE + " WHERE id_user = " + id
    }
}