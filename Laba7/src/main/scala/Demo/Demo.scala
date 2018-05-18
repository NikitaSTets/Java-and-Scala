package Demo

object Demo {
  def main(args: Array[String]): Unit = {
    val firstString="love C#"
    println(ChangeRegister(firstString));
    var wind=new WindowsOS("InternetExplorer")
    println(wind.getDownloadLink())
  }
  def ChangeRegister(firstString: String): String =
  {

    var  res="";
    for(i<-firstString)
    {

      if(i.toLower<'n')
      {
        res+=i.toLower;
      }
      else
      {
        res+=i.toUpper
      }
    }
    res
  }

  abstract class OperationSystem(browser: String) {
    def getDownloadLink: String
  }

  class WindowsOS(browser: String) extends OperationSystem(browser) {
    var Browser ="Edge";
    if(browser.isEmpty==false)
    {
      Browser=browser
    }
    override def getDownloadLink() :String={
      if(Browser.equals("InternetExplorer"))
        {
         return "Error"
        }
      "WindowsLink"
    }
  }

  class MacOS(name: String) extends OperationSystem(name) {
    override def getDownloadLink() = "MacOSLink"
  }

  class Linux(name: String) extends OperationSystem(name) {
    override def getDownloadLink() = "LinuxLink"
  }
}

