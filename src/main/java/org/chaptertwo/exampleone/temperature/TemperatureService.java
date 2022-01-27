package org.chaptertwo.exampleone.temperature;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service // @Component also can be used 
public class TemperatureService {

	public ResponseEntity<Temperature> getAverageTemperature() {
		
		Temperature temperature =new Temperature();
		temperature.setTemperature(34.5);
		temperature.setTemperatureScale(TemperatureScale.CELSIUS);
		return ResponseEntity.ok(temperature);
	}

}
// acts as a service layer 
