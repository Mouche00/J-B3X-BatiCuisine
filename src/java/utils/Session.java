package utils;

import models.Client;
import models.Project;

import java.util.Optional;

public class Session {
    private static Optional<Client> client = Optional.empty();
    private static Optional<Project> project = Optional.empty();

    public static Optional<Client> getClient() {
        return client;
    }

    public static void setClient(Client client) {
        Session.client = Optional.ofNullable(client);
    }

    public static Optional<Project> getProject() {
        return project;
    }

    public static void setProject(Project project) {
        Session.project = Optional.ofNullable(project);
    }
}
