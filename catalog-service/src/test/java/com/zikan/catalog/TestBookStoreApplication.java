package com.zikan.catalog;

import org.springframework.boot.SpringApplication;

public class TestBookStoreApplication {

    public static void main(String[] args) {
        SpringApplication.from(CatalogServiceApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }
}
