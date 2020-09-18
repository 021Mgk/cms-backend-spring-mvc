package cms.model.common;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CORSFilter")
public class CORSFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
         HttpServletResponse httpResponse = (HttpServletResponse) resp;
         httpResponse.addHeader("Access-Control-Allow-Origin", "*");
         httpResponse.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
         httpResponse.setHeader("Access-Control-Allow-Headers", "X-Requested-With, X-Auth-Token , Content-Type , Accept");
         chain.doFilter(req, resp);
    }
    public void init(FilterConfig config) throws ServletException {

    }

}
