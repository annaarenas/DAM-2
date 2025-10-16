fun main(){
    print("Introduce una cadena de texto: ")
    var cadena = readln()
    for(i in 0 .. cadena.length - 1){
        print("${cadena[i]} ")
    }
    println()
    for(i in cadena.length - 1 downTo 0){
        print("${cadena[i]} ")
    }
}