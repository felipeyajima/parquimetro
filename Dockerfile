FROM azul/zulu-openjdk:17.0.8.1-17.44.53
ADD target/parquimetro-app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

