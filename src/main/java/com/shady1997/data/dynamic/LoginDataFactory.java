package com.shady1997.data.dynamic;

import com.shady1997.model.Login;
import net.datafaker.Faker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Locale;

import static com.shady1997.config.ConfigurationManager.configuration;

public final class LoginDataFactory {

    private static final Faker faker = new Faker(new Locale.Builder().setLanguageTag(configuration().faker()).build());
    private static final Logger logger = LogManager.getLogger(LoginDataFactory.class);

    private LoginDataFactory() {
    }

    public static Login createLoginData() {
        var login = new Login.LoginBuilder().
            email("standard_user").
            password("secret_sauce").
            build();

        logger.info(login);
        return login;
    }
}
