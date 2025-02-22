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

## ⚙️ Installation et exécution

### 📌 Prérequis
Avant de lancer le projet, assure-toi d'avoir installé :

- **JDK 17**
- **Maven**
- **SQL Server** (ou une base de données compatible avec les dépendances)

### 📥 Cloner le projet
```sh
git clone https://github.com/ton-repo/adressbook.git
cd adressbook
```

### 🛠️ Configuration de la base de données
Dans le fichier `application.properties` ou `application.yml`, configure ta connexion à la base de données :
```properties
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=adressbook
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### ▶️ Lancer l'application
Compile et exécute l'application avec Maven :
```sh
mvn spring-boot:run
```

---

## 🛠️ Fonctionnalités CRUD

L'application expose une API REST permettant de gérer une entité (ex. : `Contact`).

| Méthode  | Endpoint         | Description                       |
|----------|-----------------|-----------------------------------|
| `GET`    | `/contacts`      | Récupérer tous les contacts      |
| `GET`    | `/contacts/{id}` | Récupérer un contact par ID      |
| `POST`   | `/contacts`      | Créer un nouveau contact        |
| `PUT`    | `/contacts/{id}` | Mettre à jour un contact        |
| `DELETE` | `/contacts/{id}` | Supprimer un contact            |

Les requêtes `POST` et `PUT` Json

### Contact
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

## ✅ Tests
L'application intègre des tests unitaires et d'intégration. Pour les exécuter, lance :
```sh
mvn test
```

---

## 📌 Méthodologies de codage appliquées
Ce projet met en œuvre certaines bonnes pratiques et patterns vus en Master 2 :

- **Architecture en couches (Controller, Service, Repository)**
- **Utilisation de Lombok pour réduire le boilerplate code**
- **Validation des données avec `@Valid` et `@NotNull`**
- **Utilisation de `ResponseEntity` pour une meilleure gestion des réponses API**
- **Gestion des exceptions avec `@ControllerAdvice`**

---

## 📜 Licence
Projet développé à des fins éducatives.

---

Tu peux l’adapter selon ton besoin ! 😊 🚀

