JPAManyToOne Projekt
-------------------------
Dette projekt har til formål at demonstrere, 
hvordan man arbejder med relationerne OneToMany og ManyToOne i JPA (Java Persistence API) ved hjælp af et praktisk eksempel. 
Projektet er inspireret af data fra to danske webservices, 
som leverer JSON-data om regioner og kommuner i Danmark.

Formål
-----------
Formålet med øvelsen er at lære, 
hvordan man implementerer og arbejder med relationelle databaser i et Spring Boot projekt, 
hvor én region kan have mange kommuner (OneToMany), 
og mange kommuner kan høre til den samme region (ManyToOne). 
Øvelsen vil give dig erfaring med at oprette JPA-entities, repositories, services, 
og REST-controllers for at håndtere data fra eksterne API'er og gemme dem i en lokal database.

Teknologier
-------------
* Java
* Spring Boot
* Maven
* JPA/Hibernate
* H2 Database
* MySQL

Forudsætninger
--------------
Grundlæggende kendskab til Java og Spring Boot
Grundlæggende forståelse af JPA og relationelle databaser
Installeret IntelliJ IDEA (eller en anden Java IDE)

Projekt Opsætning
----------------
Start et nyt Spring Boot projekt i IntelliJ IDEA, og vælg Maven som build tool.

Tilføj følgende dependencies:
------------------------------

Spring Web
Spring Data JPA
H2 Database
MySQL

Opsætning af projektet
-----------------------
1. Opret en Region klasse i model package.
Denne klasse repræsenterer en region med følgende properties:
kode
navn
href

2. Opret et repository til Region (RegionRepository).
3. Opret et service lag og implementer en klasse, der læser data om regioner fra følgende API: https://api.dataforsyningen.dk/regioner

4. Tilføj en REST-controller, der kan hente regioner og gemme dem i databasen via et endpoint.

5. Opret en Kommune klasse, som også skal have en relation til Region (ManyToOne).

6. Implementer en tilsvarende service og REST-controller for kommuner, hvor data hentes fra: https://api.dataforsyningen.dk/kommuner

7. Sørg for, at fremmednøglen (foreign key) for kommuner korrekt peger på den rette region i databasen.

8. Udvid projektet med endpoints til CRUD-operationer for både regioner og kommuner.

Kørsel af Projekt
-------------------
Start applikationen ved at køre main metoden i den genererede Spring Boot klasse.
Tilgå endpointet for at indlæse regioner: http://localhost:8080/getregioner
Kontroller, at regionerne er korrekt indlæst i databasen.
Implementer og test derefter de samme funktionaliteter for kommuner.
Mulige Udvidelser
Implementer flere CRUD-operationer (Post, Put, Delete) for både regioner og kommuner.
Opret et frontend-interface, som kan manipulere data direkte fra en browser.
Tilføj validering og error handling for at forbedre robustheden af applikationen.
