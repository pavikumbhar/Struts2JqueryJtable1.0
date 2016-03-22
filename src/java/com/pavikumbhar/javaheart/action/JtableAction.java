package com.pavikumbhar.javaheart.action;

import java.io.IOException;
import java.util.List;


import com.opensymphony.xwork2.Action;
import com.pavikumbhar.javaheart.dao.CrudDao;
import com.pavikumbhar.javaheart.model.Student;
import java.util.ArrayList;

public class JtableAction  {
    
        private int studentId;	
	private String name;
	private String department;
	private String emailId;
	
        private CrudDao dao = new CrudDao();

	private List<Student> records=new ArrayList<Student>();
	private String result;
	private String message;
	private Student record=new Student();
        private int jtStartIndex;//jtStartIndex 
        private int jtPageSize;//jtPageSize
        private int TotalRecordCount;//jtSorting

    public int getJtStartIndex() {
        return jtStartIndex;
    }

    public void setJtStartIndex(int jtStartIndex) {
        this.jtStartIndex = jtStartIndex;
    }

    public int getJtPageSize() {
        return jtPageSize;
    }

    public void setJtPageSize(int jtPageSize) {
        this.jtPageSize = jtPageSize;
    }

    public int getTotalRecordCount() {
        return TotalRecordCount;
    }

    public void setTotalRecordCount(int TotalRecordCount) {
        this.TotalRecordCount = TotalRecordCount;
    }

	
/**
 * 
 * @return 
 */
	public String listStudents() {
		try {
			// Fetch Data from Student Table
		    //records = dao.studentList();
                    if("".equals(name)){
                        System.err.println("empty");
                    records = dao.paging(jtStartIndex, jtPageSize);
                    TotalRecordCount=dao.getCountOfRecord();
                    
                    }else{
                    
                     System.err.println("not empty");
                    records = dao.pagingLike(name);
                    TotalRecordCount=records.size();
                    
                    }
                    
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String studentCreate() throws IOException {
		record = new Student();
		
		record.setStudentId(studentId);
		record.setName(name);
		record.setDepartment(department);
		record.setEmailId(emailId);
	
		try {
			// Create new record
			dao.saveStudent(record);
			result = "OK";

		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;	
	}

        /**
         * 
         * @return
         * @throws IOException 
         */
	public String studentUpdate() throws IOException {
		Student student = new Student();
		
		student.setStudentId(studentId);
		student.setName(name);
		student.setDepartment(department);
		student.setEmailId(emailId);
		
		try {
			// Update existing record
                    dao.updateStudent(student);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

        /**
         * 
         * @return
         * @throws IOException 
         */
	public String studentDelete() throws IOException {
		// Delete record
		try {
			dao.deleteStudent(studentId);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Student getRecord() {
		return record;
	}

	public void setRecord(Student record) {
		this.record = record;
	}

	public List<Student> getRecords() {
		return records;
	}

	public String getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public void setRecords(List<Student> records) {
		this.records = records;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setMessage(String message) {
		this.message = message;
	}

  
}