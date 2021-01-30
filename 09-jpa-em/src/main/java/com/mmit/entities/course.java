package com.mmit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import static javax.persistence.EnumType.STRING;
import static javax.persistence.TemporalType.DATE;

/**
 * Entity implementation class for Entity: course
 *
 */

@Entity
@Table (name= "course")
public class course implements Serializable {
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column(name = "name", nullable = true)
		private String courseName; 
		private int fees;
		@Enumerated(STRING)
		private Level level;
		@Temporal(DATE)
		private Date startDate;
		
		
		public enum Level{
			Basic,Intermediate,Advanced
		}
		
		public course() {
		super();
	}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCourseName() {
			return courseName;
		}

		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}

		public int getFees() {
			return fees;
		}

		public void setFees(int fees) {
			this.fees = fees;
		}

		public Level getLevel() {
			return level;
		}

		public void setLevel(Level level) {
			this.level = level;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
   
}
