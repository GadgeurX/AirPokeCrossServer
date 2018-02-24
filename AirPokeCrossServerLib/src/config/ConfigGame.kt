package config

import common.Character

object ConfigGame {
    val START_CHARACTER = arrayOf(Character.Species.CATERPIE,
            Character.Species.WEEDLE,
            Character.Species.PIDGEY,
            Character.Species.RATTATA,
            Character.Species.SPEAROW,
            Character.Species.EKANS,
            Character.Species.PIKACHU,
            Character.Species.SANDSHREW,
            Character.Species.NIDORAN_F,
            Character.Species.NIDORAN_M,
            Character.Species.CLEFAIRY,
            Character.Species.VULPIX,
            Character.Species.JIGGLYPUFF,
            Character.Species.ZUBAT,
            Character.Species.ODDISH,
            Character.Species.GLOOM,
            Character.Species.PARAS,
            Character.Species.VENONAT,
            Character.Species.DIGLETT,
            Character.Species.MEOWTH,
            Character.Species.MANKEY,
            Character.Species.POLIWAG,
            Character.Species.MACHOP,
            Character.Species.BELLSPROUT,
            Character.Species.TENTACOOL,
            Character.Species.FARFETCH_D,
            Character.Species.VOLTORB,
            Character.Species.GOLDEEN)

    const val MAP_DIRECTORY = "./maps/"

    const val DEFAULT_AOI_X = 10
    const val DEFAULT_AOI_Y = 10
    const val GAME_MAP_MAX_USER = 50000
    const val GAME_MAP_SPECTATOR = 10
    const val USER_MAX_LIMBO_SECONDS = 20

    const val USER_JOIN_DEFAULT_MAP = 0
}