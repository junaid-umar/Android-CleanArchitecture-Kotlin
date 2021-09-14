# Welcome to CleanCrypto App.

It's an app built using the MVVM, Repository Pattern and Clean Architecture. It uses the coinranking Api to display coins and Exchanges.


## Architecture
App is developed with Clean Architecture to maintain sepration of concern.

### Domain Layer

This layer contains pure business logic independent of platform and independent of other layers. This layer contains:

  1.  Business Models
  2.  Repositories
  3.  Use Cases

### Data Layer

This layer contains repository implementation provided by Domain layer. 

## Presentation Layer
This layer contains android specific code. it handles user interactions and actions.


## Test
This applications is covered with unit and integration test. 



## Libraries
  1.  Material Design - UI design
  2.  AndroidX - ViewModel, LiveData
  3.  Coroutines
  4.  Hilt -  Dependency Injection
  5.  Navigation Component - User navigation
  6.  Glide - Loading Images
  7.  Room - Database Storage
  8.  Retrofit - API Calls
  9.  Junit, mockito, MockWebServer, hilt Testing, Truth 


## Backlog

UI Test and UI improvement

