package in.nitish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.nitish.entity.ReadJson;
import in.nitish.entity.ReadJson1;
import in.nitish.entity.SkyResMessage;
import in.nitish.service.ReadJsonService;

@RestController
public class ReadJsonController {
	
	@Autowired
	private ReadJsonService readJsonService;
	
	
	
	@GetMapping("/get")
	public ResponseEntity<ReadJson> readJson()
	{
		
		ReadJson readJson = this.readJsonService.readJson();
		
		return new ResponseEntity<ReadJson>(readJson,HttpStatus.OK);
	}
	
	
	@GetMapping("/get1")
	public ResponseEntity<ReadJson1> readJson1()
	{
		
		ReadJson1 readJson1 = this.readJsonService.readJson1();
		return new ResponseEntity<ReadJson1>(readJson1,HttpStatus.OK);
	}

	@GetMapping("/get2")
	public ResponseEntity<SkyResMessage> readJson2()
	{
		
		SkyResMessage skyResMessage = this.readJsonService.readJson2();
		
		return new ResponseEntity<SkyResMessage>(skyResMessage,HttpStatus.OK);
	}
}
