# Quickstart

```bash
  docker compose up -d
```

This demo uses keycloak authorization services to manage the endpoint security from within the keycloak. Thus, no hardcoded configuration (like a `@RolesAllowed` annotations) is needed within the code itself.

## Access the application

... with an authorized user:

```bash
  export access_token=$(\
    curl --insecure -X POST http://keycloak.localtest.me:8080/realms/quarkus/protocol/openid-connect/token \
      --user backend-service:secret \
      -H 'content-type: application/x-www-form-urlencoded' \
      -d 'username=user&password=password&grant_type=password' | jq --raw-output '.access_token' \
    )

  curl http://localhost:8081/helloworld --header "Authorization: Bearer $access_token"
```

Response Code: `200 OK`, Body: `hello world`

... or with an unauthorized user:

```bash
  export access_token=$(\
    curl --insecure -X POST http://keycloak.localtest.me:8080/realms/quarkus/protocol/openid-connect/token \
      --user backend-service:secret \
      -H 'content-type: application/x-www-form-urlencoded' \
      -d 'username=john&password=password&grant_type=password' | jq --raw-output '.access_token' \
    )

  curl http://localhost:8081/helloworld --header "Authorization: Bearer $access_token" -v
```

Response Code: `403 Forbidden`
