public class Team implements Comparable<Team> {
	private String name;
	private int seed;
	private double expected;
	private String region;
	private int wins;
	public Team(String name, double expected, String region, int seed) {
		this.seed = seed;
		this.region = region;
		this.expected = expected/100;
		this.name = name;
		wins = 0;
	}
}