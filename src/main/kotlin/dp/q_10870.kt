package dp

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val number = sc.nextInt()

    if (number == 0) {
        println("0")
    } else if (number == 1 || number == 2) {
        println("1")
    } else {
        val array = IntArray(number + 1)
        array[0] = 0
        array[1] = 1
        array[2] = 1

        for (i in 3..number) {
            array[i] = array[i-1] + array[i-2]
        }

        println(array[number])
    }
}