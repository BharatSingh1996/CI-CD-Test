package com.demo.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.DtoReq;
import com.demo.entity.MyEntity;
import com.demo.service.EntityService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

	private final EntityService serviceLayer;

	public HomeController(EntityService serviceLayer) {
		this.serviceLayer=serviceLayer;	
		}
	
	@GetMapping("/welcome")
	public MyEntity getWelcomePage() {
		new MyEntity("Bharat","Mohiniganj");
      	return new MyEntity("Bharat","Mohiniganj_Basian");
	}

	@PostMapping("/save") // create
	public MyEntity saveData(@RequestBody MyEntity entity) {

		MyEntity savedData = serviceLayer.save(entity);
		return savedData;
	}

	@GetMapping("/getAll") // read
	public List<MyEntity> getAll() {
		List<MyEntity> all = serviceLayer.getAll();
		return all;
	}

	@GetMapping("/getById/{id}")
	public Optional<MyEntity> getById(@PathVariable("id") int n) {

		Optional<MyEntity> byId = serviceLayer.getById(n);
		return byId;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") int id) {
		serviceLayer.deleteById(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/update")//update
	public DtoReq update(@RequestBody DtoReq obj) {
		DtoReq update = serviceLayer.update(obj);
		return update;
	}


}
