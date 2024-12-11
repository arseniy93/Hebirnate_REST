package com.rigin.provider;

import com.rigin.model.dto.UserDto;
import com.rigin.model.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class PropertiesSessionProvider implements SessionProvider{

    @Override
    public SessionFactory getSessionFactory() {
        Properties hebirnateproperties=new Properties();
        hebirnateproperties.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
        hebirnateproperties.setProperty("hibernate.connection.driver_class","org.postgresql.Driver");
        hebirnateproperties.setProperty("hibernate.connection.url","jdbc:postgresql://localhost:5432/hebirnate_project");
        hebirnateproperties.setProperty("hibernate.connection.username","sam");
        hebirnateproperties.setProperty("hibernate.connection.password","1234");
        hebirnateproperties.setProperty("hibernate.hbm2ddl.auto","validate");
        hebirnateproperties.setProperty("hibernate.show_sql","true");
        //hebirnateproperties.setProperty("hibernate.cache.use_query_cache","true");

        return new Configuration()
                .addProperties(hebirnateproperties)
                .addAnnotatedClass(Task.class)
                .addAnnotatedClass(UserDto.class)//TODO check
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Comment.class)
                .addAnnotatedClass(Activity.class)
                .buildSessionFactory();
    }
}
