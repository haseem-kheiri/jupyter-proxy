package com.hk.proxy.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Haseem Kheiri
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.hk.proxy.controller.impl")
public class Proxy {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Proxy.class, args);
	}
}
