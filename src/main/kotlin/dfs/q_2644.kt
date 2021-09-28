package dfs

import java.util.*

private var find: Boolean = false

fun main() {
    val sc = Scanner(System.`in`)
    val size = sc.nextLine().toInt()
    val input = sc.nextLine().split(" ")
    val source = input[0].toInt() - 1
    val destination = input[1].toInt() - 1
    val number = sc.nextLine().toInt()
    val node = Array(size){ IntArray(size) }
    val visit = Array(size){ BooleanArray(size) }

    for (i in 0 until number) {
        val inputs = sc.nextLine().split(" ")
        val x = inputs[0].toInt() - 1
        val y = inputs[1].toInt() - 1

        node[x][y] = 1
        node[y][x] = 1
    }

    val result = q_2644_dfs(source, destination, size, node, visit, 0)
    println(result)
}

private fun q_2644_dfs(i: Int, destination: Int, size: Int, node: Array<IntArray>, visit: Array<BooleanArray>, count: Int): Int {
    for (k in 0 until size) {
        if (node[i][k] == 1 && k == destination) {
            find = true
            return count+1
        } else if (node[i][k] == 1 && !visit[i][k]) {
            visit[i][k] = true;
            visit[k][i] = true;

            val result = q_2644_dfs(k, destination, size, node, visit, count+1)
            if(find){
                return result;
            }
        }
    }

    return -1
}