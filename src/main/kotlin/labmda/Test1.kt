package labmda

fun main() {
    val items = listOf(1, 2, 3, 4, 5)

    //fold 는 초기값 (initial)에 iterable 객체 요소들을 순서대로 더하는 기능을 한다

    // Lambdas are code blocks enclosed in curly braces.
    val fold = items.fold(0) {
        // When a lambda has parameters, they go first, followed by '->'
            acc: Int, i: Int ->
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in a lambda is considered the return value:
        result
    }

    val joinedToString = items.fold("Elements:", {
        acc, i ->
        println("==")
        println(acc)
        println("==")
        acc + " " + i
    })

    print(joinedToString)
}
