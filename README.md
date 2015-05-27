# Tiny Scala.js example

These are some slides and code I used for a talk about 
[Scala.js](http://www.scala-js.org).

## Get started

Please note that the project uses a now outdated version of [Scala.js](http://www.scala-js.org), so the commands are slightly different from the current documentation.

To get started, open `sbt` in scala-js-tiny-example project, and issue the task
`packageJS`. This creates the file `target/scala-2.10/example.js` and its
siblings `example-extdeps.js` and `example-intdeps.js`.
You can now open `index-dev.html` in your favorite Web browser!


## The optimized version

For ultimate code size reduction, use `optimizeJS`.  While `index-dev.html` refers to the JavaScript emitted by `packageJS`,
`index.html` refers to the optimized JavaScript emitted by `optimizeJS`.

