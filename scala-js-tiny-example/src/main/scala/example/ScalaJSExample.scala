package example

import scala.scalajs.js
import org.scalajs.jquery.jQuery
import js.annotation.JSExport


@JSExport
object ScalaJSExample {
  val docroot = js.Dynamic.global
  // Use jquery
  val jQ = jQuery
  var count = Map[Char,Int]()

  @JSExport
  def main(): Unit = {
    // use scala functions as callbacks for javascript events
    jQ("#thebutton").click(() => updateList())
  }

  /**
   * You can use pattern matching ...
   */
  def updateList(): Unit = {
    /*
    use any javascript method (dynamically), no restrictions
     */
    val text = jQ("#thetext").`val`().toString
    jQ("#thetext").`val`("")
    /* User pattern matching */
    text match {
      case "cls" => {
        count = count.empty
        jQ("#thelist").empty()
      }
      case _ => { countCharacters(text); showCount() }
    }
  }

  /**
   * ... string interpolation ...
   */
  def showCount(): Unit = {
    val ul = jQ("#thelist")
    ul.empty()
    val lis = count.map(e => s"""<li class="list-group-item">${e._1}<span class="badge">${e._2}</span></li>""")
    lis.foreach(ul.append(_))
  }

  /**
   * ... the collections API
   */
  def countCharacters(text: String): Unit =  {
    count = merge(count,
      text.toUpperCase.filterNot(_.isWhitespace).groupBy(identity).mapValues(_.length))
  }


  def merge(m1: Map[Char,Int], m2: Map[Char,Int]): Map[Char, Int] = {
    (m1.keySet ++ m2.keySet).map(c => (c -> (m1.getOrElse(c, 0) + m2.getOrElse(c, 0)))).toMap
  }

  /** Computes the square of an integer.
   *  To be used by test to demonstrate unit testing
   */
  def square(x: Int): Int = x*x
}
