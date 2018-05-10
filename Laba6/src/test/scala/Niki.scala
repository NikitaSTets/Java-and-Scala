import collection.mutable.Stack
import scala.collection.immutable.List
import org.scalatest._

class  Niki extends  FlatSpec {
  "A List sum" should "be equal 21" in {
    val mainList = List(3, 2, 1,0,1,2,3,9);
    var a=Demo.Demo.SumOfList(mainList)
    assert(a==21)
  }

  it should "be equal 22" in {
    val mainList = List(3, 2, 1,0,1,2,3,9,1);
    var a=Demo.Demo.SumOfList(mainList)
    assert(a==22)
  }
  "A List last element " should "be equal 9" in {
    val mainList = List(3, 2, 1,0,1,2,3,9);
    var a=Demo.Demo.GetLastElementOfListFold(mainList)
    assert(a==9)
  }
  it should "be equal b" in {
    val mainList = List('a','b');
    var a=Demo.Demo.GetLastElementOfListFold(mainList)
    assert(a=='b')
  }
  "A List sumOfMatrix " should "be equal 28" in {
    val list01=List[Int](0,1)
    val list23=List[Int](2,3)
    val list45=List[Int](4,5)
    val list67=List[Int](6,7)
    val list01234567=List[List[Int]](list01,list23,list45,list67)
    val a=Demo.Demo.GetMatrixA3x3(list01234567)
    assert(a.toString()=="List(28)")
  }
  it should "be equal 0" in {
    val list01=List[Int](0,-1)
    val list23=List[Int](-1,2)
    val list45=List[Int](-4,5)
    val list67=List[Int](6,-7)
    val list01234567=List[List[Int]](list01,list23,list45,list67)
    val a=Demo.Demo.GetMatrixA3x3(list01234567)
    assert(a.toString()=="List(0)")
  }

}