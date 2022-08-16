package exception

import kotlin.Exception

class Testing {

    fun exceptionTrhow() {
        throw RuntimeException("hi")
    }
}

fun main() {
    try {
        Testing().exceptionTrhow()
    } catch (e : RuntimeException) {
        print("hi")
    }

    print("hi")
}
