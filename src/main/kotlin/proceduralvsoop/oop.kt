package proceduralvsoop

fun main() {
    val customer = Customer(changes = 1000)
    val vm = VendingMachine(10, 3)

    val wantJuice = "Orange juice"

    // 잔금
    val balance = vm.calculate(wantJuice, customer.changes)

    customer.resetMyPocket(balance, wantJuice)

    println(customer)
}

class Customer(
    var changes: Int,
    var hasJuice: String? = null
) {

    // 주머니에 있는 값들을 수정
    fun resetMyPocket(balance: Int, wantJuice: String) {
        if (balance == 0) {
            this.resettingValues(balance, null)
        }
        else {
            this.resettingValues(balance, wantJuice)
        }
    }

    private fun resettingValues(changes: Int, hasJuice: String?) {
        this.changes -= changes
        this.hasJuice = hasJuice
    }

    override fun toString(): String {
        return "잔액 : $changes, 갖고 있는 음료 : $hasJuice"
    }
}

class VendingMachine(
    private var orangeJuice: Int,
    private var appleJuice: Int
) {
    // 오렌지주스 판매가 가능한지 검사
    private fun orangePossible(pay: Int): Boolean {
        if (orangeJuice > 0) {
            if (pay >= 500) {
                return true
            }
        }
        return false
    }

    // 사과주스 판매가 가능한지 검사
    private fun applePossible(pay: Int): Boolean {
        if (appleJuice > 0) {
            if (pay >= 300) {
                return true
            }
        }
        return false
    }

    fun calculate(kind: String, pay: Int): Int {
        if (kind == "Orange juice") {
            if (orangePossible(pay)) {
                orangeJuice--
                println("오렌지 주스가 정상적으로 구매되었습니다")
                return 500
            }
            println("오렌지 주스를 구매하실 수 없습니다")
            return 0
        } else if (kind == "Apple juice") {
            if (applePossible(pay)) {
                appleJuice--
                println("사과 주스가 정상적으로 구매되었습니다")
                return 300
            }
            println("사과 주스를 구매하실 수 없습니다")
            return 0
        }
        println("없는 물품입니다")
        return 0
    }
}
