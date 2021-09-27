package dfs

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val size = sc.nextLine().toInt()
    val node = mutableListOf<MutableList<Int>>()
    val map = mutableMapOf<Int, Int>()

    for (i in 0 until size) {
        node.add(mutableListOf())
    }

    for (i in 0 until size - 1) {
        val inputs = sc.nextLine().split(" ")
        val x = inputs[0].toInt() - 1
        val y = inputs[1].toInt() - 1

        node[x].add(y)
        node[y].add(x)
    }

    q_11725_dfs(0, -1, node, map)

    map
        .toSortedMap()
        .forEach{ println(it.value) }
}

private fun q_11725_dfs(i: Int, parent: Int, node: MutableList<MutableList<Int>>, map: MutableMap<Int, Int>) {
    for (tmp in node[i]) {
        if (tmp != parent) {
            map[tmp+1] = i+1
            q_11725_dfs(tmp, i, node, map)
        }
    }
}
