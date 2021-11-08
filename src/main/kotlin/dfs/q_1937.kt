package dfs

private var n = 0
private val dirs = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

fun main(args: Array<String>) {
    n = (readLine() ?: "").toInt()
    val node = Array(n) { IntArray(n) }
    val dp = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val input = (readLine() ?: "0 0 0 0").split(" ")

        for (j in 0 until n) {
            node[i][j] = input[j].toInt()
        }
    }
    var answer = 0

    for (i in 0 until n) {
        for (j in 0 until n) {
            answer = answer.coerceAtLeast(dfs(i, j, dp, node))
        }
    }

    println(answer)
}

private fun dfs(
    i: Int,
    j: Int,
    dp: Array<IntArray>,
    node: Array<IntArray>,
): Int {
    if (dp[i][j] != 0) {
        return dp[i][j]
    }

    dp[i][j] = 1

    for (dir in dirs) {
        val x = i + dir[0]
        val y = j + dir[1]

        if (x < 0 || x >= n || y < 0 || y >= n) {
            continue
        }

        if (node[i][j] < node[x][y]) {
            dp[i][j] = dp[i][j].coerceAtLeast(dfs(x, y, dp, node) + 1)
            dfs(x, y, dp, node)
        }
    }
    return dp[i][j]
}
