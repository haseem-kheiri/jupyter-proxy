package com.hk.proxy.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Haseem Kheiri
 *
 */
@RestController
public class ApiConfigController extends BaseController {
	@GetMapping(path = "api/config/{sectionName}")
	public void getConfigs(@PathVariable(name = "sectionName") String sectionName, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/config/%s", sectionName), HttpMethod.GET, request,
				response);
	}

	@PatchMapping(path = "api/config/{sectionName}")
	public void patchConfigs(@PathVariable(name = "sectionName") String sectionName, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/config/%s", sectionName), HttpMethod.PATCH, request,
				response);
	}
}
