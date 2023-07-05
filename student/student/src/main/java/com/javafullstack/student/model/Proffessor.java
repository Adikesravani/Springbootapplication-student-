package com.javafullstack.student.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="proffessor")
public class Proffessor {
	public Proffessor(long pId,String proName,String proSub) {
		super();
		this.pId=pId;
		this.proName=proName;
		this.proSub=proSub;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long pId;
	@Column(name="proName")
	private String proName;
	@Column(name="proSub")
	private String proSub;
	@JsonManagedReference
	@OneToMany(mappedBy="proffessor")
	List<Student>students;
	public Proffessor() {
		
		
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProSub() {
		return proSub;
	}
	public void setProSub(String proSub) {
		this.proSub = proSub;
	}
	
	public long getPId() {
		return pId;
	}
	public void setPId(long pId) {
		this.pId = pId;
	}
	@Override
	public String toString() {
		return "Proffessor[id="+pId+","+proName+","+proSub+","
				+ "getProName()="+getProName()+",getProSub()="+getProSub()+",getPid()="+getPId()+"]";
		
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	

}
