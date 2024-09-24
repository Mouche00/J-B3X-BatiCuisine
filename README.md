# Bati-Cuisine

## Overview

**Title:** Kitchen Construction Cost Estimation Application  
**Description:** An application for estimating the costs of kitchen construction projects.

## Context

Bati-Cuisine is a Java application designed for construction and renovation professionals. It calculates the total cost of work, taking into account materials used and labor costs, which are billed hourly. The application includes advanced features such as client management, custom quote generation, and an overview of the financial and logistical aspects of renovation projects. This project aims to provide professionals with a powerful and practical tool to accurately estimate costs and effectively manage kitchen renovation projects.

## Functional Requirements

### 1. Project Management
- Associate a client with the project.
- Add and manage components (materials, workforce).
- Associate an invoice with the project to estimate costs before work begins.
- Project characteristics:
    - `title (String)`: Title of the construction or renovation project.
    - `margin (double)`: Profit margin applied to the total cost.
    - `vatRate (double)`: Applicable VAT rate for the project.
    - `discount (double)`: Discount rate applicable for professional clients.
    - `projectStatus (Enum)`: Status of the project (Ongoing, Completed, Canceled).

### 2. Component Management
- **Materials:** Manage material costs.
    - Characteristics:
        - `name (String)`: Name of the component.
        - `price (double)`: Unit cost of the component.
        - `quantity (double)`: Quantity of components used.
        - `transportCost (double)`: Cost of transporting the material.
        - `qualityCoefficient (double)`: Coefficient reflecting the quality of the material.
- **workforce:** Calculate costs based on hourly rates, hours worked, and worker productivity.
    - Characteristics:
        - `name (String)`: Name of the component.
        - `hourlyRate (double)`: Hourly rate of labor.
        - `workHours (double)`: Number of hours worked.
        - `productivityCoefficient (double)`: Productivity factor of workers.

### 3. Client Management
- Register basic client information.
- Differentiate between professional and individual clients, affecting discounts.
- Client information:
    - `name (String)`: Client's name.
    - `address (String)`: Client's address.
    - `phone (String)`: Client's phone number.
    - `isProfessional (boolean)`: Indicates if the client is a professional.

### 4. Invoice Generation
- Generate a invoice before work begins, including cost estimates for materials, workforce, equipment, and taxes.
- Include issue and validity dates of the quote.
- Quote characteristics:
    - `overallCost (double)`: Estimated cost of the project based on quotes.
    - `issueDate (Date)`: Date the invoice was issued.
    - `validatedAt (Date)`: Date the invoice was validated.

### 5. Cost Calculation
- Integrate component costs (materials, workforce) into the total project cost calculation.
- Apply a profit margin to obtain the final project cost.
- Consider applicable taxes (VAT) and discounts.
- Manage cost adjustments based on material quality or workforce productivity.

### 6. Display of Details and Results
- Display complete project details.
- Show client and quote information.
- Generate a detailed summary of total costs including workforce, materials, taxes, and profit margin.

## Technical Requirements
- Java 8
- PostgreSQL database
- Design patterns: Singleton, Repository Pattern
- Organized in layers (e.g., Service Layer)
- Data validation (e.g., Dates)
- Java Time API for date management
- Use of Streams, Collection, Hashmap, Optional, Enum
- Git and JIRA for project management
- Generate a JAR file and include a detailed README.md