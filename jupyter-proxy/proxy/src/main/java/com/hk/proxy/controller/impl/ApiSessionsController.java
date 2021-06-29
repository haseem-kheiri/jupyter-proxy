package com.hk.proxy.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Haseem Kheiri
 *
 */
@RestController
public class ApiSessionsController extends BaseController {
	@GetMapping(path = "api/sessions/{session}")
	public void getSessions(@PathVariable(name = "session") String session, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/sessions/%s", session), HttpMethod.GET, request, response);
	}

	@PatchMapping(path = "api/sessions/{session}")
	public void patchSessions(@PathVariable(name = "session") String session, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/sessions/%s", session), HttpMethod.PATCH, request,
				response);
	}

	@DeleteMapping(path = "api/sessions/{session}")
	public void deleteSessions(@PathVariable(name = "session") String session, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/sessions/%s", session), HttpMethod.DELETE, request,
				response);
	}

	@GetMapping(path = "api/sessions")
	public void getSessions(HttpServletRequest request, HttpServletResponse response) {
		execute("http://10.130.11.145:8888/api/sessions", HttpMethod.GET, request, response);
	}

	@PostMapping(path = "api/sessions")
	public void postSessions(HttpServletRequest request, HttpServletResponse response) {
		execute("http://10.130.11.145:8888/api/sessions", HttpMethod.POST, request, response);
	}
}
