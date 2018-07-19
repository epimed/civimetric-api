package civimetric_api.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class DefaultErrorController implements ErrorController  {

	private static final String PATH = "/error";

	@Autowired
	private ErrorAttributes errorAttributes;

	@RequestMapping(value = PATH)
	public Object error(WebRequest webRequest, HttpServletResponse response) {
		return errorAttributes.getErrorAttributes(webRequest, false);
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}
}
