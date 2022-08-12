package designpattern.proxy

class FullTimeRider(var name: String): Rider {
    override fun delivery(): String {
        println("음식 배달")
        return "음식 배달"
    }

    override fun getPersonalInfo(level: Int): String? {
        println("$name 배달원 입니다")
        return name
    }
}
