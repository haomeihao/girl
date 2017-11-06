package com.imooc.scala

/**
  * Created by hmh on 2017/8/3.
  */
object ScalaTest {
	def main(args: Array[String]): Unit = {
		var a = 10
		var b = 20
		var c = 10
		println("a + b = " + (a + b))
		println("b - a = " + (b - a))
		println("a * b = " + (a * b))
		println("b / a = " + (b / a))
		println("b % a = " + (b % a))
		println("c % a = " + (c % a))
		
		if (c < 20) {
			println("c < 20")
		} else if (c > 30){
			println("c > 30")
		} else {
			println("20 <= c <= 30")
		}
	}
}
