package hkbbkKinesisApplication.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;
    static {
        try {
            entityManagerFactory = 
                Persistence.createEntityManagerFactory("hkbbkAdRecord");
        }
        catch(Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
 
    public static void shutdown() {
        getEntityManagerFactory().close();
    }
}
