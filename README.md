# Digital Queue Management System

A full-stack web application for managing queues in government offices. The system allows citizens to generate queue tokens, staff to manage and process tokens, and administrators to monitor counters.

## Technology Stack

* **Frontend:** React.js + Vite
* **Backend:** Spring Boot + REST APIs
* **Database:** H2 SQL Database + Spring Data JPA
* **Authentication:** Spring Security + JWT
* **Authorization:** Role-Based Access Control (RBAC)
* **CI:** GitHub Actions
* **Queue Management:** Normal and Priority Queue
* **Prediction:** Estimated waiting time based on queue position and service time

##  User Roles

### Citizen

* Select a government service
* Choose Normal or Priority token
* Generate a token
* View token status
* View estimated waiting time

### Staff

* View waiting queue
* Call the next token
* Priority tokens are processed before normal tokens
* Complete or skip tokens

### Admin

* View queue statistics
* Monitor counters
* Activate or deactivate counters

##  Demo Accounts

| Role    | Email                                       | Password |
| ------- | ------------------------------------------- | -------- |
| Citizen | [citizen@test.com](mailto:citizen@test.com) | 1234     |
| Staff   | [staff@test.com](mailto:staff@test.com)     | 1234     |
| Admin   | [admin@test.com](mailto:admin@test.com)     | 1234     |

## ▶ Running the Project

### 1. Start the Backend

Requirements:

* Java 17 or higher
* Windows

Open PowerShell:

```powershell
cd backend
.\run-backend.bat
```

The backend runs at:

`http://localhost:8080`

### 2. Start the Frontend

Open another PowerShell terminal:

```powershell
cd frontend
npm install
npm run dev
```

The frontend runs at:

`http://localhost:5173`

Open the frontend URL in your browser.

##  Main System Flow

```text
Citizen
   ↓
Select Service
   ↓
Choose Normal / Priority
   ↓
Generate Token
   ↓
View Queue Position & Estimated Wait
   ↓
Staff Calls Next Token
   ↓
Token Served
   ↓
Token Completed
```

##  Key Features

* Digital token generation
* Normal and priority queues
* Priority-based queue processing
* Estimated waiting-time prediction
* Staff token management
* Counter activation/deactivation
* Real-time dashboard updates
* JWT-based authentication
* Role-based access control
* REST API architecture
* SQL database using H2
* GitHub Actions CI workflow

##  Academic Concepts Demonstrated

* Queue data structures and priority handling
* Waiting-time estimation
* Counter allocation and management
* RESTful APIs
* Spring Boot architecture
* Database operations using JPA
* JWT authentication
* Role-Based Access Control
* Frontend-backend integration
* Continuous Integration using GitHub Actions

##  Project Structure

```text
digital-queue-management/
│
├── backend/
│   ├── src/
│   ├── run-backend.bat
│   ├── run-backend.ps1
│   └── pom.xml
│
├── frontend/
│   ├── src/
│   ├── package.json
│   └── vite.config.js
│
├── .github/
│   └── workflows/
│
├── .gitignore
└── README.md
```

##  Project Objective

The objective of this project is to develop a digital queue management system that reduces physical waiting, improves queue organization, supports priority-based processing, and provides staff and administrators with tools to efficiently manage government office queues.

##  Project Status

The core system is implemented and tested with Citizen, Staff, and Admin workflows.
