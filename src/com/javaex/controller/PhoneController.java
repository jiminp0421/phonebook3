package com.javaex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaex.dao.PhoneDao;
import com.javaex.util.WebUtil;
import com.javaex.vo.PersonVo;


@WebServlet("/pbc")
public class PhoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/pbc --> doGet()"); 
		
		String action = request.getParameter("action");
		
		//서블릿 자바코드 jsp는 html /요청은 list 일때가 응답은 list.jsp가 이런것을 포워드라고한다.
		
		//링크에 action을 빼먹었을때 action이 null이된다 if(action.equals("list")) 그래서 메소드를 읽을수없음(.이 메소드) 그럴경우 아래 코드를  쓰면된다.
		if("list".equals(action)) {
			System.out.println("list");

		//controller 등록폼 완성
		
			//phonedao객체 가져올거야
			PhoneDao dao = new PhoneDao();
			List<PersonVo> pList = dao.getPersonList();  //list일때 list.jsp 이 과정이고 하던 request와 response 그리고 plist를 request에 넣어서 list.jsp에게 줄것이다. 
			
			//포워드 작업 첫번째 request와 response를 두번째 request와 response list.jsp에 줄때 body에 넣어서 보내줄것이다. 어트리뷰트: “pList”, personList
			
			//데이터 리퀘스트에 추가
			request.setAttribute("personList", pList); //pList 데이터에 personList의 이름을 넣어서 사용할거야 personList = pList
			
			//포워드 하는방법
			WebUtil.forword(request, response, "/WEB-INF/list.jsp");			
			/*
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/list.jsp");
			rd.forward(request, response);
			*/
	}else if("wform".equals(action)) {
		System.out.println("주소록 등록폼");
		
		//포워드 하는방법
			WebUtil.forword(request, response, "/WEB-INF/writeForm.jsp");
			
		/*
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/writeForm.jsp");
			rd.forward(request, response);
			*/
		
	}else if("insert".equals(action)) {
		System.out.println("번호 저장");
		
		String name = request.getParameter("name");
		String hp = request.getParameter("hp");
		String company = request.getParameter("company");
		
		PersonVo vo = new PersonVo(name, hp, company);
		System.out.println(vo);
		PhoneDao dao = new PhoneDao();
		dao.personInsert(vo);
		
		//리다이렉트
		WebUtil.redirect(request, response, "/pb3/pbc?action=list");
		//response.sendRedirect("/pb3/pbc?action=list"); //리다이렉트는 다시 주소위치를 알려줘야한다
		
	}	

		
		
		//리스트일때 action자리에 넣을거야
		
		//등록일때 action자리에 넣을거야
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
