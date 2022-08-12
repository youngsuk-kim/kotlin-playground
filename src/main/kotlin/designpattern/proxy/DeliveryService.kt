package designpattern.proxy

class DeliveryService(private val rider: Rider) {
    fun delivery() = rider.delivery()
    fun getRiderInfo() = rider.getPersonalInfo(1)
}

fun main() {
    val deliveryService = DeliveryService(ProtectedProxyRider("라이더"))
    deliveryService.delivery()
    deliveryService.getRiderInfo()
}
