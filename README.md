# Key-Value Cache System

## Overview
This is a Spring Boot-based **Key-Value Cache System** that provides a simple API to store and retrieve key-value pairs. It is containerized using **Docker** and supports **performance testing with Locust**.

## Features
* REST API with endpoints for setting and retrieving key-value pairs.
* Optimized for performance with **Spring Boot 3.4.4** and **Java 21**.
* Uses **Lombok** to reduce boilerplate code.
* Performance testing with **Locust**.
* Containerized with **Docker** and supports **Docker Compose**.

## Getting Started

### Prerequisites
Ensure you have the following installed:
* **Java 21**
* **Maven**
* **Docker & Docker Compose** (if running via containers)

### Installation & Running Locally
1. **Clone the repository:**

```sh
git clone https://github.com/Shreshthaaa/Key-Value-Cache
cd key-value-cache
```

2. **Build the project using Maven:**

```sh
mvn clean package
```

3. **Run the application:**

```sh
java -jar target/key-value-cache-0.0.1-SNAPSHOT.jar
```

4. **API Endpoints:**

* POST /put - Stores a key-value pair.

* GET /get - Retrieves a value by key.

### Running with Docker

**Pull Docker Image:**
```sh
docker pull shreshthaa/key-value-cache:latest
```

**Running the Container**
```sh
docker run -p 7171:7171 shreshthaa/key-value-cache:latest
```

### Performance Testing with Locust
**Running Locust Tests**
1. Install Locust:
```sh
pip install locust
```
2. Run Locust:
```sh
locust -f locustfile.py --host=http://127.0.0.1:7171
```
3. Open http://localhost:8089 in your browser and start the test.
4. For post request : **http://127.0.0.1:7171/put**
5. For get request : **http://127.0.0.1:7171/get?key={key}**

### Best Practices and Optimizations
* **Containerization**: Uses a minimal openjdk:21-jdk-slim base image.

* **Port Configuration**: Explicitly sets --server.port=7171.

* **Lombok Integration**: Reduces boilerplate code for data models.

* **Spring Boot DevTools**: Enables hot reload for faster development.

* **Performance Testing**: Uses Locust to simulate concurrent users.
