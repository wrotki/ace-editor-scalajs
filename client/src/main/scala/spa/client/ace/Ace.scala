package spa.client.ace

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSImport, JSName}
import japgolly.scalajs.react._

import scala.scalajs.js.UndefOr
import scala.scalajs.js.{undefined, UndefOr, Function0 => JFn0, Function1 => JFn1}


// ACE
// http://zhouanbo.com/2016/06/10/Using-Ace-Editor-With-React/
// https://github.com/japgolly/scalajs-react/blob/master/doc/INTEROP.md

object Ace {

  @JSName("AceEditor")
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
    var isOpened: Boolean = js.native
    var onMeasure: OnMeasure = js.native
    var onRest: OnRest = js.native
  }

  def props(isOpened: Boolean,
            onMeasure: Measures => Callback = _ => Callback.empty,
            onRest: Callback = Callback.empty): Props = {
    val p = (new js.Object).asInstanceOf[Props]
    p.isOpened = isOpened
    p.onMeasure = (measures: Measures) => onMeasure(measures).runNow()
    p.onRest = onRest.toJsCallback // or alternatively: () => onRest.runNow()
    p
  }

  val component = JsComponent[Props, Children.Varargs, Null](RawComponent)
}
