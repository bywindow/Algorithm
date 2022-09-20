package Test

import kotlin.jvm.internal.Intrinsics.Kotlin

class TossExample {
    fun solution(assets: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val result = mutableListOf<String>()
        val code = listOf<String>("SP", "KE", "MO", "CO", "DE")
        assets.forEach {
            val cur = it.split("-")
            if (cur[0].toInt() < 13 || cur[0].toInt() > 22) {
                return@forEach
            }
            if (cur[0].toInt() == 13 || cur[1].substring(2,4).toInt() < 4) {
                return@forEach
            }
            if (cur[0].toInt() == 22 || cur[1].substring(2,4).toInt() > 8) {
                return@forEach
            }
            if (!code.contains(cur[1].substring(0,2))) {
                return@forEach
            }
            if (cur[1].substring(4).toInt() > 99) {
                return@forEach
            }
            if (result.contains(it)) {
                return@forEach
            }
            result.add(it)
        }
        val comparator: Comparator<String> = compareBy<String> {
            it.substring(0,2).toInt() }.thenBy {
            code.indexOf(it.substring(3,5)) }.thenBy {
            it.substring(5,7).toInt() }.thenBy {
            it.substring(7).toInt() }
        result.sortWith(comparator)
        answer = result.toTypedArray()
        return answer
    }

    fun solution(dateOfBirth: String, phoneNumber: String, inputs: Array<String>): Int {
        var answer: Int = 0
        return answer
    }
}

fun main() {
    val toss = TossExample()
    var requests: Array<String> = arrayOf("김토스,19900605")
//    println(toss.solution("20210701", requests))
}