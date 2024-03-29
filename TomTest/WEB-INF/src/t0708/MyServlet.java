package t0708;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
  //서블릿 : 한개의 웹페이지 화면을 구성!!
	
   @Override
   public void init() throws ServletException {
	  System.out.println("init()");
   }
   
   @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("service()");
	   //서블릿 서비스 메소드 == 웹브라우저 서비스!! ==> HTML 서비스
	   //request:클라이언트(사용자, 브라우저), response : 서버를 각각 의미
	   
	   // (한글)문자집합 설정
	   response.setContentType("text/html;charset=UTF-8");
	   // text/html => MIME형식
	   // 입력:text 출력:html => out.print() 메소드를 통해 전달되는 text를 브라우저에게 html해석하시오!
	   //text:plane; text:xml; 이런식으로 형식을 줄 수 있다!
	   
	   PrintWriter out = response.getWriter();
	   //PrintWriter out ==> 브라우저 출력 객체를 의미함.
	   //out.print("HTML코드(텍스트)");
	   
	   out.print("<html><head><title></title></head>");
	   out.print("<body><h3>ServletTest</h3></hr>");
	   for (int i = 0; i < 10; i++) {
		   if(i%2==0)
		   out.println("<b><font color = red>용진</font></b><br>");
		   if(i%2==1)
	    	out.println("<b><font color = blue>진주</font></b><br>");
	}
	   out.print("</body></html>");
	}
   
    @Override
    public void destroy() {
       System.out.println("destroy()");
    }
	
}
