package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.fileUpload.FileUploadUtil;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/memberRegist")
@MultipartConfig
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(MemberRegistServlet.class);
	
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/member/memberRegist.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 필터를 이용하여 인코딩 해준다.
		
		String userid = request.getParameter("userid");
		String usernm = request.getParameter("usernm");
		String alias = request.getParameter("alias");
		String pass = request.getParameter("pass");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		
		logger.debug("parameter : {}, {}, {}, {}, {}, {}, {}" ,
				userid, usernm, alias, pass, addr1, addr2, zipcode);
		
		Part profile = request.getPart("realFilename");
		logger.debug("file : {} " , profile.getHeader("Content-Disposition"));
		
		// 파일명만 추출
		String realfilename = FileUploadUtil.getFileNameFromHeader(profile.getHeader("Content-Disposition"));
		// 확장자 추출
		String extension = FileUploadUtil.getExtension(realfilename);
		logger.debug("extension : {} " , extension);
		
		String filename = UUID.randomUUID().toString(); // 중복되지 않는  UUID를 반환

		String filePath = "";
		// 파일 정보가 올바른지 간단하게 확인
		if(profile.getSize() > 0) {
			filePath = "D:\\profile\\" + filename + "." + extension;
			profile.write(filePath);
		}
		
		// 사용자 정보 등록
		MemberVO mv = new MemberVO(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realfilename);
		//memberService.deleteMember(userid);
		
		int insertCnt = memberService.insertMember(mv);
		
		if(insertCnt > 0) { // 1건이 입력되었을 때 : 정상 - memberList 페이지로 이동
			// 기존에 왔던 요청 정보를 기반으로 forward 시킨다.
			// post 요청은 post요청으로 forward
//			request.getRequestDispatcher("/memberListPage").forward(request, response);
			// 여기서 새로고침을 하게 되면 최초요청부터 다시 실행된다. => 오류 발생
			
			// 이럴경우에 redirect를 사용한다. => 서버쪽에 상태가 바뀔경우 ex) 정보를 등록하는 경우(db가 변경)
			response.sendRedirect(request.getContextPath() + "/memberListPage");
			
		}else { // 1건이 아닐 때 : 비정상 - 사용자가 데이터를 다시 입력할 수 있도록 등록페이지로 이동
			doGet(request, response);
		}
		
		
	}

}
