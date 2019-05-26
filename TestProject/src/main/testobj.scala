package main
import org.apache.spark.{SparkConf,SparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SQLImplicits

object testobj {
  def main(args:Array[String])={
   
  val conf = new SparkConf().setMaster("local[*]").setAppName("Test Project")
  val sc = new SparkContext(conf)
  
  val readTextFilev=sc.textFile("/Users/sumitpawar/SCALA_PRACTICALS/temp_scalafile/test1.scala", 2)
  
  readTextFilev.map(x=>(x.split(" "))).map(y=>(y,1)).reduceByKey(_+_).collect.foreach(println)
  }   
}