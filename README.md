# roger-iot / dat110-oblig1

Handed in by:

* Arne Olai Molland
* Sondre Gjellestad
* Anders Graneng

## Important info

This project is built with ***gradle***. Eclipse has a buildship plugin for gradle by default. To run the project in Eclipse, import as a gradle-project, navigate to ***Gradle Tasks*** and run the build task.

Alternatively, run *`./gradlew build`* in *terminal* (*`.\gradlew build`* in *cmd*/*powershell*) and you're **good to go**.

To skip unit tests during build, run *`./gradlew build -x test`*

## How to run project

The project consists of three individual programs. Start DisplayDevice and SensorDevice first, then Controller.

* DisplayDevice - ***gradle runDisplayDevice***
* SensorDevice - ***gradle runSensorDevice***
* Controller - ***gradle runController***
