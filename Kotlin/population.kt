import java.util.Scanner;


// Kotlin implementation of C pop growth
fun main(){

  val scan = Scanner(System.`in`);
  var startsize: Int;
  var endsize: Int;
  var years: Int = 0;

  // Start size

  do 
   {
    println("Start size: ");
    startsize = scan.nextInt();
   }
   while (startsize < 9);
  
  // End size
  do
  {
   println("End size: ");
   endsize = scan.nextInt();
  }
  while (endsize < startsize);

  // calculate

  while (startsize < endsize)
  {
     startsize = startsize + (startsize / 3) - (startsize / 4);
     years++;
  }

 // print
 print("Years: " + years);
}
