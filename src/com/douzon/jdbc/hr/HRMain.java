package com.douzon.jdbc.hr;

import java.util.Scanner;
import com.douzon.jdbc.hr.dao.EmployeeDao;

public class HRMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("이름 검색");
		System.out.print(">>");

		new EmployeeDao().selectStatus(sc.next());
	}

}
