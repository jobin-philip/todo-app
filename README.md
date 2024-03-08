# todo-app

todo-app is a lightweight Spring Boot application designed for managing your to-do list effortlessly.

## Prerequisites

Make sure you have the following installed:
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Quick Start

1. **Clone the repository:**
   ```bash
   git clone https://github.com/jobin-philip/todo-app.git
   cd todo-app
   ```
2. **Run the application:**
   ```bash
   mvnw spring-boot:run
   ```
3. **Access the application:**
   Open your web browser and go to http://localhost:8080
   
## Features

-   User-friendly interface for managing to-do items.
-   CRUD operations (Create, Read, Update, Delete).
-   Utilizes Spring Data JPA and an in-memory H2 database.
   
## Notes

-   The application uses an in-memory H2 database, which is reset on restart.
-   Ensure port 8080 is available before running the application.

## License

This project is licensed under the [MIT License](LICENSE).