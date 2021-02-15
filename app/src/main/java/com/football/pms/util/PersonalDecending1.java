package com.football.pms.util;

import java.util.Comparator;
import com.football.pms.domain.fieldplay.Striker;

public class PersonalDecending1 implements Comparator<Striker> {

  @Override
  public int compare(Striker o1, Striker o2) {
    Integer temp1 = o1.getGoal();
    Integer temp2 = o2.getGoal();
    return temp2.compareTo(temp1);
  }

}
