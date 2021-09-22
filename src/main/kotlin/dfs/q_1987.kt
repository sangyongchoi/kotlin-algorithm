package dfs

import java.util.*
import kotlin.collections.HashMap

private var result = 0
private var dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

fun main() {
    val sc = Scanner(System.`in`)
    val inputs = sc.nextLine().split(" ")
    val row = inputs[0].toInt()
    val col = inputs[1].toInt()
    val node = Array(row){ arrayOfNulls<String>(col) }
    val map = hashMapOf<String?, Boolean>()

    for (i in 0 until row) {
        val lines = sc.nextLine().split("").filter { it != "" }
        for (j in 0 until col) {
            node[i][j] = lines[j]
        }
    }

    dfs(0, 0, 0, row, col, node, map)
    println(result)
}

private fun dfs(i: Int, j: Int, count: Int, row: Int, col: Int, node: Array<Array<String?>>, visit: HashMap<String?, Boolean>) {
    if (visit[node[i][j]] != null) {
        result = result.coerceAtLeast(count)
        return
    }
    visit[node[i][j]] = true
    for (dir in dirs) {
        val a = i + dir[0]
        val b = j + dir[1]
        if (a >= 0 && a < row && b >= 0 && b < col) {
            dfs(a, b, count + 1, row, col, node, visit)
        }
    }
    visit.remove(node[i][j])
}