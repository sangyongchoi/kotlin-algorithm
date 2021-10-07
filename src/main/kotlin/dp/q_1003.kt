package dp

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val size = sc.nextInt()
    val node = IntArray(size)
    var max = 0

    for (i in 0 until size) {
        node[i] = sc.nextInt()
        max = max.coerceAtLeast(node[i])
    }

    if (max < 2) {
        for (i in 0 until size) {
            if (node[i] == 0) {
                println("1 0")
            } else if (node[i] == 1) {
                println("0 1")
            }
        }
    } else {
        val value = Array(max+1){ IntArray(2) }
        value[0][0] = 1
        value[0][1] = 0
        value[1][0] = 0
        value[1][1] = 1

        for (i in 2 .. max) {
            value[i][0] = value[i-2][0] + value[i-1][0]
            value[i][1] = value[i-2][1] + value[i-1][1]
        }

        for (i in 0 until size) {
            val tmp = node[i]
            val x = value[tmp][0]
            val y = value[tmp][1]

            println("$x $y")
        }
    }
}