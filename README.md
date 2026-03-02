# 🌿 PlantPal  
**Your perfect plant(s), predicted.** 

**Are you a serial plant killer? If so, today is your lucky day.**


PlantPal is a quiz-based plant recommendation web application built with **Spring Boot** and **Thymeleaf**.

Users answer a short set of questions about their environment and preferences. The system evaluates their responses against a structured plant dataset and returns a suitable plant recommendation.

---

## Overview

PlantPal predicts which plant is best suited to a user’s:

- Environment (Indoor / Outdoor / Both)
- Care level (Easy / Medium / Hard)
- Growth speed (Fast / Medium / Slow)
- Pet safety preference
- Edibility preference

The recommendation is generated through a scoring algorithm that compares user input to plant attributes stored in JSON.

---

## Tech Stack

- **Java**
- **Spring Boot**
- **Thymeleaf**
- **Jackson (JSON processing)**

Core concepts applied:

- MVC architecture  
- DTO pattern  
- Enum-based validation  
- JSON deserialization  
- Scoring & ranking logic  

---

## How It Works

1. Plant data is loaded from a JSON dataset at startup.
2. Enums enforce valid attribute values.
3. Users complete the quiz.
4. The application scores each plant against the submitted answers.
5. A suitable plant recommendation is displayed as a structured card.

If the dataset contains invalid enum values, the application fails at startup (fail-fast validation).

---

## Run Locally

```bash
./mvnw spring-boot:run
```
or
```
mvn spring-boot:run
```

Open:

```
http://localhost:8080
```

---

## Future Scope

- Search and filtering across the full plant collection  
- React or Next.js frontend  

---


Take the quiz to discover your best-suited plant pal! **The journey towards a thousand blooms begins with just a handful of seeds.** 