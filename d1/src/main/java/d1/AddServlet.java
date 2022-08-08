package d1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		try{
		//it will get the number1 and number2 from the user input and convert into integer
			
			int i = Integer.parseInt(req.getParameter("num1")); 
			int j = Integer.parseInt(req.getParameter("num2"));
			int k = i+j;
			PrintWriter out = res.getWriter();
			out.println("result is "+k);

			
			}
			catch(Exception e){
				System.out.println("Number Exception "+e);
				
			}
		}

	}
			
			
			
