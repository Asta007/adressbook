# AdressBook

## 📝 Description
**AdressBook** est une application de base permettant de tester les fonctionnalités CRUD (Create, Read, Update, Delete) sur une seule entité. Ce projet sert également de support pour l'implémentation de certaines méthodologies de codage apprises en Master 2.

L'application est développée avec **Spring Boot** et utilise **Spring Data JPA** pour l'accès aux données, avec **Microsoft SQL Server** comme base de données.

---

## 🚀 Technologies utilisées

- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Data JPA**
- **Spring Validation**
- **Spring Web**
- **Microsoft SQL Server (JDBC Driver)**
- **Lombok**

---

## Concepts Implémentés

- **CRUD Contact**
- **Authentification Keycloak**
- **Gestion des Exception [ NotFound, AlreadyExist ]**
- **Authentification Keycloak**
- **Test Junit**

---

## ⚙️ Installation et exécution

###  Configuration de la base de données
Dans le fichier `application.properties` ou `application.yml`, configure ta connexion à la base de données :
```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=adressbook
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## 🛠️ Open Api

L'application expose une API REST permettant de gérer une entité (ex. : `Contact`).
> **http://localhost:8080/swagger-ui/index.html**

| Méthode  | Endpoint         | Description                       |
|----------|-----------------|-----------------------------------|
| `GET`    | `/contacts`      | Récupérer tous les contacts      |
| `GET`    | `/contacts/{id}` | Récupérer un contact par ID      |
| `POST`   | `/contacts`      | Créer un nouveau contact        |
| `PUT`    | `/contacts/{id}` | Mettre à jour un contact        |
| `DELETE` | `/contacts/{id}` | Supprimer un contact            |

Les requêtes `POST` et `PUT` Json
```json
{
  "firstName": "Emma",
  "lastName": "Lambert",
  "phoneNumber": "0656789012",
  "email": "emma.lambert@example.com",
  "address": "7 Place Bellecour, Lyon",
  "dateOfBirth": "1988-03-18"
}
```

---
## Keycloak with Docker


### Docker Command Keycloack
````bash
docker run -p 8080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.1.2 start-dev
````

### Docker Compose Keycloack
````bash
docker compose -f .\docker-compose-keycloack.yml up -d
````
### Keycloack User
> Odd / Odd@lyoko.com / Lyoko123
> Jeremy / jeremy@lyoko.com / Lyoko123

### Keycloack Token link
> **http://localhost:8081/realms/ISI_Spring/protocol/openid-connect/token**

### keycloack Link param

````json
{
  "grant_type" : "password",
  "client_id" : "adressbook-client",
  "username" : "odd",
  "password" : "Lyoko123"
}
````
### Ressources

> * **Ali Bouali | Spring boot 3 Keycloak integration for beginners :** https://www.youtube.com/watch?v=vmEWywGzWbA

> * **Coding With Armand | Sécurisez votre application avec Keycloak :** https://www.youtube.com/watch?v=Qah3Tc85rP4