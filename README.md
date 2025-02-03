# Online Bike Shop

This is an online bike shop application built with Java, Maven, and Spark. 
It allows users to view products by category, select a products for getting more detailed information about it, 
and see models of different colors for getting a better overview of a product.

## Features

- View products by category
- Select product and view detailed information
- Select product colors and view corresponding images
- RESTful API for retrieving product data by category

## Technologies Used

- Java 20 or higher
- Maven
- Spark
- PostgreSQL
- HikariCP
- Gson

## Getting Started

### Prerequisites

- Java 20 or higher
- Maven
- PostgreSQL

### Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/online-bike-shop.git
   cd online-bike-shop

2. Set up the PostgreSQL database:  
    Create a PostgreSQL database.
    Update the database connection details in the DatabaseConnection class.
    Run the SQL script in the database to create the tables and insert the data.

3. Build the project:  
  mvn clean install

4. Run the application:  
  mvn exec:java -Dexec.mainClass="org.example.BikeShop"
  Access the application:
  Open your browser and go to http://localhost:8002/products/emtb, 
http://localhost:8002/products/mountainbikes or http://localhost:8002/products/accessories.