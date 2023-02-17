import java.util.*

fun fib(n: Int): Int{
    
    if(n<=1){
        return n
    }
    return fib(n-1)+fib(n-2)
}
fun binary_search(a: List<Int>, low:Int, high:Int, n:Int): Int{
    if(high>=low){
        var mid:Int= low+(high-low)/2
        if(a[mid]==n)
            return mid
        if(a[mid]>n)
            return binary_search(a, low, mid-1, n)
        
        return binary_search(a, mid+1, low, n)
    }
    return -1
}

fun main(){
    val reader = Scanner(System.`in`)
    println("Enter a number:")
    var n:Int = reader.nextInt()
    println(fib(n))
    val a = List(10) { Random().nextInt(20) }
    val num = Random().nextInt(20)
    println(a)
    println(num)
    println(binary_search(a, 0, 9, num))
}