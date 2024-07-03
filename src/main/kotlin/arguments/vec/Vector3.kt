package io.github.myceliumlang.arguments.vec

import io.github.myceliumlang.Minecraftable
import io.github.myceliumlang.arguments.vec.param.ParamLocal
import io.github.myceliumlang.arguments.vec.param.ParamRelative
import io.github.myceliumlang.arguments.vec.param.VectorParam

class Vector3<T>(private val x: VectorParam<T>, private val y: VectorParam<T>, private val z: VectorParam<T>) : Minecraftable {
    companion object {
        fun <T> absolute(x: T): VectorParam<T> {
            return VectorParam(x)
        }

        fun <T> relative(x: T): ParamRelative<T> {
            return ParamRelative(x)
        }

        fun <T> local(x: T): ParamLocal<T> {
            return ParamLocal(x)
        }

        fun <T> absolute(x: T, y: T, z: T): Vector3<T> {
            return Vector3(VectorParam(x), VectorParam(y), VectorParam(z))
        }

        fun <T> relative(x: T, y: T, z: T): Vector3<T> {
            return Vector3(ParamRelative(x), ParamRelative(y), ParamRelative(z))
        }

        fun <T> local(x: T, y: T, z: T): Vector3<T> {
            return Vector3(ParamLocal(x), ParamLocal(y), ParamLocal(z))
        }
    }

    override fun toMinecraft(): String {
        return "${x.toMinecraft()} ${y.toMinecraft()} ${z.toMinecraft()}"
    }
}