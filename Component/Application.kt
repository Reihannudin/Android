package udemy.kotlin.ktor.boruto

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.callloging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.*
import kotlinx.serialization.Serializable

//setup server engine
fun main(args : Array<String>) : Unit = io.ktor.server.netty.EngineMain.main(args)

//place for declarate all backEnd Server
fun Application.module(){
//    install contentNegotiation
    install(ContentNegotiation){
        json()
    }
//    install plugins
    install(CallLogging)
//    define route
    routing {
        static(remotePath = "assets") {
            resources(resourcePackage = "assets")
        }

        get("/") {
            call.respondText("This is home page")
        }

//        get request
        get("/greetings/{userName}") {
            val userName = call.parameters["userName"]
//            Extract header
            val header = call.request.headers["Connection"]
//            validate header
            if (userName == "Reihannudin" || "reihannudin" == userName) {
                call.response.header("AdminHeader", "Admin")
                call.respondText("Hello $userName, you are admin", status = HttpStatusCode.OK)
            }
            call.respondText("Hello $userName, with Header: $header")
        }

//        get request with query parameter
        get("/about") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]
            val city = call.request.queryParameters["city"]
            call.respondText { "Hello my name is $name, My age is $age years old, and I'm from $city , Nice to meet you!! " }
        }

        get("/book") {
            try {
                val book = Book(title = "Kotlin for Beginner", author = "Reihannudin", price = 10.5)
//                call.respond(message = "Book : ${book.title} by ${book.author}", status = HttpStatusCode.OK)
                call.respond(message = book, status = HttpStatusCode.OK)
            } catch (e: Exception) {
                call.respond(message = "Error: ${e.message}", status = HttpStatusCode.BadRequest)
            }
        }

        get("/redirect") {
            call.respondRedirect(url = "/endpoint", permanent = false)
        }

        get("/endpoint") {
            call.respondText("This is endpoint")
        }

        get("/ktorhtml"){
            call.respondHtml {
                head {
                    title { "Ktor HTML" }
                }
                body {
                    h1 { +"Ktor HTML" }
                    p { +"This is a paragraph" }
                    img { src ="assets/meta_logo.jpg" }
                }
            }
        }
    }
}

//serialize data
@Serializable
data class Book(
    val title : String,
    val author : String,
    val price : Double
)