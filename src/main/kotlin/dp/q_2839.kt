package dp

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val number = sc.nextInt()


    if (number == 4 || number == 7) {
        println(-1)
    } else if (number % 5 == 0) {
        println(number / 5)
    } else if (number % 5 == 1 || number % 5 == 3) {
        println(number / 5 + 1)
    } else if (number % 5 == 2 || number % 5 == 4) {
        println(number / 5 + 2)
    }
}