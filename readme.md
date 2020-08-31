spring boot
---

1. 테스트 컴파일이 안된 경우,  
테스트 컴파일에 해당 경로가 있는지 확인  
testCompileClasspath
org.springframework.boot:spring-boot-starter-test:2.1.7.RELEASE
org.springframework.boot:spring-boot-starter-web:2.1.7.RELEASE



## database
테이블에 한글이 안들어가질 경우

~~~
ALTER TABLE `test`
	COLLATE='utf8mb4_general_ci',
	CONVERT TO CHARSET utf8mb4;
~~~

