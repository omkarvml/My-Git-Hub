package com.IplData.mainClass;

import com.IplData.problem1.TopFourTeamsEclectedFieldFirstOfterWinningTheToss;
import com.IplData.problem2.ListOfTotalNumberOfSixAndFoursAndTotal;
import com.IplData.problem3.BestEconomyRateBowler;
import com.IplData.service.DeliveriesDataReaderService;
import com.IplData.service.MatchDataReaderService;

public class MainApplication {

	public static void main(String[] args) {
		MatchDataReaderService matchDataReaderService = new MatchDataReaderService();
		DeliveriesDataReaderService deliveriesDataReaderService = new DeliveriesDataReaderService();
		matchDataReaderService.readDataFromFile();
		deliveriesDataReaderService.readDataFromFile();

		TopFourTeamsEclectedFieldFirstOfterWinningTheToss problem1 = new TopFourTeamsEclectedFieldFirstOfterWinningTheToss();
		problem1.firstFourTossWinner();

		System.out.println();

		ListOfTotalNumberOfSixAndFoursAndTotal problem2 = new ListOfTotalNumberOfSixAndFoursAndTotal();
		problem2.listOfTotalNumberOfSixAndFours();

		System.out.println();

		BestEconomyRateBowler problem3 = new BestEconomyRateBowler();
		problem3.bestEconomyRateBowlerSolution();

		System.out.println();

	}

}
