import java.io.File;
import java.util.*;

public class ReadFile {
	
	public static void main(String[] args) {
		ArrayList<String> data = new ArrayList<String>();
		ArrayList<Team> teams = new ArrayList<Team>();
		
		try {
			Scanner input = new Scanner(System.in);
			
			File file = new File("ncaa_data_2016.csv");  
			
			Scanner scanner = input = new Scanner(file);
			
			while(input.hasNextLine()) {
				String line = input.nextLine();
				data.add(line);
			 }
			
			for (int i = 1; i < 65; i++ ) {
				String numbers = (data.get(i));
				String[] septeam = numbers.split(",");
				for (int j = 0; j < 1; j++) {
					Team team = new Team(septeam[0],Double.parseDouble(septeam[1]), septeam[2], Integer.parseInt(septeam[3]));
					teams.add(team);
					
				  }
			   }
			 input.close();
			
			}  catch (Exception ex) {
			ex.printStackTrace();
			  }
 
		getFinal(teams);
     
	}
	public static Team getWinner(Team team1, Team team2) {
		Random r =  new Random();
		double random = r.nextDouble();
		if ( random <= probability(team1, team2)) {
			return team1;
		}
		else {
			return team2;
		}
	}
	
	public static double probability(Team team1, Team team2) {
		double probability = 0;
		probability = (team1.getExpected() - (team1.getExpected() * team2.getExpected()))/ (team1.getExpected() + team2.getExpected() - 2* team1.getExpected() * team2.getExpected());
		//equation for the probabity
		return probability;
	}
	
	public static ArrayList<Team> sortTeam(ArrayList<Team> numbers, String region) {
		ArrayList<Team> newTeam = new ArrayList<Team>();
		for (Team x : numbers) {
			if (x.getRegion().equals(region)) {
				newTeam.add(x);
			}
		}
	 return newTeam;
	}
}