# Bike Rental REST API

This kata has for goal to create a v2 of this API and take into account new features.

At the same time, v1 will have to keep working as usual and live within the same code repo.

The business logic is really poor here and you have to focus on the way to organize your project to have 2 different versions of a given API.

In this scenario, you operate as a bikes renter like Velib in Paris, France.

## V1 API
The V1 API exposes the following endpoints and operations

### Bikes
Endpoint : _/api/v1/bikes_

### Operations
```
GET /api/v1/bikes/{bikeId} to get informations about a bike
```

## Rental
Endpoint : /api/v1/rentals

### Operations
```
POST /api/v1/rentals/ to create a new rental
The body must contain a rental without its id.
```

```
PUT /api/v1/rentals/{rentalId} to update or end a rental
The body must contain the updated rental.
```

## User
Endpoint : _/api/v1/users_

### Operations
```
GET /api/v1/users/{userId} to get informations about a user
```
```
POST /api/v1/users/ to create a new user
The body must contain the new user to create.
```
```
PUT /api/v1/users/{userId} to update a user
The body must contain the user to update.
```
```
DELETE /api/v1/users/{userId} to delete a user
```

## V2 API
For this API version, we have these new needs :
* You will be able to rent electric scooter and bikes
  * The endpoint changes : /api/v2/equipments
  * The returned object will have an identifier to know what kind of equipment it is
  * The returned object will have an identifier to know if it is electric
* We need to have information on bikes stations :
  * New endpoint : /api/v2/stations
  * If the station is in altitude, the user will have bonus
  * Ability to find near stations when one is full

And there is also in change in the users API : the id will be a string and no more an integer

## V2 API development
How can you do to do that by having just one code base and be able to improve the V2 in the future without being annoyed by V1 ?

## How to run this project
You just need to have a JDK 17 and Maven.

To run the project, just type :
```shell
mvn spring-boot:run
```