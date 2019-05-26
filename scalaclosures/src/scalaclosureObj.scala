

object scalaclosureObj {
  val maxLength = 10
  def main(args:Array[String])={
    val sList = List("sumit","apple","potato","jist","summary","mesmerising","mesmerising")

    def getlistmaxlengthelement(iList:List[String]) : String= {
     var maxString=""
      for(x <- iList)
        if (x.length > maxLength)
          maxString = x
        maxString
      
    }
    val stringval = getlistmaxlengthelement(sList)
    println("maximum length string in the list "+stringval)
  }   
 }
