package ik.config;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import ik.se.gmail.page.element.PageElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageElementModule extends AbstractModule {

    @Override
    protected void configure() {
        Properties props = new Properties();
        String filePath = System.getProperty("page_element.properties","src/main/resources/page_element.properties");
        try {
            props.load(new FileInputStream(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Names.bindProperties(binder(), props);

        binder().requestStaticInjection(PageElement.class);
    }
}
