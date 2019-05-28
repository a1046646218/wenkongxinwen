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
		 HttpServletRequest req = (HttpServletRequest)request;//先将原始的request转换成符合http协议的request对象
			String url = req.getServletPath();//获取网站根目录之后的内容,如/login?id=zhangsan
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
			
			//如果不是登录请求,那么我们来获取session中用户对象
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
