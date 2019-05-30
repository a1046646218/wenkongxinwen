package HXBservlet;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import neu.edu.service.AddNewsService;
import neu.edu.service.ForNewsListService;

/**
 * Servlet implementation class PublicNewsServlet
 */
@WebServlet("/PublicNewsServlet")
@MultipartConfig
public class PublicNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//String bathcopyPath = "C:/Users/mr.H/git/wenkongxinwen/WebContent/upload/";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		System.out.println(title);
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		String nickname = "ruojichong";
		//
		int user_id = 1;
		Part part = request.getPart("file");
		String submittedFileName = part.getSubmittedFileName();//获取上传文件的名称     ***.jpg
		String houzhui = submittedFileName.substring(submittedFileName.indexOf("."));
		
		//解决文件重名问题
		UUID randomUUID = UUID.randomUUID();
		//为文件重新换一个名字
		String newFileName=randomUUID+houzhui;
		System.out.println(newFileName);
		
		String url = "upload/"+newFileName;

		//上传文件的操作
		String realPath = request.getServletContext().getRealPath("/upload");
		//realPath的格式 ,tomcat文件夹\webapps\项目名\ upload\
		//以我的为例 D:\apache-tomcat-8.0.21\webapps\javawebTest\ upload\
		System.out.println(realPath);
		
		//2.拼接文件上传路径和文件名
		String fileFinalPath = realPath+newFileName;
		
		//3. 上传
		part.write(fileFinalPath);
		//String copyPath = bathcopyPath+newFileName;
		//copyFile(fileFinalPath,copyPath);

		
		AddNewsService addNewsService = new AddNewsService();
		addNewsService.addNews(title, user_id, content, type, nickname, url);
		
		response.sendRedirect("main.jsp");
	}
	
	/**
	 * 
	 * @param srcPath  源文件位置 ,
	 * @param destPath 目标文件位置,
	 * @throws IOException
	 */
    private  void copyFile(String srcPath, String destPath) throws IOException {
        
        // 打开输入流
        FileInputStream fis = new FileInputStream(srcPath);
        // 打开输出流
        FileOutputStream fos = new FileOutputStream(destPath);
        
        // 读取和写入信息
        int len = 0;
        // 创建一个字节数组，当做缓冲区
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        
        // 关闭流  
        fos.close(); // 后开先关
        fis.close(); // 先开后关
        
    }
}
