
### Dependencies
* Java
* PostgreSQL

### Building the project
1. Run the following to create the databases required to run the project.
```sql
CREATE DATABASE guestbook;
```
2. Run `gradle flywayMigrate` to do database migration.
3. Run `./gradlew build` to download dependencies & generate the proto.
