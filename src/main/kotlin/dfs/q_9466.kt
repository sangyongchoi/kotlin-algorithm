package dfs

private var answer: Int = 0
private var arr: IntArray = IntArray(0)
private var visit: BooleanArray = BooleanArray(0)
private var check: BooleanArray = BooleanArray(0)

fun main() {
    val num = (readLine() ?: "0").toInt()

    repeat(num) {
        val peopleNumber = (readLine() ?: "0").toInt()
        val inputs = (readLine() ?: "0").split(" ")
        arr = IntArray(peopleNumber + 1)
        visit = BooleanArray(peopleNumber + 1)
        check = BooleanArray(peopleNumber + 1)
        answer = 0

        (1..peopleNumber).forEach { i ->
            arr[i] = inputs[i - 1].toInt()
        }

        (1..peopleNumber).forEach { i ->
            if (!visit[i]) {
                solve(i)
            }
        }

        println(peopleNumber - answer)
    }
}

private fun solve(num: Int) {
    visit[num] = true
    val next = arr[num]

    if (!visit[next]) {
        solve(next)
    } else if (!check[next]) {
        var i = next
        while (i != num) {
            answer++
            i = arr[i]
        }
        answer++
    }

    check[num] = true
}