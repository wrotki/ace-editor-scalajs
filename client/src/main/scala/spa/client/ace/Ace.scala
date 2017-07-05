package spa.client.ace

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSImport, JSName}
import scala.scalajs.js.{UndefOr, Function0 => JFn0, Function1 => JFn1}

import japgolly.scalajs.react._

// ACE
// http://zhouanbo.com/2016/06/10/Using-Ace-Editor-With-React/
// https://github.com/japgolly/scalajs-react/blob/master/doc/INTEROP.md

object Ace {

  @JSImport("react-ace", JSImport.Default)
  @js.native
  object RawComponent extends js.Object

  @js.native
  trait Measures extends js.Object {
    val height: Double = js.native
    val width: Double = js.native
  }

  type OnMeasure = js.Function1[Measures, Unit]
  type OnRest = UndefOr[JFn0[Unit]]

  @js.native
  trait Props extends js.Object {
    var mode: String = js.native
    var theme: String = js.native
    var name: String = js.native
    var width: String = js.native
    var maxLines: Int = js.native
    //var ref: String = js.native
    var fontSize: Int = js.native
    var value: String = js.native
    //    var onMeasure: OnMeasure = js.native
    //    var onRest: OnRest = js.native
  }

  def props(
             mode: String,
             name: String,
             theme: String,
             width: String,
             maxLines: Int,
             //ref: String,
             fontSize: Int,
             value: String
             // onMeasure: Measures => Callback = _ => Callback.empty,
             // onRest: Callback = Callback.empty
           ): Props = {
    val p = (new js.Object).asInstanceOf[Props]
    p.mode = mode
    p.name = name
    p.theme = theme
    p.width = width
    p.maxLines = maxLines
    //p.ref = ref
    p.fontSize = fontSize
    p.value = value
    //    p.onMeasure = (measures: Measures) => onMeasure(measures).runNow()
    //    p.onRest = onRest.toJsCallback // or alternatively: () => onRest.runNow()
    p
  }

  val component = JsComponent[Props, Children.Varargs, Null](RawComponent)
}
