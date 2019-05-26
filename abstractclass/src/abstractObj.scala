
abstract class animal(name:String,legs:Int,Feathers:Int){
  def canfly(Feathers:Int):Boolean
  def animal(name:String)={
    println("Animal name initialised is "+ this.name)
  }
  def noofLegs(name:String)={
    println(name + " has "+ this.legs + " legs")
  }
}

class animalsubclass(name:String,legs2:Int,feathers2:Int) extends animal(name,legs2,feathers2){
  def canfly(Feathers:Int) = {
    if (Feathers==0) 
      false 
    else 
      true}
  def canwalk():String={
     if (this.legs2 == 0)
      this.name+" cannot walk"
      else
       this.name+" can walk"      
  }
}


object abstractObj {
  def main (args:Array[String]){
  val animalObj = new animalsubclass("Rat",4,0)
  
  animalObj.noofLegs("Rat")
  
  println("Rat can fly ? :"+animalObj.canfly(0))
  println("Rat can walk ?:"+animalObj.canwalk())
  }
}