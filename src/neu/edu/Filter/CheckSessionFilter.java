package neu.edu.Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;



import neu.edu.entity.User;
import neu.edu.service.ForUserService;

/**
 * Servlet Filter implementation class CheckSessionFilter
 */
@WebFilter(filterName="/checkSessionFilter",urlPatterns="/*")
public class CheckSessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckSessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest)request;//�Ƚ�ԭʼ��requestת���ɷ���httpЭ���request����
			String url = req.getServletPath();//��ȡ��վ��Ŀ¼֮�������,��/login?id=zhangsan
			System.out.println("url:-----------"+url);
			if(url.contains("login")
					||url.contains("register")
				||url.contains("main")||url.contains("ForNewsServlet")||url.endsWith("css")||url.endsWith("js")||url.endsWith("jpg")
				||url.endsWith("db")||url.endsWith("png")||url.endsWith("eot")||url.endsWith("svg")||url.endsWith("ttf")||url.endsWith("woff")
				||url.endsWith("woff2")||url.endsWith("otf"))
					{
				chain.doFilter(request, response);
				return;
			}
			
			//������ǵ�¼����,��ô��������ȡsession���û�����
			User u = (User)req.getSession().getAttribute("user");
			if (null!=u) {
				chain.doFilter(request, response);
			}else{
				req.getRequestDispatcher("login.jsp").forward(request, response);
			}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
