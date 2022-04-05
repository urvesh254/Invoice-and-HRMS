package com.itaims.ihs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        exposeId(config);
    }

    private void exposeId(RepositoryRestConfiguration config) {
        // Expose entity ids

        // - Gets a list of all entity classes from the entity manager.
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - Create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // - Get the entity types for the entities
        entities.forEach(entityType -> entityClasses.add(entityType.getJavaType()));

        // - Expose the entity ids for the array of entity/domain types
        Class[] domainType = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainType);
    }
}
