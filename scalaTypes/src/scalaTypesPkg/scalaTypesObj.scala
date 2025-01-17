package scalaTypesPkg

class scalaTypes(inum:Int,inum2:Int) {
  
  val num1:Int = inum
  val num2:Int = inum2
  
  def this(inum2:Int) = this(inum2,1)
  
  def gcd(no1:Int,no2:Int):Int={
    if(no2 == 0) no1 else gcd(no2,no1%no2)
  }
  
  
}
object scalaTypesObj {
  def main(args:Array[String]){
    println("""|Inside main method
               |Testing the multiline scenario""".stripMargin)
   
   //val scalaTypesObj1 = new scalaTypes(10)
   //println("value of inum"+scalaTypesObj1.num2);
   
    //val greaterdivisor = scalaTypesObj1.gcd(10, 5)
    //println("common divisor between 10 and 5 "+ greaterdivisor ) 
   
   val inputpassed = if (args.length > 0) args(0).toInt%2 else -1
   
   inputpassed match{
     case 0 => println("input passed "+args(0)+" is even")
     case -1 => println(" Please enter a valid number to test")
     case _ => println("input passed "+args(0)+" is odd")
   }
   
   val evenodd:Array[Int] = Array(1,2,3,4,5,6,7,8,9,10) 
   evenodd.foreach(x => {if (x%2 == 0) println(x+" is even") else println(x+" is odd")})
  
  
  }// end of main
               
}