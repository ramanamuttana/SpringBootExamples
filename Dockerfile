FROM payara/server-full:5.2022.5-jdk17
COPY target/JavaEEMicroservices-0.0.1-SNAPSHOT.war $DEPLOY_DIR