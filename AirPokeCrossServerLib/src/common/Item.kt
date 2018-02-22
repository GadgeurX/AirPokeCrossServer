package common

class Item {
    //Fields
    val type:Type
    var effect1:Effect = Effect.NONE
    var effect2:Effect = Effect.NONE
    var pocket:Pocket = Pocket.ITEM
    //If storeCost is -1 you can't buy it
    var storeCost:Int = 0
    var amount:Int = 0
    var reUsable:Boolean = false
    var mNo:Int = 0
    var message:String = ""
    var alphabet:Int = 0
    //If no specific power, it is automatically 100
    var power1:Int = 0
    var power2:Int = 0
    //Heals this status if STATUS_HEAL and if OK
    //it heals all statuses
    var healStatus:Character.Status = Character.Status.OK
    //If tm or Hm, the Move the Character learns
    var moveLearned:Character.Move? = null
    var found = true
    
    val nameMoney:String
        get() {
            var returnString = type.toString()
            returnString = returnString.replace('_', ' ')
            if ((effect1 == Effect.TM || effect1 == Effect.HM) && type != Type.REDBULL)
            {
                returnString = returnString + " " + mNo
                System.out.println(moveLearned)
            }
            returnString = returnString + " $" + storeCost
            return returnString
        }
    //Enum Fields
    enum class Type {
        ANTIDOTE, AWAKENING, BICYCLE, BIKE_VOUCHER, BURN_HEAL,
        CALCIUM, CARD_KEY, CARBOS, COIN_CASE, DIRE_HIT, DOME_FOSSIL,
        ELIXER, ESCAPE_ROPE, ETHER, EXPERIENCE_ALL, FIRE_STONE,
        FRESH_WATER, FULL_HEAL, FULL_RESTORE, GOLD_TEETH,
        GOOD_ROD, GREAT_BALL, GUARD_SPECIAL, HELIX_FOSSIL,
        HP_UP, HYPER_POTION, ICE_HEAL, IRON, ITEM_FINDER,
        LEAF_STONE, LEMONADE, LIFT_KEY, MASTER_BALL, MAX_ELIXIR,
        MAX_ETHER, MAX_POTION, MAX_REPEL, MAX_REVIVE, MOON_STONE,
        NUGGET, OLD_AMBER, OLD_ROD, PARALYZE_HEAL, POKE_BALL,
        POKE_FLUTE, POTION, PP_UP, PROTEIN, RARE_CANDY, REPEL,
        REVIVE, SS_TICKET, SAFARI_BALL, SECRET_KEY, SILPH_SCOPE,
        SODA_POP, SUPER_POTION, SUPER_ROD, THUNDER_STONE, TOWN_MAP,
        ULTRA_BALL, WATER_STONE, X_ACCURACY, X_ATTACK, X_DEFEND,
        X_SPECIAL, X_SPEED, TM, HM,
        OMEGA_BALL, MOUNTAIN_DEW, BEER, ROTTEN_APPLE, ULTIMA_REPEL, SILVER_NUGGET, REDBULL
        //Unused Items
        //
        //Card Key, Bike Voucher, Card Key, Coin Case, Dome Fossil, Gold Teeth, Helix Fossil,
        //Itemfinder, Lift Key, Old Amber, PP Up, Poke Flute, SS Ticket, Safari Ball, Secret Key, Silph Scope,
    }
    enum class Effect {
        STATUS_HEAL, HP_HEAL, POKEBALL, PP_HEAL, KEY_ITEM, TM, HM,
        BATTLE_BOOST, PERMA_STAT_BOOST, EVO_STONE, POKE_FLUTE,
        GUARD_SPECIAL, ITEM_FINDER, REPEL, FOSSIL, RARE_CANDY,
        MAP, BIKE, ELIXER, EXPERIENCE_ALL, ESCAPE_ROPE, ROD, PP_UP, NONE
    }
    enum class Pocket {
        ITEM, MEDICINE, POKEBALL, TMHM, BATTLE, KEY
    }
    //End of Enum Fields
    //Constructors only take name
    constructor(name:Type, amount2:Long) {
        type = name
        amount = amount2.toInt()
        createItem()
    }
    //Constructors only take name
    constructor(name:Type, amount2:Int) {
        type = name
        amount = amount2.toInt()
        createItem()
    }
    //This helps if you are creating a TM
    constructor(name:Type, amount2:Long, tmNo:Int) {
        type = name
        mNo = tmNo
        amount = amount2.toInt()
        createItem()
    }
    //This helps if you are creating a TM
    constructor(name:Type, amount2:Int, tmNo:Int) {
        type = name
        mNo = tmNo
        amount = amount2.toInt()
        createItem()
    }
    //Creates all the information from the name of the item
    private fun createItem() {
        when (type) {
            Item.Type.ANTIDOTE -> {
                effect1 = Effect.STATUS_HEAL
                power1 = 100
                healStatus = Character.Status.PSN
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 100
                pocket = Pocket.MEDICINE
                reUsable = false
                message = "Cures poison"
                alphabet = 1
            }
            Item.Type.AWAKENING -> {
                effect1 = Effect.STATUS_HEAL
                power1 = 100
                healStatus = Character.Status.SLP
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 250
                pocket = Pocket.MEDICINE
                reUsable = false
                message = "Wakes up your Character"
                alphabet = 1
            }
            Item.Type.BICYCLE -> {
                effect1 = Effect.BIKE
                power1 = 100
                effect2 = Effect.KEY_ITEM
                power2 = 100
                storeCost = 10000000
                reUsable = true
                pocket = Pocket.KEY
                amount = 1
                message = "Increases movement speed"
                alphabet = 2
            }
            Item.Type.BIKE_VOUCHER -> {
                effect1 = Effect.KEY_ITEM
                power1 = 100
                effect2 = Effect.NONE
                power2 = 0
                storeCost = -1
                reUsable = false
                amount = 1
                pocket = Pocket.KEY
                message = "Use this to purchase a bike"
                alphabet = 2
            }
            Item.Type.CALCIUM -> {
                effect1 = Effect.PERMA_STAT_BOOST
                power1 = 10
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 9800
                reUsable = false
                pocket = Pocket.MEDICINE
                message = "Increases Special stat permanently"
                alphabet = 3
            }
            Item.Type.CARBOS -> {
                effect1 = Effect.PERMA_STAT_BOOST
                power1 = 10
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 9800
                reUsable = false
                pocket = Pocket.MEDICINE
                message = "Increases Speed stat permanently"
                alphabet = 3
            }
            Item.Type.CARD_KEY -> {
                effect1 = Effect.KEY_ITEM
                power1 = 100
                effect2 = Effect.NONE
                power2 = 0
                storeCost = -1
                reUsable = true
                amount = 1
                pocket = Pocket.KEY
                message = "A card that unlocks a specific door"
                alphabet = 3
            }
            Item.Type.COIN_CASE -> {
                effect1 = Effect.KEY_ITEM
                power1 = 100
                effect2 = Effect.NONE
                power2 = 0
                storeCost = -1
                reUsable = true
                amount = 1
                pocket = Pocket.KEY
                message = "A case that contains all of your coins"
                alphabet = 3
            }
            Item.Type.DIRE_HIT //Raises Critical Chance
            -> {
                effect1 = Effect.BATTLE_BOOST
                power1 = 100
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 650
                reUsable = false
                pocket = Pocket.BATTLE
                message = "Raises critical chance in battle"
                alphabet = 4
            }
            Item.Type.DOME_FOSSIL -> {
                effect1 = Effect.FOSSIL
                power1 = 100
                effect2 = Effect.KEY_ITEM
                power2 = 0
                storeCost = -1
                reUsable = false
                pocket = Pocket.KEY
                message = "A mysterious fossil that contains the remains of an extinct Character"
                alphabet = 4
            }
            Item.Type.ELIXER -> {
                effect1 = Effect.ELIXER
                power1 = 10
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 20000
                reUsable = false
                pocket = Pocket.MEDICINE
                message = "Restores 10PP to all moves"
                alphabet = 5
            }
            Item.Type.ESCAPE_ROPE -> {
                effect1 = Effect.ESCAPE_ROPE
                power1 = 100
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 550
                reUsable = false
                pocket = Pocket.ITEM
                message = "Returns you to a cave entrance. Must be in a cave"
                alphabet = 5
            }
            Item.Type.ETHER -> {
                effect1 = Effect.PP_HEAL
                power1 = 10
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 5000
                reUsable = false
                pocket = Pocket.MEDICINE
                message = "Restores 10PP to one move"
                alphabet = 5
            }
            Item.Type.EXPERIENCE_ALL -> {
                effect1 = Effect.EXPERIENCE_ALL
                power1 = 6
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 50000
                reUsable = true
                pocket = Pocket.ITEM
                message = "Splits EXP recieved in battle between all Character in your party"
                alphabet = 5
            }
            Item.Type.FIRE_STONE -> {
                effect1 = Effect.EVO_STONE
                power1 = 100
                effect2 = Effect.NONE
                storeCost = 2100
                reUsable = false
                pocket = Pocket.ITEM
                message = "Evolves certain fire type Character"
                alphabet = 6
            }
            Item.Type.FRESH_WATER -> {
                effect1 = Effect.HP_HEAL
                power1 = 50
                effect2 = Effect.NONE
                storeCost = 200
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 6
                message = "Heals 50HP"
            }
            Item.Type.FULL_HEAL -> {
                effect1 = Effect.STATUS_HEAL
                power1 = 100
                healStatus = Character.Status.OK
                effect2 = Effect.NONE
                storeCost = 600
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 6
                message = "Cures any condition"
            }
            Item.Type.FULL_RESTORE -> {
                effect1 = Effect.HP_HEAL
                power1 = 99999
                effect2 = Effect.STATUS_HEAL
                power2 = 100
                healStatus = Character.Status.OK
                storeCost = 3000
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 6
                message = "Heals all HP and cures any condition"
            }
            Item.Type.GOLD_TEETH -> {
                effect1 = Effect.KEY_ITEM
                power1 = 100
                effect2 = Effect.NONE
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                message = "Gold colored dentures"
                alphabet = 7
            }
            Item.Type.GOOD_ROD -> {
                effect1 = Effect.ROD
                power1 = 2
                effect2 = Effect.KEY_ITEM
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                message = "A better fishing rod"
                alphabet = 7
            }
            Item.Type.GREAT_BALL -> {
                effect1 = Effect.POKEBALL
                power1 = 2
                effect2 = Effect.NONE
                storeCost = 600
                reUsable = false
                pocket = Pocket.POKEBALL
                message = "A pokeball with a higher catch rate than a pokeball"
                alphabet = 7
            }
            Item.Type.GUARD_SPECIAL -> {
                effect1 = Effect.BATTLE_BOOST
                power1 = 100
                effect2 = Effect.NONE
                storeCost = 700
                reUsable = false
                pocket = Pocket.BATTLE
                message = "Protects one Character in battle from special attacks"
                alphabet = 7
            }
            Item.Type.HELIX_FOSSIL -> {
                effect1 = Effect.FOSSIL
                power1 = 100
                effect2 = Effect.KEY_ITEM
                storeCost = -1
                reUsable = false
                pocket = Pocket.KEY
                message = "A mysterious fossil that contains the remains of an extinct Character"
                alphabet = 8
            }
            Item.Type.HP_UP -> {
                effect1 = Effect.PERMA_STAT_BOOST
                power1 = 10
                effect2 = Effect.NONE
                storeCost = 9800
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 8
                message = "Raises Health stat permanently"
            }
            Item.Type.HYPER_POTION -> {
                effect1 = Effect.HP_HEAL
                power1 = 200
                effect2 = Effect.NONE
                storeCost = 1500
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 8
                message = "Heals 200HP"
            }
            Item.Type.ICE_HEAL -> {
                effect1 = Effect.STATUS_HEAL
                power1 = 100
                healStatus = Character.Status.FRZ
                effect2 = Effect.NONE
                storeCost = 250
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 9
                message = "Defrosts one Character"
            }
            Item.Type.IRON -> {
                effect1 = Effect.PERMA_STAT_BOOST
                power1 = 10
                effect2 = Effect.NONE
                storeCost = 9800
                reUsable = false
                pocket = Pocket.MEDICINE
                message = "Raises Defense stat permanently"
                alphabet = 9
            }
            Item.Type.ITEM_FINDER -> {
                effect1 = Effect.ITEM_FINDER
                power1 = 100
                effect2 = Effect.KEY_ITEM
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                message = "Reveals hidden items"
                alphabet = 9
            }
            Item.Type.LEAF_STONE -> {
                effect1 = Effect.EVO_STONE
                power1 = 100
                effect2 = Effect.NONE
                storeCost = 2100
                reUsable = false
                pocket = Pocket.ITEM
                alphabet = 12
                message = "Evolves certain grass type Character"
            }
            Item.Type.LEMONADE -> {
                effect1 = Effect.HP_HEAL
                power1 = 80
                effect2 = Effect.NONE
                storeCost = 350
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 12
                message = "Heals 80HP"
            }
            Item.Type.LIFT_KEY -> {
                effect1 = Effect.KEY_ITEM
                effect2 = Effect.NONE
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                alphabet = 12
                message = "Unlocks a certain elevator"
            }
            Item.Type.MASTER_BALL -> {
                effect1 = Effect.POKEBALL
                power1 = 255
                effect2 = Effect.NONE
                storeCost = 9999999
                reUsable = false
                pocket = Pocket.POKEBALL
                alphabet = 13
                message = "A pokeball that wont fail"
            }
            Item.Type.MAX_ELIXIR -> {
                effect1 = Effect.ELIXER
                power1 = 255
                effect2 = Effect.NONE
                storeCost = 40000
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 13
                message = "Resores max PP to all moves"
            }
            Item.Type.MAX_ETHER -> {
                effect1 = Effect.PP_HEAL
                power1 = 255
                effect2 = Effect.NONE
                storeCost = 10000
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 13
                message = "Restores max PP to one move"
            }
            Item.Type.MAX_POTION -> {
                effect1 = Effect.HP_HEAL
                power1 = 99999
                effect2 = Effect.NONE
                storeCost = 2500
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 13
                message = "Restores max HP"
            }
            Item.Type.MAX_REPEL -> {
                effect1 = Effect.REPEL
                power1 = 250
                effect2 = Effect.NONE
                storeCost = 700
                reUsable = false
                pocket = Pocket.ITEM
                alphabet = 13
                message = "Repels for 250 steps"
            }
            Item.Type.MAX_REVIVE -> {
                effect1 = Effect.STATUS_HEAL
                power1 = 100
                healStatus = Character.Status.FNT
                effect2 = Effect.NONE
                power2 = 0
                storeCost = 5000
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 13
                message = "Revives one Character to full health"
            }
            Item.Type.NUGGET -> {
                effect1 = Effect.NONE
                effect2 = Effect.NONE
                storeCost = 10000
                reUsable = true
                pocket = Pocket.ITEM
                alphabet = 14
                message = "A valuable item"
            }
            Item.Type.OLD_AMBER -> {
                effect1 = Effect.FOSSIL
                effect2 = Effect.KEY_ITEM
                storeCost = -1
                reUsable = false
                pocket = Pocket.KEY
                alphabet = 15
                message = "An amber containing Character DNA"
            }
            Item.Type.OLD_ROD -> {
                effect1 = Effect.ROD
                power1 = 1
                effect2 = Effect.KEY_ITEM
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                alphabet = 15
                message = "A basic rod"
            }
            Item.Type.PARALYZE_HEAL -> {
                effect1 = Effect.STATUS_HEAL
                power1 = 100
                healStatus = Character.Status.PAR
                effect2 = Effect.NONE
                storeCost = 200
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 16
                message = "Cures paralysis"
            }
            Item.Type.POKE_BALL -> {
                effect1 = Effect.POKEBALL
                power1 = 1
                effect2 = Effect.NONE
                storeCost = 200
                reUsable = false
                pocket = Pocket.POKEBALL
                alphabet = 16
                message = "A basic pokeball"
            }
            Item.Type.POKE_FLUTE -> {
                effect1 = Effect.POKE_FLUTE
                effect2 = Effect.KEY_ITEM
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                alphabet = 16
                message = "A mysterious flute"
            }
            Item.Type.POTION -> {
                effect1 = Effect.HP_HEAL
                power1 = 20
                effect2 = Effect.NONE
                storeCost = 300
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 16
                message = "Heals 20HP"
            }
            Item.Type.PP_UP -> {
                effect1 = Effect.PP_UP
                power1 = 20
                effect2 = Effect.NONE
                storeCost = 20000
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 16
                message = "Raises PP by 20% for one move"
            }
            Item.Type.PROTEIN -> {
                effect1 = Effect.PERMA_STAT_BOOST
                power1 = 10
                effect2 = Effect.NONE
                storeCost = 9800
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 16
                message = "Raises Attack stat permanently"
            }
            Item.Type.RARE_CANDY -> {
                effect1 = Effect.RARE_CANDY
                effect2 = Effect.NONE
                storeCost = 8000
                reUsable = false
                pocket = Pocket.ITEM
                alphabet = 18
                message = "Raises one level"
            }
            Item.Type.REPEL -> {
                effect1 = Effect.REPEL
                power1 = 100
                effect2 = Effect.NONE
                storeCost = 350
                reUsable = false
                pocket = Pocket.ITEM
                alphabet = 18
                message = "Repels for 100 steps"
            }
            Item.Type.REVIVE -> {
                effect1 = Effect.STATUS_HEAL
                power1 = 100
                healStatus = Character.Status.FNT
                effect2 = Effect.NONE
                storeCost = 1500
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 18
                message = "Revives one Character to half health"
            }
            Item.Type.SS_TICKET -> {
                effect1 = Effect.KEY_ITEM
                effect2 = Effect.NONE
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                alphabet = 19
                message = "A ticket to get on the S.S. Anne"
            }
            Item.Type.SAFARI_BALL -> {
                effect1 = Effect.POKEBALL
                power1 = 2
                effect2 = Effect.NONE
                storeCost = 0
                reUsable = false
                pocket = Pocket.POKEBALL
                alphabet = 19
                message = "A pokeball used in the Safari Zone"
            }
            Item.Type.SECRET_KEY -> {
                effect1 = Effect.KEY_ITEM
                effect2 = Effect.NONE
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                alphabet = 19
                message = "A secretive key"
            }
            Item.Type.SILPH_SCOPE -> {
                effect1 = Effect.KEY_ITEM
                effect2 = Effect.NONE
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                alphabet = 19
                message = "Allows you to see ghosts"
            }
            Item.Type.SODA_POP -> {
                effect1 = Effect.HP_HEAL
                power1 = 60
                effect2 = Effect.NONE
                storeCost = 300
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 19
                message = "Heals 60HP"
            }
            Item.Type.SUPER_POTION -> {
                effect1 = Effect.HP_HEAL
                power1 = 70
                effect2 = Effect.NONE
                storeCost = 700
                reUsable = false
                pocket = Pocket.MEDICINE
                alphabet = 19
                message = "Heals 70HP"
            }
            Item.Type.SUPER_ROD -> {
                effect1 = Effect.ROD
                power1 = 3
                effect2 = Effect.KEY_ITEM
                storeCost = 7500
                reUsable = true
                pocket = Pocket.KEY
                alphabet = 19
                message = "The best rod"
            }
            Item.Type.THUNDER_STONE -> {
                effect1 = Effect.EVO_STONE
                effect2 = Effect.NONE
                storeCost = 2100
                reUsable = false
                pocket = Pocket.ITEM
                alphabet = 20
                message = "Evolves certain thunder type Character"
            }
            Item.Type.TOWN_MAP -> {
                effect1 = Effect.MAP
                effect2 = Effect.KEY_ITEM
                storeCost = -1
                reUsable = true
                pocket = Pocket.KEY
                alphabet = 20
                message = "Map of the entire region"
            }
            Item.Type.ULTRA_BALL -> {
                effect1 = Effect.POKEBALL
                power1 = 3
                effect2 = Effect.NONE
                storeCost = 1500
                reUsable = false
                pocket = Pocket.POKEBALL
                alphabet = 21
                message = "A stronger pokeball than great ball"
            }
            Item.Type.WATER_STONE -> {
                effect1 = Effect.EVO_STONE
                effect2 = Effect.NONE
                storeCost = 2100
                reUsable = false
                pocket = Pocket.ITEM
                alphabet = 22
                message = "Evolves certain water type Character"
            }
            Item.Type.X_ACCURACY -> {
                effect1 = Effect.BATTLE_BOOST
                power1 = 100
                effect2 = Effect.NONE
                storeCost = 950
                reUsable = false
                pocket = Pocket.BATTLE
                alphabet = 23
                message = "Temporarily raises accuracy in battle"
            }
            Item.Type.X_ATTACK -> {
                effect1 = Effect.BATTLE_BOOST
                power1 = 100
                effect2 = Effect.NONE
                storeCost = 500
                reUsable = false
                pocket = Pocket.BATTLE
                alphabet = 23
                message = "Temporarily raises attack in battle"
            }
            Item.Type.X_DEFEND -> {
                effect1 = Effect.BATTLE_BOOST
                power1 = 100
                effect2 = Effect.NONE
                storeCost = 550
                reUsable = false
                pocket = Pocket.BATTLE
                alphabet = 23
                message = "Temporarily raises defense in battle"
            }
            Item.Type.X_SPECIAL -> {
                effect1 = Effect.BATTLE_BOOST
                power1 = 100
                effect2 = Effect.NONE
                storeCost = 550
                reUsable = false
                pocket = Pocket.BATTLE
                alphabet = 23
                message = "Temporarily raises special in battle"
            }
            Item.Type.X_SPEED -> {
                effect1 = Effect.BATTLE_BOOST
                power1 = 100
                effect2 = Effect.NONE
                storeCost = 550
                reUsable = false
                pocket = Pocket.BATTLE
                alphabet = 23
                message = "Temporarily raises speed in battle"
            }
        //For both Tm and Hm their messages and
        //their move learned is depends on machine number
            Item.Type.TM -> {
                effect1 = Effect.TM
                effect2 = Effect.NONE
                reUsable = true
                alphabet = 20
                pocket = Pocket.TMHM
                when (mNo) {
                    1 -> {
                        moveLearned = Character.Move.MEGA_PUNCH
                        message = "Teaches one Character Mega Punch"
                        storeCost = 3000
                    }
                    2 -> {
                        moveLearned = Character.Move.RAZOR_WIND
                        message = "Teaches one Character Razor Wind"
                        storeCost = 1000
                    }
                    3 -> {
                        moveLearned = Character.Move.SWORDS_DANCE
                        message = "Teaches one Character Sword's Dance"
                        storeCost = 4000
                    }
                    4 -> {
                        moveLearned = Character.Move.WHIRLWIND
                        message = "Teaches one Character Whirlwind"
                        storeCost = 1000
                    }
                    5 -> {
                        moveLearned = Character.Move.MEGA_KICK
                        message = "Teaches one Character Mega Kick"
                        storeCost = 2000
                    }
                    6 -> {
                        moveLearned = Character.Move.TOXIC
                        message = "Teaches one Character Toxic"
                        storeCost = 5000
                    }
                    7 -> {
                        moveLearned = Character.Move.HORN_DRILL
                        message = "Teaches one Character Horn Drill"
                        storeCost = 3000
                    }
                    8 -> {
                        moveLearned = Character.Move.BODY_SLAM
                        message = "Teaches one Character Body Slam"
                        storeCost = 4000
                    }
                    9 -> {
                        moveLearned = Character.Move.TAKE_DOWN
                        message = "Teaches one Character Take Down"
                        storeCost = 3000
                    }
                    10 -> {
                        moveLearned = Character.Move.DOUBLE_EDGE
                        message = "Teaches one Character Double Edge"
                        storeCost = 3000
                    }
                    11 -> {
                        moveLearned = Character.Move.BUBBLEBEAM
                        message = "Teaches one Character Bubblebeam"
                        storeCost = 3000
                    }
                    12 -> {
                        moveLearned = Character.Move.WATER_GUN
                        message = "Teaches one Character Water Gun"
                        storeCost = 1500
                    }
                    13 -> {
                        moveLearned = Character.Move.ICE_BEAM
                        message = "Teaches one Character Ice Beam"
                        storeCost = 5000
                    }
                    14 -> {
                        moveLearned = Character.Move.BLIZZARD
                        message = "Teaches one Character Blizzard"
                        storeCost = 5000
                    }
                    15 -> {
                        moveLearned = Character.Move.HYPER_BEAM
                        message = "Teaches one Character Hyper Beam"
                        storeCost = 5000
                    }
                    16 -> {
                        moveLearned = Character.Move.PAY_DAY
                        message = "Teaches one Character Pay Day"
                        storeCost = 1000
                    }
                    17 -> {
                        moveLearned = Character.Move.SUBMISSION
                        message = "Teaches one Character Submission"
                        storeCost = 5000
                    }
                    18 -> {
                        moveLearned = Character.Move.COUNTER
                        message = "Teaches one Character Counter"
                        storeCost = 3500
                    }
                    19 -> {
                        moveLearned = Character.Move.SEISMIC_TOSS
                        message = "Teaches one Character Seismic Toss"
                        storeCost = 4000
                    }
                    20 -> {
                        moveLearned = Character.Move.RAGE
                        message = "Teaches one Character Rage"
                        storeCost = 2500
                    }
                    21 -> {
                        moveLearned = Character.Move.MEGA_DRAIN
                        message = "Teaches one Character Mega Drain"
                        storeCost = 4000
                    }
                    22 -> {
                        moveLearned = Character.Move.SOLARBEAM
                        message = "Teaches one Character Solarbeam"
                        storeCost = 5000
                    }
                    23 -> {
                        moveLearned = Character.Move.DRAGON_RAGE
                        message = "Teaches one Character Dragon Rage"
                        storeCost = 5000
                    }
                    24 -> {
                        moveLearned = Character.Move.THUNDERBOLT
                        message = "Teaches one Character Thunderbolt"
                        storeCost = 5000
                    }
                    25 -> {
                        moveLearned = Character.Move.THUNDER
                        message = "Teaches one Character Thunder"
                        storeCost = 5000
                    }
                    26 -> {
                        moveLearned = Character.Move.EARTHQUAKE
                        message = "Teaches one Character Earthquake"
                        storeCost = 10000
                    }
                    27 -> {
                        moveLearned = Character.Move.FISSURE
                        message = "Teaches one Character Fissure"
                        storeCost = 2500
                    }
                    28 -> {
                        moveLearned = Character.Move.DIG
                        message = "Teaches one Character Dig"
                        storeCost = 3000
                    }
                    29 -> {
                        moveLearned = Character.Move.PSYCHIC
                        message = "Teaches one Character Psychic"
                        storeCost = 5000
                    }
                    30 -> {
                        moveLearned = Character.Move.TELEPORT
                        message = "Teaches one Character Teleport"
                        storeCost = 500
                    }
                    31 -> {
                        moveLearned = Character.Move.MIMIC
                        message = "Teaches one Character Mimic"
                        storeCost = 5000
                    }
                    32 -> {
                        moveLearned = Character.Move.DOUBLE_TEAM
                        message = "Teaches one Character Double Team"
                        storeCost = 2000
                    }
                    33 -> {
                        moveLearned = Character.Move.REFLECT
                        message = "Teaches one Character Reflect"
                        storeCost = 2000
                    }
                    34 -> {
                        moveLearned = Character.Move.BIDE
                        message = "Teaches one Character Bide"
                        storeCost = 1500
                    }
                    35 -> {
                        moveLearned = Character.Move.METRONOME
                        message = "Teaches one Character Metronome"
                        storeCost = 7500
                    }
                    36 -> {
                        moveLearned = Character.Move.SELFDESTRUCT
                        message = "Teaches one Character Self Destruct"
                        storeCost = 2000
                    }
                    37 -> {
                        moveLearned = Character.Move.EGG_BOMB
                        message = "Teaches one Character Egg Bomb"
                        storeCost = 1500
                    }
                    38 -> {
                        moveLearned = Character.Move.FIRE_BLAST
                        message = "Teaches one Character Fire Blast"
                        storeCost = 5000
                    }
                    39 -> {
                        moveLearned = Character.Move.SWIFT
                        message = "Teaches one Character Swift"
                        storeCost = 3500
                    }
                    40 -> {
                        moveLearned = Character.Move.SKULL_BASH
                        message = "Teaches one Character Skull Bash"
                        storeCost = 2000
                    }
                    41 -> {
                        moveLearned = Character.Move.SOFTBOILED
                        message = "Teaches one Character Softboiled"
                        storeCost = 4000
                    }
                    42 -> {
                        moveLearned = Character.Move.DREAM_EATER
                        message = "Teaches one Character Dream Eater"
                        storeCost = 4000
                    }
                    43 -> {
                        moveLearned = Character.Move.SKY_ATTACK
                        message = "Teaches one Character Sky Attack"
                        storeCost = 3000
                    }
                    44 -> {
                        moveLearned = Character.Move.REST
                        message = "Teaches one Character Rest"
                        storeCost = 5000
                    }
                    45 -> {
                        moveLearned = Character.Move.THUNDER_WAVE
                        message = "Teaches one Character Thunder Wave"
                        storeCost = 4000
                    }
                    46 -> {
                        moveLearned = Character.Move.PSYWAVE
                        message = "Teaches one Character Psywave"
                        storeCost = 1500
                    }
                    47 -> {
                        moveLearned = Character.Move.EXPLOSION
                        message = "Teaches one Character Explosion"
                        storeCost = 5000
                    }
                    48 -> {
                        moveLearned = Character.Move.ROCK_SLIDE
                        message = "Teaches one Character Rock Slide"
                        storeCost = 5000
                    }
                    49 -> {
                        moveLearned = Character.Move.TRI_ATTACK
                        message = "Teaches one Character Tri Attack"
                        storeCost = 2500
                    }
                    50 -> {
                        moveLearned = Character.Move.SUBSTITUTE
                        message = "Teaches one Character Substitute"
                        storeCost = 10000
                    }
                }
            }
            Item.Type.HM -> {
                effect1 = Effect.HM
                effect2 = Effect.NONE
                reUsable = true
                storeCost = -1
                alphabet = 8
                pocket = Pocket.TMHM
                when (mNo) {
                    1 -> {
                        moveLearned = Character.Move.CUT
                        message = "Teaches one Character Cut"
                    }
                    2 -> {
                        moveLearned = Character.Move.FLY
                        message = "Teaches one Character Fly"
                    }
                    3 -> {
                        moveLearned = Character.Move.SURF
                        message = "Teaches one Character Surf"
                    }
                    4 -> {
                        moveLearned = Character.Move.STRENGTH
                        message = "Teaches one Character Strength"
                    }
                    5 -> {
                        moveLearned = Character.Move.FLASH
                        message = "Teaches one Character Flash"
                    }
                }
            }
        //Custom Made Items from here on down
            Item.Type.OMEGA_BALL -> {
                effect1 = Effect.POKEBALL
                power1 = 255
                effect2 = Effect.NONE
                storeCost = 99999999
                reUsable = true
                pocket = Pocket.POKEBALL
                message = "A perfect ball that can be reused"
                alphabet = 15
            }
            Item.Type.MOUNTAIN_DEW -> {
                effect1 = Effect.HP_HEAL
                power1 = 200
                effect2 = Effect.BATTLE_BOOST
                power2 = 100
                reUsable = false
                storeCost = 2000
                pocket = Pocket.MEDICINE
                message = "Heals 200HP and raises speed"
                alphabet = 13
            }
            Item.Type.BEER -> {
                effect1 = Effect.BATTLE_BOOST
                power1 = -100
                effect2 = Effect.NONE
                reUsable = false
                storeCost = 1
                pocket = Pocket.MEDICINE
                message = "Lowers accuracy"
                alphabet = 2
            }
            Item.Type.ROTTEN_APPLE -> {
                effect1 = Effect.HP_HEAL
                power1 = -2
                effect2 = Effect.NONE
                reUsable = true
                storeCost = 1
                pocket = Pocket.MEDICINE
                message = "Heals -2HP"
                alphabet = 18
            }
            Item.Type.ULTIMA_REPEL -> {
                effect1 = Effect.REPEL
                power1 = 250
                effect2 = Effect.NONE
                reUsable = true
                storeCost = 99999999
                pocket = Pocket.ITEM
                alphabet = 21
                message = "Repels for 250 steps. Reusable"
            }
            Item.Type.SILVER_NUGGET -> {
                effect1 = Effect.NONE
                effect2 = Effect.NONE
                storeCost = 100000
                reUsable = true
                pocket = Pocket.ITEM
                alphabet = 19
                message = "A valuable item"
            }
            Item.Type.REDBULL -> {
                effect1 = Effect.TM
                effect2 = Effect.NONE
                storeCost = 1000
                reUsable = true
                pocket = Pocket.TMHM
                alphabet = 18
                message = "So RedBull does give you wings."
                moveLearned = Character.Move.FLY
            }
            else -> {
            }
        }
        if (effect1 == Effect.KEY_ITEM)
            amount = 1
    }
    override fun toString():String {
        if (type != Type.TM && type != Type.HM)
            return "\n" + type.toString() + "\nAMOUNT: " + amount + "\n" + message + "\n" + pocket.toString() + "\n"
        else
            return "\n" + type.toString() + " " + mNo + "\nAMOUNT: " + amount + "\n" + message + "\n" + pocket.toString() + "\n"
    }
    fun getName():String {
        var returnString = type.toString()
        returnString = returnString.replace('_', ' ')
        if ((effect1 == Effect.TM || effect1 == Effect.HM) && type != Type.REDBULL)
        {
            returnString = returnString + " " + mNo
        }
        returnString = returnString + " x" + amount
        return returnString
    }
    fun getNameMoney(i:Int):String {
        var returnString = type.toString()
        returnString = returnString.replace('_', ' ')
        if (effect1 == Effect.TM || effect1 == Effect.HM)
        {
            returnString = returnString + " " + mNo
        }
        returnString = returnString + " $" + storeCost / 2
        return returnString
    }
    //Returns if item starts with a vowel
    fun startsWithVowel():Boolean {
        val c = this.type.toString().get(0)
        when (c) {
            'A', 'E', 'I', 'O', 'U' -> return true
            else -> return false
        }
    }
}