package com.IplData.problem3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.IplData.beans.Deliveries;
import com.IplData.problem2.Bowlers;
import com.IplData.problem2.MatchId;
import com.IplData.problem2.Seasons;
import com.IplData.service.DeliveriesDataReaderService;

public class BestEconomyRateBowler {

	private Set<Integer> seasonSet = new HashSet<Integer>();
	private Set<String> bowlerSet = new HashSet<String>();
	private Map<Integer, List<Integer>> matchIdMap = new HashMap<Integer, List<Integer>>();

	private Map<Map<String, Integer>, Float> economyMap;
	private Map<String, Integer> seasonBowlerMap;

	private Set<Integer> oversBowledSet;

	private int season;
	private String bowler;
	private int matchId;

	private int overBowled;
	private int bowlerRuns;
	private float totalRunsConceded;
	private float totalOverBowled;
	private float economy;

	public void bestEconomyRateBowlerSolution() {

		// here added seasons into set object
		Seasons seasons = new Seasons();
		seasonSet = seasons.getSeasons();

		MatchId matchIds = new MatchId();
		matchIdMap = matchIds.getMatchIdAndSeasonMap();

		Bowlers bowlers = new Bowlers();
		bowlerSet = bowlers.getBowlers();

		Iterator<Integer> itSeason = seasonSet.iterator();
		System.out.println(
				" Below is the listTop 10 Best economy rate bowler with respect to year who bowled at least 10");
		System.out.println("YEAR   PLAYER   ECONOMY");
		while (itSeason.hasNext()) {

			season = itSeason.next();

			economyMap = new HashMap<Map<String, Integer>, Float>();

			Iterator<String> itBowler = bowlerSet.iterator();

			while (itBowler.hasNext()) {
				bowler = itBowler.next();

				overBowled = 0;
				bowlerRuns = 0;
				totalRunsConceded = 0;
				totalOverBowled = 0;

				seasonBowlerMap = new HashMap<String, Integer>();
				seasonBowlerMap.put(bowler, season);

				List<Integer> reqMatchIdsList = new ArrayList<Integer>();
				reqMatchIdsList = matchIdMap.get(season);

				Iterator<Integer> itMatchId = reqMatchIdsList.iterator();

				oversBowledSet = new HashSet<Integer>();

				while (itMatchId.hasNext()) {

					matchId = itMatchId.next();

					ListIterator<Deliveries> itDeliveries = DeliveriesDataReaderService.deliveriesData.listIterator();

					int i = 0;
					while (itDeliveries.hasNext()) {

						if (matchId == DeliveriesDataReaderService.deliveriesData.get(i).getMatchId()) {

							if (bowler.equals(DeliveriesDataReaderService.deliveriesData.get(i).getBowlerName())) {

								oversBowledSet.add(DeliveriesDataReaderService.deliveriesData.get(i).getOver());
								overBowled = Collections.max(oversBowledSet);

								bowlerRuns = DeliveriesDataReaderService.deliveriesData.get(i).getTotalRuns();
								totalRunsConceded = totalRunsConceded + bowlerRuns;

							}
						}

						i++;
						itDeliveries.next();
					}

					totalOverBowled = totalOverBowled + overBowled;
				}
				if (totalOverBowled >= 10) {
					economy = (totalRunsConceded / totalOverBowled);

					economyMap.put(seasonBowlerMap, economy);

				}
			}

			for (int j = 0; j < 10; j++) {

				Entry<Map<String, Integer>, Float> firstEntry = economyMap.entrySet().iterator().next();
				Map<String, Integer> largestKey = firstEntry.getKey();
				String team_name = "";
				int year = 0;
				float largestKeyValue = firstEntry.getValue();

				for (Entry<Map<String, Integer>, Float> map : economyMap.entrySet()) {
					float value = map.getValue();
					if (value > largestKeyValue) {
						largestKeyValue = value;
						largestKey = map.getKey();
					}
				}

				for (Map.Entry<String, Integer> entry : largestKey.entrySet()) {
					team_name = entry.getKey();
					year = entry.getValue();
//					System.out.println(entry.getKey() + "/" + entry.getValue());
				}
//				System.out.println("" +largestKey +" " + largestKeyValue + "");
				System.out.println("==================================================================");
				System.out.println("" + year + "  " + team_name + "  " + largestKeyValue + "");
				// System.out.println("" + largestKey + " " + largestKeyValue + "");
				economyMap.remove(largestKey);
			}

		}
	}
}
