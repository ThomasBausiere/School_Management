# School_Management

## 📚 Description

**School_Management** est une application de gestion scolaire basée sur une architecture microservices. Elle permet de :

- Gérer les **étudiants**
- Gérer les **professeurs**
- Gérer les **classes**, qui associent étudiants et professeurs

L'application repose sur une architecture distribuée avec **Spring Boot**, **Eureka Server** pour la découverte de services, et **API Gateway** pour la gestion centralisée des routes.

---

## 🧱 Architecture

```
School_Management/
├── eureka-server/       → Microservice de découverte (Eureka)
├── gateway/             → API Gateway pour centraliser les endpoints
├── student/             → Microservice dédié à la gestion des étudiants
├── teacher/             → Microservice dédié à la gestion des professeurs
├── classroom/           → Microservice dédié à la gestion des classes (étudiants + professeurs)
└── script/              → Scripts SQL pour créer et alimenter les bases de données
```

---

## 🔧 Technologies

- **Langage** : Java 21
- **Base de données** : MySQL
- **Framework** : Spring Boot
- **Build Tool** : Maven

**Dépendances principales** :

- `Spring Data JPA` – Persistance des entités
- `Lombok` – Réduction du code boilerplate
- `MySQL Driver` – Connexion aux BDD
- `Spring Cloud Gateway` – Routage
- `Eureka Server` – Découverte des microservices
- `Spring Cloud Bootstrap` – Configuration centralisée

---

## ▶️ Démarrage du projet

### Pré-requis

- Java 21
- Maven
- MySQL installé localement

### Étapes d'installation

1. **Configurer les accès aux bases de données**  
   Modifier les fichiers `application.properties` des dossiers `student`, `teacher`, et `classroom` pour y indiquer vos identifiants MySQL.

2. **Créer les bases de données**  
   Exécuter le script SQL contenu dans le dossier `script/` :
   ```bash
   mysql -u root -p < script/init_db.sql
