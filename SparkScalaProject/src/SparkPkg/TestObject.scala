package SparkPkg

import org.apache.spark._
//import org.apache.spark.sql.sqlContext
//mport org.apache.spark.sql.SQLImplicits

object TestObject {
 def main(args:Array[String])={
   
  val conf = new SparkConf().setMaster("local[*]").setAppName("Test Project")
  val sc = new SparkContext(conf)  
  println(sc.getConf)
  println(sc.getClass)
  val readTextFilev = sc.textFile("/Users/sumitpawar/test.txt", 3)
  readTextFilev.flatMap(x=>(x.split(" "))).map(y=>(y,1)).reduceByKey(_+_).collect.foreach(println)
  }   
}