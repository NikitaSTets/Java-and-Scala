package test.scala
import org.scalatest.{FlatSpec, _}

import scala.collection.mutable.Stack


class ExampleSpec extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val stack =  Stack[Int]()
    stack.push(1)
    stack.push(2)
    stack.pop() should be (2)
    stack.pop() should be (1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = Stack[Int]()
    a [NoSuchElementException] should be thrownBy {
      emptyStack.pop()
    }
  }
}