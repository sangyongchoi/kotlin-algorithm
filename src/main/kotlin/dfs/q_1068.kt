package dfs

private var result = 0
private var arr: Array<MutableList<Int>> = Array(0){ mutableListOf() }
private var visit: BooleanArray = BooleanArray(0)

fun main() {
    var root = 0
    val number = (readLine() ?: "0").toInt()
    arr = Array(number){ mutableListOf() }
    visit = BooleanArray(number)
    val inputs = (readLine() ?: "").split(" ")

    inputs.indices.forEach { index ->
        val parent = inputs[index].toInt()

        if (parent != -1) {
            arr[parent].add(index)
        } else {
            root = index
        }
    }
    val remove = (readLine() ?: "0").toInt()

    arr.forEach {
        it.removeIf{ i -> i == remove }
    }
    arr[remove].forEach{ arr[it] = mutableListOf() }
    arr[remove] = mutableListOf()

    solve(root)

    if (result == 0 && remove != root) {
        println(1)
    } else {
        println(result)
    }
}

private fun solve(number: Int) {
    if(visit[number]) return

    visit[number] = true
    val list = arr[number]

    list.forEach { i ->
        if (!visit[i]) {
            if (arr[i].size == 0) {
                result++
            } else {
                solve(i)
            }
        }
    }
}