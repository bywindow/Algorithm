package Test

class TossExample2 {
    var name: String? = null

    fun doSomething() {
        if (name != null) {
//            print(name.length) // 컴파일 오류 발생
        }
    }
}

fun main() {
    println()
}

//import java.util.concurrent.Executors
//import java.util.concurrent.locks.ReentrantLock
//import kotlin.concurrent.withLock
//
//var sum = 0
//
//val lock = ReentrantLock()
//val executorService = Executors.newCachedThreadPool()
//fun main() {
//    for (i in 0..100) {
//        lock.withLock {
//            executorService.submit {
//                sum += i
//            }
//        }
//    }
//}
