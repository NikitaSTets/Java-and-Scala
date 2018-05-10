package Demo
import scala.collection.immutable.List
/**
  * Created by Никита on 20.04.2018.
  */
object Demo {
  def main(args: Array[String]) {
    val mainList = List(3, 2, 1,0,1,2,3,9);
    val list2=List('a','b','c','d')

    val list01=List[Int](0,1)
    val list23=List[Int](2,3)
    val list45=List[Int](4,5)
    val list67=List[Int](6,7)
    var array=Array(list01,list23,list45,list67)
    val list01234567=List[List[Int]](list01,list23,list45,list67)

    println("sum=",SumOfList(mainList));
    println("last=",GetLastElementOfList(mainList))
    println("last=",GetLastElementOfListFold(mainList))
    println("last=",GetLastElementOfListFold(list2))
    println("sum of matrix=",GetMatrixA3x3(list01234567))
    //GetLastElementOfList(List(List(0,1),List(2,3)),List(List(4,5),List(6,7)));

  }
 def SumOfList(list:List[Int]): Int =
  {
    var sum=(x:Int,y:Int)=>x+y
    var _res=0;
    for(a<-list)
    {
      _res=sum(_res,a)
    }
    _res
  }
  def GetLastElementOfList[A](list:List[A]): A =
  {
     list.last
  }
  def GetLastElementOfListFold[A](list:List[A]): A =
  {
    val list1=List[A]()
    val a=list.foldLeft(list1:List[A])
    {
      (z:List[A],i:A)=> z.::(i)
    }
    a(0)
  }
  def add(res: List[Int], x:List[Int]) = {
  //  SumOfList(res)+SumOfList(x)
    List[Int](SumOfList(res)+SumOfList(x))
  }
   def GetMatrixA3x3(list:List[List[Int]]): List[Int] =
  {

    list.reduceLeft(add)
  }


}

