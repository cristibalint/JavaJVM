# JavaJVM

## Class Loading

Java runtime load java class files from classpath. A classpath is a collection of locations which includes file systems, networks, databases where classes are held.

You can set the classpath globaly using an environmental variable (`PATH` or `CLASSPATH`), or you can set a classpath locally using `-cp` parameter.

Java class loading support a delegation model. Typical in an application there are more the one class loaders. Every class loader has a parent expect of the base class loader. A class loader may delegate to tis parrent.

Every class loader has an own set of directories and jar files where it looks for class definitions.

A simple cmd java program has 3 class loaders (see ClassloadingDelegation):
- Application class loader.
- Extension class loader.
- Bootstrap class loader (written in C).

JVM asks the Application class loader to load the clases which delegates to the extension class loader which in turn delegates to the Bootstrap class loader. If a class loader decides to load a specific class, it must always load that specific class in the future also.
If the Bootstrap class loader cannot find a specific class that load will fail and will return to the Extension class loader which in turn will try to find the class. If that also fails it will return to the Application class loader and if the Application class loader fails to load the class we will get a `NoClassDefFound` exception.

You can define an own class loader with a specific path by using the `URLClassLoader`. 

