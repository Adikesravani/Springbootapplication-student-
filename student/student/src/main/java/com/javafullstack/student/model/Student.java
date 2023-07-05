package com.javafullstack.student.model;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "student_name")
	private String student_name;
	@Column(name = "telugu")
	private int telugu;
	@Column(name = "hindi")
	private int hindi;
	@Column(name = "english")
	private int english;
	@Column(name = "maths")
	private int maths;
	@Column(name = "science")
	private int science;
	@Column(name = "social")
	private int social;
	@Column(name = "total")
	private int total;

	public Student() {

	}

	public Student(String student_name, int telugu, int hindi, int english, int maths, int science, int social,
			int total, Proffessor proffessor) {
		super();
		this.student_name = student_name;
		this.telugu = telugu;
		this.hindi = hindi;
		this.english = english;
		this.maths = maths;
		this.science = science;
		this.social = social;
		this.total = total;
		this.proffessor=proffessor;
	}
	@JsonBackReference
	@JoinColumn(name="pId")
	@ManyToOne()
	private Proffessor proffessor;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public int getTelugu() {
		return telugu;
	}

	public void setTelugu(int telugu) {
		this.telugu = telugu;
	}

	public int getHindi() {
		return hindi;
	}

	public void setHindi(int hindi) {
		this.hindi = hindi;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getSocial() {
		return social;
	}

	public void setSocial(int social) {
		this.social = social;
	}

	public int getTotal() {
		return telugu + hindi + english + maths + science + social;
	}

	public void setTotal(int total) {
		this.total = telugu + hindi + english + maths + science + social;
	}

	public Proffessor getProffessor() {
		return proffessor;
	}

	public void setProffessor(Proffessor proffessor) {
		this.proffessor = proffessor;
	}
	@Override
	public String toString() {
		return "Student [id="+id+", student_name="+student_name+","
				+ "telugu="+telugu+",hindi="+hindi+",english="+english+",maths="+english+","
						+ "science="+science+",social="+social+",total="+total+"]";
}
	public interface StudentDTOIntf{
		/*
		 * *select 
		 *s.id, s.student_name,s.total from student s,
		 *student s ,professor p
		  where s.pid=p.pid
		  and p.pid=pid",nativeQuery=true)
		 */
		
		public Long getId();
		public String getStudent_name();
		public Integer getTotal();
		public Integer getPId();
		public String getProSub();
		public String getProName();
		
	}
}

