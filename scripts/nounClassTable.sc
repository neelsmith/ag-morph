import scala.io.Source
import java.io.PrintWriter

val f = "allen-greenough/stems-tables/nouns/nouns.cex"

val lines = Source.fromFile(f).getLines.toVector

case class NounRow(columns: Vector[String]) {
  //StemUrn#LexicalEntity#Stem#Gender#InflClass#Notes
  val stemUrn = columns(0)
  val lexEnt = columns(1)
  val stem = columns(2)
  val gender = columns(3)
  val stemClass = columns(4)

  val description = if (columns.size == 6) {
    columns(5)
  } else {
    "No description for stem class " + stemClass
  }

  def markdown : String = {
    "| `" + stemClass + "` | " + description + " | *" + stem + "*- | "
  }}

def str(columns: Vector[String]) : String = {
  columns(4) + ":  " + columns(5) + ".  Example:  `" + columns(2) + "`."
}

def docs = {
  val nounRows = for (ln <- lines) yield {
    val cols = ln.split("#").toVector
    NounRow(cols)
  }
  nounRows.filterNot(_.lexEnt == "LexicalEntity")
}

def writeTable(f: String) = {
  val hdr = "| Stem class | Description | Example |\n| :------------- | :------------- | :------------- |\n"
  new PrintWriter(f){write(hdr + docs.sortBy(_.description).map(_.markdown).mkString("\n")); close;}
}

println("\n\nWrite a markdown table documenting noun stem classes:")
println("\n\twriteTable(FILENAME)")
