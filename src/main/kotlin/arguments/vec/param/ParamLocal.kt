package io.github.myceliumlang.arguments.vec.param

class ParamLocal<T>(x: T) : VectorParam<T>(x) {
    override fun toMinecraft(): String {
        return "^$x"
    }
}