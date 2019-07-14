package com.fse.projectmanager;

import com.fse.projectmanager.builders.RequestBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public RequestBuilder requestBuilder() {
        return new RequestBuilder();
    }
}
