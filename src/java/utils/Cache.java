package utils;

import models.Client;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cache {

    private static final Map<String, Client> clientCache = new HashMap<>();

    public static Optional<Client> getClient(String name) {
        return Optional.ofNullable(clientCache.get(name));
    }

    public static void setClient(String name, Client client) {
        clientCache.put(name, client);
    }
}
