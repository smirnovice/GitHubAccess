import java.text.MessageFormat;
import java.util.Scanner;
import java.io.*;
import org.eclipse.egit.github.core.User;
import org.eclipse.egit.github.core.service.UserService;



public class Access 
{

	public static void main(String[] args) throws IOException 
	{
		System.out.println("Username:");
		Scanner input = new Scanner (System.in);   
		String username = input.next();
		input.close();
		User user = getUser(username);  
		System.out.println("Information on this user:\nLogin: "
							+ user.getLogin() + "\nName: "
							+ user.getName() + "\nEmail: "
							+ user.getEmail() + "\nUser URL: "
							+ user.getUrl() + "\nFollowers: "
							+ user.getFollowers() + "\nFollowing: "
							+ user.getFollowing() + "\nPublic Repos: "
							+ user.getPublicRepos() + "\nPublic Gists: "
							+ user.getPublicGists());					
		
		String getName = user.getName();  
		String getEmail = user.getEmail();
		String getUrl = user.getUrl();
		int getFollowers = user.getFollowers();
		int getFollowing = user.getFollowing();
		int getPublicRepos = user.getPublicRepos();
		int getPublicGists = user.getPublicGists();
		draw(getFollowers,username,getFollowing,getPublicRepos,getPublicGists,getName,getEmail,getUrl);
		
	}
		
	private static void draw(int followers, String username, int following, int publicRepos, int publicGists, String getName,
			String email, String url){
		
		StdDraw.picture(.5, .5, "background.jpg"); 
		StdDraw.picture(.1, .9,"trinity.png" );
		StdDraw.picture(.925, .9, "github.png");
		
		StdDraw.setPenColor(StdDraw.WHITE);   
		StdDraw.line(0.02,0.09, 0.445, 0.09);
		StdDraw.line(0.02,0.09, 0.02, 0.72);	
		StdDraw.setPenRadius(0.003);  
		StdDraw.line(.19, .738, .25, .738);
		StdDraw.setPenRadius();
		StdDraw.text(.2196,.75, "Graph A");
	
		
		double x = 0.0005;
		StdDraw.setPenColor(StdDraw.BOOK_BLUE); 
		StdDraw.filledRectangle(0.13, 0.1+(x * followers), 0.1, x * followers);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledRectangle(0.34, 0.1+(x*following), 0.1, x * following);
		StdDraw.setPenColor(StdDraw.WHITE);		
		StdDraw.setPenRadius(0.002);
		StdDraw.rectangle(0.34, 0.1+(x*following), 0.1, x * following);
		StdDraw.rectangle(0.13, 0.1+(x * followers), 0.1, x * followers);
		
		StdDraw.setPenRadius();
		StdDraw.setNumberFont();
		StdDraw.text(0.005,0.1,"0");   
		StdDraw.text(0.0005,0.2,"100");
		StdDraw.text(0.00000001,0.3,"200");
		StdDraw.text(0.00000001,0.4,"300");
		StdDraw.text(0.00000001,0.5,"400");
		StdDraw.text(0.00000001,0.6,"500");
		StdDraw.text(0.00000001,0.7,"600");
		
		
		StdDraw.setFont();
		StdDraw.line(0.55,0.09, 0.98, 0.09);  
		StdDraw.line(0.55,0.09, 0.55, 0.72);
		StdDraw.setPenRadius(0.003);
		StdDraw.line(.7379, .738, .7979, .738);
		StdDraw.setPenRadius();
		StdDraw.text(.7675,.75,"Graph B");
		
		
		
		double y = 0.001;
		StdDraw.setPenColor(StdDraw.BOOK_BLUE);  
		StdDraw.filledRectangle(0.66, 0.1+(y*publicRepos), 0.1, y * publicRepos);
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledRectangle(0.87, 0.1+(y*publicGists), 0.1, y * publicGists);
		StdDraw.setPenColor(StdDraw.WHITE);    
		StdDraw.setPenRadius(0.002);
		StdDraw.rectangle(0.66, 0.1+(y*publicRepos), 0.1, y * publicRepos);
		StdDraw.rectangle(0.87, 0.1+(y*publicGists), 0.1, y * publicGists);
		
		
		StdDraw.setPenRadius();
		StdDraw.setPenColor(StdDraw.WHITE);
		StdDraw.setNumberFont();
		StdDraw.text(0.53,0.1,"0");  
		StdDraw.text(0.53,0.2,"50");
		StdDraw.text(0.53,0.3,"100");
		StdDraw.text(0.53,0.4,"150");
		StdDraw.text(0.53,0.5,"200");
		StdDraw.text(0.53,0.6,"250");
		StdDraw.text(0.53,0.7,"300");
		
		StdDraw.setPenColor(StdDraw.WHITE);  
		StdDraw.rectangle(0.54, 0.92,0.25,0.12);
		
		StdDraw.setFont();
		StdDraw.text(0.13,0.05,"Followers (" +followers + ")" ); 
		StdDraw.text(0.34,0.05,"Following (" +following + ")");
		StdDraw.text(0.66,0.05,"Public Repos (" +publicRepos + ")");
		StdDraw.text(0.87,0.05,"Public Gists (" +publicGists + ")");;
		StdDraw.textLeft(0.30,.94, "Username - " + username );
		StdDraw.textLeft(0.30,.9, "Name - " + getName);
		StdDraw.textLeft(0.30,.86, "Email - " + email);
		StdDraw.textLeft(0.30,.82,"URL - " + url);
		StdDraw.text(0.5, 1, "Details ");
		StdDraw.setPenRadius(0.003);
		StdDraw.line(.47, .988, .53, .988);
	
	}
	
	
	private static User getUser(String login) throws IOException
	{  
		UserService user = new UserService();
		return user.getUser(login);
		
	}
}