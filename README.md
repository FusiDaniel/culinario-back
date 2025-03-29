### TODO

- Handle exceptions
- Patch utils
- User endpoints
- Dietary restrictions
- Image upload
- DishItem

---

## Creating Asymmetric Keys

```bash
keytool -genkeypair \ 
  -keyalg RSA \ 
  -keysize 2048 \
  -storetype JKS \
  -validity 3650
  -alias your_alias \
  -keystore your_filename.jks \
  -keypass your_password \
  -storepass your_password
```

---

## Swagger documentation URL

[{{host}}/swagger-ui/index.html]({{host}}/swagger-ui/index.html)

---

# Environment Variables

## Required variables

The following environment variables are required to execute the project:

```
CLIENT_ID;
CLIENT_SECRET;
REDIRECT_URL;
JKS_ALIAS;
JKS_KEYPASS;
JKS_STOREPASS;
JKS_PATH;
RDS_DBNAME;
RDS_USERNAME;
RDS_PASSWORD;
RDS_DBSCHEMA;
RDS_ENDPOINT;
```

---

### CLIENT_ID, CLIENT_SECRET

Set the client_id and client_secret credentials used for client authorization.

---

### REDIRECT_URL

URL for redirection after a successful login attempt.

---

### RDS_DBNAME, RDS_USERNAME, RDS_PASSWORD, RDS_DBSCHEMA

Relational database service values set during database creation.

---

### RDS_ENDPOINT

---

## Optional Variables

The following environment variables are optional and aim to provide developers with custom configurations to help development process:

```
APP_PROFILE;
DDL_AUTO;
SHOW_SQL;
FORMAT_SQL;
```

---

### APP_PROFILE

Can assume only the value `local` for now, indicating which additional application.properties should be loaded when application starts.

---

### SHOW_SQL;

Boolean variable indication whether to log on the console automatically generated SQL.

---

### FORMAT_SQL;

Boolean variable indication whether to format the generated SQL log or just show in one line.
