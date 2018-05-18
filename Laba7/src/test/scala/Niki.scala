
import scala.collection.immutable.List
import org.scalatest._

class  Niki extends  FlatSpec {
  "A string" should "be NikitaSTeTS" in {
    val string = "nikitastets";
    val a=Demo.Demo.ChangeRegister(string)
    assert(a=="NikiTaSTeTS")
  }
    it should " be love C#" in {
    val string = "love c#";
    val a=Demo.Demo.ChangeRegister(string)
    assert(a=="lOVe c#")
  }
  "Get links" should "be Error" in {
    val string = "InternetExplorer";
    val OS=new Demo.Demo.WindowsOS(string)
    val a=OS.getDownloadLink()
    assert(a=="Error")
  }
  it should " be love LinuxLink" in {
    val string = "InternetExplorer";
    val OS=new Demo.Demo.Linux(string)
    val a=OS.getDownloadLink()
    assert(a=="LinuxLink")
  }
  it should " be love MacOSLink" in {
    val string = "InternetExplorer";
    val OS=new Demo.Demo.MacOS(string)
    val a=OS.getDownloadLink()
    assert(a=="MacOSLink")
  }

}