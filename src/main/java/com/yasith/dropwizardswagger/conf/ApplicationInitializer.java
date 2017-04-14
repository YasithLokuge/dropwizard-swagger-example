package com.yasith.dropwizardswagger.conf;

import com.yasith.dropwizardswagger.api.Endpoints;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yasith on 1/18/17.
 */
public class ApplicationInitializer extends Application<ApplicationConfiguration>{

    final static Logger log = LoggerFactory.getLogger(ApplicationInitializer.class);

    public static void main(String[] args) throws Exception {
        new ApplicationInitializer().run(args);
    }

    @Override
    public void run(ApplicationConfiguration applicationConfiguration, Environment environment) throws Exception {
        if(log.isInfoEnabled()){
            log.info("Registering REST resources");
            log.info("Initializing Config");
        }
        ConfigReader.init(applicationConfiguration, environment);
        environment.jersey().register(new Endpoints());
    }

    @Override
    public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<ApplicationConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(ApplicationConfiguration applicationConfiguration) {
                return applicationConfiguration.swaggerBundleConfiguration;
            }
        });
    }

}
