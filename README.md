# Spring Boot E-Commerce Application
## Project Overview
This project is a Spring Boot-based e-commerce application that provides essential features for managing products, user accounts, and orders with MySQL as the underlying database.

## Features
### Product Management
- Search Products: Implemented product search functionality with advanced query conditions.
- CRUD Operations:
  - Create: Allows for adding new products to the inventory.
  - Read: Lists all available products with sorting and pagination.
  - Update: Enables updating existing product details.
  - Delete: Provides the ability to remove products from the inventory.
- Unit Testing: Comprehensive unit tests to ensure the reliability of the product features.

### User Account Management
- Register New Account: Users can register for a new account with email verification.
- Email Login: Implemented email-based login with password encryption using MD5 hashing.
- Password Security: Ensured passwords are stored securely with proper hashing.
- Unit Testing: Thorough unit tests to validate user-related functionalities.
  
### Order Management
- Create Order: Users can create orders, with automatic stock inventory deduction.
- Order List Query: Implemented query functionality to list all orders placed by the user.
- Order Validation: Checks for valid user IDs and manages stock levels during order creation.
- Unit Testing: Unit tests to ensure the correct functionality of order processing.
  
## Future Improvements
### Product Management
- Elastic Search: Integrate Elastic Search to improve product search capabilities.
- RBAC (Role-Based Access Control): Implement RBAC to manage user permissions and product management more effectively.
### User Account Management
- API Token Authentication: Enhance security by implementing API token-based authentication.
### Order Management
- Concurrency Handling: Address the issue of multiple users attempting to place orders simultaneously (e.g., for limited stock items).
- Order Status Management: Improve the handling of order statuses, particularly in scenarios involving payment gateways.
- Payment Gateway Integration: Integrate with a payment gateway to handle online transactions seamlessly.
