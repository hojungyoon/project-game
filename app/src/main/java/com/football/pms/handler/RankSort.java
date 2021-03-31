package com.football.pms.handler;

import com.football.pms.domain.fieldplay.PlayerProfile;

public class RankSort implements Comparable<PlayerProfile> {
  private String teamName;
  private int assist;
  private String rank;
  private String position;
  private String playerName;

  public RankSort(String teamName, int assist, String rank, String position, String playerName) {
    this.teamName = teamName;
    this.rank = rank;
    this.assist = assist;
    this.position = position;
    this.playerName = playerName;
  } 

  @Override
  public String toString() {
    return " - [ " + teamName + " ]" + assist + " " + rank + " / " + playerName + "(" +
        position + ")";
  }

  @Override
  public int compareTo(PlayerProfile rankSort) {
    if (this.assist < rankSort.getAssist()) {
      return -1;
    } else if (this.assist == rankSort.getAssist()) {
      return 0;
    } else {
      return -1;
    }
  }

}
@Override
public String toString() {
  return win + " 승  " + draw + " 무  " + loose + " 패  /  "
      + "승점 " + point + "  득실차 " + scores + " / [" + teamName + "]";
}
