package com.hk.proxy.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Haseem Kheiri
 *
 */
@RestController
public class ApiSpecController extends BaseController {
	@GetMapping(path = "api/spec.yaml")
	public void getSpec(HttpServletRequest request, HttpServletResponse response) {
		execute("http://10.130.11.145:8888/api/spec.yaml", HttpMethod.GET, request, response);
	}
}
