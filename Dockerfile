 FROM eclipse-temurin:17-jdk-jammy
VOLUME /tmp
EXPOSE 9090
ARG JAR_FILE=target/Biseccion_service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY libbiseLibJava.so /usr/local/lib/
RUN ldconfig /usr/local/lib

ENTRYPOINT ["java", "-Djava.library.path=/usr/local/lib", "-jar", "app.jar"]