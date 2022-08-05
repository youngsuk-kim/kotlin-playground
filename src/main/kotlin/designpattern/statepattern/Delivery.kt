package designpattern.statepattern

class Delivery {
    var status: DeliveryStatus = Wait

    fun forwardStatus() = status.forward(this)

    fun backwardStatus() = status.forward(this)
}

fun main() {
    val delivery = Delivery()

    // 배차 완료
    println(delivery.forwardStatus())

    // 픽업 완료
    println(delivery.forwardStatus())

    // 전달 완료
    println(delivery.backwardStatus())
}
