package com.mycelium

enum class EntityType(name: String) : Minecraftable {
    Player("player"),
    ArmorStand("armor_stand"),
    Arrow("arrow"),
    SpectralArrow("spectral_arrow"),
    BlockDisplay("block_display"),
    Boat("boat"),
    BoatwithChest("chest_boat"),
    Egg("egg"),
    EndCrystal("end_crystal"),
    EnderPearl("ender_pearl"),
    EvokerFangs("evoker_fangs"),
    EyeofEnder("eye_of_ender"),
    ExperienceOrb("experience_orb"),
    FallingBlock("falling_block"),
    FishingBobber("fishing_bobber"),
    Fireball("fireball"),
    SmallFireball("small_fireball"),
    WitherSkull("wither_skull"),
    DragonFireball("dragon_fireball"),
    FireworkRocket("fireworks_rocket"),
    Interaction("interaction"),
    Item("item"),
    ItemDisplay("item_display"),
    ItemFrame("item_frame"),
    GlowItemFrame("glow_item_frame"),
    LightningBolt("lightning_bolt"),
    LeashKnot("leash_knot"),
    LlamaSpit("llama_spit"),
    Marker("marker"),

    Minecart("minecart"),
    MinecartwithChest("chest_minecart"),
    MinecartwithCommandBlock("command_block_minecart"),
    MinecartwithFurnace("furnace_minecart"),
    MinecartwithHopper("hopper_minecart"),
    MinecartwithMonsterSpawner("spawner_minecart"),
    MinecartwithTNT("tnt_minecart"),
    Painting("painting"),
    PrimedTNT("tnt"),
    TextDisplay("text_display"),
    ShulkerBullet("shulker_bullet"),
    Snowball("snowball"),
    Trident("trident"),
    WindCharge("wind_charge"),
    BreezeWindCharge("breeze_wind_charge");

    override fun toMinecraft(): String {
        return name
    }
}