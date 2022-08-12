package designpattern.proxy

class ProxyRider(var name: String): Rider {

    private var fullTimeRider: FullTimeRider? = null

    override fun delivery(): String {
        return (fullTimeRider ?: FullTimeRider(name)).delivery()
    }

    override fun getPersonalInfo(level: Int): String {
        println("${level}레벨 $name 라이더 입니다")
        return name
    }
}
