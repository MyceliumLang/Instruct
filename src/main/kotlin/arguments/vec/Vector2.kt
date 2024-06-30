package com.mycelium.arguments.vec

import com.mycelium.Minecraftable
import com.mycelium.arguments.vec.param.ParamLocal
import com.mycelium.arguments.vec.param.ParamRelative
import com.mycelium.arguments.vec.param.VectorParam

class Vector2<T>(private val x: VectorParam<T>, private val y: VectorParam<T>) : Minecraftable {
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

        fun <T> absolute(x: T, y: T): Vector2<T> {
            return Vector2(VectorParam(x), VectorParam(y))
        }

        fun <T> relative(x: T, y: T): Vector2<T> {
            return Vector2(ParamRelative(x), ParamRelative(y))
        }

        fun <T> local(x: T, y: T): Vector2<T> {
            return Vector2(ParamLocal(x), ParamLocal(y))
        }
    }

    override fun toMinecraft(): String {
        return "${x.toMinecraft()} ${y.toMinecraft()}"
    }
}