							OpenLegacy FullStack Exam

Author: Alfredo Estrada Gonzalez
  Date: 2017-08-01

				Project for expose knowlagde requested for OpenLegacy exam
				----------------------------------------------------------

ABSTRACT:

	Proposed architecture by decopuled Persistence and Services Layer

1) Contains:

	Backend Projects
	Front End Project

2) Requiriments:

	Java8
	Maven 3
	Tomcat7+
	Ant			(OPTIONAL)

3) Steps to build ( default profile is configured for use backend-jersey profile)

$	mvn clean install

3.1) Build using Jax-rs (Jersey) Backend services

$	mvn clean install -P backend-jersey

3.2) Build using Jax-rs (RestEasy) Backend services

$	mvn clean install -P backend-resteasy

3.3) Build using Spring ( MVC ) Backend services

$	mvn clean install -P backend-springmvc


3.4) Build using Spring ( BOOT ) Backend services

$	mvn clean install -P backend-springboot

4) Tasks before deploy

4.1 ) Init Derby DataBase Server
	cd OpenLegacy-FullStack-Exam/
	cd OpenLegacy-FullStack-Exam-DBEngine/target/staging/
	./run.sh
	
4.2) Install 1st time : DB scheme and data
	cd OpenLegacy-FullStack-Exam/
	cd OpenLegacy-FullStack-Exam-JPA-Persistence/target/staging/
	./run.sh

5) Deploy

5.1) Deploy manually Backend chosen services project

5.2) Deploy manually Frontend project ( OpenLegacy-FullStack-Exam-AngularFront )

6) Browse

	http://localhost:8080/olfse/


