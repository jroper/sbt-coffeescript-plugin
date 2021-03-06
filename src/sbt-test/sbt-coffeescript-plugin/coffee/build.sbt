import com.typesafe.sbt.jse.SbtJsTaskPlugin

webSettings

SbtJsTaskPlugin.jsEngineAndTaskSettings

coffeeScriptSettings

val checkMapFileContents = taskKey[Unit]("check that map contents are correct")

checkMapFileContents := {
  val contents = IO.read((WebKeys.public in WebKeys.Assets).value / "coffee" / "a.js.map")
  if (contents != """{
                    |  "version": 3,
                    |  "file": "a.js",
                    |  "sourceRoot": "",
                    |  "sources": [
                    |    "a.coffee"
                    |  ],
                    |  "names": [],
                    |  "mappings": "AAAA;AAAA,MAAA,gBAAA;;AAAA,EAAA,MAAA,GAAW,EAAX,CAAA;;AAAA,EACA,QAAA,GAAW,IADX,CAAA;AAAA"
                    |}""".stripMargin) {
    sys.error(s"Unexpected contents: $contents")
  }
}