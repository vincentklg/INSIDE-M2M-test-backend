# INSIDE M2M Test Backend

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at <http://localhost:8080/q/dev/>.\
> **_WARN:_**  This is not available when running via docker

## Docker

You can also execute `docker compose up --build` to build an image from source and get the apropriate database setup.
Currently, the database is being initialized with the schema but the ingestion of demo data is not working properly via docker volume binds.

## REST

The REST API has two endpoints.

### v1/device/read/{id}
Get a device by id
Use this `curl` command:
`
curl localhost:8080/v1/device/read/{id}
`

### v1/device/create
create a device via a JSON payload
Use this `curl` command:
`
curl --request POST 'localhost:8080/v1/device/create' --header 'Content-Type: application/json' \
--data-raw '{
"external_id": "lskdgf",
"connection_type": "LAN"
}'
`
