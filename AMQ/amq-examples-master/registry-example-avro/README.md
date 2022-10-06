# Apicurio Service Registry Example - Avro

This project shows how to use the Apicurio Service Registry to manage Apache Kafka data schemas. This example uses the [Avro](https://avro.apache.org/docs/current/) data format messages to and from a local cluster.

## Apache Kafka Cluster and Apicurio Service Registry

First you need an Apache Kafka cluster. You can follow the instructions from the [Apache Kafka website](https://kafka.apache.org/quickstart) or use the `docker-compose.yaml` file in this project.

## Using Local Environment

To start the local development cluster and registry:

1. Open a terminal window and clone this GitHub repository

    ```bash
    git clone https://github.com/hguerrero/amq-examples.git
    ```

1. Navigate to /registry-example-avro directory.

    ```bash
    cd amq-examples/registry-example-avro
    ```

1. Be sure Docker Desktop is running.
1. Execute the following command:

    ```bash
    docker-compose -f docker-compose.yaml up -d
    ```

1. Wait until all the components are up and running.

## Start Application

The application is based on Quarkus (using Java 8) so it can be started executing the following command:

```bash
./mvnw quarkus:dev
```

This will start the application in the Confluent schema registry compatibility mode.

## Apicurio Serializer and Deserializer

To use the Apicurio Avro Serializer and Deserializer:

1. Open the `application.properties` file
2. Uncomment the `value.serializer` properties to use the `io.apicurio.registry.serde.avro.AvroKafkaSerializer`and `io.apicurio.registry.serde.avro.AvroKafkaDeserializer` classes instead.

    ```properies
    mp.messaging.outgoing.price-out.value.serializer=io.apicurio.registry.serde.avro.AvroKafkaSerializer
    mp.messaging.incoming.price-in.value.deserializer=io.apicurio.registry.serde.avro.AvroKafkaDeserializer
    ```

3. Comment the same lines that use the `io.confluent.kafka.*` packages

    ```properies
    # mp.messaging.outgoing.price-out.value.serializer=io.confluent.kafka.serializers.KafkaAvroSerializer
    # mp.messaging.incoming.price-in.value.deserializer=io.confluent.kafka.serializers.KafkaAvroDeserializer
    ```

4. Uncomment the property using the `apicurio` registry

    ```properies
    mp.messaging.incoming.price-in.apicurio.registry.url=http://localhost:8081/apis/registry/v2
    ```

5. Comment the property using the `schema` registry

    ```properies
    # mp.messaging.incoming.price-in.schema.registry.url=http://localhost:8081/apis/ccompat/v6
    ```

To test that everything is workin start again the application with the new configuration values:

```bash
./mvnw quarkus:dev
```
