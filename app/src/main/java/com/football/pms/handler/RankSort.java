package com.football.pms.handler;

import com.football.pms.domain.LeagueTeam;

public class RankSort implements Comparable<LeagueTeam> {
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
  public int compareTo(LeagueTeam rankSort) {
    if (this.assist < rankSort) {
      return -1;
    } else if (this.assist == rankSort) {
      return 0;
    } else {
      return -1;
    }
    return 0;
  }

}
