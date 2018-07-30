import scala.io.Source

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
    "| " + stemClass + " | " + description + " | " + stem + " | "
  }
}

def str(columns: Vector[String]) : String = {
  columns(4) + ":  " + columns(5) + ".  Example:  `" + columns(2) + "`."
}

val docs = for (ln <- lines) yield {
  val cols = ln.split("#").toVector
  NounRow(cols)
}
