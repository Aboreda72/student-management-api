# Student & Enrollment Management System (Backend API)

A robust, enterprise-grade RESTful API built with **Spring Boot 4** and **Java 21** to manage university/school operations. The system handles student profiles, academic departments, course catalogs, and secure student enrollments, protected by Keycloak OAuth2 authentication.

## 🚀 Key Features

- **OAuth2 Authentication:** Integrated **Spring Security** with **OAuth2 Resource Server** using JWT tokens issued by an external Identity Provider (e.g., Keycloak).
- **Student & Account Management:** Full CRUD operations for managing student profiles and system accounts.
- **Academic Hierarchy:** Structure for managing university **Departments** and their offered **Courses**.
- **Enrollment Logic:** Core business service handling student course registration with strict validation rules.
- **Database Architecture:** Powered by **PostgreSQL** with optimized Hibernate/JPA queries.

## 🛠️ Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 4 (Spring Web, Spring Security, Spring Data JPA)
- **Database:** PostgreSQL
- **Security:** OAuth2 / JWT (Resource Server)
- **Other Tools:** Lombok, Jakarta Validation

## 💻 How to Run Locally

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/your-username/student-management-api.git](https://github.com/your-username/student-management-api.git)