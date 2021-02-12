package com.football.pms.domain;

import com.football.pms.domain.fieldplay.Defender;
import com.football.pms.domain.fieldplay.Kipper;
import com.football.pms.domain.fieldplay.Midfielder;
import com.football.pms.domain.fieldplay.Striker;

public class LeagueTeam {
  int teamCode;
  String teamName;
  String coachName;
  public Striker[] striker;
  public Midfielder[] midfielder;
  public Defender[] defender;
  public Kipper[] kipper;
  int win;
  int loose;
  int draw;
  int leagueWin;

  public int getTeamCode() {
    return teamCode;
  }
  public void setTeamCode(int teamCode) {
    this.teamCode = teamCode;
  }
  public String getTeamName() {
    return teamName;
  }
  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }
  public String getCoach() {
    return coachName;
  }
  public void setCoach(String coach) {
    this.coachName = coach;
  }
  public Striker[] getStriker() {
    return striker;
  }
  public void setStriker(Striker[] striker) {
    this.striker = striker;
  }
  public Midfielder[] getMidfielder() {
    return midfielder;
  }
  public void setMidfielder(Midfielder[] midfielder) {
    this.midfielder = midfielder;
  }
  public Defender[] getDefender() {
    return defender;
  }
  public void setDefender(Defender[] defender) {
    this.defender = defender;
  }
  public Kipper[] getKipper() {
    return kipper;
  }
  public void setKipper(Kipper[] kipper) {
    this.kipper = kipper;
  }
  public int getWin() {
    return win;
  }
  public void setWin(int win) {
    this.win = win;
  }
  public int getLoose() {
    return loose;
  }
  public void setLoose(int loose) {
    this.loose = loose;
  }
  public int getDraw() {
    return draw;
  }
  public void setDraw(int draw) {
    this.draw = draw;
  }
  public int getLeagueWin() {
    return leagueWin;
  }
  public void setLeagueWin(int leagueWin) {
    this.leagueWin = leagueWin;
  }

}
