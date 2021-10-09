package dp

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val number = sc.nextInt()

    if (number == 1) {
        println("1")
    } else if (number == 2) {
        println("2")
    } else {
        val array = IntArray(number + 1)
        array[1] = 1 % 10007
        array[2] = 2 % 10007

        for (i in 3..number) {
            array[i] = array[i-1] + array[i-2]
        }

        println(array[number])
    }
}