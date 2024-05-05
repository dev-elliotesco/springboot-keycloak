package com.develliotesco.springbootkeycloak.util;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.beans.factory.annotation.Value;

public class KeycloakProvider {

    @Value("${keycloak.server-url}")
    private static  String KEYCLOAK_SERVER_URL;
    @Value("${keycloak.realm}")
    private static  String KEYCLOAK_REALM;
    @Value("${keycloak.realm-master}")
    private static  String KEYCLOAK_REALM_MASTER;
    @Value("${keycloak.admin-cli}")
    private static  String KEYCLOAK_ADMIN_CLI;
    @Value("${keycloak.user-console}")
    private static  String KEYCLOAK_USER_CONSOLE;
    @Value("${keycloak.user-password}")
    private static  String KEYCLOAK_USER_PASSWORD;
    @Value("${keycloak.client-secret}")
    private static  String KEYCLOAK_CLINT_SECRET;

    public static RealmResource getRealmResource() {
        Keycloak keycloak = KeycloakBuilder.builder()
                .serverUrl(KEYCLOAK_SERVER_URL)
                .realm(KEYCLOAK_REALM_MASTER)
                .clientId(KEYCLOAK_ADMIN_CLI)
                .username(KEYCLOAK_USER_CONSOLE)
                .password(KEYCLOAK_USER_PASSWORD)
                .clientSecret(KEYCLOAK_CLINT_SECRET)
                .resteasyClient(new ResteasyClientBuilderImpl()
                        .connectionPoolSize(10)
                        .build())
                .build();

        return keycloak.realm(KEYCLOAK_REALM);
    }

    public static UsersResource getUserResource() {
        RealmResource realmResource = getRealmResource();
        return realmResource.users();
    }
}
