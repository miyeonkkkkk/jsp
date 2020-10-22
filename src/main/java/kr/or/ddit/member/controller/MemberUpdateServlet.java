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

@WebServlet("/memberUpdate")
@MultipartConfig
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberUpdateServlet.class);
	private MemberServiceI memberService;
	
	@Override
	public void init() throws ServletException {
		memberService = new MemberServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		//logger.debug("userid : {}", userid);
		
		MemberVO memberVo = memberService.getMember(userid);
		
		request.setAttribute("memberVo", memberVo);
		
		request.getRequestDispatcher("/member/memberUpdate.jsp").forward(request, response);
		
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
		
//		logger.debug("parameter : {}, {}, {}, {}, {}, {}, {}" ,
//				userid, usernm, alias, pass, addr1, addr2, zipcode);
		
		Part profile = request.getPart("realFilename");
//		logger.debug("file : {} " , profile.getHeader("Content-Disposition"));
		
		// 파일명만 추출
		String realfilename = FileUploadUtil.getFileNameFromHeader(profile.getHeader("Content-Disposition"));
		
		String filePath = "";
		
		// 파일명이 없을 경우
		if("".equals(realfilename)) {
			MemberVO memberVo = memberService.getMember(userid);
			realfilename = memberVo.getRealFilename();
			filePath = memberVo.getFilename();
			
		}else { // 파일명이 있을 경우
			// 확장자 추출
			String extension = FileUploadUtil.getExtension(realfilename);
			logger.debug("extension : {} " , extension);
			
			String filename = UUID.randomUUID().toString(); // 중복되지 않는  UUID를 반환
			
			// 파일 정보가 올바른지 간단하게 확인
			if(profile.getSize() > 0) {
				filePath = "D:\\profile\\" + filename + "." + extension;
				profile.write(filePath);
			}
		}
		
		// 사용자 정보 등록
		MemberVO mv = new MemberVO(userid, pass, usernm, alias, addr1, addr2, zipcode, filePath, realfilename);
		
		int updateCnt = memberService.updateMember(mv);
		
		if(updateCnt > 0) { // 1건이 입력되었을 때 : 정상 - member 페이지로 이동
			response.sendRedirect(request.getContextPath() + "/member?userid=" + userid);
			
		}else { // 1건이 아닐 때 : 비정상 - 사용자가 데이터를 다시 입력할 수 있도록 등록페이지로 이동
			doGet(request, response);
		}
		
	}

}
