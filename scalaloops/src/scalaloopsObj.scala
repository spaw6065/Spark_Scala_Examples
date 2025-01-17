

object scalaloopsObj {
def main(args:Array[String]){
  println("Entered main method")
  
  def fileLines(file: java.io.File) =
    scala.io.Source.fromFile(file).getLines
   
  def grep(pattern:String)={
   
  //read the files from the input directory 
  val filesHere = (new java.io.File(args(0)).listFiles())
  
  println("filesHere is of type"+filesHere.isInstanceOf)
  var icounter = 0
  for{file <- filesHere  
    if (file.getName.endsWith(".scala"))
      line <- fileLines(file)     
      if line.trim.matches(pattern)
  } println("line : "+line+" file "+file)//;  icounter = icounter +1 
 }
  
  def multiTable = { 
    var sum=0
    val table = for (i <- 1 to 10) yield { 
     if (i%2 == 0){ 
      sum=sum+i
      sum}
    else 
      1
    }
  table.mkString(",")
  }

  //invocatin of the methods
  grep(".*scala.*")
  println(multiTable.split(",")(9))
//  val test = multiTable
//  for (i <- test){
//    println("i ----- "+i)
//  }
  
  
  println("Exited main method")
}
}