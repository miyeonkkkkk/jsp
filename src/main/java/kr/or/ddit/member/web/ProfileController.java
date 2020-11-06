package kr.or.ddit.member.web;

import java.io.FileInputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.member.model.MemberVO;
import kr.or.ddit.member.service.MemberServiceI;

@Controller
public class ProfileController {

	@Resource(name = "memberService")
	private MemberServiceI memberService;

	@RequestMapping("/profileImgDownloadView") // -- 두번째 방법
	public String profileImgDownload(String userid, Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는 것

		MemberVO memberVo = memberService.getMember(userid);
		
		model.addAttribute("realFileName", memberVo.getRealFilename());
		model.addAttribute("fileName", memberVo.getFilename());

		return "profileImgDownloadView";
	}

	@RequestMapping("/profileImgView") // -- 두번째 방법
	public String profileImgView(String userid, Model model) throws IOException {
		// 응답으로 생성하려고 하는 것 : 이미지 파일을 읽어서 output stream 객체에 쓰는 것

		MemberVO memberVo = memberService.getMember(userid);

		model.addAttribute("filepath", memberVo.getFilename());

		return "profileImgView";
	}

	// @RequestMapping("/profileImg") -- 첫번째 방법
	public void profileImg(HttpServletResponse response, String userid) {

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
}
