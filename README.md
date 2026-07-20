**Project structure**
src/main/java/com/example/ecommerce/
├── config/
│   ├── SecurityConfig.java        # Spring Security filter chain + JWT setup
│   └── SwaggerConfig.java         # Swagger UI with Bearer token support
├── controller/
│   ├── AuthController.java        # POST /api/auth/register, /login
│   ├── ProductController.java     # GET/POST/PUT/DELETE /api/products
│   ├── CategoryController.java    # GET/POST /api/categories
│   ├── CartController.java        # GET/POST/PUT/DELETE /api/cart
│   └── OrderController.java       # POST /api/orders/place, GET /api/orders
├── service/
│   ├── AuthService.java           # Registration + login logic
│   ├── ProductService.java        # Product CRUD
│   ├── CartService.java           # Add/update/remove/clear cart
│   └── OrderService.java          # Cart → Order conversion (the interesting part)
├── entity/                        # User, Product, Category, Cart, CartItem, Order, OrderItem
├── repository/                    # JpaRepository for each entity
├── dto/
│   ├── request/                   # RegisterRequest, LoginRequest, ProductRequest, CartItemRequest
│   └── response/                  # AuthResponse, ProductResponse, CartResponse, OrderResponse
├── mapper/                        # Entity ↔ DTO conversion (no raw entities in API responses)
├── security/
│   ├── JwtUtil.java               # Token generate, extract, validate
│   ├── JwtAuthFilter.java         # Runs once per request, sets SecurityContext
│   └── UserDetailsServiceImpl.java
└── exception/
    ├── GlobalExceptionHandler.java # @ControllerAdvice — structured JSON errors
    ├── ResourceNotFoundException.java
    ├── BadRequestException.java
    └── UnauthorizedException.java

**🛒 E-Commerce Backend API**

A Spring Boot REST API for an e-commerce platform. Currently implements the foundation — user authentication with JWT and role-based access control. More features being added actively.

What's done so far
User Registration — create an account, password hashed with BCrypt
User Login — returns a JWT token on successful login
JWT Authentication — every protected route validates the Bearer token
Role-Based Access Control (RBAC) — two roles: ADMIN (full access) and USER (limited access)
Spring Security filter chain — custom JwtAuthFilter runs on every request
Input validation — request DTOs validated with @Valid, @NotBlank, @Email
Global exception handling — structured JSON error responses via @ControllerAdvice
Swagger UI — API docs auto-generated at /swagger-ui.html


 ** Tech stack**
Layer	Technology
Language	Java 17
Framework	Spring Boot 3.2.5
Security	Spring Security + JWT (jjwt 0.11.5)
ORM	Spring Data JPA + Hibernate
Database	MySQL
Build tool	Maven
API docs	springdoc-openapi (Swagger UI)



