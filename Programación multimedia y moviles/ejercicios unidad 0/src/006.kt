fun main(){
    print("Introduce un número: ")
    val x: Int = readln().toInt()
    if (esPrimo(x)) {
        println("El número $x es primo")
    } else {
        println("El número $x no es primo")
    }
}

fun esPrimo(n: Int): Boolean {
    if (n <= 1) return false
    for (i in 2 until n) {
        if (n % i == 0) return false
    }
    return true
}