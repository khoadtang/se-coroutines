import kotlinx.coroutines.*

fun main() = runBlocking{// this: CoroutineScope

    println("Thread ${Thread.currentThread().name} is running for runBlocking")
    launch{
        println("[1]Thread [${Thread.currentThread().name}] is running ")
        delay(1000L)
        println("[2]Thread ${Thread.currentThread().name} is running ")
        println("World!")
    }

    launch{
        println("[3]Thread ${Thread.currentThread().name} is running ")
        delay(2000)
        println("[4]Thread ${Thread.currentThread().name} is running ")
    }

    println("Hello")
}

