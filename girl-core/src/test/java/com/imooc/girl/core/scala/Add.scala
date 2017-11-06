package com.imooc.scala

import java.util.Date

/**
  * Created by hmh on 2017/8/3.
  */
object Add {
	def main(args: Array[String]): Unit = {
		addInt()
		delayed(time())
		printStrings("Runoob", "Scala", "Python")
		
		println(factorial(0))
		println(factorial(1))
		println(factorial(2))
		println(factorial(3))
		
		val date = new Date
//		log(date, "message1")
//		Thread.sleep(1000)
//		log(date, "message2")
//		Thread.sleep(1000)
//		log(date, "message3")
		
		val logWithDateBound = log(date, _ : String)
		logWithDateBound("message1" )
		Thread.sleep(1000)
		logWithDateBound("message2" )
		Thread.sleep(1000)
		logWithDateBound("message3" )
	}
	
	def addInt(a: Int = 5, b: Int = 7): Int = {
		var sum: Int = 0
		sum = a + b
		println("a + b = " + sum)
		return sum
	}
	
	def time() = {
		println("获取时间，单位为纳秒")
		System.nanoTime
	}
	
	def delayed(t: => Long) = {
		println("在 delayed 方法内")
		println("参数： " + t)
		t
	}
	
	def printStrings(args: String*) = {
		var i: Int = 0
		for (arg <- args) {
			println("Arg value[" + i + "] = " + arg)
			i = i + 1
		}
	}
	
	def factorial(i: Int): Int = {
		def fact(i: Int, accumulator: Int): Int = {
			if (i <= 1)
				accumulator
			else
				fact(i - 1, i * accumulator)
		}
		
		fact(i, 1)
	}
	
	def log(date: Date, message: String) = {
		println(date + "----" + message)
	}
}
