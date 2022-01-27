package org.chaptertwo.exampleone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	@GetMapping
	public String helloWorld() {
		return "Hello world";
	}

}
