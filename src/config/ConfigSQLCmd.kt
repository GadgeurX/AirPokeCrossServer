package config

import common.Character

object ConfigSQLCmd {

    fun getUserCharactersByUserId(id: Int): String {
        return "SELECT * FROM " + ConfigDB.DATABASE_CHARACTER_TABLE + " WHERE id_user=" + id + ";"
    }

    fun createUserCharacter(character: Character): String {
        return "INSERT INTO " + ConfigDB.DATABASE_CHARACTER_TABLE + " (id_user, species, move_1," +
                "move_2, move_3, move_4, level, hp_iv, atk_iv, def_iv, spe_iv, speed_iv, exp, nickname)" +
                "VALUES (" + character.idUser + "," +
                character.species.ordinal + "," +
                (if (character.move[0] != null) character.move[0]!!.ordinal else "null") + "," +
                (if (character.move[1] != null) character.move[1]!!.ordinal else "null") + "," +
                (if (character.move[2] != null) character.move[2]!!.ordinal else "null") + "," +
                (if (character.move[3] != null) character.move[3]!!.ordinal else "null") + "," +
                character.level + "," +
                character.HP_IV + "," +
                character.ATK_IV + "," +
                character.DEF_IV + "," +
                character.SPCL_IV + "," +
                character.SPEED_IV + "," +
                character.exp + ",\"" +
                character.nickname + "\");"
    }
}