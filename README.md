# Introduction to Java Microservices

### Initial Considerations

* The code in this repository will support a video-training which is in preparation.
* Its purpose is to guide the student step-by-step with focus in understanding the Java Microservices basic techniques and architecture.
* We assume that the student already knows (or is aware of) the best practices, coding standards, etc. Based on this assumption the code was simplified in several ocasions to avoid adding complexity.
* Also, please be aware that the code is under review.
* Therefore, the MUST NOT be used in a production environment.
* Also, it doesn't cover important subjects like Security, OAuth, Service Registry, among others, which will be covered in further trainings.

### Repository Structure

* The training is composed of 52 lessons and exercises, each one stored in it's own branch.
* The 52 lessons are grouped in 08 Parts, each part adding a significant upgrade on the application.
* The latest version can be found on the branch **dev-integration**.
* Each lesson (or branch) are executable independent of the others (Note: some Review Exercises are under review and can present problems).

### The Example Application

* The main application's objetive is to manage exams (groups of questions and answers).
* The user can list, take, remove, and update exams.
* After the exam is submitted the system intentionally takes five seconds to deliver the final grade. The result is sent to the front-end (via websocket) and to the administrator (via email).
* There are several other features (like Hystrix Circuit-Breaker, messaging, others) used in the application that will be detailed in further versions of this readme file.

### Application Infrastructure Overview

* Five Java Microservices based on Spring Boot (we suggest to run them in the following order):
  * Questions and Answers (ijm_qna)
  * Exams (ijm_exam)
  * Grader (ijm_grader)
  * Logger (ijm_logger)
  * User Interface (ijm_ui) - Uses AngularJS 2

* Commons Library (ijm_commons)

* Swagger2 (all microservices)

* MySQL Databases
  * ijm_qna (for questions and answers)
  * ijm_exam (for the exams)
  *(Note: the script ijm-testdata.sql generates the databases and the data used in the tests so far)*

* MongoDB: for the logger

* Application Containers
  * Tomcat
  * Jetty

* Mail Server (port 2525)
* Message Queue Server (RabbitMQ)

### Basic Requirements

* Java 8 (the latest version was tested under the version 1.8.0_144).
* MySQL server
* MongoDB server
* RabbitMQ server
* SMTP server (we've been using the 'fakeSMTP server', for simplicity)
