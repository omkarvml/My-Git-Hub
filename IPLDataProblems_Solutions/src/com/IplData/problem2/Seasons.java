package com.IplData.problem2;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import com.IplData.beans.Match;
import com.IplData.service.MatchDataReaderService;

public class Seasons {

    public Set<Integer> seasonSet = new HashSet<Integer>();

    public Set<Integer> getSeasons() {

        ListIterator<Match> it = MatchDataReaderService.matchesData.listIterator();

        while (it.hasNext()) {

            seasonSet.add(it.next().getSeason());

        }
        return seasonSet;

    }
}
