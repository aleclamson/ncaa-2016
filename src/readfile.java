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
	public static Team getRegionWinner(ArrayList<Team> numbers) {
	    Team first = getWinner(numbers.get(0), numbers.get(15));
	    Team second = getWinner(numbers.get(1), numbers.get(14));
	    Team third = getWinner(numbers.get(2), numbers.get(13));
	    Team fourth = getWinner(numbers.get(3), numbers.get(12));
	    Team fifth = getWinner(numbers.get(4), numbers.get(11));
	    Team sixth = getWinner(numbers.get(5), numbers.get(10));
	    Team seventh = getWinner(numbers.get(6), numbers.get(9));
	    Team eight = getWinner(numbers.get(7), numbers.get(8));
	    Team firstsec = getWinner(first, second);
	    Team threefou = getWinner(third, fourth);
	    Team fivesix = getWinner(fifth, sixth);
	    Team seveneig = getWinner(seventh, eight);
	    return getWinner( getWinner(firstsec, threefou), getWinner(fivesix, seveneig));
	  	
	}
	public static void getFinalChamp(ArrayList<Team> teams) {
		ArrayList<Team> west = sortTeam(teams, "West");
		ArrayList<Team> midwest = sortTeam(teams, "Midwest");
		ArrayList<Team> east = sortTeam(teams, "East");
		ArrayList<Team> south = sortTeam(teams, "South");
	    System.out.println(getRegionWinner(west).getName() + " won West bracket");
	    System.out.println(getRegionWinner(midwest).getName() + " won Midwest bracket");
	    System.out.println(getRegionWinner(east).getName() + " won East bracket");
	    System.out.println(getRegionWinner(south).getName() + " won South bracket");
	    Team final1 = getWinner(getRegionWinner(west),getRegionWinner(south));
	    Team final2 = getWinner(getRegionWinner(east),getRegionWinner(midwest));
	    System.out.println(final1.getName() + " has advanced to the finals!");
	    System.out.println(final2.getName() + " has advanced to the finals!");
	    System.out.println(getWinner(final1, final2).getName() +  " HAS WON THE TOURNAMENT");
	    System.out.println();
	}
	
}
