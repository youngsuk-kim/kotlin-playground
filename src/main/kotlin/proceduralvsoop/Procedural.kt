package proceduralvsoop

var orangeJuice = 10
var appleJuice = 20

fun main() {

    var customerChanges = 1000
    var customerHas: String? = null

    val wantJuice = "Orange juice"

    if (wantJuice == "Orange juice") {
        if(orangePossible(customerChanges)) {
            val changes = pullOutAppleJuice()
            println("오렌지 주스가 성공적으로 구매되었습니다")
            customerHas = wantJuice
            customerChanges -= changes
        }
        else {
            println("오렌지 주스를 구매하실 수 없습니다")
        }
    }

    else if (wantJuice == "Apple juice") {
        if(applePossible(customerChanges)) {
            val changes = pullOutAppleJuice()
            println("사과 주스가 성공적으로 구매되었습니다")
            customerHas = wantJuice
            customerChanges -= changes
        }
        else {
            println("사과 주스를 구매하실 수 없습니다")
        }
    }

    else {
        println("없는 물품입니다")
    }

    println("잔액 : $customerChanges, 갖고 있는 음료: $customerHas")
}

fun orangePossible(pay: Int): Boolean {
    if (orangeJuice > 0) {
        if (pay >= 500) {
            return true
        }
    }
    return false
}

// 오렌지 주스 꺼내기
fun pullOutOrangeJuice(): Int {
    orangeJuice--
    return 500
}

// 사과주스 구매 가능?
fun applePossible(pay: Int): Boolean {
    if (appleJuice > 0) {
        if (pay >= 300) {
            return true
        }
    }
    return false
}

// 사과주스 꺼내기
fun pullOutAppleJuice(): Int {
    appleJuice--
    return 300
}
