package com.barshop.app.models.mapper.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.barshop.app.models.entity.Entity;
import com.barshop.app.properties.LoadProperties;

public class EntityReflexionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityReflexionUtil.class);

    public static final String PACKAGE_ENTITY = "com.barshop.app.models.entity.impl.";


    private EntityReflexionUtil() {
        throw new IllegalStateException("EntityConstant class");
    }

    public static Entity newInstance( String entity ) {

        String engine = LoadProperties.getInstance().getProperty("engine.db");
        LOGGER.info("engine: {}", engine);
        LOGGER.info("packageEntity: " + PACKAGE_ENTITY);

        if ("mysql".equalsIgnoreCase(engine)) {
            String entityImpl = PACKAGE_ENTITY + engine + "." + entity + "MySQL";
            LOGGER.info("entityImpl: {}", entityImpl);
            return (Entity) ReflexionUtil.createNewInstance(entityImpl);
        } else if ("oracle".equalsIgnoreCase(engine)) {
            String entityImpl = PACKAGE_ENTITY + engine + "." + entity + "Oracle";
            LOGGER.info("entityImpl: {}", entityImpl);
            return (Entity) ReflexionUtil.createNewInstance(entityImpl);
        }

        return null;
    }
}
