package dp

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val number = sc.nextInt()
    val node = IntArray(number + 2)

    if (number == 0 || number == 1) {
        println(0)
    } else if (number == 2 || number == 3) {
        println(1)
    } else {
        node[1] = 1
        node[2] = 1
        node[3] = 1

        for (i in 4 .. number) {
            var min = node[i-1]

            if (i % 2 == 0) {
                min = min.coerceAtMost(node[i / 2])
            }

            if (i % 3 == 0) {
                min = min.coerceAtMost(node[i/3])
            }

            node[i] = min + 1
        }

        println(node[number])
    }
}