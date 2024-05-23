import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String message = null;
        String username = request.getParameter("username");          //取出用户名和密码
        String password = request.getParameter("password");
        if ("admin".equals(username) && "admin".equals(password)) {             //登录成功
            //判断是否勾选自动登录
            if (request.getParameter("check") != null && request.getParameter("check").equals("check")) {
                //生成Cookie
                Cookie nameCookie = new Cookie("username", username);
                Cookie passwordCookie = new Cookie("password", password);
                nameCookie.setMaxAge(60 * 1);
                passwordCookie.setMaxAge(60 * 1);
                response.addCookie(nameCookie);
                response.addCookie(passwordCookie);
            }
            message = "你已登录成功！";
            request.getSession().setAttribute("message", message);
            response.sendRedirect("../welcome.jsp");
        }else {
            //登录失败
            message = "用户名或口令不正确，请重试！";
            response.sendRedirect("../login.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //直接通过链接访问时
        String message = null;
        //从Cookie中取出值
        String value1 = "";
        String value2 = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    value1 = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    value2 = cookie.getValue();
                }
            }
        }
        if (value1.equals("admin") && value2.equals("admin")) {
            message = "欢迎您！" + value1 + "！再次登录该页面！";
            request.getSession().setAttribute("message", message);
            response.sendRedirect("../welcome.jsp");
        } else {
            response.sendRedirect("../login.jsp");
        }
    }
}

