# Usa un'immagine con OpenJDK
FROM openjdk:21-jdk-slim

# Imposta la cartella di lavoro nel container
WORKDIR /app

# Copia il file .jar nel container
COPY Maven_Test.jar /app/Maven_Test.jar

# Esegui il .jar
CMD ["java", "-jar", "Maven_Test.jar"]