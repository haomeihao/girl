package com.imooc.scala

/**
  * Created by hmh on 2017/8/3.
  */
class Outer {
	class Inner {
		private def f(): Unit = {
			println("f")
		}
		class InnerMost {
			f()
		}
		(new Inner).f()
	}
}