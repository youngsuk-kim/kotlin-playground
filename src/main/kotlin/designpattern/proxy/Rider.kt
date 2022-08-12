package designpattern.proxy

interface Rider {
    fun delivery(): String
    fun getPersonalInfo(level: Int): String?
}
