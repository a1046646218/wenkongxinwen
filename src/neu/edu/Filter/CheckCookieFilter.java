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
 * Servlet Filter implementation class CheckCookieFilter
 */
@WebFilter(filterName="/cookieFilter",urlPatterns="/main.jsp")
public class CheckCookieFilter implements Filter {

    /**
     * Default constructor. 
     */
    public CheckCookieFilter() {
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
	
			
			Cookie[] cookies = req.getCookies();
			if(cookies.length==0) {
				for(Cookie c :cookies) {
					String name = c.getName();
					if("userName".equals(c.getName())){
						ForUserService  fus=new ForUserService ();
						User user=fus.getUserByusername(c.getValue());
						req.getSession().setAttribute("user", user);
					}
				}				
			}
			
			
			chain.doFilter(request, response);
		
	
		//如果不是登录请求,那么我们来获取session中用户对象
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
