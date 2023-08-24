
fun main() {
    val a = arrayOf("gay", "poop")
    val b = arrayOf("pea", "nuts")
    print(compareArrayLength(a, b))
}
fun compareArrayLength(a:Array<String>,b:Array<String>):Boolean{
   return a.size == b.size
}
