package com.lemursoft.library;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // включаем использование AspectJ
@ComponentScan(basePackages = {"com.lemursoft.library"})
public class ServletInitializer extends SpringBootServletInitializer {

}
