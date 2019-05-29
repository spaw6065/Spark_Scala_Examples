

object mapObject {
  def main(args:Array[String])={
    
    var exchangeRate = Map(
      "USD" -> Map("USD" -> 1.0   , "EUR" -> 0.7596,
                   "JPY" -> 1.211 , "CHF" -> 1.223),
      "EUR" -> Map("USD" -> 1.316 , "EUR" -> 1.0   ,
                   "JPY" -> 1.594 , "CHF" -> 1.623),
      "JPY" -> Map("USD" -> 0.8257, "EUR" -> 0.6272,
                   "JPY" -> 1.0   , "CHF" -> 1.018)
                          )
    //lets search for the USD to EUR conversion rate
    val srcCurrency = args(0).toString()
    val trgtCurrency = args(1).toString()
    
    val srctotrgcurrRate = exchangeRate(srcCurrency)(trgtCurrency)                      
    println("Total amount of 100 in "+ srcCurrency + " is equal to "+ 100*srctotrgcurrRate +" "+ trgtCurrency)
    
    
  }
}