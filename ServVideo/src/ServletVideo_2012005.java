

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletVideo_2012005
 */
@WebServlet("/ServletVideo_2012005")
public class ServletVideo_2012005 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VIDEO_ADDED = "Video added.";
       
	private List<Video> videos = new ArrayList<Video>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVideo_2012005() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*response.setContentType("text/plain");
		PrintWriter sendToClient = response.getWriter();
		for(Video v:this.videos)
		{
			sendToClient.write(v.getName()+"\n");
		}
		*/
		response.getOutputStream().println("Hurray !! This Servlet Works");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String durations = request.getParameter("duration");
		String heights = request.getParameter("height");
		String widths = request.getParameter("width");
		long duration = -1;
		long height = -1;
		long width = -1;
		try{
			duration= Long.parseLong(durations);
			height= Long.parseLong(heights);
			width= Long.parseLong(widths);
		}catch(NumberFormatException e){
			
		}
		
		response.setContentType("text/plain");
		if (name == null || type == null || durations == null || heights==null || widths==null || name.trim().length() < 1 || type.trim().length() < 1 || durations.trim().length() < 1 || heights.trim().length() < 1 || widths.trim().length() <1 || duration <= 0 || height <=0 || width <=0) {
			response.sendError(400, "Missing ['name','duration','type','height','width'].");
		} 
		else {
			Video v = new Video(name, type, duration, height, width);
			
			videos.add(v);
			
			response.getWriter().write(VIDEO_ADDED);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String durations = request.getParameter("duration");
		String heights = request.getParameter("height");
		String widths = request.getParameter("width");
		long duration = -1;
		long height = -1;
		long width = -1;
		try{
			duration= Long.parseLong(durations);
			height= Long.parseLong(heights);
			width= Long.parseLong(widths);
		}catch(NumberFormatException e){
			
		}
		
		response.setContentType("text/plain");
		if (name == null || type == null || durations == null || heights==null || widths==null || name.trim().length() < 1 || type.trim().length() < 1 || durations.trim().length() < 1 || heights.trim().length() < 1 || widths.trim().length() <1 || duration <= 0 || height <=0 || width <=0) {
			response.sendError(400, "Missing ['name','duration','type','height','width'].");
		} 
		else {
			Video v = new Video(name, type, duration, height, width);
			
			videos.add(v);
			
			response.getWriter().write(VIDEO_ADDED);
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String durations = request.getParameter("duration");
		String heights = request.getParameter("height");
		String widths = request.getParameter("width");
		long duration = -1;
		long height = -1;
		long width = -1;
		try{
			duration= Long.parseLong(durations);
			height= Long.parseLong(heights);
			width= Long.parseLong(widths);
		}catch(NumberFormatException e){
			
		}
		
		response.setContentType("text/plain");
		if (name == null || type == null || durations == null || heights==null || widths==null || name.trim().length() < 1 || type.trim().length() < 1 || durations.trim().length() < 1 || heights.trim().length() < 1 || widths.trim().length() <1 || duration <= 0 || height <=0 || width <=0) {
			response.sendError(400, "Missing ['name','duration','type','height','width'].");
		} 
		else {
			Video v = new Video(name, type, duration, height, width);
			
			if(videos.remove(v))
			{
				response.getWriter().write("\n Video Deleted");
			}
			else
			{
				response.getWriter().write("\n Video Missing");
			}
		}
	}

}
