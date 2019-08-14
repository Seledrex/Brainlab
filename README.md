# Brainlab

Coding assessment for Brainlab.

## Description

This REST API is used to perform mathematical operations.

## Technology

- IntelliJ
- Java
- Maven
- Javalin
- JUnit
- Rest Assured

## Routes

/calculator/add

- Description: sums together a list of operands
- Query params:
    - operands: a list of comma separated floating point values
- Response:
    - Success: {"sum": value}
    - Failure: {"error": message}
    
## Instructions

1. Install Java JDK 12.0.1 (or similar)
2. Open project in IntelliJ
3. Run App or Tests

The web server will be run on localhost.

- http://localhost:5000
- http://localhost:5000/calculator/add

## Example

Request: http://localhost:5000/calculator/add?operands=-7,7  
Response: {"sum": 0.0}
