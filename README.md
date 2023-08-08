# API AGGREGATION SERVICE

The assignment is implementing the API aggregation service.

## Prerequisites

Make sure you have the following tools installed on your machine:

- Java Development Kit (JDK) 17 or higher
- Maven
- Docker (optional, if you want to use a Docker container to run the project)

## Setup

1. Clone the repository:

sh
git clone https://github.com/mauricio-delrei/aggregation-service.git

# Running the Project
Option 1: Running Locally
Run the project using Maven:

mvn spring-boot:run

Option 2: Running with Docker (if you've built the image)
Run a Docker container using the built image:
docker run -p 8081:8081 xyz-assessment-backend

# Testing the Project
To run automated tests for the project, execute the following command:
mvn test

# Accessing the API
After starting the project, you can access the API at:
POST http://localhost:8081/aggregation

{
"pricing": ["NL", "CN"],
"track": ["109347263", "123456891"],
"shipments": ["109347263", "123456891"]
}

# Contributions
If you'd like to contribute to this project, feel free to fork, make your changes, and submit a pull request.

Please adjust the instructions based on your project's actual structure and the technologies you're using.
Ensure you provide clear and concise information so that others can easily follow the instructions and run the project.