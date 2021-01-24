package com.wuwenwen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 *  键盘录入三个学生信息：
 *  （学号，姓名，年龄，居住地）存入集合
 *  然后遍历每个学生信息存入文本文件；
 *  每个学生信息为一行数据，自己定义分割标记；
 * 
 *  1.定义学生类
 *  2.创建集合对象
 *  3.写方法实现学生信息录入，并把学生对象作为元素添加到集合
 *  4.创建输出缓冲流对象
 *  5.遍历集合，得到每个学生信息，并把学生信息按照一定格式写入文件
 *     举例：0001，小明，18，浙江
 *  6.释放资源
 * 
 */
public class ArrayListToFileTest {
	public static void main(String[] args) throws IOException {
		//创建集合对象
		ArrayList<Student> arr = new ArrayList<Student>();
		
		//调用添加学生的方法
		addStu(arr);
		addStu(arr);
	
		//创建输出缓冲流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("bw1.txt"));
		
		//遍历集合
		for(int i=0;i<arr.size();i++) {
			Student s = arr.get(i);
			StringBuilder sb = new StringBuilder();
			sb.append(s.getId()).append(",");
			sb.append(s.getName()).append(",");
			sb.append(s.getAge()).append(",");
			sb.append(s.getAddress()).append(",");
			
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
			
		}
		bw.close();
	}
	//添加学生
	public static void addStu(ArrayList<Student> arr){
		Scanner sc = new Scanner(System.in);

		String id;
		while(true) {

			System.out.println("请输入学生学号：");
			id = sc.nextLine();


			boolean flag = false;

			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				if(s.getId().equals(id))
					flag = true;
				break;
			}

			if(flag) {
				System.out.println("你的学号被占用，请重新输入！");
			}else {
				break;
			}
		}

		System.out.println("请输入学生姓名：");
		String name = sc.nextLine();
		System.out.println("请输入学生年龄：");
		String age = sc.nextLine();
		System.out.println("请输入学生居住地：");
		String address = sc.nextLine();




		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);

		arr.add(s);

		System.out.println("添加成功！");

	}//添加
}
