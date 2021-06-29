package com.hk.proxy.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Haseem Kheiri
 *
 */
@RestController
public class ApiTerminalsController extends BaseController {
	@GetMapping(path = "api/terminals")
	public void getTerminals(HttpServletRequest request, HttpServletResponse response) {
		execute("http://10.130.11.145:8888/api/terminals", HttpMethod.GET, request, response);
	}

	@PostMapping(path = "api/terminals")
	public void postTerminals(HttpServletRequest request, HttpServletResponse response) {
		execute("http://10.130.11.145:8888/api/terminals", HttpMethod.POST, request, response);
	}

	@GetMapping(path = "api/terminals/{terminalId}")
	public void getTerminals(@PathVariable(name = "terminalId") String terminalId, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/terminals/%s", terminalId), HttpMethod.GET, request,
				response);
	}

	@DeleteMapping(path = "api/terminals/{terminalId}")
	public void deleteTerminals(@PathVariable(name = "terminalId") String terminalId, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/terminals/%s", terminalId), HttpMethod.DELETE, request,
				response);
	}
}
