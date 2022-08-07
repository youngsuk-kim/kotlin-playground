package designpattern.statepattern

/**
상태 패턴 미적용 시

if (상태 == 대기) {
상태 = 배차완료
} else if (상태 == 배차완료) {
상태 = 배차완료
} else if (상태 == 배달완료) {
println("다음 상태 없음")
}

문제점
1. 알아보기 힘들다
2. 로직이 많아진다면 기능을 추가 수정 삭제하기 어렵다
3. 테스트 하기 어렵다
 */
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
