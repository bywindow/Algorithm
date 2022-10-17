package interview.kotlin

fun solution(paragraph: String, banned: List<String>): String {
    val word_list = paragraph.lowercase().replace("[^\\w]".toRegex(), " ").split(" ").toTypedArray()
//    println(word_list)
    val counter = mutableMapOf<String, Int>()
    word_list.forEach {
        if (it.isNotBlank() && !banned.contains(it)) {
            counter[it] = counter.getOrDefault(it, 0) + 1
        }
    }

    return counter.maxBy { it.value }.key
}

fun main() {
    val paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
    val banned = listOf<String>("hit")
    print(solution(paragraph, banned))
}