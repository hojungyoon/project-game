package com.football.pms.handler;

import java.util.Comparator;

public class RankDecending implements Comparator<Object>{

  @Override
  public int compare(Object o1, Object o2) {
    Integer temp1 = (int)o1;
    Integer temp2 = (int)o2;
    return temp2.compareTo(temp1);
  }

}
