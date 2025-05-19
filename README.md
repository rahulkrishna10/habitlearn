<h1>HabitLearn</h1>

Overview
A simple Spring Boot application to help users track and manage their learning habits, log progress, and set personal goals.

Features
Create, update, and delete habits

Log daily/periodic progress for each habit

View logs associated with each habit

RESTful APIs for habit and habit log management

Technologies Used
Java 17 (or your version)

Spring Boot

Spring Data JPA

MySQL

Lombok

Maven (or Gradle)

Getting Started
Prerequisites
JDK 17+

MySQL database setup

Maven (or Gradle) installed

Postman (optional, for API testing)

Installation
Clone the repository

```bash
git clone https://github.com/yourusername/your-repo-name.git
```

Configure your MySQL database credentials in application.properties

Run the application

```bash
mvn spring-boot:run
```
Use Postman or any REST client to test the APIs

API Endpoints
GET /api/habits - List all habits

POST /api/habits - Create a new habit

GET /api/habits/{id} - Get habit by ID

DELETE /api/habits/{id} - Delete habit by ID

GET /api/habits/{id}/logs - Get logs of a habit

POST /api/habits/{id}/logs - Add a log to a habit
