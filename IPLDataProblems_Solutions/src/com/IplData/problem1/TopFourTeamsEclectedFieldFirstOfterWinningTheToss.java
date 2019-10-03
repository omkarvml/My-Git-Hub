package com.IplData.problem1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.IplData.beans.Match;
import com.IplData.problem2.Seasons;
import com.IplData.problem2.Teams;
import com.IplData.service.MatchDataReaderService;

public class TopFourTeamsEclectedFieldFirstOfterWinningTheToss {

	private Set<Integer> seasonSet = new HashSet<Integer>();
	private Map<Map<String, Integer>, Integer> tossWinnerMap;
	private Set<String> teamSet = new HashSet<String>();
	private Map<String, Integer> seasonTeamMap;

	private int count;
	private int countDecision;
	private int season;
	private String team;

	public void firstFourTossWinner() {
		// Added Teams Set Object
		Teams teams = new Teams();
		teamSet = teams.getTeams();

		// Added Seasons in Set Object
		Seasons seasons = new Seasons();
		seasonSet = seasons.getSeasons();

		// Here Iterator Set Object
		Iterator<Integer> itSeason = seasonSet.iterator();
		System.out.println(
				"Below are the top 4 teams from 2016 and 2017 and who elected to field first after winning toss.");
		while (itSeason.hasNext()) {
			season = itSeason.next();

			tossWinnerMap = new HashMap<Map<String, Integer>, Integer>();
			if (season == 2016 || season == 2017) {

				Iterator<String> itTeam = teamSet.iterator();

				// Iterating Team
				while (itTeam.hasNext()) {
					team = itTeam.next();

					count = 0;
					countDecision = 0;

					seasonTeamMap = new HashMap<String, Integer>();
					seasonTeamMap.put(team, season);

					// Here Adding ListIterater to Matches Data
					ListIterator<Match> it = MatchDataReaderService.matchesData.listIterator();
					int i = 0;
					while (it.hasNext()) {

						if ((MatchDataReaderService.matchesData.get(i).getSeason() == season)
								&& (MatchDataReaderService.matchesData.get(i).getTossWinner().equals(team))) {

							if (MatchDataReaderService.matchesData.get(i).getTossDecision().equals("field"))
								count++;

							countDecision = count;
						}
						it.next();
						i++;

					}

					tossWinnerMap.put(seasonTeamMap, countDecision);

				}

				// Here Getting Top 4 teams which elected to field first after winning toss in
				// 2016 and 2017
				for (int j = 0; j < 4; j++) {

					Entry<Map<String, Integer>, Integer> firstEntry = tossWinnerMap.entrySet().iterator().next();
					Map<String, Integer> largestKey = firstEntry.getKey();
					String team_name = "";
					int year = 0;
					Integer largestKeyValue = firstEntry.getValue();

					for (Entry<Map<String, Integer>, Integer> map : tossWinnerMap.entrySet()) {
						Integer value = map.getValue();
						if (value > largestKeyValue) {
							largestKeyValue = value;
							largestKey = map.getKey();

						}
					}
					for (Map.Entry<String, Integer> entry : largestKey.entrySet()) {
						team_name = entry.getKey();
						year = entry.getValue();
//						System.out.println(entry.getKey() + "/" + entry.getValue());
					}
//					System.out.println("" +largestKey +" " + largestKeyValue + "");
					System.out.println("==================================================================");
					System.out.println("" + year + " " + team_name + " " + largestKeyValue + "");
					tossWinnerMap.remove(largestKey);
				}

			}
		}
	}
}