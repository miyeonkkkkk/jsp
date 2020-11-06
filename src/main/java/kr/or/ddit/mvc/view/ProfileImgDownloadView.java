package kr.or.ddit.mvc.view;

import java.io.FileInputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class ProfileImgDownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// response content-type 설정
		response.setHeader("Content-Disposition", "attachment; filename=\"" + (String)model.get("realFileName") + "\"");
		response.setContentType("application/octet-stream");

		FileInputStream fis;
		try {
			fis = new FileInputStream((String)model.get("fileName"));
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
