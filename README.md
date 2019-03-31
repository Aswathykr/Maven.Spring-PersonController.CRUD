# CRUDApplication

This com.crud.io.zipcoder.crudapp.repository provides a starter project for a CRUD application using Spring Boot, RestControllers, and H2 for an in memory database. When using the H2 console in the browser (eg: `localhost:8080/console`) be sure to set the `JDBC URL` to match the url defined in `application-h2.properties`. The default is `jdbc:h2:mem:testdb`.

## Exercise

Using this project as a starter, you will create a Person class as an com.crud.io.zipcoder.crudapp.entity to persist to H2 with an autogenerated id, and provide access to CRUD operations on those entities using a Spring Rest Controller supporting `GET`, `PUT`, `POST`, and `DELETE` operations. Spring Boot will handle the actual HTTP traffic and database components for you, you just need to build the last few pieces of the puzzle described in this lab.

As you are working on this lab, you can demo the behavior of your `GET` endpoints using your browser. For `PUT`, `POST`, and `DELETE` you will need a more robust tool, such as [Postman](https://www.getpostman.com/) or [curl](https://curl.haxx.se/).

### Part 1:

Create a `Person` class with fields for first name, last name, and an id number.

Create a `PersonController` class with `Person createPerson(Person p)`, `Person getPerson(int id)`, `List<Person> getPersonList()`, `Person updatePerson(Person p)`, and `void DeletePerson(int id)` methods, and let it track a list of Person objects.

Add the `@RestController` annotation to your `PersonController` class, and using the "Endpoints" list in the Reference section below, add the appropriate `@RequestMapping` annotations to each of your methods. Endpoints should be at `/people` and `/people/{id}` as appropriate. You will have to use `@PathVariable` for id numbers in the URI and `@RequestBody` for Person objects sent in the requests.


### Part 2: 

Add the `@Entity` and `@Id` annotations to your Person class as shown in the Reference section. These tell Spring how to convert your Person objects to database entities when you pass them to a com.crud.io.zipcoder.crudapp.repository.

Create a `PersonRepository` interface that extends the `CrudRepository` interface. Be sure to specify the `Person` type parameter on `CrudRepository<>`. You will not need to implement this interface as Spring automatically generates an implementation at runtime.

Update your com.crud.io.zipcoder.crudapp.controller logic to use the `PersonRepository` instead of manually tracking Person objects in a list. You will need a `PersonRepository` field marked with the `@Autowired` annotation -- again, Spring will provide an implementation here automatically. You will need to use the `findAll()`, `findOne(id)`, `save(Person)` and `delete(id)` methods of `PersonRepository` to fetch and save Person objects.

### Part 3:


Now that your CRUD application is working, it's time to make sure the correct HTTP response codes are sent. Check the list of endpoints in the Reference section for the correct responses and change your `PersonController` methods to produce `ResponseEntity` objects containing the appropriate values.


### Reference

**Endpoints:**

- `POST /people` - create a new person
  - Response: `201 Created`
- `GET /people` - get the list of all people
  - Response: `200 OK` 
- `GET /people/{id}` - Get the person with id number `{id}`
  - Response: `200 OK` if found, else `404 Not Found`
- `PUT /people/{id}` - Update the person with id number `{id}`
  - Response: `200 OK` if updated, `201 Created` if a new com.crud.io.zipcoder.crudapp.entity was created
- `DELETE /people/{id}` - delete the person with id number `{id}`
  - Response: `204 No Content`

**Person class and  ID configuration for H2**:

```Java
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    ...
}
```

## Resources

- For more practice building RESTful web services, see the [Spring Boot Guides](https://spring.com.crud.io/guides)
- For an example of how to properly test an app such as this one, see [this example repo](https://github.com/Zipcoder/SpringBootWithUnitTest)
