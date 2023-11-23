# Countrys API 🧑‍💻 

![Countrys-API](https://socialify.git.ci/EcossB/Countrys-API/image?font=Jost&language=1&logo=https%3A%2F%2Fth.bing.com%2Fth%2Fid%2FR.5f2ab7897d6c8b40c9e70eb400a833b2%3Frik%3D4veMJFnCYZJVTA%26pid%3DImgRaw%26r%3D0&name=1&pattern=Diagonal%20Stripes&theme=Light)

#### This project is an API that provides information about countries, including details such as name, description, continent, flag, images, and more. 🧑‍💻 

Basically, it's an API about countries that allows you to:

* Query countries by name.
* Query countries by continents.
* Get information about famous places, hotels, flights, and gastronomy of the requested country.

Each REST method has security thanks to Spring Security, so to access each API method, you need to be authenticated and authorized through JWT.

### What technologies did I use to create this project? 🧑‍💻 

* Java 17
* SpringBoot
* JPA
* Lombok
* Flyway
* MySQL 

As a dependency manager, I used Maven.

#### All these technologies were used to create this project, they are widely used technologies in the Spring Boot with Java ecosystem.

### Prerequisites 🧑‍💻 

To run this project, you need to have the following technologies installed on your machine:

* Java SDK > 17 
* MySQL (> 8.0)
* Insomnia to consume the API. 

### How to Run the Project on Your Machine?

* The first thing you need to do is clone this repository.
* You must create the "application.properties" file in the resource folder to add the connection string and thus be able to connect to the database.
* Create an environment variable called JWT_SECRET so that you can create JWTs and authenticate users.

That's it! This is how you can have the project on your machine to run.

## API References 🧑‍💻 

#### Get all countries

```http
 GET /paises
```

| Type     | Description                |
| :------- | :------------------------- |
| `string` | Devuelve un 200 con todos los paises listados. |

#### Get countries by name

```http
  GET /paises/pais/{nombre}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nombre`      | `string` | **Required**. nombre del pais para hacer fetch |

#### Get countries by continents

```http
  GET /paises/continentes/{continente}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `continente`      | `string` | **Required**. nombre del continente para hacer fetch |

## 🧑‍💻 Credits 🧑‍💻
Here are my different social medias where you can reach me:
* IG: erwincossb
* Github: EcossB
* Twitter: ErwingCossb
* Linkedin: www.linkedin.com/in/erwingcossb
