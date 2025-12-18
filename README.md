# Google News Clone - Backend

This is the Spring Boot backend service for the Google News Clone application. It acts as a proxy server that communicates with **TheNewsAPI**, handles data filtering, and serves clean JSON data to the React frontend.

## 🚀 Tech Stack
* **Java 21+**
* **Spring Boot 3.x**
* **Maven**
* **Spring Web** (REST API)
* **Spring Reactive Web** (RestClient for external API calls)
* **Lombok** (Boilerplate reduction)

## ✨ Features
* **Proxy API:** Fetches data securely from `thenewsapi.com` so API keys are not exposed to the frontend.
* **Smart Filtering:** Fetches a buffer of 12 articles and returns valid ones to ensure high data quality.
* **Search & Pagination:** Supports searching by keyword, filtering by category, and pagination.
* **CORS Configured:** Pre-configured to allow requests from the React frontend (`localhost:5173`).
* **Timeout Handling:** Custom read timeouts configured to handle slow upstream API responses.

## 🛠️ Setup & Installation

### 1. Prerequisites
* Java 17 or higher installed.
* An API Key from [TheNewsAPI](https://www.thenewsapi.com/).

### 2. Clone the Repository
```bash
git clone [https://github.com/hasinduudara/news-backend.git](https://github.com/hasinduudara/news-backend.git)
cd news-backend
