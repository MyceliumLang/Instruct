package io.github.myceliumlang.arguments.vec.param

class ParamRelative<T>(x: T) : VectorParam<T>(x) {
    override fun toMinecraft(): String {
        return "~$x"
    }
}