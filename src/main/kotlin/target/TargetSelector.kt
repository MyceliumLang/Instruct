package io.github.myceliumlang.target

import io.github.myceliumlang.Minecraftable

open class TargetSelector : Minecraftable {
    private var selector: Selector? = null
    private var player: String? = null
    private var individual: Boolean = false

    constructor(holder: Selector) {
        this.selector = holder
    }

    constructor(holder: String) {
        this.player = holder
    }

    constructor() {
        individual = true
    }

    override fun toMinecraft(): String {
        if(individual) return "*"
        if(player != null) return player!!
        if(selector != null) return selector!!.toMinecraft()
        return Selector(Selector.Type.AllPlayers).toMinecraft()
    }
}