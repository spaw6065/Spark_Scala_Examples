package traitspkg

class myclass extends mytrait with mytrait2 {
 override def myprintln2(mystring:String) = {
   println("This is println2 from myclass "+mystring)
   }
  
// def myprintln3(istr:String)={
//    println("this is my myclass myprintln3 "+istr)
//   }
}