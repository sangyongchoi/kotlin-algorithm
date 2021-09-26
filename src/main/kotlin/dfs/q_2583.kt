package dfs

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val infos = sc.nextLine().split(" ")
    val height = infos[0].toInt()
    val width = infos[1].toInt()
    val number = infos[2].toInt()

    val node = Array(height){ IntArray(width) }
    val visit = Array(height){ BooleanArray(width) }

    for (i in 0 until number) {
        val inputs = sc.nextLine().split(" ")
        val x1 = inputs[0].toInt()
        val x2 = inputs[2].toInt()
        val y1 = inputs[1].toInt()
        val y2 = inputs[3].toInt()

        for (x in x1 until x2) {
            for (y in y1 until y2) {
                val tempY = height - y -1
                node[tempY][x] = 1
            }
        }
    }

    var result = 0
    val results = mutableListOf<Int>()
    for (i in 0 until height) {
        for (j in 0 until width) {
            if (node[i][j] != 1 && !visit[i][j]) {
                result++
                val r = q_2583_dfs(i, j, width, height, node, visit)
                results.add(r)
            }
        }
    }

    println(result)
    results.sorted().forEach{ println(it) }
}

fun q_2583_dfs(i: Int, j: Int, width: Int, height: Int, node: Array<IntArray>, visit: Array<BooleanArray>): Int {
    if (i < 0 || j < 0 || i >= height || j >= width || node[i][j] == 1 || visit[i][j]) return 0
    visit[i][j] = true

    var count = 1
    count += q_2583_dfs(i+1, j, width, height, node, visit)
    count += q_2583_dfs(i-1, j, width, height, node, visit)
    count += q_2583_dfs(i, j+1, width, height, node, visit)
    count += q_2583_dfs(i, j-1, width, height, node, visit)
    return count
}
