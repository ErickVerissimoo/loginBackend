package com.springsimplelogin.simplelogin;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;

@Configuration
@EnableJdbcHttpSession(maxInactiveIntervalInSeconds = 30*30*30)
public class sessionconfig {

}
