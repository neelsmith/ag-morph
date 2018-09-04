// Compile a morphological parser

import edu.holycross.shot.tabulae.builder._
import better.files._
import java.io.{File => JFile}
import better.files.Dsl._

import sys.process._
import scala.language.postfixOps


val compiler = "/usr/local/bin/fst-compiler-utf8"
val fstinfl = "/usr/local/bin/fst-infl"
val make = "/usr/bin/make"


def compile(repo: String =  "../tabulae") = {
  val datasets = "."
  val tabulae = File(repo)
  val corpus = "allen-greenough"
  val conf =  Configuration(compiler,fstinfl,make,datasets)

  try {
    FstCompiler.compile(File(datasets), File(repo), corpus, conf, true)
    val tabulaeParser = tabulae/"parsers/allen-greenough/latin.a"
    val localParser = File("parser/latin.a")
    cp(tabulaeParser, localParser)
    println("\nCompilation completed.  Parser latin.a is " +
    "available in directory \"parser\"\n\n")
  } catch {
    case t: Throwable => println("Error trying to compile:\n" + t.toString)
  }

}




/**  Parse words listed in a file, and return their analyses
* as a String.
*
* @param wordsFile File with words to parse listed one per line.
* @param parser Name of corpus-specific parser, a subdirectory of
* tabulae/parsers.
*/
def parse(wordsFile : String) : String = {
  val cmd = fstinfl + " parser/latin.a  " + wordsFile
  cmd !!
}

println("\n\n1. Compile a morphological parser.\n")
println("  A. When tabulae and hmt-lexicon repositories are ")
println("  in adjacent directories to this directory:")
println("\n\tcompile()\n")
println("  B. To specify the location of tabulae and")
println("  hmt-lexicon repositories:")
println("\n\tcompile(\"tabulae__DIRECTORY\", \"HMT_LEXICON_DIRECTORY\" )\n")
println("\n2. Parse a file of words (one per line):")
println("\n\tparse(\"WORDS_FILE\")")
