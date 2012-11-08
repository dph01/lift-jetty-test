This is a test to show that running a jetty server in a Specs test causes an error.

To see the error, run 

    $./sbt test
    
The starting point for the project is the lift_basic template: 
[https://github.com/lift/lift_25_sbt/](https://github.com/lift/lift_25_sbt/)

The error is caused by adding the dependency:

    "org.seleniumhq.selenium" % "selenium-server" % "2.25.0" % "compile,test",

and the 'val context = new WebAppContext()' in the following:

    class HelloWorldTestSpecs extends Specification {
      val server = new Server
      val scc = new SelectChannelConnector
      scc.setPort(8080)
      server.setConnectors(Array(scc))
      val context = new WebAppContext()
  
The error message is: 

    [error] Could not create an instance of code.snippet.HelloWorldTestSpecs
    [error]   caused by java.lang.SecurityException: class "javax.servlet.FilterRegistration"'s signer information does not match signer information of other classes in the same package
    [error]   java.lang.ClassLoader.checkCerts(ClassLoader.java:806)
    [error]   java.lang.ClassLoader.preDefineClass(ClassLoader.java:487)
    [error]   java.lang.ClassLoader.defineClassCond(ClassLoader.java:625)
 
