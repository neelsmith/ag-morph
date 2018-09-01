# `ag-morph`

This repository hosts a a morphological data set that can be used to build a Latin morphological parser with the `tabulae` system (see <https://neelsmith.github.io/tabulae/>).

`tabulae` builds parsers in specified orthographies, for specific corpora of Latin: as small or as large a corpus as you like.  This repository treats the paradigms of Allen and Greenough's grammar as a small corpus.  It therefore has a very small lexicon of stems, but a very full suite of inflectional rules.

## Directory organization

The directory `allen-greenough` contains tabular data in the directory structure expected by `tabulae`.

The directory `testforms` contains word lists that can be used to test the parser built from the data in `allen-greenough`.

## Compiling a parser

The `scripts` directory contains a Scala script that will compile a parser from this data set.

1.  Start an sbt console:     `sbt console`
2.  Load the script:  `:load scripts/compile.sc`
3.  Use the `compile()` function to compile `parsers/latin.a`

## Status

Initial work in progress: no published releases yet.
