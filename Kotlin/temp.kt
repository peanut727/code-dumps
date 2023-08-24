import java.util.Scanner;

fun main() {


  val s = Scanner(System.`in`)
  // Base celcius temp
  println("What is the temperature today in celcius?: ")
  val temp: Double = s.nextDouble()

  println("What values do you want to convert it? F - Fahrenheit K - Kelvin")
  val grr = s.nextLine().uppercase()

  // Kelvin
  val kelv: Double = temp + 273.15;
  // Fahrenheit
  val fahr: Double = (9.0/5.0)*temp + 32;

  val ans = when(grr) {
 
  "F" -> println(fahr)
  "K" -> println(kelv)
  else -> "invalid values"
  } 
println(ans)



  //println("The temperature today is " + fahr +"F " + "and" + temp +"C" )
    
  



}
