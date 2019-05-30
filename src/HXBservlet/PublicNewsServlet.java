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
		String submittedFileName = part.getSubmittedFileName();//��ȡ�ϴ��ļ�������     ***.jpg
		String houzhui = submittedFileName.substring(submittedFileName.indexOf("."));
		
		//����ļ���������
		UUID randomUUID = UUID.randomUUID();
		//Ϊ�ļ����»�һ������
		String newFileName=randomUUID+houzhui;
		System.out.println(newFileName);
		
		String url = "upload/"+newFileName;

		//�ϴ��ļ��Ĳ���
		String realPath = request.getServletContext().getRealPath("/upload");
		//realPath�ĸ�ʽ ,tomcat�ļ���\webapps\��Ŀ��\ upload\
		//���ҵ�Ϊ�� D:\apache-tomcat-8.0.21\webapps\javawebTest\ upload\
		System.out.println(realPath);
		
		//2.ƴ���ļ��ϴ�·�����ļ���
		String fileFinalPath = realPath+newFileName;
		
		//3. �ϴ�
		part.write(fileFinalPath);
		//String copyPath = bathcopyPath+newFileName;
		//copyFile(fileFinalPath,copyPath);

		
		AddNewsService addNewsService = new AddNewsService();
		addNewsService.addNews(title, user_id, content, type, nickname, url);
		
		response.sendRedirect("main.jsp");
	}
	
	/**
	 * 
	 * @param srcPath  Դ�ļ�λ�� ,
	 * @param destPath Ŀ���ļ�λ��,
	 * @throws IOException
	 */
    private  void copyFile(String srcPath, String destPath) throws IOException {
        
        // ��������
        FileInputStream fis = new FileInputStream(srcPath);
        // �������
        FileOutputStream fos = new FileOutputStream(destPath);
        
        // ��ȡ��д����Ϣ
        int len = 0;
        // ����һ���ֽ����飬����������
        byte[] b = new byte[1024];
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        
        // �ر���  
        fos.close(); // ���ȹ�
        fis.close(); // �ȿ����
        
    }
}
