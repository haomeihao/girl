package com.imooc.scala

object HelloWorld {
	def main(args: Array[String]): Unit = {
		println("Hello\tworld!!!\n\n")
	}
}

final case class Symbol private(name: String) {
	override def toString: String = "`" + name
}