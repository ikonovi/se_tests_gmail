package ik.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfigModule extends AbstractModule {

    @Override
    protected void configure() {
        Properties props = new Properties();
        String filePath = System.getProperty("test_config.properties","src/test/resources/test_config.properties");
        try {
            props.load(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Names.bindProperties(binder(), props);

        binder().requestStaticInjection(TestData.class);
    }
}
