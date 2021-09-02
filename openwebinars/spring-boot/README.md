
# Second Hand Market


Proyecto del «Curso de Spring Boot y Spring MVC 5: Creando una aplicación con Spring Boot y Spring MVC» de OpenWebinars.

## Alumno

- [@tomascarralero](https://github.com/tomascarralero)

  
## Despliegue

Necesita usar **Redis**, para almacenar los datos de la sesión, mediante una imagen en **Docker** que se debe arrancar con:

```bash
  docker run -d --name myredis -p 6379:6379 redis
```

Para crear la base de datos por primera vez poner a `update` esta propiedad del fichero `application.properties`, después del primer arranque volver a ponerlo de nuevo a `none`:

```bash
  spring.jpa.hibernate.ddl-auto=update
```

Para inicializarla hay que descomentar el código de la clase `SecondHandMarketApplication.java`, después del primer aranque volver a comentarlo.

Puerto por defecto: `9000`


## Stack Tecnológico

**Framework:** Spring, Spring Boot, Thymeleaf

**Session Database:** Redis

**Database:** H2

  
## Enlaces relacionados

 - [Curso de Spring Boot y Spring MVC 5: Creando una aplicación con Spring Boot y Spring MVC](https://openwebinars.net/academia/portada/spring-boot/)

  