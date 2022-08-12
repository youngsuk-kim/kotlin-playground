package designpattern.proxy

class ProtectedProxyRider(var name: String): Rider {
    // 메소드 호출이 발생하기 전까지 실제 객체가 생성성되지 않는다 (메모리 이점)
    private var fullTimeRider: FullTimeRider? = null

    private fun getRider(name: String) = fullTimeRider ?: FullTimeRider(name)

    override fun delivery(): String {
        return getRider(name).delivery()
    }

    override fun getPersonalInfo(level: Int): String? {
        return if (level > 3) {
            getRider(name).getPersonalInfo(level)
        } else {
            println("접근 불가한 정보입니다")
            "접근 불가"
        }
    }
}
