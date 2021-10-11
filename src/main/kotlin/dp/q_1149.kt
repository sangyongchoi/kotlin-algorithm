package dp

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val size = sc.nextInt()
    val node = Array(size) { IntArray(3) }

    for (i in 0 until size) {
        node[i][0] = sc.nextInt()
        node[i][1] = sc.nextInt()
        node[i][2] = sc.nextInt()
    }

    for (i in 1 until size) {
        val temp = node[i - 1]
        node[i][0] = node[i][0] + temp[1].coerceAtMost(temp[2])
        node[i][1] = node[i][1] + temp[0].coerceAtMost(temp[2])
        node[i][2] = node[i][2] + temp[0].coerceAtMost(temp[1])
    }

    val temp = node[size - 1]
    var min = temp[0].coerceAtMost(temp[1])
    min = min.coerceAtMost(temp[2])

    println(min)
}