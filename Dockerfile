FROM java
RUN	mkdir /app
COPY build/libs/DaemonProjectSample.jar /app
CMD ["java", "-jar", "/app/DaemonProjectSample.jar"]