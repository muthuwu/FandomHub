
package com.fandomhub.mongoangular.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fandomhub.mongoangular.model.lastid;
import com.fandomhub.mongoangular.repository.LastIdRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/lastidapi")
public class LastIdController {
	@Autowired LastIdRepository lastidrepo;
	
	@GetMapping("/getlastid")
	public Optional<lastid> getLastId() {
		return lastidrepo.findById(1);
	}
	
	@PutMapping("/updatelastid")
	public String updateLastId(@RequestBody lastid lastids) {
		lastidrepo.save(lastids);
		return "Lastid updated";
	}
}
