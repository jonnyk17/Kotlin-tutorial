import java.util.Scanner

fun main(args: Array<String>){
    val reader = Scanner(System.`in`)
    
    print("Enter a number: ")
    var integer:Int = reader.nextInt()

    var a = 0
    var b = 0

    println("The first $integer values in the Fibbanacci sequence are:")

    for (i in 1..integer){
        if (b == 0){
            println(1)
            b = 1;
        } else {
            val sum = a + b
            println(sum)
            a = b
            b = sum
        }
    }

    print("Fib Recursion Function returns: ")
    println(fib(integer))

}
//recursion
fun fib(x :Int) :Int{
    if (x==1){
        return 1
    } else if (x==2){
        return 1
    } else {
        return fib(x-1) + fib(x-2)
    }
}
