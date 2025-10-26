# 🧾 Report Generation App

## 📘 Overview
The **Report Generation App** is a Spring Boot–based web application that enables users to view and manage **Citizen Plans** efficiently.  
It provides functionalities for **report generation, searching/filtering, exporting to Excel & PDF, and sending reports via email**.

---

## ✨ Features

- 📊 **Report Generation**
    - Displays details of citizens including:
        - Holder Name
        - Plan Name
        - Plan Status
        - Gender
        - Start & End Dates
        - Benefit Amount

- 🔍 **Search / Filter Functionality**
    - Filter by:
        - Plan Name
        - Plan Status
        - Gender
        - Date Range

- 📧 **Email Sending**
    - Sends email notifications and reports through Gmail SMTP.

- 📂 **Export Options**
    - Export data in:
        - Excel (`.xls`)
        - PDF (`.pdf`)

- 🧰 **Tech Stack**
    - **Backend:** Spring Boot, Spring MVC, Spring Data JPA
    - **Frontend:** JSP, HTML, CSS, Bootstrap
    - **Database:** MySQL
    - **Libraries:** Apache POI, iText, JavaMailSender
    - **Build Tool:** Maven

---

## ⚙️ System Requirements

| Component | Version / Requirement |
|------------|------------------------|
| **Java** | 17 or higher |
| **Spring Boot** | 3.x |
| **MySQL** | 8.0 or higher |
| **Maven** | 3.8+ |
| **IDE** | IntelliJ IDEA / Eclipse |
| **Browser** | Chrome, Edge, or Firefox |

---

## 🧩 Project Structure
ReportGenerationApp/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── Report_Generation_App/
│ │ │ ├── Controller/
│ │ │ ├── Service/
│ │ │ ├── Repository/
│ │ │ ├── Entity/
│ │ │ └── Utils/ (Excel & PDF generator)
│ │ └── resources/
│ │ ├── application.yml
│ │ └── templates/ (JSP files)
│ └── test/
└── pom.xml

# Step 1: To Clone the Project
git init
git clone

## Git hub Repo
https://github.com/ayuuusssh/InsuranceRegistrationApp.git

---