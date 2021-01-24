package com.wuwenwen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 *  ����¼������ѧ����Ϣ��
 *  ��ѧ�ţ����������䣬��ס�أ����뼯��
 *  Ȼ�����ÿ��ѧ����Ϣ�����ı��ļ���
 *  ÿ��ѧ����ϢΪһ�����ݣ��Լ�����ָ��ǣ�
 * 
 *  1.����ѧ����
 *  2.�������϶���
 *  3.д����ʵ��ѧ����Ϣ¼�룬����ѧ��������ΪԪ����ӵ�����
 *  4.�����������������
 *  5.�������ϣ��õ�ÿ��ѧ����Ϣ������ѧ����Ϣ����һ����ʽд���ļ�
 *     ������0001��С����18���㽭
 *  6.�ͷ���Դ
 * 
 */
public class ArrayListToFileTest {
	public static void main(String[] args) throws IOException {
		//�������϶���
		ArrayList<Student> arr = new ArrayList<Student>();
		
		//�������ѧ���ķ���
		addStu(arr);
		addStu(arr);
	
		//�����������������
		BufferedWriter bw = new BufferedWriter(new FileWriter("bw1.txt"));
		
		//��������
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
	//���ѧ��
	public static void addStu(ArrayList<Student> arr){
		Scanner sc = new Scanner(System.in);

		String id;
		while(true) {

			System.out.println("������ѧ��ѧ�ţ�");
			id = sc.nextLine();


			boolean flag = false;

			for(int i=0;i<arr.size();i++) {
				Student s = arr.get(i);
				if(s.getId().equals(id))
					flag = true;
				break;
			}

			if(flag) {
				System.out.println("���ѧ�ű�ռ�ã����������룡");
			}else {
				break;
			}
		}

		System.out.println("������ѧ��������");
		String name = sc.nextLine();
		System.out.println("������ѧ�����䣺");
		String age = sc.nextLine();
		System.out.println("������ѧ����ס�أ�");
		String address = sc.nextLine();




		Student s = new Student();
		s.setId(id);
		s.setName(name);
		s.setAge(age);
		s.setAddress(address);

		arr.add(s);

		System.out.println("��ӳɹ���");

	}//���
}
