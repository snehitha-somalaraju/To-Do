A simple To-Do List web application built with Spring Boot 3.x, Thymeleaf, and MySQL.
This project demonstrates full-stack development with Java 17, Spring Boot, role-based authentication, and CRUD operations.

**Tech Stack**
Backend: Java 17, Spring Boot 3.x (Spring MVC, Spring Data JPA, Spring Security)
Frontend: Thymeleaf, HTML5, CSS3
Database: MySQL
Build Tool: Maven
Authentication: Spring Security + BCrypt (hashed passwords)

**Features**
User Management
Register new users
Login & Logout
Password hashing with BCrypt
Role-based access (USER, ADMIN)

Task Management
Add tasks with:
Title
Description
Deadline
Priority (Low / Medium / High)
Status (Pending / Completed)
Edit and delete tasks
Filter tasks by status or priority


**Setup instructions**
1. Clone the repository
   git clone https://github.com/snehitha-somalaraju/To-Do.git
   cd todo-list
2. Make sure MySQL is running and create a database
   create DATABASE todo_db
3. Update your src/main/resources/application.properties with your credentials
   spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
   spring.datasource.username=your_mysql_user
   spring.datasource.password=your_mysql_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.thymeleaf.cache=false
4. Build and run
   mvn clean install
   mvn spring-boot:run
App will start at http://localhost:8080

**Future Improvements**
1. Add pagination for task list
2. Email notifications for upcoming deadlines
3. Dark/light theme toggle
