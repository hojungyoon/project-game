package com.football.pms.util;

import java.util.Comparator;
import com.football.pms.domain.fieldplay.PlayerProfile;

public class PersnalRankDecending implements Comparator<PlayerProfile>{

  @Override
  public int compare(PlayerProfile o1, PlayerProfile o2) {
    Integer temp1 = o1.getGoal();
    Integer temp2 = o2.getGoal();

    return temp2.compareTo(temp1);
  }

}
