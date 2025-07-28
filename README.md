# Banking Backend System (Spring Boot)

This is a backend banking application built with Spring Boot. It simulates core banking operations such as account creation, balance updates, and fund transfers. The application uses an H2 in-memory database to persist user account data and is designed to demonstrate a basic service-controller-repository architecture.

## Features

- User sign-up with username, password, email, and initial balance
- Deposit functionality to increase account balance
- Fund transfer between registered users
- Basic error handling for invalid user IDs and insufficient funds
- RESTful API design using Spring Web and Spring Data JPA

## Technologies Used

- Java 17
- Spring Boot
  - Spring Web
  - Spring Data JPA
- H2 Database (in-memory)
- Maven

## API Endpoints

| Method | Endpoint               | Description                         |
|--------|------------------------|-------------------------------------|
| POST   | `/api/account/signUp`       | Create a new user account           |
| POST   | `/api/account/updateBalance`| Deposit funds into an account       |
| POST   | `/api/account/fundTransfer` | Transfer funds between two users    |
| GET    | `/api/account/demo`         | Simple GET test with query param    |

## Example JSON Requests

**Sign Up:**
```json
{
  "userName": "alice",
  "password": "secure123",
  "email": "alice@example.com",
  "balance": 500.0
}
