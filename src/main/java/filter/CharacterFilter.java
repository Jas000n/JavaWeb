package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.LogRecord;
@WebFilter(urlPatterns = { "/Equi/EquiManage","/Prod/ProdManage","/User/UserManage","/Fact/FactManage","/Rent/RentManage","/Order/OrderManage","/Bid/BidManage","/Sche/ScheManage"})
public class CharacterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}