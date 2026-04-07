package klu.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import klu.repository.FacultyRepository;

@Service
public class FacultyManager {
	@Autowired
	FacultyRepository FR;
	//Insert operation
	public String insertData(Faculty F) throws Exception{
		FR.save(F); //Insert operation into the DB
		return "New faculty data has been added!";
	}
	
	//Read operation
	public List<Faculty> readData() throws Exception{
//		List<Faculty> flist = FR.findAll();
//		return flist; 
		return FR.findAll();
	}
	
	public Faculty readById(Long fid) throws Exception{
		return FR.findById(fid).get();
	}
	
	//Update operation
	public String updateData(Faculty F) throws Exception{
		Faculty temp=FR.findById(F.getFid()).get();
		temp.setFname(F.getFname());
		temp.setDept(F.getDept());
		FR.save(temp);
		return "The Faculty data has been updated!";
	}
	
	//Delete operation
	public String deleteData(Long id) throws Exception{
		Faculty temp=FR.findById(id).get();
		FR.delete(temp);
		return "The faculty data has been deleted!";
	}
}
