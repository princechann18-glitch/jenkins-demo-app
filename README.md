# Jenkins Demo App

A production-ready Spring Boot application designed for CI/CD demonstration with Jenkins.

## Overview

This project showcases best practices for containerized Spring Boot applications with automated CI/CD pipelines using Jenkins.

## Prerequisites

- Java 17 or higher
- Maven 3.8.1 or higher
- Docker (for building and running containers)
- Jenkins (for CI/CD pipeline execution)

## Project Structure

```
jenkins-demo-app/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── DemoApplication.java      # Main Spring Boot application class
│   │   │   └── HelloController.java      # REST controller
│   │   └── resources/
│   │       └── application.properties    # Application configuration
│   └── test/
│       └── java/com/example/demo/
│           └── DemoApplicationTests.java # Unit tests
├── pom.xml                                # Maven configuration
├── Dockerfile                             # Docker build configuration
├── Jenkinsfile                            # Jenkins CI/CD pipeline
├── .gitignore                             # Git ignore rules
└── README.md                              # This file
```

## Building the Application

### Maven Build

```bash
# Clean and package the application
mvn clean package

# Run tests
mvn test

# Build with JaCoCo code coverage
mvn clean package jacoco:report
```

### Docker Build

```bash
# Build Docker image
docker build -t jenkins-demo-app .

# Run Docker container
docker run -p 8080:8080 jenkins-demo-app
```

## API Endpoints

### Hello Endpoint
- **URL:** `http://localhost:8080/hello`
- **Method:** GET
- **Response:** 
```json
{
  "message": "Hello CI/CD"
}
```

## Running Locally

### Using Maven
```bash
mvn spring-boot:run
```

### Using Docker
```bash
# Build the image
docker build -t jenkins-demo-app .

# Run the container
docker run -p 8080:8080 jenkins-demo-app

# Access the application
curl http://localhost:8080/hello
```

## Jenkins Pipeline

The Jenkinsfile defines the following stages:

1. **Checkout** - Clones the repository
2. **Build** - Compiles the source code
3. **Test** - Runs unit tests with JUnit
4. **Package** - Creates executable JAR file
5. **Docker Build** - Builds Docker image
6. **Archive Artifacts** - Stores build artifacts and test reports

## Technologies Used

- **Spring Boot 3.2.0** - Modern Java framework
- **Java 17** - Latest LTS Java version
- **Maven** - Build and dependency management
- **JUnit 5** - Unit testing framework
- **JaCoCo** - Code coverage analysis
- **Docker** - Container orchestration
- **Jenkins** - CI/CD automation

## Configuration

### application.properties

The application is configured via `src/main/resources/application.properties`:

```properties
spring.application.name=jenkins-demo-app
server.port=8080
logging.level.root=INFO
```

## Testing

Run tests with coverage:

```bash
mvn clean test jacoco:report
```

Coverage reports will be available at: `target/site/jacoco/index.html`

## CI/CD Workflow

1. Commit code to repository
2. Jenkins detects changes and triggers the pipeline
3. Code is checked out, built, and tested
4. JAR artifact is packaged
5. Docker image is built
6. Test reports are published
7. Build artifacts are archived

## Troubleshooting

### Maven Build Fails
```bash
# Clear Maven cache
mvn clean install
```

### Docker Build Fails
```bash
# Ensure Docker daemon is running
docker --version
```

### Port Already in Use
```bash
# Change port in application.properties
server.port=8081
```

## License

MIT License

## Contributing

1. Fork the repository
2. Create feature branch
3. Commit changes
4. Push to branch
5. Create Pull Request

## Support

For issues and questions, please create a GitHub issue.