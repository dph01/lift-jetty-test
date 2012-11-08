package code
package snippet

import net.liftweb._
import http._
import net.liftweb.util._
import net.liftweb.common._
import Helpers._
import lib._
import org.specs2.mutable.Specification
import org.specs2.specification.AroundExample
import org.specs2.execute.Result
import org.eclipse.jetty.server.nio.SelectChannelConnector
import org.eclipse.jetty.server.handler.ContextHandler
import org.eclipse.jetty.webapp.WebAppContext
import org.eclipse.jetty.server.{ Handler, Server }

//object HelloWorldTestSpecs2 extends Specification with AroundExample {
class HelloWorldTestSpecs extends Specification {
  // val session = new LiftSession("", randomString(20), Empty)
  // val stableTime = now


  val server = new Server
  val scc = new SelectChannelConnector
  scc.setPort(8080)
  server.setConnectors(Array(scc))

  // the following line causes:
  // [error] Could not create an instance of code.snippet.HelloWorldTestSpecs
  // [error]   caused by java.lang.SecurityException: class "javax.servlet.FilterRegistration"'s signer information does not match signer information of other classes in the same package
  // [error]   java.lang.ClassLoader.checkCerts(ClassLoader.java:806)
  // [error]   java.lang.ClassLoader.preDefineClass(ClassLoader.java:487)
  // [error]   java.lang.ClassLoader.defineClassCond(ClassLoader.java:625)
  val context = new WebAppContext()
  
  //  context.setServer(server)
  //  context.setWar("src/main/webapp")
  //
  //  val context0: ContextHandler = new ContextHandler();
  //  context0.setHandler(context)
  //  server.setHandler(context0)

  /**
   * For additional ways of writing tests,
   * please see http://www.assembla.com/spaces/liftweb/wiki/Mocking_HTTP_Requests
   */
  //  def around[T <% Result](body: => T) = {
  //    S.initIfUninitted(session) {
  //      DependencyFactory.time.doWith(stableTime) {
  //        body
  //      }
  //    }
  //  }
  //
  //  "HelloWorld Snippet" should {
  //    "Put the time in the node" in {
  //      val hello = new HelloWorld
  //      Thread.sleep(1000) // make sure the time changes
  //
  //      val str = hello.howdy(<span>Welcome to your Lift app at <span id="time">Time goes here</span></span>).toString
  //
  //      str.indexOf(stableTime.toString) must be >= 0
  //      str must startWith("<span>Welcome to")
  //    }
  //  }
}
