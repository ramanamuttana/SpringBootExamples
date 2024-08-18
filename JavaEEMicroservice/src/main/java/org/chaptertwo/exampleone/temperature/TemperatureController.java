package org.chaptertwo.exampleone.temperature;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/temperature")
public class TemperatureController {
	
	private TemperatureService temperatureService;
	
	@Autowired
	public TemperatureController(TemperatureService temperatureService) {
		this.temperatureService=temperatureService;
	}

	@GetMapping //  this also can be used @RequestMapping(method=RequestMethod.GET)
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<Temperature> getAverageTemperature(){
		return temperatureService.getAverageTemperature();	
	}
}
