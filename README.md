# E-Commerce Mobile Backend Application

This backend application is developed using **Java Spring Boot** and is designed to manage mobile phone products for an e-commerce platform. It provides a comprehensive REST API to perform operations like adding, retrieving, updating, and deleting mobile phone records, along with various filters such as brand, model, color, processor type, and more.

## Description

The application primarily handles mobile phone catalog management through a set of endpoints exposed via the `MobileController`. It supports the following:

- Basic CRUD operations for mobile phones
- Filtering by brand, model, color, and processor
- Querying for phones above a certain price
- Counting unique models by brand
- Working with DTOs for data transfer efficiency

It uses a `MobilePhoneService` layer to interact with the database and encapsulate business logic.

---

## Features

- ✅ Add, view, update, and delete mobile phones
- 🔍 Search by brand name, model name, processor, and color
- 📊 Get phones with price greater than a specified value
- 📦 DTO support for optimized data representation
- 📈 Count unique mobile phone models by brand

---

## Technologies Used

- Java
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Maven
- H2 / MySQL (can be configured)
- Lombok (optional, if used in models)

---

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/Mobile` | Add a new mobile phone |
| GET    | `/Mobile` | Get all mobile phones |
| GET    | `/Mobile/{id}` | Get a mobile phone by ID |
| PUT    | `/Mobile` | Edit/update a mobile phone |
| DELETE | `/Mobile/{id}` | Delete a mobile phone by ID |
| GET    | `/Mobile/brand/{brandname}` | Get phones by brand |
| GET    | `/Mobile/model/{modelname}` | Get phones by model |
| GET    | `/Mobile/color/{colortype}` | Get phones by color |
| GET    | `/Mobile/processor/{processortype}` | Get phones by processor |
| GET    | `/Mobile/greaterthan/{amount}` | Count phones priced above given amount |
| GET    | `/Mobile/unique` | Count of unique mobile phone models |
| POST   | `/Mobile/post` | Save phones using DTO |
| GET    | `/Mobile/Mobiledto` | Get all phones as DTOs |
| GET    | `/Mobile/Mobiledto/{id}` | Get phone by ID (DTO) |
| GET    | `/Mobile/Mobiledto/brand/{brandname}` | Get phones by brand (DTO) |
| GET    | `/Mobile/Mobiledto/model/{modelname}` | Get phones by model (DTO) |

---

## Getting Started

### Prerequisites

- Java
- Maven
- MySQL or H2 Database

### Build and Run

```bash
# Build the application
mvn clean install

# Run the application
mvn spring-boot:run
