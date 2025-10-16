 fun main(){
     val cadenas: MutableList<String> = mutableListOf()
     var input: String = ""
     do{
         print("Introduce una cadena (o 'fin' para terminar): ")
         input = readln()
         if(input!="fin"){
             cadenas.add(input)
         }
     }while(input!="fin")

     //Mostramos en orden inverso
     println("Cadenas en orden inverso:")
     for(i in cadenas.size - 1 downTo 0){
         println(cadenas[i])
     }

     //Mostramos todas las cadenas de la lista
     println("Cadenas en orden original:")
     cadenas.forEach{ println(it) }
 }