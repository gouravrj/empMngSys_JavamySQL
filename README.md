Employee Management System (Java + MySQL)

📌 Project Overview:
This project is a simple Employee Management System developed using Java and MySQL.
It allows users to manage employee information such as adding, updating, viewing, and deleting employee records stored in a MySQL database.

The main purpose of this project is to practice Java programming, database connectivity using JDBC, and CRUD operations.

⚙️ Technologies Used:
Java
MySQL
JDBC (Java Database Connectivity)
SQL
IDE: Eclipse

🚀 Features:
Add new employee records
View employee details
Update employee information
Delete employee records
Store and retrieve employee data from MySQL database
Basic database connectivity using JDBC

🗂️ Project Structure:
empMngSys_JavamySQL
│
├── src/
│   ├── database connection files
│   ├── employee model classes
│   └── main application logic
│
└── SQL files / database scripts


🗄️ Database Setup
Install MySQL Server
Create a database
CREATE DATABASE employee_db;
Create a table for employees
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DOUBLE
);
Update your database username and password in the Java database connection file.


▶️ How to Run the Project
Clone the repository
git clone https://github.com/gouravrj/empMngSys_JavamySQL.git
Open the project in your preferred Java IDE
Configure the MySQL database connection
Run the main Java file


📚 What I Learned
Java programming fundamentals
JDBC database connectivity
SQL queries and database management
Implementing CRUD operations
Structuring a simple backend project
