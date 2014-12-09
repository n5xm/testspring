package com.yiibai;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
	public static void useBeans1() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans1.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
	}

	public static void useBeans2() {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"conf/Beans2.xml"));
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		obj.getMessage();
	}

	public static void useBeans3() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans3.xml");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.setMessage("I'm object A");
		objA.getMessage();
		HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
		objB.getMessage();
	}

	public static void useBeans4() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans4.xml");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.setMessage("I'm object A");
		objA.getMessage();
		HelloWorld objB = (HelloWorld) context.getBean("helloWorld");
		objB.getMessage();
	}

	public static void useBeans5() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans5.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		context.registerShutdownHook();
	}

	public static void useBeans6() {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans6.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		context.registerShutdownHook();
	}

	public static void useBeans7() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans7.xml");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.getMessage1();
		objA.getMessage2();
		HelloIndia objB = (HelloIndia) context.getBean("helloIndia");
		objB.getMessage1();
		objB.getMessage2();
		objB.getMessage3();
	}

	public static void useBeans8() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans8.xml");
		TextEditor te = (TextEditor) context.getBean("textEditor");
		te.spellCheck();
	}

	public static void useBeans9() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans9.xml");
		JavaCollection jc = (JavaCollection) context.getBean("javaCollection");
		jc.getAddressList();
		jc.getAddressSet();
		jc.getAddressMap();
		jc.getAddressProp();
	}

	public static void unuseBeans1() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				HelloWorldConfig.class);
		HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
		helloWorld.setMessage("Hello World!");
		helloWorld.getMessage();
	}

	public static void unuseBeans2() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				TextEditorConfig.class);
		TextEditor2 te = ctx.getBean(TextEditor2.class);
		te.spellCheck();
	}

	public static void useBeans10() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans10.xml");
		// Let us raise a start event.
		context.start();
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		// Let us raise a stop event.
		context.stop();
	}

	public static void useBeans11() {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans11.xml");
		CustomEventPublisher cvp = (CustomEventPublisher) context
				.getBean("customEventPublisher");
		cvp.publish();
		cvp.publish();
	}

	public static void useBeans12() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans12.xml");
		Student student = (Student) context.getBean("student");
		student.getName();
		student.getAge();
		student.printThrowException();
	}

	public static void useBeans13() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans13.xml");
		Student student = (Student) context.getBean("student");
		student.getName();
		student.getAge();
		student.printThrowException();
	}

	/**
	 * http://www.yiibai.com/spring/spring_jdbc_example.html
	 */
	public static void useBeans14() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans14.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context
				.getBean("studentJDBCTemplate");
		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("Zara", 11);
		studentJDBCTemplate.create("Nuha", 2);
		studentJDBCTemplate.create("Ayan", 15);
		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudents();
		for (Student record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}
		System.out.println("----Updating Record with ID = 2 -----");
		studentJDBCTemplate.update(2, 20);
		System.out.println("----Listing Record with ID = 2 -----");
		Student student = studentJDBCTemplate.getStudent(2);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());
	}

	/**
	 * http://www.yiibai.com/spring/calling_stored_procedure.html
	 */
	public static void useBeans15() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans15.xml");
		StudentJDBCTemplate2 studentJDBCTemplate = (StudentJDBCTemplate2) context
				.getBean("studentJDBCTemplate");
		System.out.println("------Records Creation--------");
		studentJDBCTemplate.create("Zara", 11);
		studentJDBCTemplate.create("Nuha", 2);
		studentJDBCTemplate.create("Ayan", 15);
		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentJDBCTemplate.listStudents();
		for (Student record : students) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.println(", Age : " + record.getAge());
		}
		System.out.println("----Listing Record with ID = 2 -----");
		Student student = studentJDBCTemplate.getStudent(2);
		System.out.print("ID : " + student.getId());
		System.out.print(", Name : " + student.getName());
		System.out.println(", Age : " + student.getAge());
	}

	/**
	 * http://www.yiibai.com/spring/programmatic_management.html
	 */
	public static void useBeans16() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans16.xml");
		StudentJDBCTemplate3 studentJDBCTemplate = (StudentJDBCTemplate3) context
				.getBean("studentJDBCTemplate");
		System.out.println("------Records creation--------");
		studentJDBCTemplate.create("Zara", 11, 99, 2010);
		studentJDBCTemplate.create("Nuha", 20, 97, 2010);
		studentJDBCTemplate.create("Ayan", 25, 100, 2011);
		System.out.println("------Listing all the records--------");
		List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
		for (StudentMarks record : studentMarks) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.print(", Marks : " + record.getMarks());
			System.out.print(", Year : " + record.getYear());
			System.out.println(", Age : " + record.getAge());
		}
	}

	/**
	 * http://www.yiibai.com/spring/declarative_management.html
	 */
	public static void useBeans17() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans17.xml");
		StudentDAO3 studentJDBCTemplate = (StudentDAO3) context
				.getBean("studentJDBCTemplate");
		System.out.println("------Records creation--------");
		studentJDBCTemplate.create("Zara", 11, 99, 2010);
		studentJDBCTemplate.create("Nuha", 20, 97, 2010);
		studentJDBCTemplate.create("Ayan", 25, 100, 2011);
		System.out.println("------Listing all the records--------");
		List<StudentMarks> studentMarks = studentJDBCTemplate.listStudents();
		for (StudentMarks record : studentMarks) {
			System.out.print("ID : " + record.getId());
			System.out.print(", Name : " + record.getName());
			System.out.print(", Marks : " + record.getMarks());
			System.out.print(", Year : " + record.getYear());
			System.out.println(", Age : " + record.getAge());
		}
	}

	static Logger log = Logger.getLogger(MainApp.class.getName());

	/**
	 * http://www.yiibai.com/spring/logging_with_log4j.html
	 */
	public static void useBeans18() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"conf/Beans18.xml");
		log.info("Going to create HelloWord Obj");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();
		log.info("Exiting the program");
	}

	public static void main(String[] args) {
		useBeans18();
		// unuseBeans2();
	}
}