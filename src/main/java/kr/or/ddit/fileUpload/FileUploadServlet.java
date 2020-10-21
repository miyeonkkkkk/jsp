package kr.or.ddit.fileUpload;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// maxFileSize : 파일 하나당 최대 허용 크기
// maxRequestSize : 요청에 담긴 모든 사이즈
// 단위 : byte
// 1 MB = 1024KB = 1024 * 1024
// 10 MB = 1024KB * 10 = 1024 * 1024 * 10
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*26 )
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// HTTP Message의 body 영역에 있는 타입에서 대해서 가져온다.
		// get방식은 line에 파라미터가 담기고, post방식은 body에 파라미터가 담긴다.
		// 응답은 대부분 html
		logger.debug("request.getContentType() : {}", request.getContentType());
		request.getRequestDispatcher("/fileUpload/uploadView.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("post request.getContentType() : {}", request.getContentType());
		
		String userid = request.getParameter("userid");
		String img = request.getParameter("img");
		
		// body 영역에 있는 데이터를 이진데이터로 변환해준다.
//		BufferedReader br = request.getReader();
//		char[] buffer = new char[512];
//		
//		while (br.read(buffer) != -1) {
//			for(int i=0; i < buffer.length; i++) {
//				System.out.print(buffer[i]);
//			}
////			logger.debug("{}", buffer);
//		}
		
		// multipart 형태로 보냈기 때문에 따로 설정을 해주어야 값을 읽을 수 있다.
//		@MultipartConfig(maxFileSize = 5000, maxRequestSize = 5000*10 )
		logger.debug("userid : {}", userid);
		logger.debug("img : {}", img);
		
		// userid파트 , img파트 
		Part imgPart = request.getPart("img");
		logger.debug("imgPart.getName() : {} ", imgPart.getName());
		logger.debug("imgPart.getSize() : {} ", imgPart.getSize()); // 단위 byte
		logger.debug("imgPart.getContentType() : {} ", imgPart.getContentType());
		
		// file명을 header를 통해서도 가져올 수 있다.
		logger.debug(imgPart.getHeader("Content-Disposition"));
		
		// form-data; name="img"; filename="aa.jpg"
		String cd = imgPart.getHeader("Content-Disposition");
		logger.debug("FileUploadUtil.getFileNameFromHeader() : {}", FileUploadUtil.getFileNameFromHeader(cd));
		
		String fileName = FileUploadUtil.getFileNameFromHeader(cd);
		
		// write : 경로를 포함한 파일명
		imgPart.write("d:\\upload\\" + fileName);
		
		// 파일이 너무 큰 경우 임시메모리 공간에 저장을 하게 되는데 작업이 끝난 후, 그런 불필요한 메모리를 삭제 해준다.
		imgPart.delete();
		
		
	}
}
