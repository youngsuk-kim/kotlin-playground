package designpattern.statepattern

interface DeliveryStatus {
    val name: String
    fun forward(delivery: Delivery): String
    fun backward(delivery: Delivery): String
}

object Wait: DeliveryStatus {
    override val name: String = "배차 대기"

    // 배차대기의 다음 상태는 배차완료 이므로 배차완료 상태로 변경한다.
    override fun forward(delivery: Delivery): String {
        delivery.status = Assign // 해당 배달을 매개변수로 넘겨 받아 상태를 변경시킨다.
        return delivery.status.name
    }

    override fun backward(delivery: Delivery): String {
        return "뒤로 불가"
    }
}

object Assign: DeliveryStatus {
    override val name: String = "배차 완료"

    override fun forward(delivery: Delivery): String {
        delivery.status = PickUp
        return delivery.status.name
    }

    override fun backward(delivery: Delivery): String {
        delivery.status = Wait
        return delivery.status.name
    }
}

object PickUp: DeliveryStatus {
    override val name: String = "픽업 완료"

    override fun forward(delivery: Delivery): String {
        delivery.status = Complete
        return delivery.status.name
    }

    override fun backward(delivery: Delivery): String {
        delivery.status = Assign
        return delivery.status.name
    }
}

object Complete: DeliveryStatus {
    override val name: String = "전달 완료"

    // 전달 완료는 다음 상태가 없기 때문에 진행불가
    override fun forward(delivery: Delivery): String {
        return "진행 불가"
    }

    override fun backward(delivery: Delivery): String {
        delivery.status = PickUp
        return delivery.status.name
    }
}
