application.properties

spring.application.name=ck

spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.url=jdbc:mariadb://localhost:3306/cuoiky
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.MariaDBDialect

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

#logging.level.org.springframework.security=DEBUG


dependencies {

  implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

 implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'

 implementation 'org.springframework.boot:spring-boot-starter-web'

 compileOnly 'org.projectlombok:lombok'
   
developmentOnly 'org.springframework.boot:spring-boot-devtools'
 
 runtimeOnly 'org.mariadb.jdbc:mariadb-java-client'

 annotationProcessor 'org.projectlombok:lombok'

testImplementation 'org.springframework.boot:spring-boot-starter-test'
    
 testImplementation 'org.springframework.security:spring-security-test'
    
 testRuntimeOnly 'org.junit.platform:junit-platform-launcher'




 implementation 'net.datafaker:datafaker:2.4.2'

}



## GIỮA KỲ TOMCAT
Bước 1: Add Dependencies

    jakarta.servlet
    
    jakarta.servlet.jsp
    
    jakarta.servlet.jsp.jstl
    
    com.fasterxml.jackson.core
    
    org.glassfish.web
    
    com.microsoft.sqlserver
    
    org.mariadb.jdbc
    
    org.projectlombok
    
    jakarta.annotation
