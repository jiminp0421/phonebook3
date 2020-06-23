package com.javaex.dao;

import java.util.List;

import com.javaex.vo.PersonVo;

public class PhoneTest {

	public static void main(String[] args) {
		
		
		
		PhoneDao phoneDao = new PhoneDao();
		
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList.toString());
		
		/*PersonVo personVo = new PersonVo("박지민","010-222-2222","02-3333-33333");
		phoneDao.personInsert(personVo);*/
		
		PersonVo personVo = phoneDao.getPerson(1);
		System.out.println(personVo.toString());
		
		
	}

}
