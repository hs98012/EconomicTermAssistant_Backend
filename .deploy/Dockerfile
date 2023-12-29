FROM openjdk:17
ARG JAR_FILE=./build/libs/EconomicTermAssistant_backend-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} EconomicTermAssistant_backend.jar
COPY ./build/libs/EconomicTermAssistant_backend-0.0.1-SNAPSHOT.jar /EconomicTermAssistant_backend.jar
ENTRYPOINT ["java","-jar","/EconomicTermAssistant_backend.jar", "--spring.profiles.active=prod"]
