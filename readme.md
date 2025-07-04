# School_Management

## 📚 Description

**School_Management** est une application de gestion scolaire basée sur une architecture microservices. Elle permet de :

- Gérer les **étudiants**
- Gérer les **professeurs**
- Gérer les **classes**, qui associent étudiants et professeurs

L'application repose sur une architecture distribuée avec **Spring Boot**, **Eureka Server** pour la découverte de services, et **API Gateway** pour la gestion centralisée des routes.

---

## 🧱 Architecture

Le repository est structuré comme suit :

School_Management/
│
├── eureka-server # Service Eureka pour la découverte des microservices
├── gateway # API Gateway pour centraliser les routes
├── student # Microservice de gestion des étudiants
├── teacher # Microservice de gestion des professeurs
├── classroom # Microservice de gestion des classes
└── script # Scripts SQL pour initialiser et remplir les bases de données

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
