FROM openjdk:21
WORKDIR /
ADD target/rowe-portfolio-1.0-SNAPSHOT.jar app.jar
RUN useradd -m myuser
USER myuser
EXPOSE 8090
CMD java -jar -Dspring.profiles.active=prod app.jar