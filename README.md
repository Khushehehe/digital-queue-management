# Digital Queue Management System

A submission-ready full-stack project for government office queue management.

## Stack
- React + Vite
- Spring Boot + REST APIs
- Spring Data JPA / H2 SQL database
- Spring Security + JWT + RBAC
- GitHub Actions CI

## Demo accounts
- Citizen: citizen@test.com / 1234
- Staff: staff@test.com / 1234
- Admin: admin@test.com / 1234

## Run backend
Requirements: Java 17+, Maven.
```bash
cd backend
mvn spring-boot:run
```
Backend: http://localhost:8080

## Run frontend
Requirements: Node.js 18+.
```bash
cd frontend
npm install
npm run dev
```
Frontend: http://localhost:5173

## Main flow
Citizen -> select service -> Normal/Priority -> generate token -> see wait time.
Staff -> select service -> call next -> complete/skip.
Admin -> view counters and toggle active/inactive.

## Academic concepts
- Queue ordering with priority
- Waiting-time prediction
- Counter allocation/status
- REST APIs
- JWT authentication
- RBAC
- SQL database
- CI testing workflow
