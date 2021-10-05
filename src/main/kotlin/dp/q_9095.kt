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

    if (max < 4) {
        for (i in 0 until size) {
            when (node[i]) {
                0 -> println("0")
                1 -> println("1")
                2 -> println("2")
                3 -> println("4")
            }
        }
    } else {
        val node1 = IntArray(max + 1)
        node1[0] = 0
        node1[1] = 1
        node1[2] = 2
        node1[3] = 4

        for(i in 4 .. max) {
            node1[i] = node1[i-1] + node1[i-2] + node1[i-3]
        }

        for (i in 0 until size) {
            println(node1[node[i]])
        }
    }
}