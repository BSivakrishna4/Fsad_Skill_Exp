package klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import klu.model.Faculty;
import klu.model.FacultyManager;


@RestController
@RequestMapping("faculty")
@CrossOrigin(origins = "http://localhost:1060/")
public class FacultyController {
	@Autowired
	FacultyManager FM;
//	FacultyManager FM = new FacultyManager();(old method for object declaration can be avoided by auto wiring annotation)
	@PostMapping("save")
	public String save(@RequestBody Faculty F) {
		try {
			return FM.insertData(F);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@GetMapping("read")
	public List<Faculty> read() throws Exception {
		return FM.readData();
	}
	//end point to read single record from the table
	@GetMapping("read/{fid}")
	public Faculty readbyid(@PathVariable Long fid) throws Exception{
		return FM.readById(fid);
	}
	
	@PutMapping("update")
	public String update(@RequestBody Faculty F) {
		try {
			return FM.updateData(F);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	@DeleteMapping("delete/{id}")
	public String del(@PathVariable("id") Long id) {
		try {
			return FM.deleteData(id);
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}
