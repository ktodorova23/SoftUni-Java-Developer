package com.softuni.xmlprocessing.config;

import com.softuni.xmlprocessing.utils.XMLParser;
import com.softuni.xmlprocessing.utils.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public XMLParser xmlParser() {
        return new XmlParserImpl();
    }
}
