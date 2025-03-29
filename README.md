# Environment Variables

```
APP_PROFILE;
RDS_DBNAME;
RDS_DBSCHEMA;
RDS_ENDPOINT;
RDS_PASSWORD;
RDS_USERNAME;
SHOW_SQL;
DDL_AUTO;
FORMAT_SQL;
CLIENT_ID;
CLIENT_SECRET;
JKS_ALIAS;
JKS_KEYPASS;
JKS_STOREPASS;
JKS_PATH;
REDIRECT_URL;
```
### TODO

- Handle exceptions
- Patch utils
- User endpoints
- Dietary restrictions
- Image upload
- DishItem

# Creating Asymmetric Keys

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