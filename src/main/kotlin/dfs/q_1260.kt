import java.util.*

fun main(args: Array<String>) {
    var visit: BooleanArray
    val sc = Scanner(System.`in`)
    val size: Int = sc.nextInt()
    val count: Int = sc.nextInt()
    val start: Int = sc.nextInt()
    visit = BooleanArray(size + 1)
    val node = Array(size + 1) { IntArray(size + 1) }
    for (i in 0 until count) {
        val a: Int = sc.nextInt()
        val b: Int = sc.nextInt()
        node[b][a] = 1
        node[a][b] = node[b][a]
    }
    dfs(node, start, size, visit)
    visit = BooleanArray(size + 1)
    println()
    bfs(node, start, size, visit)
}

fun dfs(node: Array<IntArray>, start: Int, size: Int, visit: BooleanArray) {
    visit[start] = true
    print("$start ")
    for (i in 1..size) {
        if (!visit[i] && node[start][i] == 1) {
            dfs(node, i, size, visit)
        }
    }
}

fun bfs(node: Array<IntArray>, start: Int, size: Int, visit: BooleanArray) {
    val queue: Queue<Int> = LinkedList()
    queue.offer(start)
    visit[start] = true
    print("$start ")
    while (!queue.isEmpty()) {
        val poll = queue.poll()
        for (i in 1..size) {
            if (!visit[i] && node[poll][i] == 1) {
                visit[i] = true
                queue.offer(i)
                print("$i ")
            }
        }
    }
}