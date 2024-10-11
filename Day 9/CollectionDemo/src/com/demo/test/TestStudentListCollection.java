package com.demo.test;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Student;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceImpl;


public class TestStudentListCollection {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentService sservice=new StudentServiceImpl();
		int choice=0;
		do {
		System.out.println("1. add new student\n2. delete student by id\n 3. modify marks\n4. search by id");
		System.out.println("5. search by marks > given marks\n6. sort by id\n 7. sort by name\n8. sort by marks");
		System.out.println("9.display all\n10. search by name and display in sorted order\n 11. exit\nchoice:");
	    choice=sc.nextInt();
	    //text block
	    //String s= """ 
	    //		  this is multiline string
        //          testing""";
	    //new Switch case syntax
	    switch(choice) {
	    case 1->{
	         System.out.println("1. MasterStudent\n 2. GraduateStudent\n3. faculty\n choice: ");
	         int ch=sc.nextInt();
	         sservice.addnewStudent(ch);
	    }
	    case 2->{
	    	System.out.println("enter id for delete");
	    	int id=sc.nextInt();
	    	boolean status=sservice.deleteById(id);
	    	if(status) {
	    		System.out.println("deleted successfully");
	    	}else {
	    		System.out.println("not found");
	    	}
	    	
	    }
	    case 3->{
	    	System.out.println("enter id for delete");
	    	int id=sc.nextInt();
	    	System.out.println("enter marks to modify");
	    	int newmarks=sc.nextInt();
	    	boolean status=sservice.modifyStudentMarks(id,newmarks);
	    	if(status) {
	    		System.out.println("updation done successfully");
	    	}else {
	    		System.out.println("not found");
	    	}
	    }
	    case 4->{
	    	System.out.println("enter id");
	    	int id=sc.nextInt();
	    	Student s=sservice.getById(id);
	    	if(s!=null) {
	    		System.out.println(s);
	    	}else {
	    		System.out.println("not found");
	    	}
	    }
	    case 5->{
	    	System.out.println("enter marks for searching");
	    	int mks=sc.nextInt();
	    	List<Student> lst=sservice.getByMarks(mks);
	    	if(lst!=null) {
	    		lst.stream().forEach(ob->System.out.println(ob));
	    	}else {
	    		System.out.println("Not found");
	    	}
	    }
	    case 6->{
	    	List<Student> lst=sservice.sortById();
	    	lst.stream().forEach(System.out::println);
	    }
	    case 7->{
	    	List<Student> lst=sservice.sortByName();
    	     lst.stream().forEach(System.out::println);}
	    case 8->{List<Student> lst=sservice.sortByMarks();
	     lst.stream().forEach(System.out::println);
	     }
	    case 9->{
	    	List<Student> slst=sservice.getAllStudents();
	    	slst.stream().forEach(System.out::println);
	    }
	    case 10->{
	    	System.out.println("enter name");
	    	String nm=sc.next();
	    	List<Student> lst=sservice.getByName(nm);
	    	if(lst!=null) {
	    		lst.stream().forEach(ob->System.out.println(ob));
	    	}else {
	    		System.out.println("Not found");
	    	}
	    }
	    case 11->{}
	    default->System.out.println("Wrong choice");
	    }
		}while(choice!=11);
	}

}
