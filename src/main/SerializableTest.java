package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import test.*;
import test1.*;
import test2.*;

public class SerializableTest {
	public static void Serialize(Object obj,String filename) throws Exception {
		File file =new File(filename);
		FileOutputStream out=new FileOutputStream(file);
		ObjectOutputStream ob=new ObjectOutputStream(out);
		ob.writeObject(obj);
		ob.flush();
		ob.close();
		out.close();
	}
	public static Object DeSerialize(String filename) throws Exception{
		File file=new File(filename);
		FileInputStream in=new FileInputStream(file);
		ObjectInputStream ob=new ObjectInputStream(in);
		Object obj=ob.readObject();
		in.close();
		ob.close();
		return obj;
	}
	public static void main(String[] args) throws Exception {
		// TODO 自动生成的方法存根
		//test
		Person person=new Person();
		person.setName("person");
		Student student=new Student();
		student.setName("student");
		SerializableTest.Serialize(person,"D:/testperson.txt");
		SerializableTest.Serialize(student,"D:/teststudent.txt");
		System.out.println("序列化："+person.getName());
		System.out.println("序列化："+student.getName());
		Person per=(Person)SerializableTest.DeSerialize("D:/testperson.txt");
		Student stu=(Student)SerializableTest.DeSerialize("D:/teststudent.txt");
		System.out.println("反序列化："+per.getName());
		System.out.println("反序列化："+stu.getName());
		//test1
		Person1 person1=new Person1();
		person1.setName("person1");
		Student1 student1=new Student1();
		student1.setName("student1");
		SerializableTest.Serialize(person1,"D:/testperson1.txt");
		SerializableTest.Serialize(student1,"D:/teststudent1.txt");
		System.out.println("序列化："+person1.getName());
		System.out.println("序列化："+student1.getName());
		Person1 per1=(Person1)SerializableTest.DeSerialize("D:/testperson1.txt");
		Student1 stu1=(Student1)SerializableTest.DeSerialize("D:/teststudent1.txt");
		System.out.println("反序列化："+per1.getName());
		System.out.println("反序列化："+stu1.getName());
		//test2
		Person2 person2=new Person2();
		Student2 student2=new Student2();
		person2.setName("person2");
		student2.setName("student2");
		
		SerializableTest.Serialize(student2,"D:/teststudent2.txt");
		System.out.println("序列化："+student2.getName());
		Student2 stu2=(Student2)SerializableTest.DeSerialize("D:/teststudent2.txt");
		System.out.println("反序列化："+stu2.getName());
	
		SerializableTest.Serialize(person2,"D:/testperson2.txt");
		System.out.println("序列化："+person2.getName());
		Person2 per2=(Person2)SerializableTest.DeSerialize("D:/testperson2.txt");	
		System.out.println("反序列化："+per2.getName());
	}

}
