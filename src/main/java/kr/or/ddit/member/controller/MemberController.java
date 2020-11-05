package kr.or.ddit.member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.login.web.LoginController;
import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;

@Controller
@RequestMapping("/member")
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Resource(name = "memberService")
	private MemberServiceI memberService;

	@RequestMapping("/memberListPage")
	public String view(PageVO pageVo, Model model) {

		// pageVo에 담긴 값이 없을 경우 초기화 해준다.
		if (pageVo.getPage() == 0) {
			pageVo.setPage(1);
		}

		if (pageVo.getPageSize() == 0) {
			pageVo.setPageSize(5);
		}

		Map<String, Object> map = memberService.selectAllMemberPage(pageVo);

		// 전체 페이지수
		int totalCnt = (int) map.get("totalCnt");
		int pages = (int) Math.ceil((double) totalCnt / pageVo.getPageSize());
		logger.debug("pgaeSize : {}", pageVo.getPageSize());

		model.addAttribute("memberList", map.get("memberList"));
		model.addAttribute("pages", pages);

		return "member/memberList";

	}

	@RequestMapping("/getMember")
	public String getMember(String userid, Model model) {

		MemberVO memberVo = memberService.getMember(userid);

		model.addAttribute("memberVo", memberVo);

		return "member/member";
	}

	@RequestMapping("/profileImg")
	public void getProfile(String userid, HttpServletResponse response) {

		response.setContentType("image/png");

		MemberVO memberVo = memberService.getMember(userid);

		FileInputStream fis;
		try {
			fis = new FileInputStream(memberVo.getFilename());
			// file -> 문자열(text) : write , 이진파일 : outputStream
			ServletOutputStream sos = response.getOutputStream();

			byte[] buffer = new byte[512];

			while (fis.read(buffer) != -1) {
				sos.write(buffer);
			}

			fis.close();
			sos.flush(); // 응답이 안간 부분이 있으면 처리한다.
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/profileDownload")
	public void profileDownload(String userid, HttpServletResponse response) {

		MemberVO memberVo = memberService.getMember(userid);

		// response content-type 설정
		response.setHeader("Content-Disposition", "attachment; filename=\"" + memberVo.getRealFilename() + "\"");
		response.setContentType("application/octet-stream");

		FileInputStream fis;
		try {
			fis = new FileInputStream(memberVo.getFilename());
			// file -> 문자열(text) : write , 이진파일 : outputStream
			ServletOutputStream sos = response.getOutputStream();

			byte[] buffer = new byte[512];

			while (fis.read(buffer) != -1) {
				sos.write(buffer);
			}

			fis.close();
			sos.flush(); // 응답이 안간 부분이 있으면 처리한다.
			sos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping(path = "/memberUpdate", method = { RequestMethod.GET })
	public String memberUpdateGet(String userid, Model model) {

		MemberVO memberVo = memberService.getMember(userid);

		model.addAttribute("memberVo", memberVo);

		return "member/memberUpdate";

	}

	@RequestMapping(path = "/memberUpdate", method = { RequestMethod.POST })
	public String memberUpdatePost(MemberVO memberVo, @RequestPart("rf") MultipartFile file) {

		// 파일명만 추출
		String realfilename = "";
		String filePath = "";

		File uploadFile = null;

		// 파일명이 없을 경우
		if ("".equals(file.getOriginalFilename())) {
			MemberVO dbmemberVo = memberService.getMember(memberVo.getUserid());
			realfilename = dbmemberVo.getRealFilename();
			filePath = dbmemberVo.getFilename();

		} else { // 파일명이 있을 경우
			// 확장자 추출
			String filename = UUID.randomUUID().toString(); // 중복되지 않는 UUID를 반환

			// 파일 정보가 올바른지 간단하게 확인
			if (file.getSize() > 0) {
				filePath = "D:\\upload\\" + filename + "." + file.getOriginalFilename().split("\\.")[1];
				realfilename = file.getOriginalFilename();
				uploadFile = new File(filePath);
			}
			try {
				file.transferTo(uploadFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}

		memberVo.setRealFilename(realfilename);
		memberVo.setFilename(filePath);

		int updateCnt = memberService.updateMember(memberVo);

		if (updateCnt > 0) { // 1건이 입력되었을 때 : 정상 - member 페이지로 이동
			return "redirect:/member/getMember?userid=" + memberVo.getUserid();

		} else { // 1건이 아닐 때 : 비정상 - 사용자가 데이터를 다시 입력할 수 있도록 등록페이지로 이동
			return "member/memberUpdate";
		}
	}

	@RequestMapping(path = "/memberRegist", method = { RequestMethod.GET })
	public String memberRegistGet() {

		return "member/memberRegist";

	}

	@RequestMapping(path = "/memberRegist", method = { RequestMethod.POST })
	public String memberRegistPost(MemberVO memberVo, @RequestPart("rf") MultipartFile file) {
		// MemberVO 객체의 realFilename 속성과 multipartFile의 name속성이 같을 경우 
		// memberVo 객체에 넣을려고 하기 때문에 오류가 난다. 그래서 다르게 지정 해주어야 한다.

		// 파일명만 추출
		String realfilename = "";
		String filePath = "";

		File uploadFile = null;

		// 확장자 추출
		String filename = UUID.randomUUID().toString(); // 중복되지 않는 UUID를 반환
		
		// 파일 정보가 올바른지 간단하게 확인
		if (file.getSize() > 0) {
			filePath = "D:\\upload\\" + filename + "." + file.getOriginalFilename().split("\\.")[1];
			realfilename = file.getOriginalFilename();
			uploadFile = new File(filePath);
		}
		try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		memberVo.setRealFilename(realfilename);
		memberVo.setFilename(filePath);

		int insertCnt = memberService.insertMember(memberVo);
		
		if (insertCnt > 0) { // 1건이 입력되었을 때 : 정상 - member 페이지로 이동
			return "redirect:/member/memberListPage";

		} else { // 1건이 아닐 때 : 비정상 - 사용자가 데이터를 다시 입력할 수 있도록 등록페이지로 이동
			return "member/memberRegist";
		}
	}
	
}
