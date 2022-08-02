import kotlinx.coroutines.*

//fun main() = runBlocking{// this: CoroutineScope
//
//    println("Thread ${Thread.currentThread().name} is running for runBlocking")
//    launch {
//        println("[1]Thread [${Thread.currentThread().name}] is running ")
//        delay(1000L)
//        println("[2]Thread ${Thread.currentThread().name} is running ")
//        println("World!")
//    }
//
//    launch{
//        println("[3]Thread ${Thread.currentThread().name} is running ")
//        delay(2000)
//        println("[4]Thread ${Thread.currentThread().name} is running ")
//    }
////    delay(4000)
//
//    println("Hello")
//}


fun main() {
    println("Main Program starts: ${Thread.currentThread().name}")


    runBlocking {

        launch(Dispatchers.Unconfined) {
            println("[Unconfined] coroutine starts: ${Thread.currentThread().name}")
            delay(5000)
            // After delaying, this coroutine is executed in background thread instead of main thread.
            println("[Unconfined] coroutine ends: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("[IO] coroutine starts: ${Thread.currentThread().name}")
            delay(5000)
            // After delaying, this coroutine is executed in background thread instead of main thread.
            println("[IO] coroutine ends: ${Thread.currentThread().name}")
        }

        println("[RunBlocking] coroutine scope starts: ${Thread.currentThread().name}")
        delay(2000)
        println("[RunBlocking] coroutine scope ends: ${Thread.currentThread().name}")
    }


    println("Main Program ends: ${Thread.currentThread().name}")
}

