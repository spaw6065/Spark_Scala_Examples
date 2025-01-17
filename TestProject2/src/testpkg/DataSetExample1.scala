package testpkg

import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.sql.Encoders
import scala.reflect.runtime.universe.TypeTag

object DataSetExample1 {
    
    case class Name1(pid: Int,first:String , last:String, middle: String)
    case class Loc(pid: Int, hno: String, add1:String, add2: String, pin: Int)
    
  def main(args: Array[String]): Unit ={
    //val conf = new SparkConf().setAppName("DataSetExample1").setMaster("local[*]")
    //val sc = new SparkContext(conf)

    val spark  = SparkSession.builder().master("local[*]").appName("DataSetExample2").getOrCreate()

    import spark.implicits._

    spark.sparkContext.setLogLevel("WARN")

   //Take the filename as input
    val inputFileName = args(0)
    println("Entered filename : "+inputFileName)
    
    //DataFrame
    val namesDF = spark.read.option("header",false).option("delimiter"," ").csv(inputFileName)
    
    println("*** namesDF ***")
    namesDF.show(false)
    
    val nameDS = spark.read.schema(Encoders.product[Name1].schema).option("header",false).option("delimiter","\t").csv(inputFileName).as[Name1]
    println("*** namesDS ***")
    nameDS.show()
    
    //RDD[Name]
    // val names = sc.textFile("C:\\Users\\Administrator\\Desktop\\Data\\names.txt").map{ line =>
    //   val p = line.split("\t")
    //   Name(p(0).toInt,p(1),p(2),p(3))
    // }.cache()

  }
}