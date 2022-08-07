package bestpractice

class BasicDataSource {
    var name: String? = null
    var url: String? = null
    var username: String? = null
    var password: String? = null
}


fun main() {

    /**
     * The extension function apply() helps to group and centralize initialization code for an object.
     * Besides, we don’t have to repeat the variable name over and over again.
     */

    //Don't
    val dataSource = BasicDataSource()
    dataSource.name = "User 1"
    dataSource.url = "www.xyz.com"
    dataSource.username = "username"
    dataSource.password = "password"

    //Do
    val dataSource2 = BasicDataSource().apply {
        name = "User 1"
        url = "www.xyz.com"
        username = "username"
        password = "password"
    }
}


