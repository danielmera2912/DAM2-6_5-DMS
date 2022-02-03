package un6.eje6_5

import CatalogoLibrosJSON
import CatalogoLibrosXML
import java.util.logging.Level
import java.util.logging.LogManager

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}


fun main() {
    var portatil = "Catalog.xml"
    val XML= CatalogoLibrosXML(portatil)
    //val JSON= CatalogoLibrosJSON(portatil)
    val idiomaESP= GestorDeLibrosEsp()
    val idiomaEN= GestorDeLibrosEn()
    val gestorDeLibros = gestionLibrosIU(XML,idiomaESP)
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}

interface GestorDeLibrosIUT1{


    fun existeLibro(idLibro: String): Boolean

    fun infoLibro(idLibro: String): Map<String, Any>

}
interface GestorDeLibrosIUT2{
    fun realizarPregunta()
    fun realizarAfirmacion()
    fun realizarNegacion()
    fun realizarInfo()
    fun realizarNoInfo()
}
open class GestorDeLibrosEsp(): GestorDeLibrosIUT2{

    override fun realizarPregunta(){
        println("Introduzca un ID: ")
    }
    override fun realizarAfirmacion(){
        println("El libro existe!")
    }
    override fun realizarNegacion(){
        println("El libro NO existe!")
    }
    override fun realizarInfo(){
        println("La información sobre es la siguiente\n")
    }
    override fun realizarNoInfo(){
        println("No se encontró información sobre el libro")
    }
}
open class GestorDeLibrosEn(): GestorDeLibrosIUT2{
    override fun realizarPregunta(){
        println("Enter an ID ")
    }
    override fun realizarAfirmacion(){
        println("The book exists!")
    }
    override fun realizarNegacion(){
        println("the book doesn't exists!")
    }
    override fun realizarInfo(){
        println("The information about is as follows\n")
    }
    override fun realizarNoInfo(){
        println("No information found about the book")
    }
}
open class gestionLibrosIU(val lib: GestorDeLibrosIUT1, val idioma: GestorDeLibrosIUT2)

{
    fun preguntarPorUnLibro() {
        idioma.realizarPregunta()
        var idLibro = readln()
        if(lib.existeLibro(idLibro)){
            idioma.realizarAfirmacion()
        }
        else{
            idioma.realizarNegacion()
        }



    }

    fun mostrarInfoDeUnLibro() {
        idioma.realizarPregunta()
        var idLibro = readln()
        var infoLibro = lib.infoLibro(idLibro)
        if(infoLibro!= null){
            if (infoLibro.isEmpty()){
                idioma.realizarInfo()
                println(infoLibro)
            }else{
                idioma.realizarNoInfo()
            }
        }

    }

}