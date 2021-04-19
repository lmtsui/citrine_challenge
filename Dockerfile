FROM openjdk:15  
COPY . /lokman  
WORKDIR /lokman
ENV CLASSPATH=libs/java-json.jar:${CLASSPATH}
RUN javac -cp lib/java-json.jar -d bin src/citrine_challenge/*
RUN jar cfm citrine_challenge.jar Manifest.txt -C bin citrine_challenge
CMD ["java", "-jar", "citrine_challenge.jar"]