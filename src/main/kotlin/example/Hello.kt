package example

import com.github.mustachejava.DefaultMustacheFactory
import java.io.PrintWriter

fun main(args: Array<String>) {
    val page = Page(listOf(
            Item("Item 1", "$19.99", listOf("new", "good"), listOf(Feature("New!"), Feature("Awesome!"))),
            Item("Item 2", "$29.99", listOf("old", "bad"), listOf(Feature("Old."), Feature("Ugly.")))
    ))
    val mf = DefaultMustacheFactory()
    val mustache = mf.compile(mf.getReader("templates/hello.html"), "hello")
    mustache.execute(PrintWriter(System.out), page).flush()
}

data class Page(val items: List<Item>)

data class Feature(val description: String)

data class Item(val name: String, val price: String, val keywords: List<String>, val features: List<Feature>)
