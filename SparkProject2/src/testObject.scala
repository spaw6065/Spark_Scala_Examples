import org.apache.spark.{SparkConf,SparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession

object testObject {
  
  def main(args:Array[String]):Unit={    
  val spark = SparkSession.builder().master("local[*]").appName("Word Count").getOrCreate()

  
  val readDF = spark.read.csv("/Users/sumitpawar/test.csv").toDF("lines")
  readDF.show(false)
  }
}