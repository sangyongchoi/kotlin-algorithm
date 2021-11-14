package dfs

private lateinit var nodes: Array<MutableList<Node>>
private var diameter: Int = 0
private var max: Int = 0
private var maxIndex: Int = 0
private var visit: BooleanArray = BooleanArray(0)

fun main() {
    diameter = (readLine() ?: "0").toInt()
    nodes = Array(diameter) { mutableListOf() }
    visit = BooleanArray(diameter)

    repeat(diameter - 1) {
        val inputs = (readLine() ?: "0 0 0").split(" ")
        val parent = inputs[0].toInt() - 1
        val child = inputs[1].toInt() - 1
        val value = inputs[2].toInt()

        nodes[parent].add(Node(child, value))
        nodes[child].add(Node(parent, value))
    }

    visit[0] = true
    dfs(0, 0)

    visit = BooleanArray(diameter)
    visit[maxIndex] = true
    dfs(maxIndex, 0)

    println(max)
}

private fun dfs(index: Int, sum: Int) {
    if (max < sum) {
        max = sum
        maxIndex = index
    }

    for (node in nodes[index]) {
        if (!visit[node.index]) {
            visit[node.index] = true
            dfs(node.index, sum + node.value)
        }
    }
}

data class Node(
    val index: Int,
    val value: Int,
)
