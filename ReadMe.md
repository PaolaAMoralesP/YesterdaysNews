# 🧑‍💻 Yesterday's News

Welcome to the Yesterday's News project!

## 🗞️ Project Description

This project involves building a REST API developed with Java Spring Boot and Maven for managing articles of a digital newspaper called Yesterday's News. The API allows users to create, list, retrieve, update, and delete articles, as well as create users. A PostgreSQL database is used for data storage, and endpoint testing is performed using Postman.

---

## 🎯 Objectives

* Develop a REST API for managing articles of a digital newspaper.
* Implement a 3-layer MVC (Model-View-Controller) architecture.
* Establish a connection with a PostgreSQL database.
* Create endpoints for CRUD (Create, Read, Update, Delete) operations on articles.
* Implement user creation.
* Define relationships between user and article entities.
* Validate input data according to the specified requirements.
* Perform integration tests of the controllers using Spring Boot Test.

---

## 🛠️ Technologies and Tools

* **Programming Language:** Java 21
* **Backend Framework:** Spring Boot 3.4.4
* **Spring Data:** JPA
* **Database:** PostgreSQL / H2 
* **IDE:** Visual Studio Code
* **Project Management:** Trello
* **Version Control:** Git - GitHub
* **API Client:** Postman

---

## ⚙️ Environment Setup

Before running the application, ensure you have the following installed:

* **Java Development Kit (JDK):** Version compatible with Spring Boot.
* **Maven:** For dependency management and project building.
* **PostgreSQL:** Running PostgreSQL database server.
* **pgAdmin:** (Or any PostgreSQL client) for database administration.
* **Git:** For version control management.
* **Visual Studio Code:** (Or your preferred IDE) with necessary plugins for Java and Spring Boot.
* **Postman:** For testing the API endpoints.

---

##  📂Database Configuration

1.  Create a database named (for example) `yesterdaynews` on your PostgreSQL server using pgAdmin or the command line.
2.  Configure the environment variables for the database connection in a `.env` file at the root of the project. This file should contain the following variables:

    ```
    SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/yesterdaynews
    SPRING_DATASOURCE_USERNAME=your_postgres_username
    SPRING_DATASOURCE_PASSWORD=your_postgres_password
    SPRING_DATASOURCE_DRIVER_CLASS_NAME=org.postgresql.Driver
    ```

    **Note:** Replace `your_postgres_username` and `your_postgres_password` with your PostgreSQL credentials.

---

## ⭐Running the Application

1.  Clone the project repository from GitHub.
2.  Open the project in Visual Studio Code (or your IDE).
3.  Ensure that the `.env` file is at the root of the project. The provided code (`YesterdaysnewsApplication.java`) loads these variables when the application starts.
4.  Open a terminal in the root of the project.
5.  Execute the Maven command to build and run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

    Or if you don't have the Maven wrapper (`mvnw`):

    ```bash
    mvn spring-boot:run
    ```

6.  The Spring Boot application will start and connect to the PostgreSQL database. You will see messages in the console indicating if the connection was successful.

---

## 🚀 API Endpoints

Once the application is running, you can interact with the following endpoints using Postman - read Postman read.me

---

## 🧪 Integration Tests

The project includes integration tests for the controllers. These tests are usually located in the `src/test/java` directory. To run the tests, use the following Maven command or the "play" icon.

```bash
./mvnw test


---

## ☎️ Contact

<table style="border-collapse: collapse; border: none;">
  <tr>
  <td align="center" style="border: none;">
      <br><b>Einar Sanchez</b>
      <br>
      <a href="https://www.linkedin.com/in/einartech/">LinkedIn</a> |
      <a href="https://github.com/einartech/">GitHub</a>
    </td>
    <td align="center" style="border: none;">
      <br><b>Kat Leverton</b>
      <br>
      <a href="https://www.linkedin.com/in/kat-leverton/">LinkedIn</a> |
      <a href="https://github.com/Kat-lev/">GitHub</a>
    </td>
    <td align="center" style="border: none;">
      <br><b>Mariuxi Olaya</b>
      <br>
      <a href="hhttp://www.linkedin.com/in/molaya">LinkedIn</a> |
      <a href="https://github.com/catmaluci/">GitHub</a>
    </td>
    <td align="center" style="border: none;">
      <br><b>Paola Morales</b>
      <br>
      <a href="https://www.linkedin.com/in/paola-morales-/?locale=en_US">LinkedIn</a> |
      <a href="https://github.com/PaolaAMoralesP/">GitHub</a>
    </td>
  </tr>
</table>
