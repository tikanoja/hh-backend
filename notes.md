ctrl+shift+p
create maven project
3.2.2. -> not listed, prob deprecated -> 3.3.2
Java
group id fi.haagahelia
artifact id [project name] no spaces
Jar
Java ver 17
add Spring Web, Spring Boot DevTools

open xampp manager (applications->xampp->manager-osx)
start new sql db
http://localhost/phpmyadmin/
create db test
comment/uncomment the config at application.properties
comment/uncomment the tests to match the db solution being used

running maven
mvn spring-boot:run

reinstall dependencies
mvn clean install

run tests
mvn clean test
