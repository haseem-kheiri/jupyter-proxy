package com.hk.proxy.controller.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

/**
 * Please refer https://jupyter-server.readthedocs.io/en/latest/developers/rest-api.html
 * 
 * @author Haseem Kheiri
 * 
 */
public class BaseController {
	protected final RestTemplate rt = new RestTemplate();

	protected String prepareUrl(HttpServletRequest request, String baseUrl) {
		final String qString = request.getQueryString();
		final String url = qString == null ? baseUrl : String.format("%s?%s", baseUrl, qString);
		return url;
	}

	protected void copyRequestHeaders(HttpServletRequest request, ClientHttpRequest req) {
		Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				String headerName = headerNames.nextElement();
				Enumeration<String> headerValues = request.getHeaders(headerName);
				if (headerValues != null) {
					while (headerValues.hasMoreElements()) {
						String headerValue = headerValues.nextElement();
						req.getHeaders().add(headerName, headerValue);
					}
				}
			}
		}
	}

	protected void copyResponseHeaders(HttpServletResponse response, ClientHttpResponse res) {
		HttpHeaders headers = res.getHeaders();
		if (headers != null) {
			headers.forEach((headerName, headerValues) -> {
				if (headerValues != null) {
					headerValues.forEach(headerValue -> response.addHeader(headerName, headerValue));
				}
			});
		}
	}

	protected void copyResponseBody(HttpServletResponse response, ClientHttpResponse res) throws IOException {
		OutputStream out = response.getOutputStream();
		InputStream in = res.getBody();
		byte[] buffer = new byte[1024 * 4];
		int len = 0;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		out.flush();
	}

	private void copyRequestBody(HttpServletRequest request, ClientHttpRequest req) throws IOException {
		OutputStream out = req.getBody();
		InputStream in = request.getInputStream();
		byte[] buffer = new byte[1024 * 4];
		int len = 0;
		while ((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}
		out.flush();

	}

	protected void execute(String baseUrl, HttpMethod method, HttpServletRequest request,
			HttpServletResponse response) {
		rt.execute(prepareUrl(request, baseUrl), method, req -> {
			copyRequestHeaders(request, req);
			copyRequestBody(request, req);
		}, res -> {
			copyResponseHeaders(response, res);
			copyResponseBody(response, res);
			return null;
		});
	}

}
