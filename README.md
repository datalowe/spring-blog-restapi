# Blog REST API built with Spring Boot
This is a simple REST API I plan on using as the backend for the new version of my blog at [datalowe.com](https://datalowe.com). It's built with [Spring Boot](https://spring.io/projects/spring-boot).

## Deployment
### Docker / Docker Compose
Run `docker compose up -d` to trigger download of the official [postgres](https://hub.docker.com/_/postgres/) image and (multistage) building of an image for the Spring Boot app. Once image download/build has finished, the images are used to spin up containers.

You may update important environment variables (used through 'src/main/resources/application.properties'), e.g. database username and password, in the 'docker-compose.yaml' file.

### Development mode
You need to have openJDK 17 and a compatible version of maven installed.
1. Ensure that a postgresql database is running locally.
2. Update 'src/main/resources/application.properties' with database name/username/password.
3. Run `mvn clean package` in the root directory.
4. Run `java -jar target/blogapi-0.0.1-SNAPSHOT.jar` (you might need to update the version number in the filename).

## Endpoints
All endpoints are __prepended__ with `http://localhost:8080/api/v1` and return JSON responses.

### Posts
* `GET /post`: Get an array of all blog posts.
* `POST /post`: Create a new blog post, by sending a JSON object which includes keys `title`, `body`, `blurb` and `slug`.
* `GET /post/{id}`: Get a single blog post.
* `DELETE /post/{id}`: Delete a single blog post.

### Tags
* `GET /tag`: Get an array of all post tags.
* `POST /tag`: Create a new post tag, by sending a JSON object which includes key `name`.
* `GET /tag/{id}`: Get a single tag.
* `DELETE /tag/{id}`: Delete a single tag.

Example request: `curl http://localhost:8080/api/v1/post/1`.