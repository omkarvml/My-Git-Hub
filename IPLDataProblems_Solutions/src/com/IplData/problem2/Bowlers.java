package com.IplData.problem2;

import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;

import com.IplData.beans.Deliveries;
import com.IplData.service.DeliveriesDataReaderService;

public class Bowlers {
    
    


public Set<String> bowlerSet = new HashSet<String>();

public Set<String> getBowlers() {

    ListIterator<Deliveries> it = DeliveriesDataReaderService.deliveriesData.listIterator();

    while (it.hasNext()) {

        bowlerSet.add(it.next().getBowlerName());

    }
    return bowlerSet;

}
}