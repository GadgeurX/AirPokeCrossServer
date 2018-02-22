package common

import com.smartfoxserver.v2.entities.data.ISFSObject
import com.smartfoxserver.v2.entities.data.SFSObject
import config.ConfigDB
import config.ConfigSFSPacketKey


class Character {

    var mIsTraded = false
    var HP_IV = (Math.random() * 31).toInt() + 1
    var ATK_IV = (Math.random() * 31).toInt() + 1
    var DEF_IV = (Math.random() * 31).toInt() + 1
    var SPCL_IV = (Math.random() * 31).toInt() + 1
    var SPEED_IV = (Math.random() * 31).toInt() + 1
    var HP_EV = 0
    var ATK_EV = 0
    var DEF_EV = 0
    var SPCL_EV = 0
    var SPEED_EV = 0

    var idUser = 0

    var TRUE_PP = intArrayOf(0, 0, 0, 0)
    var TRUE_PPMAX = intArrayOf(0, 0, 0, 0)

    var nickname: String = "none"
    var idNumber: Int = 0
    var pokedexNumber: Int = 0
    var level: Int = 0
    var exp: Int = 0
    var health: Int = 0
    var atk: Int = 0
    var def: Int = 0
    var speed: Int = 0
    var spcl: Int = 0
    var healthMax: Int = 0
    var atkStage: Int = 0
    var defStage: Int = 0
    var speedStage: Int = 0
    var spclStage: Int = 0
    var eva = 1.0
    var evaStage: Int = 0
    var accuracyStage: Int = 0
    var baseHP: Int = 0
    var baseATK: Int = 0
    var baseDEF: Int = 0
    var baseSPEED: Int = 0
    var baseSPCL: Int = 0
    var type1: Type = Type.NONE
    var type2: Type = Type.NONE
    var species: Species = Species.BULBASAUR
    var status = Status.OK
    var substatus = Substatus.OK
    var move = arrayOfNulls<Move>(4)
    //Returns Sum of Base Stats
    val baseStatTotal: Int
        get() {
            return HP_IV + ATK_IV + DEF_IV + SPCL_IV + SPEED_IV
        }
    //Returns a string of this Character's types
    val typeString: String
        get() {
            var str = ""
            when (type1) {
                Character.Type.BIRD -> str += "Bird"
                Character.Type.BUG -> str += "Bug"
                Character.Type.DRAGON -> str += "Drag"
                Character.Type.ELECTRIC -> str += "Elec"
                Character.Type.FIGHTING -> str += "Fght"
                Character.Type.FIRE -> str += "Fire"
                Character.Type.FLYING -> str += "Fly"
                Character.Type.GHOST -> str += "Ghst"
                Character.Type.GRASS -> str += "Grss"
                Character.Type.GROUND -> str += "Grd"
                Character.Type.ICE -> str += "Ice"
                Character.Type.NORMAL -> str += "Nrm"
                Character.Type.POISON -> str += "Psn"
                Character.Type.PSYCHIC -> str += "Psy"
                Character.Type.ROCK -> str += "Rock"
                Character.Type.WATER -> str += "Wtr"
                else -> {
                }
            }
            if (type2 != Type.NONE) {
                str += "/"
                when (type2) {
                    Character.Type.BIRD -> str += "Bird"
                    Character.Type.BUG -> str += "Bug"
                    Character.Type.DRAGON -> str += "Drag"
                    Character.Type.ELECTRIC -> str += "Elec"
                    Character.Type.FIGHTING -> str += "Fght"
                    Character.Type.FIRE -> str += "Fire"
                    Character.Type.FLYING -> str += "Fly"
                    Character.Type.GHOST -> str += "Ghst"
                    Character.Type.GRASS -> str += "Grss"
                    Character.Type.GROUND -> str += "Grd"
                    Character.Type.ICE -> str += "Ice"
                    Character.Type.NORMAL -> str += "Nrm"
                    Character.Type.POISON -> str += "Psn"
                    Character.Type.PSYCHIC -> str += "Psy"
                    Character.Type.ROCK -> str += "Rock"
                    Character.Type.WATER -> str += "Wtr"
                    else -> {
                    }
                }
            }
            return str
        }

    enum class Species {
        BULBASAUR, IVYSAUR, VENUSAUR, CHARMANDER, CHARMELEON, CHARIZARD, SQUIRTLE,
        WARTORTLE, BLASTOISE, CATERPIE, METAPOD, BUTTERFREE, WEEDLE, KAKUNA, BEEDRILL,
        PIDGEY, PIDGEOTTO, PIDGEOT, RATTATA, RATICATE, SPEAROW, FEAROW, EKANS, ARBOK, PIKACHU,
        RAICHU, SANDSHREW, SANDSLASH, NIDORAN_F, NIDORINA, NIDOQUEEN, NIDORAN_M,
        NIDORINO, NIDOKING, CLEFAIRY, CLEFABLE, VULPIX, NINETALES, JIGGLYPUFF, WIGGLYTUFF, ZUBAT,
        GOLBAT, ODDISH, GLOOM, VILEPLUME, PARAS, PARASECT, VENONAT, VENOMOTH, DIGLETT, DUGTRIO,
        MEOWTH, PERSIAN, PSYDUCK, GOLDUCK, MANKEY, PRIMEAPE, GROWLITHE, ARCANINE, POLIWAG, POLIWHIRL,
        POLIWRATH, ABRA, KADABRA, ALAKAZAM, MACHOP, MACHOKE, MACHAMP, BELLSPROUT, WEEPINBELL,
        VICTREEBEL, TENTACOOL, TENTACRUEL, GEODUDE, GRAVELER, GOLEM, PONYTA, RAPIDASH, SLOWPOKE,
        SLOWBRO, MAGNEMITE, MAGNETON, FARFETCH_D, DODUO, DODRIO, SEEL, DEWGONG, GRIMER, MUK,
        SHELLDER, CLOYSTER, GASTLY, HAUNTER, GENGAR, ONIX, DROWZEE, HYPNO, KRABBY, KINGLER, VOLTORB,
        ELECTRODE, EXEGGCUTE, EXEGGUTOR, CUBONE, MAROWAK, HITMONLEE, HITMONCHAN, LICKITUNG, KOFFING,
        WEEZING, RHYHORN, RHYDON, CHANSEY, TANGELA, KANGASKHAN, HORSEA, SEADRA, GOLDEEN, SEAKING,
        STARYU, STARMIE, MR_MIME, SCYTHER, JYNX, ELECTABUZZ, MAGMAR, PINSIR, TAUROS, MAGIKARP,
        GYARADOS, LAPRAS, DITTO, EEVEE, VAPOREON, JOLTEON, FLAREON, PORYGON, OMANYTE, OMASTAR, KABUTO,
        KABUTOPS, AERODACTYL, SNORLAX, ARTICUNO, ZAPDOS, MOLTRES, DRATINI, DRAGONAIR, DRAGONITE,
        MEWTWO, MEW, MISSINGNO
    }

    enum class Type {
        BUG, DRAGON, ELECTRIC, FIGHTING, FIRE, FLYING, GHOST, GRASS, GROUND, ICE,
        NORMAL, POISON, PSYCHIC, ROCK, WATER, NONE, BIRD
    }

    enum class Status {
        OK, SLP, PSN, PAR, BRN, FRZ, FNT
    }

    enum class Substatus {
        OK, CONFU, FLINCH, SEED
    }

    enum class Move {
        ABSORB, ACID, ACID_ARMOR, AGILITY, AMNESIA, AURORA_BEAM, BARRAGE, BARRIER,
        BIDE, BIND, BITE, BLIZZARD, BODY_SLAM, BONE_CLUB, BONEMERANG, BUBBLE, BUBBLEBEAM,
        CLAMP, COMET_PUNCH, CONFUSE_RAY, CONFUSION, CONSTRICT, CONVERSION, COUNTER,
        CRABHAMMER, CUT, DEFENSE_CURL, DIG, DISABLE, DIZZY_PUNCH, DOUBLE_KICK,
        DOUBLE_TEAM, DOUBLE_EDGE, DOUBLESLAP, DRAGON_RAGE, DREAM_EATER, DRILL_PECK,
        EARTHQUAKE, EGG_BOMB, EMBER, EXPLOSION, FIRE_BLAST, FIRE_PUNCH, FIRE_SPIN,
        FISSURE, FLAMETHROWER, FLASH, FLY, FOCUS_ENERGY, FURY_ATTACK, FURY_SWIPES, GLARE,
        GROWL, GROWTH, GUILLOTINE, GUST, HARDEN, HAZE, HEADBUTT, HI_JUMP_KICK, HORN_ATTACK,
        HORN_DRILL, HYDRO_PUMP, HYPER_BEAM, HYPER_FANG, HYPNOSIS, ICE_BEAM, ICE_PUNCH,
        JUMP_KICK, KARATE_CHOP, KINESIS, LEECH_LIFE, LEECH_SEED, LEER, LICK, LIGHT_SCREEN,
        LOVELY_KISS, LOW_KICK, MEDITATE, MEGA_DRAIN, MEGA_KICK, MEGA_PUNCH, METRONOME,
        MIMIC, MINIMIZE, MIRROR_MOVE, MIST, NIGHT_SHADE, PAY_DAY, PECK, PETAL_DANCE,
        PIN_MISSILE, POISON_GAS, POISON_STING, POISONPOWDER, POUND, PSYBEAM, PSYCHIC,
        PSYWAVE, QUICK_ATTACK, RAGE, RAZOR_LEAF, RAZOR_WIND, RECOVER, REFLECT, REST, ROAR,
        ROCK_SLIDE, ROCK_THROW, ROLLING_KICK, SAND_ATTACK, SCRATCH, SCREECH, SEISMIC_TOSS,
        SELFDESTRUCT, SHARPEN, SING, SKULL_BASH, SKY_ATTACK, SLAM, SLASH, SLEEP_POWDER,
        SLUDGE, SMOG, SMOKESCREEN, SOFTBOILED, SOLARBEAM, SONIC_BOOM, SPIKE_CANNON, SPLASH,
        SPORE, STOMP, STRENGTH, STRING_SHOT, STRUGGLE, STUN_SPORE, SUBMISSION, SUBSTITUTE,
        SUPER_FANG, SUPERSONIC, SURF, SWIFT, SWORDS_DANCE, TACKLE, TAIL_WHIP, TAKE_DOWN,
        TELEPORT, THRASH, THUNDER, THUNDER_WAVE, THUNDERBOLT, THUNDERPUNCH, THUNDERSHOCK,
        TOXIC, TRANSFORM, TRI_ATTACK, TWINEEDLE, VICEGRIP, VINE_WHIP, WATER_GUN, WATERFALL,
        WHIRLWIND, WING_ATTACK, WITHDRAW, WRAP, NONE;

        internal var accuracy: Int = 0
        internal var mainEffect: Primary_Effect = Primary_Effect.NONE
        internal var sideEffect: Side_Effect = Side_Effect.NONE
        internal var status: Status = Status.OK
        internal var substatus: Substatus = Substatus.OK
        internal var sideEffectAcc: Int = 0
        internal var basePower: Int = 0
        internal var pp: Int = 0
        internal var ppMax: Int = 0
        internal var moveType: Type = Type.NONE
    }

    enum class Side_Effect {
        NONE, STAT, STATUS, SUBSTATUS, MULTI_HIT, MULTI_TURN, ABSORB, OHKO, HIGH_CRIT, CHARGE,
        FAINT, RECOIL, SUBSTITUTE, DISABLE, RECOVERY, COLLECT_DAMAGE, TRANSFORM,
        CONVERSION, FIXED_DAMAGE, METRONOME, MIMIC, MIRROR_MOVE, QUICK_ATTACK, SWIFT, ROAR, HIDE, FURY
    }

    enum class Primary_Effect {
        DAMAGE, RAISE_STAT, LOWER_STAT, INFLICT_STATUS, SPECIAL, NONE
    }

    //Create a brand new Character
    constructor(s: Species) {
        level = 5
        exp = 100
        idUser = -1
        createPokemon(s, level)
        createMoves()
    }

    constructor(s: Species, id_user:Int, nick:String) {
        level = 5
        exp = 100
        idUser = id_user
        createPokemon(s, level)
        createMoves()
        nickname = nick
    }

    //Create a brand new Character with a specified level
    constructor(s: Species, lvl: Int) {
        level = lvl
        exp = (lvl - 1) * (lvl - 1) * (lvl - 1)
        exp += lvl
        idUser = -1
        createPokemon(s, level)
        createMoves()
    }

    //Creates a Character for Trainers with moveset and level
    constructor(s: Species, m1: Move?, lvl: Int) {
        level = lvl
        exp = (lvl - 1) * (lvl - 1) * (lvl - 1)
        exp += lvl
        idUser = -1
        createPokemon(s, level)
        move[0] = m1
        createMoves()
    }

    //Creates a Character for Trainers with moveset and level
    constructor(s: Species, m1: Move?, m2: Move?, lvl: Int) {
        level = lvl
        exp = (lvl - 1) * (lvl - 1) * (lvl - 1)
        exp += lvl
        idUser = -1
        createPokemon(s, level)
        move[0] = m1
        move[1] = m2
        createMoves()
    }

    //Creates a Character for Trainers with moveset and level
    constructor(s: Species, m1: Move?, m2: Move?, m3: Move?, lvl: Int) {
        level = lvl
        exp = (lvl - 1) * (lvl - 1) * (lvl - 1)
        exp += lvl
        idUser = -1
        createPokemon(s, level)
        move[0] = m1
        move[1] = m2
        move[2] = m3
        createMoves()
    }

    //Creates a Character for Trainers with moveset and level
    constructor(s: Species, m1: Move?, m2: Move?, m3: Move?, m4: Move?, lvl: Int) {
        level = lvl
        exp = (lvl - 1) * (lvl - 1) * (lvl - 1)
        exp += lvl
        idUser = -1
        createPokemon(s, level)
        move[0] = m1
        move[1] = m2
        move[2] = m3
        move[3] = m4
        createMoves()
    }

    //Most verbose way to create a Character
    constructor(s: Species, m1: Move?, m2: Move?, m3: Move?, m4: Move?, lvl: Int, hpiv: Int, atkiv: Int, defiv: Int, spcliv: Int, speediv: Int,
                nick: String, stat: Status, idNo: Int, pExp: Int, pIdUser: Int) {
        level = lvl
        exp = pExp
        idUser = pIdUser
        HP_IV = hpiv
        ATK_IV = atkiv
        DEF_IV = defiv
        SPCL_IV = spcliv
        SPEED_IV = speediv
        createPokemon(s, lvl)
        move[0] = m1
        move[1] = m2
        move[2] = m3
        move[3] = m4
        createMoves()
        status = stat
        nickname = nick
        idNumber = idNo
    }

    constructor(obj: ISFSObject) : this(Species.values()[obj.getInt(ConfigDB.DATABASE_CHARACTER_SPECIES_FIELD)],
            if (obj.getInt(ConfigDB.DATABASE_CHARACTER_MOVE_1_FIELD) != null)  Move.values()[obj.getInt(ConfigDB.DATABASE_CHARACTER_MOVE_1_FIELD)] else Move.NONE,
            if (obj.getInt(ConfigDB.DATABASE_CHARACTER_MOVE_2_FIELD) != null)  Move.values()[obj.getInt(ConfigDB.DATABASE_CHARACTER_MOVE_2_FIELD)] else Move.NONE,
            if (obj.getInt(ConfigDB.DATABASE_CHARACTER_MOVE_3_FIELD) != null)  Move.values()[obj.getInt(ConfigDB.DATABASE_CHARACTER_MOVE_3_FIELD)] else Move.NONE,
            if (obj.getInt(ConfigDB.DATABASE_CHARACTER_MOVE_4_FIELD) != null)  Move.values()[obj.getInt(ConfigDB.DATABASE_CHARACTER_MOVE_4_FIELD)] else Move.NONE,
            obj.getInt(ConfigDB.DATABASE_CHARACTER_LEVEL_FIELD),
            obj.getInt(ConfigDB.DATABASE_CHARACTER_HP_IV_FIELD),
            obj.getInt(ConfigDB.DATABASE_CHARACTER_ATK_IV_FIELD),
            obj.getInt(ConfigDB.DATABASE_CHARACTER_DEF_IV_FIELD),
            obj.getInt(ConfigDB.DATABASE_CHARACTER_SPE_IV_FIELD),
            obj.getInt(ConfigDB.DATABASE_CHARACTER_SPEED_IV_FIELD),
            obj.getUtfString(ConfigDB.DATABASE_CHARACTER_NICKNAME_FIELD),
            Status.OK,
            obj.getInt(ConfigDB.DATABASE_CHARACTER_ID_FIELD),
            obj.getInt(ConfigDB.DATABASE_CHARACTER_EXP_FIELD),
            obj.getInt(ConfigDB.DATABASE_CHARACTER_ID_USER_FIELD))

    public override fun toString(): String {
        return ("Name: " + nickname + " Species: " + toString(species) + " Level:" + level + "\n" +
                "Atk: " + atk + " Def: " + def + " Spcl: " + spcl + " Speed: " + speed + " Exp: " + exp + "\n" +
                "HP:" + health + "/" + healthMax + "\n" +
                move[0] + "\n" + move[1] + "\n" + move[2] + "\n" + move[3])
    }

    fun toBattleString(): String {
        return (nickname + " Lvl: " + level + " HP:" + health + "/" + healthMax + " Status: " + status + "\n" + "\n" +
                "0:" + move[0] + " PP: " + move[0]?.pp + "/" + move[0]?.ppMax + "\n" +
                "1:" + move[1] + " PP: " + move[1]?.pp + "/" + move[1]?.ppMax + "\n" +
                "2:" + move[2] + " PP: " + move[2]?.pp + "/" + move[2]?.ppMax + "\n" +
                "3:" + move[3] + " PP: " + move[3]?.pp + "/" + move[3]?.ppMax)
    }

    //Checks and Sets if a Character is traded given an ID
    fun checkTraded(idToBeChecked: Int) {
        mIsTraded = (idNumber == idToBeChecked)
    }

    //Returns the new calculation of a Pokemon's HP stat
    fun calcHPStat(base: Int, iv: Int, ev: Int, lvl: Int): Int {
        return ((2 * base + iv + ev / 255 / 4) * (lvl / 100.0) + lvl.toDouble() + 10.0).toInt()
    }

    //Returns the new calculation of a Pokemon's non-HP stat
    fun calcOtherStat(base: Int, iv: Int, ev: Int, lvl: Int): Int {
        return (((2 * base + iv + ev / 255 / 4) * (lvl / 100.0) + 5) * 1.1).toInt()
    }

    //Sets this Character's stats TO DA MAX!!!
    fun setMaxStats() {
        HP_IV = 31
        HP_EV = 256 * 256
        ATK_IV = 31
        ATK_EV = 256 * 256
        DEF_IV = 31
        DEF_EV = 256 * 256
        SPCL_IV = 31
        SPCL_EV = 256 * 256
        SPEED_IV = 31
        SPEED_EV = 256 * 256
        healthMax = calcHPStat(baseHP, HP_IV, HP_EV, level)
        health = healthMax
        atk = calcOtherStat(baseATK, ATK_IV, ATK_EV, level)
        def = calcOtherStat(baseDEF, DEF_IV, DEF_EV, level)
        spcl = calcOtherStat(baseSPCL, SPCL_IV, SPCL_EV, level)
        speed = calcOtherStat(baseSPEED, SPEED_IV, SPEED_EV, level)
    }

    //Sets Character EVs to the given stat and value
    fun setEV(str: String, ev: Int) {
        if (str == "HP")
            HP_EV = ev
        else if (str == "ATK")
            ATK_EV = ev
        else if (str == "DEF")
            DEF_EV = ev
        else if (str == "SPCL")
            SPCL_EV = ev
        else if (str == "SPEED")
            SPEED_EV = ev
        if (HP_EV > 256 * 256)
            HP_EV = 256 * 256
        if (ATK_EV > 256 * 256)
            ATK_EV = 256 * 256
        if (DEF_EV > 256 * 256)
            DEF_EV = 256 * 256
        if (SPCL_EV > 256 * 256)
            SPCL_EV = 256 * 256
        if (SPEED_EV > 256 * 256)
            SPEED_EV = 256 * 256
        healthMax = calcHPStat(baseHP, HP_IV, HP_EV, level)
        health = healthMax
        atk = calcOtherStat(baseATK, ATK_IV, ATK_EV, level)
        def = calcOtherStat(baseDEF, DEF_IV, DEF_EV, level)
        spcl = calcOtherStat(baseSPCL, SPCL_IV, SPCL_EV, level)
        speed = calcOtherStat(baseSPEED, SPEED_IV, SPEED_EV, level)
    }

    fun toHPOnlyString(): String {
        return nickname + " HP:" + health + "/" + healthMax + " Status: " + status
    }

    fun toString(s: Species): String {
        return "" + s
    }

    fun toString(m: Move): String {
        val str = "" + m
        str.replace('_', ' ')
        return str
    }

    //Returns the species a Character will evolve into
    //Level up version
    fun evolve(p: Character): Species {
        when (p.species) {
            Character.Species.BULBASAUR -> if (level >= 16)
                return Species.IVYSAUR
            Character.Species.IVYSAUR -> if (level >= 32)
                return Species.VENUSAUR
            Character.Species.CHARMANDER -> if (level >= 16)
                return Species.CHARMELEON
            Character.Species.CHARMELEON -> if (level >= 36)
                return Species.CHARIZARD
            Character.Species.SQUIRTLE -> if (level >= 16)
                return Species.WARTORTLE
            Character.Species.WARTORTLE -> if (level >= 36)
                return Species.BLASTOISE
            Character.Species.CATERPIE -> if (level >= 7)
                return Species.METAPOD
            Character.Species.METAPOD -> if (level >= 10)
                return Species.BUTTERFREE
            Character.Species.WEEDLE -> if (level >= 7)
                return Species.KAKUNA
            Character.Species.KAKUNA -> if (level >= 10)
                return Species.BEEDRILL
            Character.Species.PIDGEY -> if (level >= 18)
                return Species.PIDGEOTTO
            Character.Species.PIDGEOTTO -> if (level >= 36)
                return Species.PIDGEOT
            Character.Species.RATTATA -> if (level >= 20)
                return Species.RATICATE
            Character.Species.SPEAROW -> if (level >= 20)
                return Species.FEAROW
            Character.Species.EKANS -> if (level >= 22)
                return Species.ARBOK
            Character.Species.SANDSHREW -> if (level >= 22)
                return Species.SANDSLASH
            Character.Species.NIDORAN_F -> if (level >= 16)
                return Species.NIDORINA
            Character.Species.NIDORAN_M -> if (level >= 16)
                return Species.NIDORINO
            Character.Species.ZUBAT -> if (level >= 22)
                return Species.GOLBAT
            Character.Species.ODDISH -> if (level >= 21)
                return Species.GLOOM
            Character.Species.PARAS -> if (level >= 24)
                return Species.PARASECT
            Character.Species.VENONAT -> if (level >= 31)
                return Species.VENOMOTH
            Character.Species.DIGLETT -> if (level >= 26)
                return Species.DUGTRIO
            Character.Species.MEOWTH -> if (level >= 28)
                return Species.PERSIAN
            Character.Species.PSYDUCK -> if (level >= 33)
                return Species.GOLDUCK
            Character.Species.MANKEY -> if (level >= 28)
                return Species.PRIMEAPE
            Character.Species.POLIWAG -> if (level >= 25)
                return Species.POLIWHIRL
            Character.Species.ABRA -> if (level >= 16)
                return Species.KADABRA
            Character.Species.MACHOP -> if (level >= 28)
                return Species.MACHOKE
            Character.Species.BELLSPROUT -> if (level >= 21)
                return Species.WEEPINBELL
            Character.Species.TENTACOOL -> if (level >= 30)
                return Species.TENTACRUEL
            Character.Species.GEODUDE -> if (level >= 25)
                return Species.GRAVELER
            Character.Species.PONYTA -> if (level >= 40)
                return Species.RAPIDASH
            Character.Species.SLOWPOKE -> if (level >= 37)
                return Species.SLOWBRO
            Character.Species.MAGNEMITE -> if (level >= 30)
                return Species.MAGNETON
            Character.Species.DODUO -> if (level >= 31)
                return Species.DODRIO
            Character.Species.SEEL -> if (level >= 34)
                return Species.DEWGONG
            Character.Species.GRIMER -> if (level >= 38)
                return Species.MUK
            Character.Species.GASTLY -> if (level >= 25)
                return Species.HAUNTER
            Character.Species.DROWZEE -> if (level >= 26)
                return Species.HYPNO
            Character.Species.KRABBY -> if (level >= 28)
                return Species.KINGLER
            Character.Species.VOLTORB -> if (level >= 30)
                return Species.ELECTRODE
            Character.Species.CUBONE -> if (level >= 28)
                return Species.MAROWAK
            Character.Species.KOFFING -> if (level >= 35)
                return Species.WEEZING
            Character.Species.RHYHORN -> if (level >= 42)
                return Species.RHYDON
            Character.Species.HORSEA -> if (level >= 32)
                return Species.SEADRA
            Character.Species.GOLDEEN -> if (level >= 33)
                return Species.SEAKING
            Character.Species.MAGIKARP -> if (level >= 20)
                return Species.GYARADOS
            Character.Species.OMANYTE -> if (level >= 40)
                return Species.OMASTAR
            Character.Species.KABUTO -> if (level >= 40)
                return Species.KABUTOPS
            Character.Species.DRATINI -> if (level >= 30)
                return Species.DRAGONAIR
            Character.Species.DRAGONAIR -> if (level >= 55)
                return Species.DRAGONITE
            Character.Species.MISSINGNO -> if (level >= 80)
                return Species.KANGASKHAN
            else -> return p.species
        }
        return p.species
    }

    //Evolutionary Stone version
    fun evolve(p: Character, t: Item.Type): Species {
        when (p.species) {
            Character.Species.PIKACHU -> if (t === Item.Type.THUNDER_STONE)
                return Species.RAICHU
            Character.Species.NIDORINA -> if (t === Item.Type.MOON_STONE)
                return Species.NIDOQUEEN
            Character.Species.NIDORINO -> if (t === Item.Type.MOON_STONE)
                return Species.NIDOKING
            Character.Species.CLEFAIRY -> if (t === Item.Type.MOON_STONE)
                return Species.CLEFABLE
            Character.Species.VULPIX -> if (t === Item.Type.FIRE_STONE)
                return Species.NINETALES
            Character.Species.JIGGLYPUFF -> if (t === Item.Type.MOON_STONE)
                return Species.WIGGLYTUFF
            Character.Species.GLOOM -> if (t === Item.Type.LEAF_STONE)
                return Species.VILEPLUME
            Character.Species.GROWLITHE -> if (t === Item.Type.FIRE_STONE)
                return Species.ARCANINE
            Character.Species.POLIWHIRL -> if (t === Item.Type.WATER_STONE)
                return Species.POLIWRATH
            Character.Species.WEEPINBELL -> if (t === Item.Type.LEAF_STONE)
                return Species.VICTREEBEL
            Character.Species.SHELLDER -> if (t === Item.Type.WATER_STONE)
                return Species.CLOYSTER
            Character.Species.EXEGGCUTE -> if (t === Item.Type.LEAF_STONE)
                return Species.EXEGGUTOR
            Character.Species.STARYU -> if (t === Item.Type.WATER_STONE)
                return Species.STARMIE
            Character.Species.EEVEE -> if (t === Item.Type.WATER_STONE)
                return Species.VAPOREON
            else if (t === Item.Type.THUNDER_STONE)
                return Species.JOLTEON
            else if (t === Item.Type.FIRE_STONE)
                return Species.FLAREON
            else -> return p.species
        }
        return p.species
    }

    //Trade version
    fun evolve(p: Character, idToCheck: Int): Species {
        if (idToCheck != p.idNumber) {
            when (p.species) {
                Character.Species.KADABRA -> return Species.ALAKAZAM
                Character.Species.MACHOKE -> return Species.MACHAMP
                Character.Species.GRAVELER -> return Species.GOLEM
                Character.Species.HAUNTER -> return Species.GENGAR
            }
        }
        return p.species
    }

    //Constructs a similar Character that has evolved
    fun evolution(p: Character, s: Species): Character {
        var newP = Character(s, p.move[0], p.move[1], p.move[2], p.move[3], p.level)
        newP.HP_EV = p.HP_EV
        newP.ATK_EV = p.ATK_EV
        newP.DEF_EV = p.DEF_EV
        newP.SPEED_EV = p.SPEED_EV
        newP.SPCL_EV = p.SPCL_EV
        newP.HP_IV = p.HP_IV
        newP.ATK_IV = p.ATK_IV
        newP.DEF_IV = p.DEF_IV
        newP.SPEED_IV = p.SPEED_IV
        newP.SPCL_IV = p.SPCL_IV
        newP.mIsTraded = p.mIsTraded
        newP.idNumber = p.idNumber
        if (p.nickname != p.species.toString())
            newP.nickname = p.nickname
        System.arraycopy(p.TRUE_PP, 0, newP.TRUE_PP, 0, 4)
        return newP
    }

    //Takes in 0 - 162 and returns metronome when it's not between 0 and 162
    fun randomMove(num: Int): Move {
        when (num) {
            0 -> return Move.ABSORB
            1 -> return Move.ACID
            2 -> return Move.ACID_ARMOR
            3 -> return Move.AGILITY
            4 -> return Move.AMNESIA
            5 -> return Move.AURORA_BEAM
            6 -> return Move.BARRAGE
            7 -> return Move.BARRIER
            8, 9, 10 -> return Move.BITE
            11 -> return Move.BLIZZARD
            12 -> return Move.BODY_SLAM
            13 -> return Move.BONE_CLUB
            14 -> return Move.BONEMERANG
            15 -> return Move.BUBBLE
            16 -> return Move.BUBBLEBEAM
            17, 18 -> return Move.COMET_PUNCH
            19 -> return Move.CONFUSE_RAY
            20 -> return Move.CONFUSION
            21 -> return Move.CONSTRICT
            22 -> return Move.CONVERSION
            23 -> return Move.COUNTER
            24 -> return Move.CRABHAMMER
            25 -> return Move.CUT
            26 -> return Move.DEFENSE_CURL
            27, 28 -> return Move.DISABLE
            29 -> return Move.DIZZY_PUNCH
            30 -> return Move.DOUBLE_KICK
            31 -> return Move.DOUBLE_TEAM
            32 -> return Move.DOUBLE_EDGE
            33 -> return Move.DOUBLESLAP
            34 -> return Move.DRAGON_RAGE
            35 -> return Move.DREAM_EATER
            36 -> return Move.DRILL_PECK
            37 -> return Move.EARTHQUAKE
            38 -> return Move.EGG_BOMB
            39 -> return Move.EMBER
            40 -> return Move.EXPLOSION
            41 -> return Move.FIRE_BLAST
            42 -> return Move.FIRE_PUNCH
            43, 44 -> return Move.FISSURE
            45 -> return Move.FLAMETHROWER
            46 -> return Move.FLASH
            47, 48 -> return Move.FOCUS_ENERGY
            49 -> return Move.FURY_ATTACK
            50 -> return Move.FURY_SWIPES
            51 -> return Move.GLARE
            52 -> return Move.GROWL
            53 -> return Move.GROWTH
            54 -> return Move.GUILLOTINE
            55 -> return Move.GUST
            56 -> return Move.HARDEN
            57 -> return Move.HAZE
            58 -> return Move.HEADBUTT
            59 -> return Move.HI_JUMP_KICK
            60 -> return Move.HORN_ATTACK
            61 -> return Move.HORN_DRILL
            62 -> return Move.HYDRO_PUMP
            63, 64 -> return Move.HYPER_FANG
            65 -> return Move.HYPNOSIS
            66 -> return Move.ICE_BEAM
            67 -> return Move.ICE_PUNCH
            68 -> return Move.JUMP_KICK
            69 -> return Move.KARATE_CHOP
            70 -> return Move.KINESIS
            71 -> return Move.LEECH_LIFE
            72 -> return Move.LEECH_SEED
            73 -> return Move.LEER
            74 -> return Move.LICK
            75 -> return Move.LIGHT_SCREEN
            76 -> return Move.LOVELY_KISS
            77 -> return Move.LOW_KICK
            78 -> return Move.MEDITATE
            79 -> return Move.MEGA_DRAIN
            80 -> return Move.MEGA_KICK
            81 -> return Move.MEGA_PUNCH
            82 -> return Move.MIMIC
            83 -> return Move.MINIMIZE
            84 -> return Move.MIRROR_MOVE
            85 -> return Move.MIST
            86 -> return Move.NIGHT_SHADE
            87 -> return Move.PAY_DAY
            88 -> return Move.PECK
            89, 90 -> return Move.PIN_MISSILE
            91 -> return Move.POISON_GAS
            92 -> return Move.POISON_STING
            93 -> return Move.POISONPOWDER
            94 -> return Move.POUND
            95 -> return Move.PSYBEAM
            96 -> return Move.PSYCHIC
            97 -> return Move.PSYWAVE
            98 -> return Move.QUICK_ATTACK
            99, 100 -> return Move.RAZOR_LEAF
            101, 102 -> return Move.RECOVER
            103 -> return Move.REFLECT
            104 -> return Move.REST
            105 -> return Move.ROAR
            106 -> return Move.ROCK_SLIDE
            107 -> return Move.ROCK_THROW
            108 -> return Move.ROLLING_KICK
            109 -> return Move.SAND_ATTACK
            110 -> return Move.SCRATCH
            111 -> return Move.SCREECH
            112 -> return Move.SEISMIC_TOSS
            113 -> return Move.SELFDESTRUCT
            114 -> return Move.SHARPEN
            115 -> return Move.SING
            116, 117, 118 -> return Move.SLAM
            119 -> return Move.SLASH
            120 -> return Move.SLEEP_POWDER
            121 -> return Move.SLUDGE
            122 -> return Move.SMOG
            123 -> return Move.SMOKESCREEN
            124 -> return Move.SOFTBOILED
            125, 126 -> return Move.SONIC_BOOM
            127 -> return Move.SPIKE_CANNON
            128 -> return Move.SPLASH
            129 -> return Move.SPORE
            130 -> return Move.STOMP
            131 -> return Move.STRENGTH
            132 -> return Move.STRING_SHOT
            133 -> return Move.STUN_SPORE
            134 -> return Move.SUBMISSION
            135 -> return Move.SUBSTITUTE
            136 -> return Move.SUPER_FANG
            137 -> return Move.SUPERSONIC
            138 -> return Move.SURF
            139 -> return Move.SWIFT
            140 -> return Move.SWORDS_DANCE
            141 -> return Move.TACKLE
            142 -> return Move.TAIL_WHIP
            143 -> return Move.TAKE_DOWN
            144 -> return Move.TELEPORT
            145, 146 -> return Move.THUNDER
            147 -> return Move.THUNDER_WAVE
            148 -> return Move.THUNDERBOLT
            149 -> return Move.THUNDERPUNCH
            150 -> return Move.THUNDERSHOCK
            151 -> return Move.TOXIC
            152 -> return Move.TRANSFORM
            153 -> return Move.TRI_ATTACK
            154 -> return Move.TWINEEDLE
            155 -> return Move.VICEGRIP
            156 -> return Move.VINE_WHIP
            157 -> return Move.WATER_GUN
            158 -> return Move.WATERFALL
            159 -> return Move.WHIRLWIND
            160 -> return Move.WING_ATTACK
            161 -> return Move.WITHDRAW
            162 -> return Move.METRONOME
            else -> return Move.METRONOME
        }
    }

    //Actually creates a Character and assigns moves and stats
    fun createPokemon(s: Species, lvl: Int) {
        var m = 0
        for (i in 0..3)
            move[i] = Move.NONE
        species = s
        //Note for evolutions the moves were made basically the same for the pre evolved
        //versions except a level higher since it is still possible to obtain them without
        //having to use a tm
        when (s) {
            Character.Species.BULBASAUR -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.POISON
                pokedexNumber = 1
                baseHP = 45
                baseATK = 49
                baseDEF = 49
                baseSPEED = 45
                baseSPCL = 65
                //Move Block
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.SOLARBEAM
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.GROWTH
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.RAZOR_LEAF
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.VINE_WHIP
                    m++
                }
                if (lvl >= 7 && m < 4) {
                    move[m] = Move.LEECH_SEED
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.IVYSAUR -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.POISON
                pokedexNumber = 2
                baseHP = 60
                baseATK = 62
                baseDEF = 63
                baseSPCL = 80
                baseSPEED = 60
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.SOLARBEAM
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.GROWTH
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.RAZOR_LEAF
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.VINE_WHIP
                    m++
                }
                if (lvl >= 8 && m < 4) {
                    move[m] = Move.LEECH_SEED
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.VENUSAUR -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.POISON
                pokedexNumber = 3
                baseHP = 80
                baseATK = 82
                baseDEF = 83
                baseSPCL = 100
                baseSPEED = 80
                if (lvl >= 50 && m < 4) {
                    move[m] = Move.SOLARBEAM
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.GROWTH
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.RAZOR_LEAF
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.VINE_WHIP
                    m++
                }
                if (lvl >= 9 && m < 4) {
                    move[m] = Move.LEECH_SEED
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.CHARMANDER -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 4
                baseHP = 39
                baseATK = 52
                baseDEF = 43
                baseSPEED = 65
                baseSPCL = 50
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.FIRE_SPIN
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.FLAMETHROWER
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 9 && m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.CHARMELEON -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 5
                baseHP = 58
                baseATK = 64
                baseDEF = 58
                baseSPEED = 80
                baseSPCL = 65
                if (lvl >= 47 && m < 4) {
                    move[m] = Move.FIRE_SPIN
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.FLAMETHROWER
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.CHARIZARD -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.FLYING
                pokedexNumber = 6
                baseHP = 78
                baseATK = 84
                baseDEF = 78
                baseSPEED = 100
                baseSPCL = 85
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.FIRE_SPIN
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.FLAMETHROWER
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 11 && m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.SQUIRTLE -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 7
                baseHP = 44
                baseATK = 48
                baseDEF = 65
                baseSPEED = 43
                baseSPCL = 64
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.SKULL_BASH
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.WITHDRAW
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 8 && m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.WARTORTLE -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 8
                baseHP = 59
                baseATK = 63
                baseDEF = 80
                baseSPEED = 58
                baseSPCL = 65
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.SKULL_BASH
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.WITHDRAW
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 9 && m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.BLASTOISE -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 9
                baseHP = 79
                baseATK = 83
                baseDEF = 100
                baseSPEED = 78
                baseSPCL = 85
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.SKULL_BASH
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.WITHDRAW
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.CATERPIE -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.NONE
                pokedexNumber = 10
                baseHP = 45
                baseATK = 30
                baseDEF = 35
                baseSPEED = 45
                baseSPCL = 20
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.STRING_SHOT
                    m++
                }
            }
            Character.Species.METAPOD -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.NONE
                pokedexNumber = 11
                baseHP = 50
                baseATK = 20
                baseDEF = 55
                baseSPEED = 30
                baseSPCL = 25
                if (m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.STRING_SHOT
                    m++
                }
            }
            Character.Species.BUTTERFREE -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.FLYING
                pokedexNumber = 12
                baseHP = 60
                baseATK = 45
                baseDEF = 50
                baseSPEED = 70
                baseSPCL = 80
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.PSYBEAM
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.WHIRLWIND
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.STRING_SHOT
                    m++
                }
            }
            Character.Species.WEEDLE -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.POISON
                pokedexNumber = 13
                baseHP = 40
                baseATK = 35
                baseDEF = 30
                baseSPEED = 50
                baseSPCL = 20
                if (m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (m < 4) {
                    move[m] = Move.STRING_SHOT
                    m++
                }
            }
            Character.Species.KAKUNA -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.POISON
                pokedexNumber = 14
                baseHP = 45
                baseATK = 25
                baseDEF = 50
                baseSPEED = 35
                baseSPCL = 25
                if (m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (m < 4) {
                    move[m] = Move.STRING_SHOT
                    m++
                }
            }
            Character.Species.BEEDRILL -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.POISON
                pokedexNumber = 15
                baseHP = 65
                baseATK = 80
                baseDEF = 40
                baseSPEED = 75
                baseSPCL = 45
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.PIN_MISSILE
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.TWINEEDLE
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 12 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (m < 4) {
                    move[m] = Move.STRING_SHOT
                    m++
                }
            }
            Character.Species.PIDGEY -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.FLYING
                pokedexNumber = 16
                baseHP = 40
                baseATK = 45
                baseDEF = 40
                baseSPEED = 56
                baseSPCL = 35
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.MIRROR_MOVE
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.WING_ATTACK
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.WHIRLWIND
                    m++
                }
                if (lvl >= 12 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (lvl >= 5 && m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GUST
                    m++
                }
            }
            Character.Species.PIDGEOTTO -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.FLYING
                pokedexNumber = 17
                baseHP = 63
                baseATK = 60
                baseDEF = 55
                baseSPEED = 71
                baseSPCL = 50
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.MIRROR_MOVE
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.WING_ATTACK
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.WHIRLWIND
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (lvl >= 6 && m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GUST
                    m++
                }
            }
            Character.Species.PIDGEOT -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.FLYING
                pokedexNumber = 18
                baseHP = 83
                baseATK = 80
                baseDEF = 75
                baseSPEED = 91
                baseSPCL = 70
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.MIRROR_MOVE
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.WING_ATTACK
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.WHIRLWIND
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (lvl >= 7 && m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GUST
                    m++
                }
            }
            Character.Species.RATTATA -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 19
                baseHP = 30
                baseATK = 56
                baseDEF = 35
                baseSPEED = 72
                baseSPCL = 25
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.SUPER_FANG
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.HYPER_FANG
                    m++
                }
                if (lvl >= 9 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.RATICATE -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 20
                baseHP = 55
                baseATK = 81
                baseDEF = 60
                baseSPEED = 97
                baseSPCL = 50
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.SUPER_FANG
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.HYPER_FANG
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.SPEAROW -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.FLYING
                pokedexNumber = 21
                baseHP = 40
                baseATK = 60
                baseDEF = 30
                baseSPEED = 70
                baseSPCL = 31
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.DRILL_PECK
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.MIRROR_MOVE
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 9 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PECK
                    m++
                }
            }
            Character.Species.FEAROW -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.FLYING
                pokedexNumber = 22
                baseHP = 65
                baseATK = 90
                baseDEF = 65
                baseSPEED = 100
                baseSPCL = 61
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.DRILL_PECK
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.MIRROR_MOVE
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PECK
                    m++
                }
            }
            Character.Species.EKANS -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 23
                baseHP = 35
                baseATK = 60
                baseDEF = 44
                baseSPEED = 55
                baseSPCL = 40
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.ACID
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.GLARE
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
            }
            Character.Species.ARBOK -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 24
                baseHP = 60
                baseATK = 85
                baseDEF = 69
                baseSPEED = 80
                baseSPCL = 65
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.ACID
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.GLARE
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 11 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
            }
            Character.Species.PIKACHU -> {
                nickname = toString(s)
                type1 = Type.ELECTRIC
                type2 = Type.NONE
                pokedexNumber = 25
                baseHP = 35
                baseATK = 55
                baseDEF = 30
                baseSPEED = 90
                baseSPCL = 50
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.THUNDER
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (lvl >= 9 && m < 4) {
                    move[m] = Move.THUNDER_WAVE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.THUNDERSHOCK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.RAICHU -> {
                nickname = toString(s)
                type1 = Type.ELECTRIC
                type2 = Type.NONE
                pokedexNumber = 26
                baseHP = 60
                baseATK = 90
                baseDEF = 55
                baseSPEED = 100
                baseSPCL = 90
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.THUNDER
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.THUNDER_WAVE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.THUNDERSHOCK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.SANDSHREW -> {
                nickname = toString(s)
                type1 = Type.GROUND
                type2 = Type.NONE
                pokedexNumber = 27
                baseHP = 50
                baseATK = 75
                baseDEF = 85
                baseSPEED = 40
                baseSPCL = 30
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.SANDSLASH -> {
                nickname = toString(s)
                type1 = Type.GROUND
                type2 = Type.NONE
                pokedexNumber = 28
                baseHP = 75
                baseATK = 100
                baseDEF = 110
                baseSPEED = 65
                baseSPCL = 55
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 11 && m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.NIDORAN_F -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 29
                baseHP = 55
                baseATK = 47
                baseDEF = 52
                baseSPEED = 41
                baseSPCL = 40
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.DOUBLE_KICK
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 8 && m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.NIDORINA -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 30
                baseHP = 70
                baseATK = 62
                baseDEF = 67
                baseSPEED = 56
                baseSPCL = 55
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.DOUBLE_KICK
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 9 && m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.NIDOQUEEN -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.GROUND
                pokedexNumber = 31
                baseHP = 90
                baseATK = 82
                baseDEF = 87
                baseSPEED = 76
                baseSPCL = 75
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.DOUBLE_KICK
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.BODY_SLAM
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.NIDORAN_M -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 32
                baseHP = 46
                baseATK = 57
                baseDEF = 40
                baseSPEED = 50
                baseSPCL = 40
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.DOUBLE_KICK
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.HORN_DRILL
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 8 && m < 4) {
                    move[m] = Move.HORN_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
            }
            Character.Species.NIDORINO -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 33
                baseHP = 61
                baseATK = 72
                baseDEF = 57
                baseSPEED = 65
                baseSPCL = 55
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.DOUBLE_KICK
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.HORN_DRILL
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 9 && m < 4) {
                    move[m] = Move.HORN_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
            }
            Character.Species.NIDOKING -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.GROUND
                pokedexNumber = 34
                baseHP = 81
                baseATK = 92
                baseDEF = 77
                baseSPEED = 85
                baseSPCL = 75
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.DOUBLE_KICK
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.HORN_DRILL
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.THRASH
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.HORN_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
            }
            Character.Species.CLEFAIRY -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 35
                baseHP = 70
                baseATK = 45
                baseDEF = 48
                baseSPEED = 35
                baseSPCL = 60
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.DEFENSE_CURL
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.METRONOME
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.MINIMIZE
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.SING
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POUND
                    m++
                }
            }
            Character.Species.CLEFABLE -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 36
                baseHP = 95
                baseATK = 70
                baseDEF = 73
                baseSPEED = 60
                baseSPCL = 85
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.DEFENSE_CURL
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.METRONOME
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.MINIMIZE
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.SING
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POUND
                    m++
                }
            }
            Character.Species.VULPIX -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 37
                baseHP = 38
                baseATK = 41
                baseDEF = 40
                baseSPEED = 65
                baseSPCL = 65
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.FIRE_SPIN
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.FLAMETHROWER
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.CONFUSE_RAY
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.ROAR
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
            }
            Character.Species.NINETALES -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 38
                baseHP = 73
                baseATK = 76
                baseDEF = 75
                baseSPEED = 100
                baseSPCL = 100
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.FIRE_SPIN
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.FLAMETHROWER
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.CONFUSE_RAY
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.ROAR
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
            }
            Character.Species.JIGGLYPUFF -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 39
                baseHP = 115
                baseATK = 45
                baseDEF = 20
                baseSPEED = 20
                baseSPCL = 25
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.DOUBLE_EDGE
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.BODY_SLAM
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.REST
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.DEFENSE_CURL
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (lvl >= 9 && m < 4) {
                    move[m] = Move.POUND
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SING
                    m++
                }
            }
            Character.Species.WIGGLYTUFF -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 40
                baseHP = 140
                baseATK = 70
                baseDEF = 45
                baseSPEED = 45
                baseSPCL = 50
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.DOUBLE_EDGE
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.BODY_SLAM
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.REST
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.DEFENSE_CURL
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.POUND
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SING
                    m++
                }
            }
            Character.Species.ZUBAT -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.FLYING
                pokedexNumber = 41
                baseHP = 40
                baseATK = 45
                baseDEF = 35
                baseSPEED = 55
                baseSPCL = 40
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.HAZE
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.WING_ATTACK
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.CONFUSE_RAY
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEECH_LIFE
                    m++
                }
            }
            Character.Species.GOLBAT -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.FLYING
                pokedexNumber = 42
                baseHP = 75
                baseATK = 80
                baseDEF = 70
                baseSPEED = 90
                baseSPCL = 75
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.HAZE
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.WING_ATTACK
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.CONFUSE_RAY
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 11 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEECH_LIFE
                    m++
                }
            }
            Character.Species.ODDISH -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.POISON
                pokedexNumber = 43
                baseHP = 45
                baseATK = 50
                baseDEF = 55
                baseSPEED = 30
                baseSPCL = 75
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.SOLARBEAM
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.PETAL_DANCE
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.ACID
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.ABSORB
                    m++
                }
            }
            Character.Species.GLOOM -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.POISON
                pokedexNumber = 44
                baseHP = 60
                baseATK = 65
                baseDEF = 70
                baseSPEED = 40
                baseSPCL = 85
                if (lvl >= 47 && m < 4) {
                    move[m] = Move.SOLARBEAM
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.PETAL_DANCE
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.ACID
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.ABSORB
                    m++
                }
            }
            Character.Species.VILEPLUME -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.POISON
                pokedexNumber = 45
                baseHP = 75
                baseATK = 80
                baseDEF = 85
                baseSPEED = 50
                baseSPCL = 100
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.SOLARBEAM
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.PETAL_DANCE
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.ACID
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.ABSORB
                    m++
                }
            }
            Character.Species.PARAS -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.GRASS
                pokedexNumber = 46
                baseHP = 35
                baseATK = 70
                baseDEF = 55
                baseSPEED = 25
                baseSPCL = 55
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.GROWTH
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.SPORE
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.LEECH_LIFE
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.PARASECT -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.GRASS
                pokedexNumber = 47
                baseHP = 60
                baseATK = 95
                baseDEF = 80
                baseSPEED = 30
                baseSPCL = 80
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.GROWTH
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.SPORE
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.LEECH_LIFE
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.VENONAT -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.POISON
                pokedexNumber = 48
                baseHP = 60
                baseATK = 55
                baseDEF = 50
                baseSPEED = 45
                baseSPCL = 40
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.PSYBEAM
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.LEECH_LIFE
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.VENOMOTH -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.POISON
                pokedexNumber = 49
                baseHP = 70
                baseATK = 65
                baseDEF = 60
                baseSPEED = 90
                baseSPCL = 90
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.PSYBEAM
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.LEECH_LIFE
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.DIGLETT -> {
                nickname = toString(s)
                type1 = Type.GROUND
                type2 = Type.NONE
                pokedexNumber = 50
                baseHP = 10
                baseATK = 55
                baseDEF = 25
                baseSPEED = 95
                baseSPCL = 45
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.EARTHQUAKE
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.DIG
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.DUGTRIO -> {
                nickname = toString(s)
                type1 = Type.GROUND
                type2 = Type.NONE
                pokedexNumber = 51
                baseHP = 35
                baseATK = 80
                baseDEF = 50
                baseSPEED = 120
                baseSPCL = 70
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.EARTHQUAKE
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.DIG
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.MEOWTH -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 52
                baseHP = 40
                baseATK = 45
                baseDEF = 35
                baseSPEED = 90
                baseSPCL = 40
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.PAY_DAY
                    m++
                }
                if (lvl >= 12 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.PERSIAN -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 53
                baseHP = 65
                baseATK = 70
                baseDEF = 60
                baseSPEED = 115
                baseSPCL = 65
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.PAY_DAY
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.PSYDUCK -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 54
                baseHP = 50
                baseATK = 52
                baseDEF = 48
                baseSPEED = 55
                baseSPCL = 50
                if (lvl >= 52 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.GOLDUCK -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 55
                baseHP = 80
                baseATK = 82
                baseDEF = 78
                baseSPEED = 85
                baseSPCL = 80
                if (lvl >= 53 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.MANKEY -> {
                nickname = toString(s)
                type1 = Type.FIGHTING
                type2 = Type.NONE
                pokedexNumber = 56
                baseHP = 40
                baseATK = 80
                baseDEF = 35
                baseSPEED = 70
                baseSPCL = 35
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.THRASH
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.SEISMIC_TOSS
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.KARATE_CHOP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.PRIMEAPE -> {
                nickname = toString(s)
                type1 = Type.FIGHTING
                type2 = Type.NONE
                pokedexNumber = 57
                baseHP = 65
                baseATK = 105
                baseDEF = 60
                baseSPEED = 95
                baseSPCL = 60
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.THRASH
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.SEISMIC_TOSS
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.FURY_SWIPES
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.KARATE_CHOP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.GROWLITHE -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 58
                baseHP = 55
                baseATK = 70
                baseDEF = 45
                baseSPEED = 60
                baseSPCL = 50
                if (lvl >= 50 && m < 4) {
                    move[m] = Move.FLAMETHROWER
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.ROAR
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BITE
                    m++
                }
            }
            Character.Species.ARCANINE -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 59
                baseHP = 90
                baseATK = 110
                baseDEF = 80
                baseSPEED = 95
                baseSPCL = 80
                if (lvl >= 51 && m < 4) {
                    move[m] = Move.FLAMETHROWER
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.ROAR
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BITE
                    m++
                }
            }
            Character.Species.POLIWAG -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 60
                baseHP = 40
                baseATK = 50
                baseDEF = 40
                baseSPEED = 90
                baseSPCL = 40
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.AMNESIA
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.BODY_SLAM
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
            }
            Character.Species.POLIWHIRL -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 61
                baseHP = 65
                baseATK = 65
                baseDEF = 65
                baseSPEED = 90
                baseSPCL = 50
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.AMNESIA
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.BODY_SLAM
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
            }
            Character.Species.POLIWRATH -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.FIGHTING
                pokedexNumber = 62
                baseHP = 90
                baseATK = 85
                baseDEF = 95
                baseSPEED = 70
                baseSPCL = 70
                if (lvl >= 47 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.AMNESIA
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.BODY_SLAM
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
            }
            Character.Species.ABRA -> {
                nickname = toString(s)
                type1 = Type.PSYCHIC
                type2 = Type.NONE
                pokedexNumber = 63
                baseHP = 25
                baseATK = 20
                baseDEF = 15
                baseSPEED = 90
                baseSPCL = 105
                if (m < 4) {
                    move[m] = Move.TELEPORT
                    m++
                }
            }
            Character.Species.KADABRA -> {
                nickname = toString(s)
                type1 = Type.PSYCHIC
                type2 = Type.NONE
                pokedexNumber = 64
                baseHP = 40
                baseATK = 35
                baseDEF = 30
                baseSPEED = 105
                baseSPCL = 120
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.REFLECT
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.RECOVER
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.PSYBEAM
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
                if (m < 4) {
                    move[m] = Move.KINESIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TELEPORT
                    m++
                }
            }
            Character.Species.ALAKAZAM -> {
                nickname = toString(s)
                type1 = Type.PSYCHIC
                type2 = Type.NONE
                pokedexNumber = 65
                baseHP = 55
                baseATK = 50
                baseDEF = 45
                baseSPEED = 120
                baseSPCL = 135
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.REFLECT
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.RECOVER
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.PSYBEAM
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
                if (m < 4) {
                    move[m] = Move.KINESIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TELEPORT
                    m++
                }
            }
            Character.Species.MACHOP -> {
                nickname = toString(s)
                type1 = Type.FIGHTING
                type2 = Type.NONE
                pokedexNumber = 66
                baseHP = 70
                baseATK = 80
                baseDEF = 50
                baseSPEED = 35
                baseSPCL = 35
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.SUBMISSION
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.SEISMIC_TOSS
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.LOW_KICK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.KARATE_CHOP
                    m++
                }
            }
            Character.Species.MACHOKE -> {
                nickname = toString(s)
                type1 = Type.FIGHTING
                type2 = Type.NONE
                pokedexNumber = 67
                baseHP = 80
                baseATK = 100
                baseDEF = 70
                baseSPEED = 45
                baseSPCL = 50
                if (lvl >= 47 && m < 4) {
                    move[m] = Move.SUBMISSION
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.SEISMIC_TOSS
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.LOW_KICK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.KARATE_CHOP
                    m++
                }
            }
            Character.Species.MACHAMP -> {
                nickname = toString(s)
                type1 = Type.FIGHTING
                type2 = Type.NONE
                pokedexNumber = 68
                baseHP = 90
                baseATK = 130
                baseDEF = 80
                baseSPEED = 55
                baseSPCL = 65
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.SUBMISSION
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.SEISMIC_TOSS
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.LOW_KICK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.KARATE_CHOP
                    m++
                }
            }
            Character.Species.BELLSPROUT -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.POISON
                pokedexNumber = 69
                baseHP = 50
                baseATK = 75
                baseDEF = 35
                baseSPEED = 40
                baseSPCL = 70
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.SLAM
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.RAZOR_LEAF
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.ACID
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWTH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.VINE_WHIP
                    m++
                }
            }
            Character.Species.WEEPINBELL -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.POISON
                pokedexNumber = 70
                baseHP = 65
                baseATK = 90
                baseDEF = 50
                baseSPEED = 55
                baseSPCL = 85
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.SLAM
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.RAZOR_LEAF
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.ACID
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWTH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.VINE_WHIP
                    m++
                }
            }
            Character.Species.VICTREEBEL -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.POISON
                pokedexNumber = 71
                baseHP = 80
                baseATK = 105
                baseDEF = 65
                baseSPEED = 70
                baseSPCL = 100
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.SLAM
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.RAZOR_LEAF
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.ACID
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWTH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.VINE_WHIP
                    m++
                }
            }
            Character.Species.TENTACOOL -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.POISON
                pokedexNumber = 72
                baseHP = 40
                baseATK = 40
                baseDEF = 35
                baseSPEED = 70
                baseSPCL = 100
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.BARRIER
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.CONSTRICT
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
                if (lvl >= 7 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.ACID
                    m++
                }
            }
            Character.Species.TENTACRUEL -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.POISON
                pokedexNumber = 73
                baseHP = 80
                baseATK = 70
                baseDEF = 65
                baseSPEED = 100
                baseSPCL = 120
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.BARRIER
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.CONSTRICT
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.POISON_STING
                    m++
                }
                if (lvl >= 14 && m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
                if (lvl >= 8 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.ACID
                    m++
                }
            }
            Character.Species.GEODUDE -> {
                nickname = toString(s)
                type1 = Type.ROCK
                type2 = Type.GROUND
                pokedexNumber = 74
                baseHP = 40
                baseATK = 80
                baseDEF = 100
                baseSPEED = 20
                baseSPCL = 30
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.EXPLOSION
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.EARTHQUAKE
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.SELFDESTRUCT
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.ROCK_THROW
                    m++
                }
                if (lvl >= 11 && m < 4) {
                    move[m] = Move.DEFENSE_CURL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.GRAVELER -> {
                nickname = toString(s)
                type1 = Type.ROCK
                type2 = Type.GROUND
                pokedexNumber = 75
                baseHP = 55
                baseATK = 95
                baseDEF = 115
                baseSPEED = 35
                baseSPCL = 45
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.EXPLOSION
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.EARTHQUAKE
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.SELFDESTRUCT
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.ROCK_THROW
                    m++
                }
                if (lvl >= 12 && m < 4) {
                    move[m] = Move.DEFENSE_CURL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.GOLEM -> {
                nickname = toString(s)
                type1 = Type.ROCK
                type2 = Type.GROUND
                pokedexNumber = 76
                baseHP = 80
                baseATK = 110
                baseDEF = 130
                baseSPEED = 45
                baseSPCL = 55
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.EXPLOSION
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.EARTHQUAKE
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.SELFDESTRUCT
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.ROCK_THROW
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.DEFENSE_CURL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.PONYTA -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 77
                baseHP = 50
                baseATK = 85
                baseDEF = 55
                baseSPEED = 90
                baseSPCL = 65
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.FIRE_SPIN
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.STOMP
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
            }
            Character.Species.RAPIDASH -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 78
                baseHP = 65
                baseATK = 100
                baseDEF = 70
                baseSPEED = 105
                baseSPCL = 80
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.FIRE_SPIN
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.STOMP
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
            }
            Character.Species.SLOWPOKE -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.PSYCHIC
                pokedexNumber = 79
                baseHP = 90
                baseATK = 65
                baseDEF = 65
                baseSPEED = 15
                baseSPCL = 40
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.AMNESIA
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.HEADBUTT
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
            }
            Character.Species.SLOWBRO -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.PSYCHIC
                pokedexNumber = 80
                baseHP = 95
                baseATK = 75
                baseDEF = 110
                baseSPEED = 30
                baseSPCL = 80
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.AMNESIA
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.HEADBUTT
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
            }
            Character.Species.MAGNEMITE -> {
                nickname = toString(s)
                type1 = Type.ELECTRIC
                type2 = Type.NONE
                pokedexNumber = 81
                baseHP = 25
                baseATK = 35
                baseDEF = 70
                baseSPEED = 45
                baseSPCL = 95
                if (lvl >= 47 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.THUNDER_WAVE
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.THUNDERSHOCK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SONIC_BOOM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.MAGNETON -> {
                nickname = toString(s)
                type1 = Type.ELECTRIC
                type2 = Type.NONE
                pokedexNumber = 82
                baseHP = 50
                baseATK = 60
                baseDEF = 95
                baseSPEED = 70
                baseSPCL = 120
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.THUNDER_WAVE
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.THUNDERSHOCK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SONIC_BOOM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.FARFETCH_D -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.FLYING
                pokedexNumber = 83
                baseHP = 52
                baseATK = 65
                baseDEF = 55
                baseSPEED = 60
                baseSPCL = 58
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.SWORDS_DANCE
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 7 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PECK
                    m++
                }
            }
            Character.Species.DODUO -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.FLYING
                pokedexNumber = 84
                baseHP = 35
                baseATK = 85
                baseDEF = 45
                baseSPEED = 75
                baseSPCL = 35
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.TRI_ATTACK
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.DRILL_PECK
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PECK
                    m++
                }
            }
            Character.Species.DODRIO -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.FLYING
                pokedexNumber = 85
                baseHP = 60
                baseATK = 110
                baseDEF = 70
                baseSPEED = 100
                baseSPCL = 60
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.TRI_ATTACK
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.DRILL_PECK
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PECK
                    m++
                }
            }
            Character.Species.SEEL -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 86
                baseHP = 65
                baseATK = 45
                baseDEF = 55
                baseSPEED = 45
                baseSPCL = 70
                if (lvl >= 50 && m < 4) {
                    move[m] = Move.ICE_BEAM
                    m++
                }
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.REST
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.AURORA_BEAM
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HEADBUTT
                    m++
                }
            }
            Character.Species.DEWGONG -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.ICE
                pokedexNumber = 87
                baseHP = 90
                baseATK = 70
                baseDEF = 80
                baseSPEED = 70
                baseSPCL = 95
                if (lvl >= 51 && m < 4) {
                    move[m] = Move.ICE_BEAM
                    m++
                }
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.REST
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.AURORA_BEAM
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HEADBUTT
                    m++
                }
            }
            Character.Species.GRIMER -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 88
                baseHP = 80
                baseATK = 80
                baseDEF = 50
                baseSPEED = 25
                baseSPCL = 40
                if (lvl >= 55 && m < 4) {
                    move[m] = Move.ACID_ARMOR
                    m++
                }
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.SLUDGE
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.MINIMIZE
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.POISON_GAS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POUND
                    m++
                }
            }
            Character.Species.MUK -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 89
                baseHP = 105
                baseATK = 105
                baseDEF = 75
                baseSPEED = 50
                baseSPCL = 65
                if (lvl >= 56 && m < 4) {
                    move[m] = Move.ACID_ARMOR
                    m++
                }
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.SLUDGE
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.MINIMIZE
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.POISON_GAS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POUND
                    m++
                }
            }
            Character.Species.SHELLDER -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 90
                baseHP = 30
                baseATK = 65
                baseDEF = 100
                baseSPEED = 40
                baseSPCL = 45
                if (lvl >= 50 && m < 4) {
                    move[m] = Move.ICE_BEAM
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.AURORA_BEAM
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.CLAMP
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WITHDRAW
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.CLOYSTER -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.ICE
                pokedexNumber = 91
                baseHP = 50
                baseATK = 95
                baseDEF = 180
                baseSPEED = 70
                baseSPCL = 85
                if (lvl >= 51 && m < 4) {
                    move[m] = Move.ICE_BEAM
                    m++
                }
                if (lvl >= 50 && m < 4) {
                    move[m] = Move.SPIKE_CANNON
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.AURORA_BEAM
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.CLAMP
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WITHDRAW
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.GASTLY -> {
                nickname = toString(s)
                type1 = Type.GHOST
                type2 = Type.POISON
                pokedexNumber = 92
                baseHP = 30
                baseATK = 35
                baseDEF = 30
                baseSPEED = 80
                baseSPCL = 100
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.DREAM_EATER
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.NIGHT_SHADE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.CONFUSE_RAY
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LICK
                    m++
                }
            }
            Character.Species.HAUNTER -> {
                nickname = toString(s)
                type1 = Type.GHOST
                type2 = Type.POISON
                pokedexNumber = 93
                baseHP = 45
                baseATK = 50
                baseDEF = 45
                baseSPEED = 95
                baseSPCL = 115
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.DREAM_EATER
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.NIGHT_SHADE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.CONFUSE_RAY
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LICK
                    m++
                }
            }
            Character.Species.GENGAR -> {
                nickname = toString(s)
                type1 = Type.GHOST
                type2 = Type.POISON
                pokedexNumber = 94
                baseHP = 60
                baseATK = 65
                baseDEF = 60
                baseSPEED = 110
                baseSPCL = 130
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.DREAM_EATER
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.NIGHT_SHADE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.CONFUSE_RAY
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LICK
                    m++
                }
            }
            Character.Species.ONIX -> {
                nickname = toString(s)
                type1 = Type.ROCK
                type2 = Type.GROUND
                pokedexNumber = 95
                baseHP = 35
                baseATK = 45
                baseDEF = 160
                baseSPEED = 70
                baseSPCL = 30
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.SLAM
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.ROCK_THROW
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.BIND
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.DROWZEE -> {
                nickname = toString(s)
                type1 = Type.PSYCHIC
                type2 = Type.NONE
                pokedexNumber = 96
                baseHP = 60
                baseATK = 48
                baseDEF = 45
                baseSPEED = 42
                baseSPCL = 90
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.MEDITATE
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.POISON_GAS
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.HEADBUTT
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
                if (lvl >= 12 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POUND
                    m++
                }
            }
            Character.Species.HYPNO -> {
                nickname = toString(s)
                type1 = Type.PSYCHIC
                type2 = Type.NONE
                pokedexNumber = 97
                baseHP = 85
                baseATK = 73
                baseDEF = 70
                baseSPEED = 67
                baseSPCL = 115
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.MEDITATE
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.POISON_GAS
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.HEADBUTT
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
                if (lvl >= 13 && m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POUND
                    m++
                }
            }
            Character.Species.KRABBY -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 98
                baseHP = 30
                baseATK = 105
                baseDEF = 90
                baseSPEED = 50
                baseSPCL = 25
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.CRABHAMMER
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.STOMP
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.GUILLOTINE
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.VICEGRIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
            }
            Character.Species.KINGLER -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 99
                baseHP = 55
                baseATK = 130
                baseDEF = 115
                baseSPEED = 75
                baseSPCL = 50
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.CRABHAMMER
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.STOMP
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.GUILLOTINE
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.VICEGRIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
            }
            Character.Species.VOLTORB -> {
                nickname = toString(s)
                type1 = Type.ELECTRIC
                type2 = Type.NONE
                pokedexNumber = 100
                baseHP = 40
                baseATK = 30
                baseDEF = 50
                baseSPEED = 100
                baseSPCL = 55
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.EXPLOSION
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.SELFDESTRUCT
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.SONIC_BOOM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.ELECTRODE -> {
                nickname = toString(s)
                type1 = Type.ELECTRIC
                type2 = Type.NONE
                pokedexNumber = 101
                baseHP = 60
                baseATK = 50
                baseDEF = 70
                baseSPEED = 140
                baseSPCL = 80
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.EXPLOSION
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.SELFDESTRUCT
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.SONIC_BOOM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.EXEGGCUTE -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.PSYCHIC
                pokedexNumber = 102
                baseHP = 60
                baseATK = 40
                baseDEF = 80
                baseSPEED = 40
                baseSPCL = 60
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.SOLARBEAM
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.LEECH_SEED
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.REFLECT
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BARRAGE
                    m++
                }
            }
            Character.Species.EXEGGUTOR -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.PSYCHIC
                pokedexNumber = 103
                baseHP = 95
                baseATK = 95
                baseDEF = 85
                baseSPEED = 55
                baseSPCL = 125
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.SOLARBEAM
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.LEECH_SEED
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.STOMP
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.REFLECT
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HYPNOSIS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BARRAGE
                    m++
                }
            }
            Character.Species.CUBONE -> {
                nickname = toString(s)
                type1 = Type.GROUND
                type2 = Type.NONE
                pokedexNumber = 104
                baseHP = 50
                baseATK = 50
                baseDEF = 95
                baseSPEED = 35
                baseSPCL = 40
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.BONEMERANG
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.THRASH
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BONE_CLUB
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.MAROWAK -> {
                nickname = toString(s)
                type1 = Type.GROUND
                type2 = Type.NONE
                pokedexNumber = 105
                baseHP = 60
                baseATK = 80
                baseDEF = 110
                baseSPEED = 45
                baseSPCL = 50
                if (lvl >= 47 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.BONEMERANG
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.THRASH
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BONE_CLUB
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
            }
            Character.Species.HITMONLEE -> {
                nickname = toString(s)
                type1 = Type.FIGHTING
                type2 = Type.NONE
                pokedexNumber = 106
                baseHP = 50
                baseATK = 120
                baseDEF = 53
                baseSPEED = 87
                baseSPCL = 35
                if (lvl >= 53 && m < 4) {
                    move[m] = Move.MEGA_KICK
                    m++
                }
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.HI_JUMP_KICK
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.JUMP_KICK
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.ROLLING_KICK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.MEDITATE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DOUBLE_KICK
                    m++
                }
            }
            Character.Species.HITMONCHAN -> {
                nickname = toString(s)
                type1 = Type.FIGHTING
                type2 = Type.NONE
                pokedexNumber = 107
                baseHP = 50
                baseATK = 105
                baseDEF = 79
                baseSPEED = 76
                baseSPCL = 35
                if (lvl >= 53 && m < 4) {
                    move[m] = Move.COUNTER
                    m++
                }
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.MEGA_PUNCH
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.THUNDERPUNCH
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.ICE_PUNCH
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.FIRE_PUNCH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (m < 4) {
                    move[m] = Move.COMET_PUNCH
                    m++
                }
            }
            Character.Species.LICKITUNG -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 108
                baseHP = 90
                baseATK = 55
                baseDEF = 75
                baseSPEED = 30
                baseSPCL = 60
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.SLAM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DEFENSE_CURL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DISABLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.STOMP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
            }
            Character.Species.KOFFING -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 109
                baseHP = 40
                baseATK = 65
                baseDEF = 95
                baseSPEED = 35
                baseSPCL = 60
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.EXPLOSION
                    m++
                }
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.HAZE
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.SELFDESTRUCT
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.SMOKESCREEN
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.SLUDGE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SMOG
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.WEEZING -> {
                nickname = toString(s)
                type1 = Type.POISON
                type2 = Type.NONE
                pokedexNumber = 110
                baseHP = 65
                baseATK = 90
                baseDEF = 120
                baseSPEED = 60
                baseSPCL = 85
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.EXPLOSION
                    m++
                }
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.HAZE
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.SELFDESTRUCT
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.SMOKESCREEN
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.SLUDGE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SMOG
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.RHYHORN -> {
                nickname = toString(s)
                type1 = Type.GROUND
                type2 = Type.ROCK
                pokedexNumber = 111
                baseHP = 80
                baseATK = 85
                baseDEF = 95
                baseSPEED = 25
                baseSPCL = 30
                if (lvl >= 55 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 50 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.HORN_DRILL
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.STOMP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HORN_ATTACK
                    m++
                }
            }
            Character.Species.RHYDON -> {
                nickname = toString(s)
                type1 = Type.GROUND
                type2 = Type.ROCK
                pokedexNumber = 112
                baseHP = 105
                baseATK = 130
                baseDEF = 120
                baseSPEED = 40
                baseSPCL = 45
                if (lvl >= 56 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 51 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.HORN_DRILL
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.STOMP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HORN_ATTACK
                    m++
                }
            }
            Character.Species.CHANSEY -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 113
                baseHP = 250
                baseATK = 5
                baseDEF = 5
                baseSPEED = 50
                baseSPCL = 105
                if (lvl >= 54 && m < 4) {
                    move[m] = Move.DOUBLE_EDGE
                    m++
                }
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.DEFENSE_CURL
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.MINIMIZE
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.SING
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POUND
                    m++
                }
            }
            Character.Species.TANGELA -> {
                nickname = toString(s)
                type1 = Type.GRASS
                type2 = Type.NONE
                pokedexNumber = 114
                baseHP = 65
                baseATK = 55
                baseDEF = 115
                baseSPEED = 60
                baseSPCL = 100
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.GROWTH
                    m++
                }
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.SLAM
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.SLEEP_POWDER
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.STUN_SPORE
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.POISONPOWDER
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.ABSORB
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BIND
                    m++
                }
                if (m < 4) {
                    move[m] = Move.CONSTRICT
                    m++
                }
            }
            Character.Species.KANGASKHAN -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 115
                baseHP = 105
                baseATK = 95
                baseDEF = 80
                baseSPEED = 90
                baseSPCL = 40
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.DIZZY_PUNCH
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.MEGA_PUNCH
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 26 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.COMET_PUNCH
                    m++
                }
            }
            Character.Species.HORSEA -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 116
                baseHP = 30
                baseATK = 40
                baseDEF = 70
                baseSPEED = 60
                baseSPCL = 70
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.SMOKESCREEN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
            }
            Character.Species.SEADRA -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 117
                baseHP = 55
                baseATK = 65
                baseDEF = 95
                baseSPEED = 85
                baseSPCL = 95
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.SMOKESCREEN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BUBBLE
                    m++
                }
            }
            Character.Species.GOLDEEN -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 118
                baseHP = 45
                baseATK = 67
                baseDEF = 60
                baseSPEED = 63
                baseSPCL = 50
                if (lvl >= 54 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.HORN_DRILL
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.WATERFALL
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.HORN_ATTACK
                    m++
                }
                if (lvl >= 19 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PECK
                    m++
                }
            }
            Character.Species.SEAKING -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 119
                baseHP = 80
                baseATK = 92
                baseDEF = 65
                baseSPEED = 68
                baseSPCL = 80
                if (lvl >= 55 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.HORN_DRILL
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.WATERFALL
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.FURY_ATTACK
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.HORN_ATTACK
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PECK
                    m++
                }
            }
            Character.Species.STARYU -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 120
                baseHP = 30
                baseATK = 45
                baseDEF = 55
                baseSPEED = 85
                baseSPCL = 70
                if (lvl >= 47 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.MINIMIZE
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.RECOVER
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 17 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.STARMIE -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.PSYCHIC
                pokedexNumber = 121
                baseHP = 60
                baseATK = 75
                baseDEF = 85
                baseSPEED = 115
                baseSPCL = 100
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.MINIMIZE
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.RECOVER
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 18 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.MR_MIME -> {
                nickname = toString(s)
                type1 = Type.PSYCHIC
                type2 = Type.NONE
                pokedexNumber = 122
                baseHP = 40
                baseATK = 45
                baseDEF = 65
                baseSPEED = 90
                baseSPCL = 100
                if (lvl >= 47 && m < 4) {
                    move[m] = Move.SUBSTITUTE
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.MEDITATE
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.CONFUSION
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BARRIER
                    m++
                }
            }
            Character.Species.SCYTHER -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.FLYING
                pokedexNumber = 123
                baseHP = 70
                baseATK = 110
                baseDEF = 80
                baseSPEED = 105
                baseSPCL = 55
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.SWORDS_DANCE
                    m++
                }
                if (lvl >= 29 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 24 && m < 4) {
                    move[m] = Move.DOUBLE_TEAM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
            }
            Character.Species.JYNX -> {
                nickname = toString(s)
                type1 = Type.ICE
                type2 = Type.PSYCHIC
                pokedexNumber = 124
                baseHP = 65
                baseATK = 50
                baseDEF = 35
                baseSPEED = 95
                baseSPCL = 95
                if (lvl >= 58 && m < 4) {
                    move[m] = Move.BLIZZARD
                    m++
                }
                if (lvl >= 47 && m < 4) {
                    move[m] = Move.THRASH
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.BODY_SLAM
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.ICE_PUNCH
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DOUBLESLAP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LICK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LOVELY_KISS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POUND
                    m++
                }
            }
            Character.Species.ELECTABUZZ -> {
                nickname = toString(s)
                type1 = Type.ELECTRIC
                type2 = Type.NONE
                pokedexNumber = 125
                baseHP = 65
                baseATK = 83
                baseDEF = 57
                baseSPEED = 105
                baseSPCL = 85
                if (lvl >= 54 && m < 4) {
                    move[m] = Move.THUNDER
                    m++
                }
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.THUNDERPUNCH
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.SCREECH
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.THUNDERSHOCK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
            }
            Character.Species.MAGMAR -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 126
                baseHP = 65
                baseATK = 95
                baseDEF = 57
                baseSPEED = 93
                baseSPCL = 85
                if (lvl >= 55 && m < 4) {
                    move[m] = Move.FLAMETHROWER
                    m++
                }
                if (lvl >= 52 && m < 4) {
                    move[m] = Move.SMOG
                    m++
                }
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.SMOKESCREEN
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.FIRE_PUNCH
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.CONFUSE_RAY
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
            }
            Character.Species.PINSIR -> {
                nickname = toString(s)
                type1 = Type.BUG
                type2 = Type.NONE
                pokedexNumber = 127
                baseHP = 65
                baseATK = 125
                baseDEF = 100
                baseSPEED = 85
                baseSPCL = 55
                if (lvl >= 54 && m < 4) {
                    move[m] = Move.SWORDS_DANCE
                    m++
                }
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 43 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 36 && m < 4) {
                    move[m] = Move.FOCUS_ENERGY
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.GUILLOTINE
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.SEISMIC_TOSS
                    m++
                }
                if (m < 4) {
                    move[m] = Move.VICEGRIP
                    m++
                }
            }
            Character.Species.TAUROS -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 128
                baseHP = 75
                baseATK = 100
                baseDEF = 95
                baseSPEED = 110
                baseSPCL = 70
                if (lvl >= 51 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.STOMP
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.MAGIKARP -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 129
                baseHP = 20
                baseATK = 10
                baseDEF = 55
                baseSPEED = 80
                baseSPCL = 20
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SPLASH
                    m++
                }
            }
            Character.Species.GYARADOS -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.FLYING
                pokedexNumber = 130
                baseHP = 95
                baseATK = 125
                baseDEF = 79
                baseSPEED = 81
                baseSPCL = 100
                if (lvl >= 52 && m < 4) {
                    move[m] = Move.HYPER_BEAM
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.DRAGON_RAGE
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 15 && m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SPLASH
                    m++
                }
            }
            Character.Species.LAPRAS -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.ICE
                pokedexNumber = 131
                baseHP = 130
                baseATK = 85
                baseDEF = 80
                baseSPEED = 60
                baseSPCL = 95
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.ICE_BEAM
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.CONFUSE_RAY
                    m++
                }
                if (lvl >= 25 && m < 4) {
                    move[m] = Move.BODY_SLAM
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.MIST
                    m++
                }
                if (lvl >= 16 && m < 4) {
                    move[m] = Move.SING
                    m++
                }
                if (m < 4) {
                    move[m] = Move.GROWL
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
            }
            Character.Species.DITTO -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 132
                baseHP = 48
                baseATK = 48
                baseDEF = 48
                baseSPEED = 48
                baseSPCL = 48
                if (m < 4) {
                    move[m] = Move.TRANSFORM
                    m++
                }
            }
            Character.Species.EEVEE -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 133
                baseHP = 55
                baseATK = 55
                baseDEF = 50
                baseSPEED = 55
                baseSPCL = 65
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.VAPOREON -> {
                nickname = toString(s)
                type1 = Type.WATER
                type2 = Type.NONE
                pokedexNumber = 134
                baseHP = 130
                baseATK = 65
                baseDEF = 60
                baseSPEED = 65
                baseSPCL = 110
                if (lvl >= 52 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.MIST
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.HAZE
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.ACID_ARMOR
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.JOLTEON -> {
                nickname = toString(s)
                type1 = Type.ELECTRIC
                type2 = Type.NONE
                pokedexNumber = 135
                baseHP = 65
                baseATK = 65
                baseDEF = 60
                baseSPEED = 130
                baseSPCL = 110
                if (lvl >= 52 && m < 4) {
                    move[m] = Move.THUNDER
                    m++
                }
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.PIN_MISSILE
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.DOUBLE_KICK
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.THUNDER_WAVE
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.THUNDERSHOCK
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.FLAREON -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.NONE
                pokedexNumber = 136
                baseHP = 65
                baseATK = 130
                baseDEF = 60
                baseSPEED = 65
                baseSPCL = 110
                if (lvl >= 54 && m < 4) {
                    move[m] = Move.FLAMETHROWER
                    m++
                }
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.RAGE
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.FIRE_SPIN
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 37 && m < 4) {
                    move[m] = Move.TAIL_WHIP
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.EMBER
                    m++
                }
                if (lvl >= 27 && m < 4) {
                    move[m] = Move.QUICK_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SAND_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.PORYGON -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 137
                baseHP = 65
                baseATK = 60
                baseDEF = 70
                baseSPEED = 40
                baseSPCL = 75
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.TRI_ATTACK
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 28 && m < 4) {
                    move[m] = Move.RECOVER
                    m++
                }
                if (lvl >= 23 && m < 4) {
                    move[m] = Move.PSYBEAM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.CONVERSION
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SHARPEN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.TACKLE
                    m++
                }
            }
            Character.Species.OMANYTE -> {
                nickname = toString(s)
                type1 = Type.ROCK
                type2 = Type.WATER
                pokedexNumber = 138
                baseHP = 35
                baseATK = 40
                baseDEF = 100
                baseSPEED = 35
                baseSPCL = 90
                if (lvl >= 53 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 46 && m < 4) {
                    move[m] = Move.SPIKE_CANNON
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.HORN_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WITHDRAW
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
            }
            Character.Species.OMASTAR -> {
                nickname = toString(s)
                type1 = Type.ROCK
                type2 = Type.WATER
                pokedexNumber = 139
                baseHP = 70
                baseATK = 60
                baseDEF = 125
                baseSPEED = 55
                baseSPCL = 115
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.SPIKE_CANNON
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.HORN_ATTACK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WITHDRAW
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
            }
            Character.Species.KABUTO -> {
                nickname = toString(s)
                type1 = Type.ROCK
                type2 = Type.WATER
                pokedexNumber = 140
                baseHP = 30
                baseATK = 80
                baseDEF = 90
                baseSPEED = 55
                baseSPCL = 45
                if (lvl >= 49 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 44 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 39 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 34 && m < 4) {
                    move[m] = Move.ABSORB
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.KABUTOPS -> {
                nickname = toString(s)
                type1 = Type.ROCK
                type2 = Type.WATER
                pokedexNumber = 141
                baseHP = 60
                baseATK = 115
                baseDEF = 105
                baseSPEED = 80
                baseSPCL = 70
                if (lvl >= 50 && m < 4) {
                    move[m] = Move.HYDRO_PUMP
                    m++
                }
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.SLASH
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.ABSORB
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SCRATCH
                    m++
                }
            }
            Character.Species.AERODACTYL -> {
                nickname = toString(s)
                type1 = Type.ROCK
                type2 = Type.FLYING
                pokedexNumber = 142
                baseHP = 80
                baseATK = 105
                baseDEF = 65
                baseSPEED = 130
                baseSPCL = 60
                if (lvl >= 54 && m < 4) {
                    move[m] = Move.HYPER_BEAM
                    m++
                }
                if (lvl >= 45 && m < 4) {
                    move[m] = Move.TAKE_DOWN
                    m++
                }
                if (lvl >= 38 && m < 4) {
                    move[m] = Move.BITE
                    m++
                }
                if (lvl >= 33 && m < 4) {
                    move[m] = Move.SUPERSONIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WING_ATTACK
                    m++
                }
            }
            Character.Species.SNORLAX -> {
                nickname = toString(s)
                type1 = Type.NORMAL
                type2 = Type.NONE
                pokedexNumber = 143
                baseHP = 160
                baseATK = 110
                baseDEF = 65
                baseSPEED = 30
                baseSPCL = 65
                if (lvl >= 56 && m < 4) {
                    move[m] = Move.HYPER_BEAM
                    m++
                }
                if (lvl >= 48 && m < 4) {
                    move[m] = Move.DOUBLE_EDGE
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.HARDEN
                    m++
                }
                if (lvl >= 35 && m < 4) {
                    move[m] = Move.BODY_SLAM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.REST
                    m++
                }
                if (m < 4) {
                    move[m] = Move.AMNESIA
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HEADBUTT
                    m++
                }
            }
            Character.Species.ARTICUNO -> {
                nickname = toString(s)
                type1 = Type.ICE
                type2 = Type.FLYING
                pokedexNumber = 144
                baseHP = 90
                baseATK = 85
                baseDEF = 100
                baseSPEED = 85
                baseSPCL = 125
                if (lvl >= 60 && m < 4) {
                    move[m] = Move.MIST
                    m++
                }
                if (lvl >= 55 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 51 && m < 4) {
                    move[m] = Move.BLIZZARD
                    m++
                }
                if (m < 4) {
                    move[m] = Move.ICE_BEAM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PECK
                    m++
                }
            }
            Character.Species.ZAPDOS -> {
                nickname = toString(s)
                type1 = Type.ELECTRIC
                type2 = Type.FLYING
                pokedexNumber = 145
                baseHP = 90
                baseATK = 90
                baseDEF = 85
                baseSPEED = 100
                baseSPCL = 125
                if (lvl >= 60 && m < 4) {
                    move[m] = Move.LIGHT_SCREEN
                    m++
                }
                if (lvl >= 55 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 51 && m < 4) {
                    move[m] = Move.THUNDER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.DRILL_PECK
                    m++
                }
                if (m < 4) {
                    move[m] = Move.THUNDERSHOCK
                    m++
                }
            }
            Character.Species.MOLTRES -> {
                nickname = toString(s)
                type1 = Type.FIRE
                type2 = Type.FLYING
                pokedexNumber = 146
                baseHP = 90
                baseATK = 100
                baseDEF = 90
                baseSPEED = 90
                baseSPCL = 125
                if (lvl >= 60 && m < 4) {
                    move[m] = Move.SKY_ATTACK
                    m++
                }
                if (lvl >= 55 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (lvl >= 51 && m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.FIRE_SPIN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PECK
                    m++
                }
            }
            Character.Species.DRATINI -> {
                nickname = toString(s)
                type1 = Type.DRAGON
                type2 = Type.NONE
                pokedexNumber = 147
                baseHP = 41
                baseATK = 64
                baseDEF = 45
                baseSPEED = 50
                baseSPCL = 50
                if (lvl >= 50 && m < 4) {
                    move[m] = Move.HYPER_BEAM
                    m++
                }
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.DRAGON_RAGE
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.SLAM
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (m < 4) {
                    move[m] = Move.THUNDER_WAVE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
            }
            Character.Species.DRAGONAIR -> {
                nickname = toString(s)
                type1 = Type.DRAGON
                type2 = Type.NONE
                pokedexNumber = 148
                baseHP = 61
                baseATK = 84
                baseDEF = 65
                baseSPEED = 70
                baseSPCL = 70
                if (lvl >= 51 && m < 4) {
                    move[m] = Move.HYPER_BEAM
                    m++
                }
                if (lvl >= 41 && m < 4) {
                    move[m] = Move.DRAGON_RAGE
                    m++
                }
                if (lvl >= 31 && m < 4) {
                    move[m] = Move.SLAM
                    m++
                }
                if (lvl >= 21 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (m < 4) {
                    move[m] = Move.THUNDER_WAVE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
            }
            Character.Species.DRAGONITE -> {
                nickname = toString(s)
                type1 = Type.DRAGON
                type2 = Type.FLYING
                pokedexNumber = 149
                baseHP = 91
                baseATK = 134
                baseDEF = 95
                baseSPEED = 80
                baseSPCL = 100
                if (lvl >= 52 && m < 4) {
                    move[m] = Move.HYPER_BEAM
                    m++
                }
                if (lvl >= 42 && m < 4) {
                    move[m] = Move.DRAGON_RAGE
                    m++
                }
                if (lvl >= 32 && m < 4) {
                    move[m] = Move.SLAM
                    m++
                }
                if (lvl >= 22 && m < 4) {
                    move[m] = Move.AGILITY
                    m++
                }
                if (m < 4) {
                    move[m] = Move.THUNDER_WAVE
                    m++
                }
                if (m < 4) {
                    move[m] = Move.LEER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.WRAP
                    m++
                }
            }
            Character.Species.MEWTWO -> {
                nickname = toString(s)
                type1 = Type.PSYCHIC
                type2 = Type.NONE
                pokedexNumber = 150
                baseHP = 106
                baseATK = 110
                baseDEF = 90
                baseSPEED = 130
                baseSPCL = 154
                if (lvl >= 81 && m < 4) {
                    move[m] = Move.AMNESIA
                    m++
                }
                if (lvl >= 75 && m < 4) {
                    move[m] = Move.MIST
                    m++
                }
                if (m < 4) {
                    move[m] = Move.RECOVER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (m < 4) {
                    move[m] = Move.BARRIER
                    m++
                }
                if (m < 4) {
                    move[m] = Move.SWIFT
                    m++
                }
            }
            Character.Species.MEW -> {
                nickname = toString(s)
                type1 = Type.PSYCHIC
                type2 = Type.NONE
                pokedexNumber = 151
                baseHP = 100
                baseATK = 100
                baseDEF = 100
                baseSPEED = 100
                baseSPCL = 100
                if (lvl >= 40 && m < 4) {
                    move[m] = Move.PSYCHIC
                    m++
                }
                if (lvl >= 30 && m < 4) {
                    move[m] = Move.METRONOME
                    m++
                }
                if (lvl >= 20 && m < 4) {
                    move[m] = Move.MEGA_PUNCH
                    m++
                }
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.TRANSFORM
                    m++
                }
                if (m < 4) {
                    move[m] = Move.POUND
                    m++
                }
            }
            Character.Species.MISSINGNO -> {
                nickname = toString(s)
                type1 = Type.BIRD
                type2 = Type.NORMAL
                pokedexNumber = 256
                baseHP = 256
                baseATK = 256
                baseDEF = 256
                baseSPEED = 16
                baseSPCL = 256
                if (lvl >= 10 && m < 4) {
                    move[m] = Move.FISSURE
                    m++
                }
                if (lvl >= 7 && m < 4) {
                    move[m] = Move.SKY_ATTACK
                    m++
                }
                if (lvl >= 5 && m < 4) {
                    move[m] = Move.WATER_GUN
                    m++
                }
                if (m < 4) {
                    move[m] = Move.HYPER_BEAM
                    m++
                }
            }
        }
        healthMax = calcHPStat(baseHP, HP_IV, HP_EV, level)
        health = healthMax
        atk = calcOtherStat(baseATK, ATK_IV, ATK_EV, level)
        def = calcOtherStat(baseDEF, DEF_IV, DEF_EV, level)
        spcl = calcOtherStat(baseSPCL, SPCL_IV, SPCL_EV, level)
        speed = calcOtherStat(baseSPEED, SPEED_IV, SPEED_EV, level)
        println("New " + this.species + " created successfully.")
    }

    fun createMoves() {
        for (i in 0..3) {
            when (move[i]) {
                Character.Move.TACKLE -> {
                    move[i]?.accuracy = 95
                    move[i]?.basePower = 35
                    move[i]?.pp = 35
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.GROWL -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.LOWER_STAT
                }
                Character.Move.ABSORB -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 20
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.ABSORB
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.ACID -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.POISON
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.ACID_ARMOR -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.POISON
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.AGILITY -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.AMNESIA -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.AURORA_BEAM -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 65
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.ICE
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.FRZ
                }
                Character.Move.BARRAGE -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 15
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.BARRIER -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.BIDE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.COLLECT_DAMAGE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.BIND -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 15
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.MULTI_TURN
                    move[i]?.sideEffectAcc = 75
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.BITE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 60
                    move[i]?.pp = 25
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.substatus = Substatus.FLINCH
                }
                Character.Move.BLIZZARD -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 120
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.ICE
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.FRZ
                }
                Character.Move.BODY_SLAM -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 85
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.PAR
                }
                Character.Move.BONE_CLUB -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 65
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.GROUND
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.substatus = Substatus.FLINCH
                }
                Character.Move.BONEMERANG -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 50
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 90
                    move[i]?.moveType = Type.GROUND
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.BUBBLE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 20
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.WATER
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.BUBBLEBEAM -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 65
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.WATER
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.CLAMP -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 35
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.MULTI_TURN
                    move[i]?.sideEffectAcc = 75
                    move[i]?.moveType = Type.WATER
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.COMET_PUNCH -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 18
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.CONFUSE_RAY -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GHOST
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.substatus = Substatus.CONFU
                }
                Character.Move.CONFUSION -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 50
                    move[i]?.pp = 25
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.substatus = Substatus.CONFU
                }
                Character.Move.CONSTRICT -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 10
                    move[i]?.pp = 35
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.CONVERSION -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.CONVERSION
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.COUNTER -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.COLLECT_DAMAGE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.CRABHAMMER -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 90
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.HIGH_CRIT
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.WATER
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.CUT -> {
                    move[i]?.accuracy = 95
                    move[i]?.basePower = 50
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.DEFENSE_CURL -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.DIG -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 100
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.HIDE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GROUND
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.DISABLE -> {
                    move[i]?.accuracy = 55
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.DISABLE
                    move[i]?.sideEffectAcc = 55
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.DIZZY_PUNCH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 70
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.DOUBLE_KICK -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 30
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.DOUBLE_TEAM -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.DOUBLE_EDGE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 100
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.RECOIL
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.DOUBLESLAP -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 15
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.DRAGON_RAGE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.FIXED_DAMAGE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.DRAGON
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.DREAM_EATER -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 100
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.ABSORB
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.DRILL_PECK -> {
                    move[i]?.accuracy = 80
                    move[i]?.basePower = 100
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FLYING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.EARTHQUAKE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 100
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GROUND
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.EGG_BOMB -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 100
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.EMBER -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 25
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.FIRE
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.BRN
                }
                Character.Move.EXPLOSION -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 170
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.FAINT
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.FIRE_BLAST -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 120
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.FIRE
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.BRN
                }
                Character.Move.FIRE_PUNCH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 75
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.FIRE
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.BRN
                }
                Character.Move.FIRE_SPIN -> {
                    move[i]?.accuracy = 70
                    move[i]?.basePower = 15
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.MULTI_TURN
                    move[i]?.sideEffectAcc = 70
                    move[i]?.moveType = Type.FIRE
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.FISSURE -> {
                    move[i]?.accuracy = 30
                    move[i]?.basePower = 0
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.OHKO
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.GROUND
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.FLAMETHROWER -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 95
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.FIRE
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.BRN
                }
                Character.Move.FLASH -> {
                    move[i]?.accuracy = 70
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 70
                    move[i]?.moveType = Type.ELECTRIC
                    move[i]?.mainEffect = Primary_Effect.LOWER_STAT
                }
                Character.Move.FLY -> {
                    move[i]?.accuracy = 95
                    move[i]?.basePower = 70
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.HIDE
                    move[i]?.sideEffectAcc = 95
                    move[i]?.moveType = Type.FLYING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.FOCUS_ENERGY -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.FURY_SWIPES -> {
                    move[i]?.accuracy = 80
                    move[i]?.basePower = 18
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 80
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.FURY_ATTACK -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 15
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.GLARE -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 75
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.PAR
                }
                Character.Move.GROWTH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.GUILLOTINE -> {
                    move[i]?.accuracy = 30
                    move[i]?.basePower = 0
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.OHKO
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.GUST -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 35
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FLYING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.HARDEN -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.HAZE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.ICE
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.HEADBUTT -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 70
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.substatus = Substatus.FLINCH
                }
                Character.Move.HI_JUMP_KICK -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 85
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.RECOIL
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.HORN_ATTACK -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 65
                    move[i]?.pp = 25
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.HORN_DRILL -> {
                    move[i]?.accuracy = 30
                    move[i]?.basePower = 0
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.OHKO
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.HYDRO_PUMP -> {
                    move[i]?.accuracy = 80
                    move[i]?.basePower = 120
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.WATER
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.HYPER_BEAM -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 150
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.CHARGE
                    move[i]?.sideEffectAcc = 90
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.HYPER_FANG -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 80
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.substatus = Substatus.FLINCH
                }
                Character.Move.HYPNOSIS -> {
                    move[i]?.accuracy = 60
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 60
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.SLP
                }
                Character.Move.ICE_BEAM -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 95
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.ICE
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.FRZ
                }
                Character.Move.ICE_PUNCH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 75
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.ICE
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.FRZ
                }
                Character.Move.JUMP_KICK -> {
                    move[i]?.accuracy = 95
                    move[i]?.basePower = 70
                    move[i]?.pp = 25
                    move[i]?.sideEffect = Side_Effect.RECOIL
                    move[i]?.sideEffectAcc = 95
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.KARATE_CHOP -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 50
                    move[i]?.pp = 25
                    move[i]?.sideEffect = Side_Effect.HIGH_CRIT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.KINESIS -> {
                    move[i]?.accuracy = 80
                    move[i]?.basePower = 0
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 80
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.LOWER_STAT
                }
                Character.Move.LEECH_LIFE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 20
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.ABSORB
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.BUG
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.substatus = Substatus.SEED
                }
                Character.Move.LEECH_SEED -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 90
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.substatus = Substatus.SEED
                }
                Character.Move.LEER -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.LOWER_STAT
                }
                Character.Move.LICK -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 20
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.GHOST
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.PAR
                }
                Character.Move.LIGHT_SCREEN -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.LOVELY_KISS -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 75
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.SLP
                }
                Character.Move.LOW_KICK -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 50
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.MEDITATE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.MEGA_DRAIN -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.ABSORB
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.MEGA_KICK -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 120
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 75
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.MEGA_PUNCH -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 80
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.METRONOME -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.METRONOME
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.MIMIC -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.MIMIC
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.MINIMIZE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.MIRROR_MOVE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.MIRROR_MOVE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FLYING
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.MIST -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.MULTI_TURN
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.ICE
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.NIGHT_SHADE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.FIXED_DAMAGE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GHOST
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.PAY_DAY -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.PECK -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 35
                    move[i]?.pp = 35
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FLYING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.PETAL_DANCE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 70
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.FURY
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.PIN_MISSILE -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 14
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.BUG
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.POISON_GAS -> {
                    move[i]?.accuracy = 55
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 55
                    move[i]?.moveType = Type.POISON
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.PSN
                }
                Character.Move.POISON_STING -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 15
                    move[i]?.pp = 35
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 20
                    move[i]?.moveType = Type.POISON
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.PSN
                }
                Character.Move.POISONPOWDER -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 0
                    move[i]?.pp = 35
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 75
                    move[i]?.moveType = Type.POISON
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.PSN
                }
                Character.Move.POUND -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 35
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.PSYBEAM -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 65
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.substatus = Substatus.CONFU
                }
                Character.Move.PSYCHIC -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 90
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.PSYWAVE -> {
                    move[i]?.accuracy = 80
                    move[i]?.basePower = 0
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.FIXED_DAMAGE
                    move[i]?.sideEffectAcc = 80
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.QUICK_ATTACK -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.QUICK_ATTACK
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.RAGE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 20
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.FURY
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.RAZOR_LEAF -> {
                    move[i]?.accuracy = 95
                    move[i]?.basePower = 55
                    move[i]?.pp = 25
                    move[i]?.sideEffect = Side_Effect.HIGH_CRIT
                    move[i]?.sideEffectAcc = 95
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.RAZOR_WIND -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 80
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.CHARGE
                    move[i]?.sideEffectAcc = 75
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.RECOVER -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.RECOVERY
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.REFLECT -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.REST -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.RECOVERY
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.ROAR -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.ROAR
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.ROCK_SLIDE -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 75
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.ROCK
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.ROCK_THROW -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 50
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.ROLLING_KICK -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 60
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.substatus = Substatus.FLINCH
                }
                Character.Move.SAND_ATTACK -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GROUND
                    move[i]?.mainEffect = Primary_Effect.LOWER_STAT
                }
                Character.Move.SCRATCH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 35
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SCREECH -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.LOWER_STAT
                }
                Character.Move.SEISMIC_TOSS -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.FIXED_DAMAGE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SELFDESTRUCT -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 130
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.FAINT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SHARPEN -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.SING -> {
                    move[i]?.accuracy = 55
                    move[i]?.basePower = 0
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 55
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.SLP
                }
                Character.Move.SKULL_BASH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 100
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.CHARGE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SKY_ATTACK -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 140
                    move[i]?.pp = 5
                    move[i]?.sideEffect = Side_Effect.CHARGE
                    move[i]?.sideEffectAcc = 90
                    move[i]?.moveType = Type.FLYING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SLAM -> {
                    move[i]?.accuracy = 80
                    move[i]?.basePower = 75
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 80
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SLASH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 70
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.HIGH_CRIT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SLEEP_POWDER -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 0
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 75
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.SLP
                }
                Character.Move.SLUDGE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 65
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.POISON
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.PSN
                }
                Character.Move.SMOG -> {
                    move[i]?.accuracy = 70
                    move[i]?.basePower = 20
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 40
                    move[i]?.moveType = Type.POISON
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.PSN
                }
                Character.Move.SMOKESCREEN -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.LOWER_STAT
                }
                Character.Move.SOFTBOILED -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.RECOVERY
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.SOLARBEAM -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 120
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.CHARGE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SONIC_BOOM -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 20
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.FIXED_DAMAGE
                    move[i]?.sideEffectAcc = 90
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SPIKE_CANNON -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 20
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SPLASH -> {
                    move[i]?.accuracy = 0
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 0
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.SPORE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.SLP
                }
                Character.Move.STOMP -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 65
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 30
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.substatus = Substatus.FLINCH
                }
                Character.Move.STRENGTH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 80
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.STRING_SHOT -> {
                    move[i]?.accuracy = 95
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 95
                    move[i]?.moveType = Type.BUG
                    move[i]?.mainEffect = Primary_Effect.LOWER_STAT
                }
                Character.Move.NONE, Character.Move.STRUGGLE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 50
                    move[i]?.pp = 256
                    move[i]?.sideEffect = Side_Effect.RECOIL
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.STUN_SPORE -> {
                    move[i]?.accuracy = 75
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 75
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.PAR
                }
                Character.Move.SUBMISSION -> {
                    move[i]?.accuracy = 80
                    move[i]?.basePower = 80
                    move[i]?.pp = 25
                    move[i]?.sideEffect = Side_Effect.RECOIL
                    move[i]?.sideEffectAcc = 80
                    move[i]?.moveType = Type.FIGHTING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SUBSTITUTE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.SUBSTITUTE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.SUPER_FANG -> {
                    move[i]?.accuracy = 90
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.FIXED_DAMAGE
                    move[i]?.sideEffectAcc = 90
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SUPERSONIC -> {
                    move[i]?.accuracy = 55
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.SUBSTATUS
                    move[i]?.sideEffectAcc = 55
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.substatus = Substatus.CONFU
                }
                Character.Move.SURF -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 95
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.WATER
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SWIFT -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 60
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.SWIFT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.SWORDS_DANCE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.TAIL_WHIP -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.LOWER_STAT
                }
                Character.Move.TAKE_DOWN -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 90
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.RECOIL
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.TELEPORT -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.PSYCHIC
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.THRASH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 90
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.FURY
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.THUNDER -> {
                    move[i]?.accuracy = 70
                    move[i]?.basePower = 120
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.ELECTRIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.PAR
                }
                Character.Move.THUNDER_WAVE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.ELECTRIC
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.PAR
                }
                Character.Move.THUNDERBOLT -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 95
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.ELECTRIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.PAR
                }
                Character.Move.THUNDERPUNCH -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 75
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.ELECTRIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.PAR
                }
                Character.Move.THUNDERSHOCK -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 10
                    move[i]?.moveType = Type.ELECTRIC
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                    move[i]?.status = Status.PAR
                }
                Character.Move.TOXIC -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.STATUS
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.POISON
                    move[i]?.mainEffect = Primary_Effect.INFLICT_STATUS
                    move[i]?.status = Status.PSN
                }
                Character.Move.TRANSFORM -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.TRANSFORM
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.TRI_ATTACK -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 80
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.TWINEEDLE -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 25
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.MULTI_HIT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.BUG
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.VICEGRIP -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 55
                    move[i]?.pp = 30
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.VINE_WHIP -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 35
                    move[i]?.pp = 10
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.GRASS
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.WATER_GUN -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 40
                    move[i]?.pp = 25
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.WATER
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.WATERFALL -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 80
                    move[i]?.pp = 15
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.WATER
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.WHIRLWIND -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.ROAR
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.SPECIAL
                }
                Character.Move.WING_ATTACK -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 35
                    move[i]?.pp = 35
                    move[i]?.sideEffect = Side_Effect.NONE
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.FLYING
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
                Character.Move.WITHDRAW -> {
                    move[i]?.accuracy = 100
                    move[i]?.basePower = 0
                    move[i]?.pp = 40
                    move[i]?.sideEffect = Side_Effect.STAT
                    move[i]?.sideEffectAcc = 100
                    move[i]?.moveType = Type.WATER
                    move[i]?.mainEffect = Primary_Effect.RAISE_STAT
                }
                Character.Move.WRAP -> {
                    move[i]?.accuracy = 85
                    move[i]?.basePower = 15
                    move[i]?.pp = 20
                    move[i]?.sideEffect = Side_Effect.MULTI_TURN
                    move[i]?.sideEffectAcc = 85
                    move[i]?.moveType = Type.NORMAL
                    move[i]?.mainEffect = Primary_Effect.DAMAGE
                }
            }
            if (move[i] != null) {
                move[i]!!.ppMax = move[i]!!.pp
                TRUE_PP[i] = move[i]!!.pp
                TRUE_PPMAX[i] = move[i]!!.ppMax
            }
        }
        println(nickname + "'s moves created successfully")
    }

    fun toPacket(): ISFSObject {
        // Populate the response parameters
        val response = SFSObject()
        response.putInt(ConfigSFSPacketKey.CHARACTER_ID, idNumber)
        response.putInt(ConfigSFSPacketKey.CHARACTER_ID_USER, idUser)
        response.putInt(ConfigSFSPacketKey.CHARACTER_SPECIES, species.ordinal)
        if (move[0] != null)
            response.putInt(ConfigSFSPacketKey.CHARACTER_MOVE_1, move[0]!!.ordinal)
        if (move[1] != null)
            response.putInt(ConfigSFSPacketKey.CHARACTER_MOVE_2, move[1]!!.ordinal)
        if (move[2] != null)
            response.putInt(ConfigSFSPacketKey.CHARACTER_MOVE_3, move[2]!!.ordinal)
        if (move[3] != null)
            response.putInt(ConfigSFSPacketKey.CHARACTER_MOVE_4, move[3]!!.ordinal)
        response.putInt(ConfigSFSPacketKey.CHARACTER_LEVEL, level)
        response.putInt(ConfigSFSPacketKey.CHARACTER_EXP, exp)
        response.putUtfString(ConfigSFSPacketKey.CHARACTER_NICKNAME, nickname)
        return response
    }
}