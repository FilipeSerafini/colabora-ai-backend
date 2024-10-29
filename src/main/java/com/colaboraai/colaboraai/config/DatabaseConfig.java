package com.colaboraai.colaboraai.config;

import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseConfig {

    public static void connect() {
        String uri = getUri();
        if (!verifyUri(uri)) {
            return;
        }
        MongoClientSettings settings = getSettings();
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            MongoDatabase database = mongoClient.getDatabase("colaboraai");
            pingDatabase(database);
        }

    }

    public static MongoClientSettings getSettings() {
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();

        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(getUri()))
                .serverApi(serverApi)
                .build();
        return settings;
    }

    public static String getUri() {
        Dotenv dotenv = Dotenv.configure()
                .directory("./src/main/resources")
                .filename(".env")
                .load();
        String uri = dotenv.get("CONNECTION_STRING");
        return uri;
    }

    private static boolean verifyUri(String uri) {
        if (uri == null || uri.isEmpty()) {
            throw new IllegalArgumentException(
                    "URI inválida. Provalvemente a variável de ambiente CONNECTION_STRING não foi setada.");
        }
        return true;
    }

    private static void pingDatabase(MongoDatabase database) {
        try {
            Bson command = new BsonDocument("ping", new BsonInt64(1));
            Document commandResult = database.runCommand(command);
            System.out.println("Sucessfully connected to database: " + commandResult.toJson());

        } catch (Exception e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }

    public static MongoCollection<Document> getCollection(String collectionName) {
        MongoClient mongoClient = MongoClients.create(DatabaseConfig.getSettings());
        MongoDatabase database = mongoClient.getDatabase("colaboraai");
        try {
            MongoCollection<Document> collection = database.getCollection(collectionName);
            return collection;
        } catch (Exception e) {
            System.out.println("Error! Couldn't access collection: " + e);
            return null;
        }
    }

}
