import java.util.Scanner;

fun main()
{

 val scan = Scanner(System.`in`);
 var num: Int; 


 println("Enter a number: ");
 num = scan.nextInt();

if (num % 2 == 0)
{
  println("Even");

}
else
{
  println("Odd");
}

}
