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
    val JSON= CatalogoLibrosJSON(portatil)
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
    val pregunta: String
    val afirmacion: String
    val negacion: String
    val infoLibro: String
    val noInfoLibro: String
    fun realizarPregunta()
    fun realizarAfirmacion()
    fun realizarNegacion()
    fun realizarInfo()
    fun realizarNoInfo()
}
open class GestorDeLibrosEsp(): GestorDeLibrosIUT2{
    override var pregunta: String
        get() = TODO("Not yet implemented")
        set(value) {"Introduzca un ID: "}
    override var afirmacion: String
        get() = TODO("Not yet implemented")
        set(value) {"El libro existe!"}
    override var negacion: String
        get() = TODO("Not yet implemented")
        set(value) {"El libro NO existe!"}
    override var infoLibro: String
        get() = TODO("Not yet implemented")
        set(value) {"La información sobre es la siguiente\n"}
    override var noInfoLibro: String
        get() = TODO("Not yet implemented")
        set(value) {"No se encontró información sobre el libro"}
    override fun realizarPregunta(){
        println(pregunta)
    }
    override fun realizarAfirmacion(){
        println(afirmacion)
    }
    override fun realizarNegacion(){
        println(negacion)
    }
    override fun realizarInfo(){
        println(infoLibro)
    }
    override fun realizarNoInfo(){
        println(noInfoLibro)
    }
}
open class GestorDeLibrosEn(): GestorDeLibrosIUT2{
    override var pregunta: String
        get() = TODO("Not yet implemented")
        set(value) {"Enter an ID "}
    override var afirmacion: String
        get() = TODO("Not yet implemented")
        set(value) {"The book exists!"}
    override var negacion: String
        get() = TODO("Not yet implemented")
        set(value) {"the book doesn't exists!"}
    override var infoLibro: String
        get() = TODO("Not yet implemented")
        set(value) {"The information about is as follows\n"}
    override var noInfoLibro: String
        get() = TODO("Not yet implemented")
        set(value) {"No information found about the book"}
    override fun realizarPregunta(){
        println(pregunta)
    }
    override fun realizarAfirmacion(){
        println(afirmacion)
    }
    override fun realizarNegacion(){
        println(negacion)
    }
    override fun realizarInfo(){
        println(infoLibro)
    }
    override fun realizarNoInfo(){
        println(noInfoLibro)
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
                idioma.noInfoLibro
            }
        }

    }

}