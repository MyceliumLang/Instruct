package com.mycelium.target

class TargetSelector {
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

    fun toScoreHolder(): String {
        if(individual) return "*"
        if(player != null) return player!!
        if(selector != null) return selector!!.toMinecraft()
        return "*"
    }
}