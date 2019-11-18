package Dvideos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//port java.lang.*;


public class Dvideos {

	private static int type_response() {
		// Introducing option.
		int type;

		System.out.println("Choose option? " + '\n' + "[1. A new video /"
				+ '\n' + " 2. List videos /"
						+ '\n' + " 3. Exit]");
		
		Scanner in_type = new Scanner(System.in);
		type = in_type.nextInt();

		return type;
	}
	
	private static String type_name() {
		// Type a name.
		String name;
		
		Scanner in_name = new Scanner(System.in);
		System.out.println("Type User name : ");
		name = in_name.nextLine();

		while (name.isEmpty()) {
			System.out.println("User name in blank. " + '\n' + "Please type User name again : ");
			name = in_name.nextLine();
		}
		
		return name;
	}

	private static String type_surname() {
		// Type a surname.
		String surname;

		Scanner in_surname = new Scanner(System.in);
		System.out.println("Type User surname : ");
		surname = in_surname.nextLine().toUpperCase();

		while (surname.isEmpty()) {
			System.out.println("User surname in blank. " + '\n' + "Please type again : ");
			surname = in_surname.nextLine().toUpperCase();
		}
		
		return surname;
	}

	private static String type_pwd() {
		// Type a password.
		String pwd;

		Scanner in_pwd = new Scanner(System.in);
		System.out.println("Type User password : ");
		pwd = in_pwd.nextLine().toUpperCase();
		while (pwd.isEmpty()) {
			System.out.println("User password in blank. " + '\n' + "Please type again : ");
			pwd = in_pwd.nextLine().toUpperCase();
		}
		
		return pwd;
	}
	
	private static String type_URL() {
		// Type a URL name.
		String name_URL;

		Scanner in_video = new Scanner(System.in);
		System.out.println("Type URL : ");
		name_URL = in_video.nextLine();

		while (name_URL.isEmpty()) {
			System.out.println("URL in blank. " + '\n' + "Please type again.");
			name_URL = in_video.nextLine();
		}

		return name_URL;
	}

	private static String type_title() {
		// Type a title.
		String name_title;

		Scanner in_title = new Scanner(System.in);
		System.out.println("Type title : ");
		name_title = in_title.nextLine();

		while (name_title.isEmpty()) {
			System.out.println("Title in blank. " + '\n' + "Please type again: ");
			name_title = in_title.nextLine();
		}

		return name_title;
	}

	private static String type_tag() {
		// Type a tag.
		String name_tag;
		
		Scanner in_tag = new Scanner(System.in);
		System.out.println("Type tag : ");
		name_tag = in_tag.nextLine();
		
		while (name_tag.isEmpty()) {
			System.out.println("Tag in blank. " + '\n' + "Please type again : ");
			name_tag = in_tag.nextLine();
		}
		
		return name_tag;
	}

	private static Video type_video() {
		// Type a name.
		String URL, title, tag;
		List<String> tags = new ArrayList<String>();
		String answer;
		
		URL = type_URL();
		title = type_title();
				
		Scanner in_answer = new Scanner(System.in);
		System.out.println ("Do you want to add tag " + '\n' + "[Yes/Not]?");
		answer = in_answer.nextLine();
		
		while(answer.equals("Yes")) {
			tag = type_tag();
			tags.add(tag);
					
			System.out.println ("Do you want to another tag " + '\n' + "[Yes/Not]?");
			answer= in_answer.nextLine();
	
		}

		return(new Video(URL,title,tags));	
	}


	public static void main(String[] args){
		//Declaration of variables
		User user;
		String name="", surname="", pwd ="";
		List<Video> video_list = new ArrayList<Video>(); //videos of a user.

		Video video = null; //new Video();
		
		int response;
		
		try {
				//Basic data of user.
				name = type_name();
				surname = type_surname();
				pwd = type_pwd();
		}		
		catch(Exception e){
				System.out.println("No accepting data User.");
		}
	
		//Creating User.
		user = new User(name, surname, pwd, LocalDate.now(), video_list);
		
		boolean option = true;
		
		while (option) { // while(true)
			response = (int) type_response();
			switch(response) {

					case 1:
					// Create a new Video
						video = type_video();
							
						if (user.video_list == null) {
							//No videos in list. Introducing first video.
					
							try {
						
								user.video_list.add(0,video);
							}
							catch(Exception e) {
						
								System.out.println("Video not in list.");
							}			
						}
						else {
							// Almost 1 video in list. Introducing new video.			
					
							try {
						
								user.video_list.add(video);
							}	
							catch(Exception e) {
						
								System.out.println("Video not in list.");
							}
						}
						
					break;			
					case 2:
						//Display Videos.	
						
						try {					
							
							if((video_list == null) ||(video_list.isEmpty())) {
								
								System.out.println ("No videos in this User.");
							}
							else {
								User user2= new User(name, surname, pwd, LocalDate.now(), video_list);
								System.out.println("Videos of User: " + user2.name + " " + user2.surname + '\n');
									
								for (int i = 0;i < user.video_list.size();i++) {
									
									System.out.println("Title video: " + user.video_list.get(i).title);
									System.out.println("URL video: " + user.video_list.get(i).URL);
									System.out.print("Tags: " + user.video_list.get(i).tags + '\n');
								}
							}	
						}
						catch(Exception e) {
								System.out.println("No videos in this user");
						}				
					break;
					case 3:
						System.out.println("Exit of program");
						option = false;
					break;
					default:
						System.out.println("No choose option.");
					break;
				}		
			
		}

	}

}
