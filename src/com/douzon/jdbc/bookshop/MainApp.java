package com.douzon.jdbc.bookshop;

import java.util.List;
import java.util.Scanner;

import com.douzon.jdbc.bookshop.dao.BookDao;
import com.douzon.jdbc.bookshop.vo.BookVo;

public class MainApp {

	public static void main(String[] args) {
		displayBookInfo();

		Scanner sc = new Scanner(System.in);

		System.out.print("대여 하고 싶은 책의 번호를 입력하세요 : ");
		long num = sc.nextLong();

		rent(num);

		displayBookInfo();
	}

	private static void rent(long no) {
		new BookDao().updateStatus(no, "대여중");
	}

	private static void displayBookInfo() {

		System.out.println("*******도서내용 출력*******");

		List<BookVo> list = new BookDao().getList();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

}