import org.apache.spark.{SparkConf,SparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions._

object testObject {
  
  def main(args:Array[String]):Unit={    
  val spark = SparkSession.builder().master("local[*]").appName("Word Count").getOrCreate()
  
  val inputfile_df = spark.read.format("csv")
                               .option("delimiter", "|")
                               .option("inferschema","true")
                               .option("header","true")
                               .load("/Users/sumitpawar/inputfile.txt")

  
  //Algorithm : group by id,fname,lname and generate the aggregates 
  val finaloutput_df = inputfile_df.groupBy("id","fname","lname")
                                  .agg(sum(col("phone")).alias("out_phone"),
                                       concat_ws("",collect_list(col("phone_call_optin"))).alias("out_phone_call_optin"),
                                       concat_ws("",collect_list(col("vm_optin"))).alias("out_vm_optin"),
                                       concat_ws("",collect_list(col("primary_flag"))).alias("out_primary_flag"))
                                  .select("id",
                                          "fname",
                                          "lname",
                                          "out_phone",
                                          "out_phone_call_optin",
                                          "out_vm_optin",
                                          "out_primary_flag")
                                  .orderBy("id")
  finaloutput_df.show(false)                                
                           
  //write the df in directory outputdir
  finaloutput_df.coalesce(1).write.format("csv").option("delimiter", "|").save("/users/sumitpawar/outputdir")
  }
}