package io.github.myceliumlang.arguments

class Swizzle(private vararg val letters: Char) {
    companion object {
        val xyz: Swizzle = Swizzle('x', 'y', 'z')
    }

    fun verify(text: String): Boolean {
        val contains: MutableList<Char> = mutableListOf()

        for(char in text) {
            if(!letters.contains(char)) throw RuntimeException("Character '$char' cannot be present in this swizzle.")
            if(contains.contains(char)) throw RuntimeException("Only one character '$char' can be present in a swizzle.")
            contains.add(char)
        }

        return true
    }
}