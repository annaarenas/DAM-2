fun main(){
    print("Introduce un número: ")
    val n : Int = readln().toInt()


    print(if(n % 2 == 0) "El número $n es par" else "El número $n es impar")
}