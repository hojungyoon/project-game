package com.football.pms.domain;

import java.util.List;
import com.football.pms.domain.fieldplay.Kipper;
import com.football.pms.domain.fieldplay.PlayerProfile;

public class LeagueTeam {
  int teamCode;
  String teamName;
  String coachName;
  public List<PlayerProfile> playerProfile;
  public List<Kipper> kipper;
  int win;
  int loose;
  int draw;
  int leagueWin;
  int scores;
  int point;
  int plusPoint;
  int minusPoint;

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

  public String getCoachName() {
    return coachName;
  }

  public void setCoachName(String coachName) {
    this.coachName = coachName;
  }

  public List<PlayerProfile> getPlayerProfile() {
    return playerProfile;
  }

  public void setPlayerProfile(List<PlayerProfile> playerProfile) {
    this.playerProfile = playerProfile;
  }

  public List<Kipper> getKipper() {
    return kipper;
  }

  public void setKipper(List<Kipper> kipper) {
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

  public int getScores() {
    return scores;
  }

  public void setScores(int scores) {
    this.scores = scores;
  }

  public int getPoint() {
    return point;
  }

  public void setPoint(int point) {
    this.point = point;
  }

  public int getPlusPoint() {
    return plusPoint;
  }

  public void setPlusPoint(int plusPoint) {
    this.plusPoint = plusPoint;
  }

  public int getMinusPoint() {
    return minusPoint;
  }

  public void setMinusPoint(int minusPoint) {
    this.minusPoint = minusPoint;
  }

  @Override
  public String toString() {
    return win + " 승  " + draw + " 무  " + loose + " 패  /  "
        + "승점 " + point + "  득실차 " + scores + " / [" + teamName + "]";
  }


}