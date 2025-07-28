# IoT Monitoring System

This project is a personal IoT backend system that collects sensor data from microcontrollers (e.g., Arduino, ESP32) and processes it through a Spring Boot REST API. It includes basic functionality for storing and retrieving sensor logs, as well as device registration. The goal was to understand the data flow between hardware and software in a full IoT pipeline.

## Project Overview

- Collects real-time data from IoT devices using HTTP requests (or MQTT if extended).
- REST API built with Spring Boot handles incoming data and stores it.
- Data is persisted using H2 (in-memory) or MySQL (for persistent storage).
- Simple dashboard or Postman can be used to test API endpoints and view data.
- Modular design allows for easy expansion into real-world applications.

## Technologies Used

- Java 17
- Spring Boot (Web, JPA)
- H2 Database / MySQL
- Arduino IDE + C++ (for device code)
- Postman (for API testing)

## Features

- Device registration endpoint
- Sensor data logging endpoint (temperature, humidity, etc.)
- Retrieve device-specific data
- In-memory or persistent SQL storage
- Structured using controller/service/repository layers

## Sample Endpoints

- `POST /api/device/register` – register a new device
- `POST /api/device/data` – log sensor data
- `GET /api/device/logs/{deviceId}` – fetch historical data for a device
