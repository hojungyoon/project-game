package com.football.pms.util;

import java.util.Comparator;
import com.football.pms.domain.LeagueTeam;

public class TeamDecending2 implements Comparator<LeagueTeam> {

  @Override
  public int compare(LeagueTeam o1, LeagueTeam o2) {
    Integer temp1 = o1.getScores();
    Integer temp2 = o2.getScores();
    return temp2.compareTo(temp1);
  }

}
