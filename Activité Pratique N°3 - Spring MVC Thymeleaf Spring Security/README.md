# TP Hospital 🏥

Bienvenue dans le projet TP Hospital ! Ce projet vise à gérer les patients, les médecins, les rendez-vous et les consultations dans un cadre hospitalier.

## Entités 📝

### Patient 👩‍⚕️

- Attributs :
  - `id` : Long
  - `nom` : String
  - `dateNaissance` : Date
  - `malade` : boolean
- Relations :
  - `rendez-vous` : Collection de Rendez-vous

### Médecin 👨‍⚕️

- Attributs :
  - `id` : Long
  - `nom` : String
  - `email` : String
  - `spécialité` : String
- Relations :
  - `rendez-vous` : Collection de Rendez-vous

### Consultation 💬

- Attributs :
  - `id` : Long
  - `dateConsultation` : Date
  - `rapport` : String
- Relations :
  - `rendez-vous` : Rendez-vous
  - `médecin` : Médecin
  - `patient` : Patient

### Rendez-vous 📅

- Attributs :
  - `id` : String
  - `dateRendezVous` : Date
  - `statut` : StatutRendezVous
- Relations :
  - `médecin` : Médecin
  - `patient` : Patient
  - `consultation` : Consultation

### StatutRendezVous 📝

- Énumérations :
  - `EN_ATTENTE`
  - `ANNULÉ`
  - `TERMINÉ`

## Fonctionnalités 🛠️

1. **Gestion des Patients** :

   - Ajouter un nouveau patient.
   - Rechercher un patient par nom.
   - Afficher tous les patients.

2. **Gestion des Médecins** :

   - Ajouter un nouveau médecin.
   - Rechercher un médecin par nom.
   - Afficher tous les médecins.

3. **Gestion des Rendez-vous** :

   - Planifier un rendez-vous entre un patient et un médecin.
   - Mettre à jour le statut du rendez-vous (en attente, annulé, terminé).
   - Rechercher un rendez-vous par son identifiant.
   - Afficher tous les rendez-vous.

4. **Gestion des Consultations** :
   - Enregistrer une consultation associée à un rendez-vous.
   - Rechercher une consultation par son identifiant.
   - Afficher toutes les consultations.

## Repositories 🗄️

### AppointmentRepository

- Interface étendant `JpaRepository` pour les entités Rendez-vous.

### ConsultationRepository

- Interface étendant `JpaRepository` pour les entités Consultation.

### DoctorRepository

- Interface étendant `JpaRepository` pour les entités Médecin.
- Méthode supplémentaire :
  - `findByName(String name)` : Liste<Médecin>

### PatientRepository

- Interface étendant `JpaRepository` pour les entités Patient.
- Méthode supplémentaire :
  - `findByName(String name)` : Liste<Patient>

## Services 🛠️

### IHospitalService

- Interface définissant diverses méthodes de service pour gérer les entités hospitalières.

### HospitalServiceImpl

- Implémentation de `IHospitalService`.
- Fournit des méthodes pour les opérations CRUD sur les entités Patient, Médecin, Rendez-vous et Consultation.

## Point d'Entrée de l'Application 🚀

### TpHospitalApplication

- Classe principale pour exécuter l'application TP Hospital.
- Configure l'application Spring Boot.
- Initialise des données d'exemple à l'aide de CommandLineRunner.

## Configuration

Le fichier `application.properties` contient la configuration de l'application, y compris les détails de la base de données. Assurez-vous de configurer correctement les informations de votre base de données MySQL.

```properties
server.port=3309
spring.datasource.url=jdbc:mysql://localhost:3306/patientsdb?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

### Utilisation de H2

Décommentez les lignes suivantes pour utiliser H2 :

```properties
# Utilisation de H2 (base de données en mémoire)
#spring.datasource.url=jdbc:h2:mem:patientsdb
#spring.datasource.username=sa
#spring.datasource.password=
#spring.h2.console.enabled=true
```

## Exécution

Pour exécuter l'application, assurez-vous d'avoir configuré une base de données MySQL avec les informations spécifiées dans `application.properties`. Ensuite, exécutez la classe principale `ActivitePratiqueN2Application`.

## Auteur

Ce projet a été développé par **HAMZA DAMIRI (yassine)** - [GitHub Profile](https://github.com/yassine).

---

**Note :** Assurez-vous d'avoir les dépendances et l'environnement nécessaire configurés correctement avant d'exécuter l'application.

---
