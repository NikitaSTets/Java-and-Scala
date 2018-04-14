package main.scala
import scala.annotation.tailrec
import scala.collection.mutable.Stack
import scala.collection.mutable.ArrayBuffer
import scala.util.Sorting
object Hello {

  def main(args: Array[String]) = {
    val stack = Stack[Int](0, 1, 2, 3, 4, 5, 6, 7)
    val array=Array[Int](1000,2,3,4,5)
    val array1=ArrayBuffer[Int](1000,2,3,4,5)
    println("GetSecondFromStack=", GetSecondFromStack(stack))
    println("GetSecondFromStackRecursive", GetSecondFromStackRecursive(stack))
    println("GetMin=",GetMin(array))
    println("GetMax=",GetMax(array))
    println("GetMinRecursive=",GetMinRecursive(array1,array1(0)))
    println("GetMaxRecursive=",GetMaxRecursive(array1,array1(0)))


  }

  def GetSecondFromStack(stack: Stack[Int]): Int = {
    val stack2=stack.clone()
    val size = stack2.length
    for (i <- 0 to size - 3) {
     stack2.pop()
    }
    if (stack2.length > 1) {
    stack2.pop()
    }
    else
      -1
  }

  @tailrec
  def GetSecondFromStackRecursive(stack: Stack[Int]): Int = {
    val stack2=stack.clone()
    if (stack2.length < 2)
      -1
    else if (stack2.length > 2) {
      stack2.pop()
      GetSecondFromStackRecursive(stack2)
    }
    else
      stack2.pop()
  }

  def GetMaxAndMinValueInArray(array: Array[Int]): ArrayBuffer[Int] = {
    if (array.length <= 2)
      array

    val array2=array.clone()
     Sorting.stableSort(array2)

    val min: Int = array2(0)
    val max: Int = array2(array2.length-1)

    ArrayBuffer[Int](min,max)
   // result
  }
  /*def GetMaxAndMinValueInArrayRecursive(array: Array[Int],min:Int,max:Int):ArrayBuffer[Int]=
  {
    if(array(array.length-1)<min)
      {
       // min=array(array.length-1)
      }
  }*/
  @tailrec
  def GetMinRecursive(array: ArrayBuffer[Int],min:Int): Int = {
    val array2=array.clone()
    var min1 =array2(array2.length-1)

    if(min1>min)
      min1=min

    if(array2.length>2) {
      array2.remove(array.length - 1)
      GetMinRecursive(array2,min1)
    }
    else
   min1
  }
  @tailrec
  def GetMaxRecursive(array: ArrayBuffer[Int],max:Int): Int = {
    val array2=array.clone()
    var max1 =array2(array2.length-1)

    if(max1<max)
      max1=max

    if(array2.length>2) {
      array2.remove(array.length - 1)
      GetMaxRecursive(array2,max1)
    }
    else
    max1
  }
  def GetMin(array: Array[Int]): Int = {
    val array2=array.clone()
    Sorting.stableSort(array2)
    if(array2.length>0)
      array2(0)
    else
      -1
  }

  def GetMax(array: Array[Int]): Int = {
    val array2=array.clone()
    Sorting.stableSort(array2)
    if(array2.length-1>0)
    array2(array2.length-1)
    else
      -1
  }
}