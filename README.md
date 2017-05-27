Java Threes
======
Description
-----------
Java Threes is a simple clone of the original iOS game "Threes" by Sirvo llc.
This application is an assignment for **Programming Technologies** and **Programming Environments** class at the [University of Debrecen, Faculty of Informatics](http://www.inf.unideb.hu/).
To run the application you need at least java version 1.8 and to copmile and package it yourself you need the JDK and maven installed and configured, so keep that in mind.

Expectations
------------
Structure:
- [x] Testable business logic
- [x] JavaFX user interface
- [x] Persistency using JSON files

Maven-specific:
- [x] `pom.xml` must have a `description`, `developers`, `scm` and `licenses` tag
- [x] Indicate source encoding
- [x] `maven-enforcer-plugin` must check for *JDK 1.8*
- [x] `maven-javadoc-plugin`
- [x] `maven-surefire-report-plugin` 
- [x] `maven-jxr-plugin`
- [x] `cobertura-maven-plugin`
- [x] `maven-checkstyle-plugin`

Documentation:
- [x] Checkstyle XML
- [ ] ApiDoc (excluding GUI and JUnit tests)
- [x] Package informations (`package-info.java`)

Logging:
- [ ] Logging

Unit testing:
- [ ] JUnit tests

License:
- [x] Adding license 

Git-specific:
- [x] `.gitignore` file
- [x] Upload to *GitHub*
- [x] `README.md` file

How to run the application
--------------------------
You can build a standalone `.jar` application, and run it
- `$ mvn clean package`
- `$ cd target`
- `$ java -jar java-threes-X.X.X-jar-with-dependencies.jar` (where x.x.x is the current version number)