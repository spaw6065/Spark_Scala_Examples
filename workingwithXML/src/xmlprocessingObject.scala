import org.apache.spark.{SparkConf,SparkContext}
import org.apache.spark.sql.SparkSession
import com.databricks.spark.xml._

object xmlprocessingObject {
  def main(args:Array[String]):Unit = {
  val spark = SparkSession.builder().master("local[*]").appName("XML Processing").getOrCreate()
  
  //read xml file
  val read_xml_df = spark.read.option("rowTag", "book").xml("/Users/sumitpawar/xml_files/test*.xml")
  
  //display the read_xml_df
  read_xml_df.show(false)
  
  //write the data frame in xml format
  read_xml_df.filter(read_xml_df.col("_id")==="bk101").write.option("rowTag","book_detail").xml("/Users/sumitpawar/output_xmls")
  }
}