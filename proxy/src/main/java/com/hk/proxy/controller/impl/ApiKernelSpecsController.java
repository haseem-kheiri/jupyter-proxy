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
public class ApiKernelSpecsController extends BaseController{
	@GetMapping(path = "api/kernelspecs")
	public void getKernelSpecs(HttpServletRequest request, HttpServletResponse response) {
		execute("http://10.130.11.145:8888/api/kernelspecs", HttpMethod.GET, request, response);
	}
}
