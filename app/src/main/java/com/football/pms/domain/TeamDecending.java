package com.football.pms.domain;

import java.util.Comparator;

public class TeamDecending {

  class TSeamDecending implements Comparator<LeagueTeam> {

    @Override
    public int compare(LeagueTeam o1, LeagueTeam o2) {
      Integer temp1 = o1.getWin();
      Integer temp2 = o2.getWin();

      return temp2.compareTo(temp1);
    }
  }

}
