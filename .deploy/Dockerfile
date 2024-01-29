FROM openjdk:17
ARG JAR_FILE=./build/libs/EconomicTermAssistant_backend-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} EconomicTermAssistant_backend.jar
COPY ./src/main/resources/application.yml /config/application.yml
COPY ./src/main/resources/application-prod.yml /config/application-prod.yml
COPY ./build/libs/EconomicTermAssistant_backend-0.0.1-SNAPSHOT.jar /EconomicTermAssistant_backend.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/EconomicTermAssistant_backend.jar", "--spring.profiles.active=prod"]
