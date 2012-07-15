# Limit Break

<img src="http://p.hagelb.org/limit-break.jpg" alt="omnislash" />

Modernized version of George Jahad's debug-repl.

## Usage

Require `limit` and add `(limit/break)` to the body of a function to
inject a REPL.

Currently only works with a direct stdin REPL; planning support for
nREPL. Try `lein trampoline run -m clojure.main/main`.

## License

Copyright © 2009-2012 George Jahad, Alex Osborne, and Phil Hagelberg.

Image above © 1997 Square Enix.

Distributed under the Eclipse Public License, the same as Clojure.
