FROM eclipse-temurin:21-jre-alpine
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#Explanation
#${JAR_FILE} app.jar  copy jar file into app.jar
# from the terminal keep this app.jar into myapp container( below command)
# docker build --build-arg JAR_FILE=demo-0.0.1-SNAPSHOT.jar -t myapp .
#1.the above  command should be run from terminal
#2. Before running make sure docker engine is running
