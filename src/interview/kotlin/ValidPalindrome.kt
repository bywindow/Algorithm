package interview.kotlin

fun useList(s: String): Boolean {

    val strs: MutableList<Char> = mutableListOf()
    s.forEach {
        if (it.isLetterOrDigit()) {
            strs.add(it.lowercaseChar())
        }
    }
    while (strs.size > 1) {
        val left = strs[0]
        val right = strs.last()
        if (left != right) {
            return false
        }
        strs.removeFirst()
        strs.removeLast()
    }
    return true
}

//문자열 뒤집기
fun useReversed(s: String): Boolean {
    val str = s.lowercase().replace("[^a-z0-9]".toRegex(),"")
//    println(str)
    return str == str.reversed()
}

fun main() {
    val input: String = "A man, a plan, a canal: Panama"
    println(useList(input))
    println(useReversed(input))
}