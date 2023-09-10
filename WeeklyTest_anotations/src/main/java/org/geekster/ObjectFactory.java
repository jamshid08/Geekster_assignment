package org.geekster;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ObjectFactory {

    public ObjectFactory() {
        System.out.println("configuration does create object as well!!!!");
    }

    @Bean

    public myClass createname1()
    {
        System.out.println("testing configuration class");
        return new myClass("kashmir");
    }

    @Bean
    @Primary
    public myClass createname2()
    {
        System.out.println("testing configuration class");
        return new myClass("J&K");
    }



}
