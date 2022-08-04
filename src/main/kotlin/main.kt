import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Main Program starts: ${Thread.currentThread().name}")
    launch(Dispatchers.IO) {
        println("[IO-1] coroutine starts: ${Thread.currentThread().name}")
        blockingThread()
        // After delaying, this coroutine is executed in background thread instead of main thread.
        println("[IO-1] coroutine ends: ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("[IO-2] coroutine starts: ${Thread.currentThread().name}")
        blockingThread()
        // After delaying, this coroutine is executed in background thread instead of main thread.
        println("[IO-2] coroutine ends: ${Thread.currentThread().name}")
    }
    println("Main Program ends: ${Thread.currentThread().name}")
    blockingThread()

}


 fun blockingThread() {
//    println("-----BLOCKING: ${Thread.currentThread().name}")
    Thread.sleep(2000)
}


