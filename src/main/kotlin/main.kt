import com.google.common.util.concurrent.MoreExecutors
import com.google.common.util.concurrent.ThreadFactoryBuilder
import kotlinx.coroutines.*
import java.lang.Thread.sleep
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

/*
    This example don't block main thread, because of using thread pool
 */

fun main() {
    val coroutineContextDispatcher: CoroutineContext = Executors.newFixedThreadPool(
        20,
        ThreadFactoryBuilder().setNameFormat("thread-%s").build()
    )
        .asCoroutineDispatcher()
    val scope: CoroutineScope = CoroutineScope(coroutineContextDispatcher)
    println("Main Program starts: ${Thread.currentThread().name}")
    scope.launch(CoroutineName("Scope 1")){
        // coroutine is executed by multiple threads
        println("Scope 1 starts: ${Thread.currentThread().name}")
        delay(4000)
        // I delayed this coroutines for 4 seconds, but no any reuse thread (thread-2)
        // This coroutine is executed by new thread (thread-3)
        println("Scope 1 ends: ${Thread.currentThread().name}")
    }

    scope.launch(CoroutineName("Scope 2")) {
        // coroutine is executed by multiple threads
        println("Scope 2 starts: ${Thread.currentThread().name}")
        delay(1000)
        println("Scope 2 ends: ${Thread.currentThread().name}")
    }
    println("Main Program ends: ${Thread.currentThread().name}")


/*
    This implement runs only one thread
*/

//    println("Main Program starts: ${Thread.currentThread().name}")
//    val executorService = Executors.newFixedThreadPool(
//        20,
//        ThreadFactoryBuilder().setNameFormat("push-test-code-revert-%s").build()
//    )
//
//    executorService.execute{
//        println("Scope 1 starts: ${Thread.currentThread().name}")
//        sleep(4000)
//        println("Scope 1 ends: ${Thread.currentThread().name}")
//    }
//    executorService.execute{
//        println("Scope 2 starts: ${Thread.currentThread().name}")
//        sleep(1000)
//        println("Scope 2 ends: ${Thread.currentThread().name}")
//    }
//    println("Main Program ends: ${Thread.currentThread().name}")


}

