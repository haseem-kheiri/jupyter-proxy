package com.hk.proxy.controller.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Haseem Kheiri
 *
 */
@RestController
public class ApiContentsController extends BaseController {

	@GetMapping(path = "api/contents/work/{name}")
	public void getContents(@PathVariable(name = "name") String name, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/contents/work/%s", name), HttpMethod.GET, request,
				response);
	}

	@PostMapping(path = "api/contents/work/{name}")
	public void postContents(@PathVariable(name = "name") String name, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/contents/work/%s", name), HttpMethod.POST, request,
				response);
	}

	@PatchMapping(path = "api/contents/work/{name}")
	public void patchContents(@PathVariable(name = "name") String name, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/contents/work/%s", name), HttpMethod.PATCH, request,
				response);
	}

	@PutMapping(path = "api/contents/work/{name}")
	public void putContents(@PathVariable(name = "name") String name, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/contents/work/%s", name), HttpMethod.PUT, request,
				response);
	}

	@DeleteMapping(path = "api/contents/work/{name}")
	public void deleteContents(@PathVariable(name = "name") String name, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/contents/work/%s", name), HttpMethod.DELETE, request,
				response);
	}

	@GetMapping(path = "api/contents/work/{name}/checkpoints")
	public void getContentsCheckpoints(@PathVariable(name = "name") String name, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/contents/work/%s/checkpoints", name), HttpMethod.GET,
				request, response);
	}

	@PostMapping(path = "api/contents/work/{name}/checkpoints")
	public void postContentsCheckpoints(@PathVariable(name = "name") String name, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/contents/work/%s/checkpoints", name), HttpMethod.POST,
				request, response);
	}

	@PostMapping(path = "api/contents/work/{name}/checkpoints/{checkpointId}")
	public void postContentsCheckpoints(@PathVariable(name = "name") String name,
			@PathVariable(name = "checkpointId") String checkpointId, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/contents/work/%s/checkpoints/%s", name, checkpointId),
				HttpMethod.POST, request, response);
	}
	
	@DeleteMapping(path = "api/contents/work/{name}/checkpoints/{checkpointId}")
	public void deleteContentsCheckpoints(@PathVariable(name = "name") String name,
			@PathVariable(name = "checkpointId") String checkpointId, HttpServletRequest request,
			HttpServletResponse response) {
		execute(String.format("http://10.130.11.145:8888/api/contents/work/%s/checkpoints/%s", name, checkpointId),
				HttpMethod.DELETE, request, response);
	}
}
