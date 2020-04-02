# Getting Started

### A propos
* Prototype simplissime de microservice de paiement basé sur Spring Boot
* Intègre une base H2 in memory
* Port d'écoute : 8080

### Environnement de développement
Eclipse 2019/12 intégrant Spring Tools 4.2.6 | Maven 3.5.3

### Plateformes
OpenJDK 8 | Spring Boot 2.2.5

### Exécution
##### Exécuter ligne de commande (depuis le dossier racine payment - contenant pom.xml)
* On considère Maven installé - Maven et le JDK référencés dans le path
 
mvn clean install

java -jar target/payment-0.0.1-SNAPSHOT.jar

* Si Maven n'est pas installé (utilisation du wrapper Mvn intégré au projet)

mvnw clean install

java -jar target/payment-0.0.1-SNAPSHOT.jar

* Pour stopper le service : 

Ctrl+C dans le terminal

##### Exécuter le service depuis depuis Eclipse  intégrant le plugin Spring Tools
clic <droite> sur le projet | Run As Maven clean | Run As Maven Install | Run As Spring Boot App

Note : pas besoin de refaire un mvn install à chaque modification du code après le premier mvn install

### Exécuter le service dans un container Docker 
* Docker doit être installé et le service construit (mvn install)



* Création de l'image (depuis le dossier racine payment - contenant Dockerfile) : 

docker build -t payment:1.0 .

(le point en fin de commande indique que le Dockerfile est dans le dossier courant)

* Si vous voulez supprimer l'image :

docker rmi payment:1.0

* Lancement du container :

docker run --name pymt -p 8080:8080 -t payment:1.0

(--name est optionnel. Permet de donner un nom personnalisé au container)

* Si votre port d'écoute local 8080 est occupé, vous pouvez utiliser un autre port local pour accéder au service :

docker run --name pymt -p <votre port local>:8080 -t payment:1.0

* Pour stopper le container : 

docker stop <nom du container>

* Si le container n'a pas été explicitement nommé, pour retrouver le nom :

docker ps & repérer le nom indiqué dans la colonne NAMES


### Accéder au point de terminaison
le service intègre la documentation interactive Swagger 2 /OpenAPI Specification qui :
* décrit ce que le point de terminaison expose (partie payment-controller)
* permet d'exécuter des requêtes vers le service de paiement

URL : <http://localhost:8080/swagger-ui.html>

Avant de pouvoir lister des ordres de paiement via GET, il faut poster des ordres de paiement.

Note : Comme la base H2 embarquée est en mémoire, les données sont perdues à chaque redémarrage.

Vous pouvez aussi utiliser Postman pour tester.


### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/maven-plugin/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.2.5.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [doc officielle Docker - installer selon l'OS et démarrer avec Docker](https://docs.docker.com/)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

