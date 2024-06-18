package com.example.springGrpcExample.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan
@EntityScan
@EnableTransactionManagement
public class PersistenceConfig {
}
