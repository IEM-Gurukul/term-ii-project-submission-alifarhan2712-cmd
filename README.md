[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/pG3gvzt-)
# PCCCS495 – Term II Project

## Project Title
Course Registration System using Composite Pattern for Course Modules

---

## Problem Statement (max 150 words)
In many educational institutions, course registration is often handled manually or through basic systems that lack flexibility and structure. Students face difficulty in selecting courses, especially when courses are organized into groups such as core, electives, and advanced modules. Existing systems do not efficiently represent hierarchical relationships between courses or allow easy management of grouped modules. This creates confusion, redundancy, and inefficiency in the registration process. Therefore, there is a need to develop a structured and scalable Course Registration System that allows students to view, select, and manage courses effectively while supporting grouped course structures using appropriate software design principles.

---

## Target User


* College and university students (for course selection and registration)
* Academic administrators (for managing course structures and modules)


---

## Core Features
View available courses (grouped into modules)
Register/select courses
Prevent duplicate registrations
View selected courses
Calculate total credits automatically

- 
- 
- 

---

## OOP Concepts Used

- Abstraction:
- Inheritance:
- Polymorphism:
- Exception Handling:
- Collections / Threads:

---

## Proposed Architecture Description
A simple layered architecture with a menu-driven console interface. The presentation layer handles user input/output, the application layer processes course selection and validation logic, and the design layer uses the Composite Pattern to manage individual courses and grouped modules in a hierarchical structure.

---

## How to Run
Install JDK and set up Java environment
Save the program as CourseRegistrationSystem.java
Open terminal/command prompt in the file location
Compile: javac CourseRegistrationSystem.java
Run: java CourseRegistrationSystem
Follow on-screen menu to use the system

---

## Git Discipline Notes
Minimum 10 meaningful commits required.
Initial project setup
Added CourseModule interface
Implemented IndividualCourse class
Implemented CourseGroup (Composite Pattern)
Added menu-driven user interface
Implemented course registration logic
Added duplicate course validation
Implemented total credit calculation
Added error handling
Final code optimization
