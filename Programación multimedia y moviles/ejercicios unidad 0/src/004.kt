fun main(){
    print("Introduce un número: ")
    val n : Int = readln().toInt()

    for(i in 0..10){
        println("$n x $i = ${n * i}")
    }
}