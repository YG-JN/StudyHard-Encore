package t0708;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CountServlet extends HttpServlet{
	int cnt;//=0;
	ArrayList<String> list;// 접속한 ip주소를 저장하는 용도
	
	
	@Override
	public void init() throws ServletException {
		list = new ArrayList<>(); //1회 실행
	}
	
    @Override
    protected void service(HttpServletRequest req, 
    		               HttpServletResponse resp) throws ServletException, IOException {
    	
    	
       resp.setContentType("text/html;charset=UTF-8");
       //한글을 한개라도 사용하면 글자 깨짐을 방지하기 위해 '문자셋'설정을 해야 함.
    	
       //req: 요청객체(브라우저,클라이언트), resp:응답객체(서버,출력)
       PrintWriter out = resp.getWriter();//out: 브라우저 출력객체
         //out.print("HTML텍스트");
         out.print("<html><head><title>ServletCount</title></head>");
         out.print("<body><h3>ServletCounter</h3><hr>");
       
      //동일 사용자(동일 브라우저접속)의 경우 ==> 조회 수를 1증가!!
         //req ==브라우저
         //HttpSession session = req.getSession(); //세션은 접속이다!!
         //if(session.isNew())
         
       String addr = req.getRemoteAddr();//접속한 클라이언트(브라우저)의 ip주소 얻기
           //addr ="192.168.0.90"
       System.out.println("접속클라이언트 ip주소["+addr+"]");  
       
         if(!list.contains(addr)) {//이미 접속한 ip가 아니라면, ip주소가 list에 포함되지 않았다면
             cnt++;
             list.add(addr);
         }
         
         out.print("조회수: "+  cnt  +"회</body></html>");
        	
    }//service
    
}
