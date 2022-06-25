package com.ding.kotlin.demo.base
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//fun main() {
//	GlobalScope.launch { // 在后台启动一个新的协程并继续
//		delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
//		println("World!") // 在延迟后打印输出
//	}
//	println("Hello,") // 协程已在等待时主线程还在继续
//	Thread.sleep(2000L) // 阻塞主线程 2 秒钟来保证 JVM 存活
//}

//fun main() {
//	GlobalScope.launch { // 在后台启动一个新的协程并继续
//		delay(1000L) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
//		println("World!") // 在延迟后打印输出
//	}
//	runBlocking {
//		println("Hello,") // 阻塞当前线程，内部协程执行完
//		Thread.sleep(2000L)
//	}
//	//最后打印
//	println("Main Thread")
//}
//fun main(){
//	val job = GlobalScope.launch { // 启动一个新协程并保持对这个作业的引用
//		delay(1000)
//		for(i in 1..10){
//			println(i)
//		}
//		println("World!")
//	}
//	runBlocking {
//		println("Hello,")
//		job.join() //job 开始执行，加入谁，谁就开始执行
//		println("Last Message")
//	}
//}
//lanuch 就会立马执行，scope内协程是顺序执行
//fun main() = runBlocking { // this: CoroutineScope
//	launch {
//		delay(200L)
//		println("Task from runBlocking")
//	}
//
//	coroutineScope { // 创建一个协程作用域
//		launch {
//			delay(5000L)
//			println("Task from nested launch")
//		}
//
//		delay(100L)
//		println("Task from coroutine scope") // 这一行会在内嵌 launch 之前输出
//	}
//
//	println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
//}

fun main() = runBlocking { // this: CoroutineScope
	launch {
		test()
	}
	println("Coroutine scope is over") // 这一行在内嵌 launch 执行完毕后才输出
}
suspend fun test() {
		delay(1000)
        println("Do something long")
}