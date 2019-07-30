package com.softuni.xmlprocessingcardealerhomework.config;

import com.softuni.xmlprocessingcardealerhomework.utils.XmlParser;
import com.softuni.xmlprocessingcardealerhomework.utils.XmlParserImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class AppBeanConfiguration {
    @Bean
    public XmlParser xmlParser() {
        return new XmlParserImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Random random() {
        return new Random();
    }
}
