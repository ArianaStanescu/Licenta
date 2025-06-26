## Backend

GitHub repo: https://github.com/ArianaStanescu/Licenta

```bash
cd your-backend-root-path
git clone https://github.com/ArianaStanescu/Licenta.git
````

### 1. Configurarea containerelor Docker

Fișierul `keycloak-postgres.yml` conține trei imagini:

* PostgreSQL – baza de date relațională
* Keycloak – server OAuth
* pgAdmin – interfață grafică pentru administrarea bazelor de date PostgreSQL

Pentru a porni containerele, se execută următoarea comandă din folderul părinte al backendului (`your-backend-root-path`):

```bash
docker-compose -f keycloak-postgres.yml up
```

---

### 2. Import configurații Keycloak

1. Se accesează pgAdmin în browser:

```
http://localhost:5050
```

2. Autentificare:

* Email: `admin@admin.com`
* Parolă: `admin`

3. Conexiune la server se realizează prin:

* host: `postgreslicenta`
* port: `5432`
* username: `postgres`
* password: `admin`

4. Se șterge baza de date `keycloaklicenta` (conține tabele implicite) și se recreează din nou (nu va mai conține tabele în acest moment).


5. Se importă backup-ul SQL pentru Keycloak:

* În pgAdmin, se selectează baza de date `keycloaklicenta`, ulterior prin click dreapta se apasă pe `Restore` și se atașează fișierul `keycloak-backup-kidsphere.sql` din folder-ul părinte de pe backend (`your-backend-root-path`)

---

### 3. Pornire backend

Backendul poate fi pornit prin rularea metodei `main()` din clasa:

```
LicentaApplication
```

Tabelele bazei de date vor fi create automat de Spring Data – nu este necesar un import manual, server-ul fiind accesibil pe `http://localhost:8080`.