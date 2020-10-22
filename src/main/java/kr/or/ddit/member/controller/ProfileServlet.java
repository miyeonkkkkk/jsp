package kr.or.ddit.member.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/profileImg")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response content-type 설정
		// image/png , image/gif, image/jpg, 확장자를 모를경우에는 image
		// 파일명을 파라미터로 받아 확장자를 추출
		response.setContentType("image/png");
		
		// 사용자 아이디 파라미터 확인
		String userid = request.getParameter("userid");
		
		// db에서 사용자 filename확인
		MemberVO mv = memberService.getMember(userid);
		
		// 경로 확인 후 파일 입출력을 통해 응답 생성
		// 파일 읽기
		// 응답 생성
//		mv.getFilename(); // 파일 경로
		FileInputStream fis = new FileInputStream(mv.getFilename());
		
		// file -> 문자열(text) : write , 이진파일 : outputStream
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer) != -1) {
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush(); // 응답이 안간 부분이 있으면 처리한다.
		sos.close();
		
		
		
	}


}
