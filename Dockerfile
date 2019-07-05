FROM java:8-alpine
COPY ./src/main/java/tech/hiyinyougen/demo /usr/src/my-java-app/tech/hiyinyougen/demo
WORKDIR /usr/src/my-java-app
RUN javac tech/hiyinyougen/demo/HelloWorld.java
CMD ["java", "tech/hiyinyougen/demo/HelloWorld"]
