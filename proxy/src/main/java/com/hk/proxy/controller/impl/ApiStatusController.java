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
public class ApiStatusController extends BaseController{
	@GetMapping(path = "api/status")
	public void getKernelSpecs(HttpServletRequest request, HttpServletResponse response) {
		execute("http://10.130.11.145:8888/api/status", HttpMethod.GET, request, response);
	}
}
