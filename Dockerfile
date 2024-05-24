FROM openjdk:8-jre-alpine
ENV PORT 8080
ADD ./build/libs/JrebelBrainsLicenseServerforJava-1.0-SNAPSHOT-all.jar /JrebelBrains.jar
CMD java -jar /JrebelBrains.jar -p $PORT

