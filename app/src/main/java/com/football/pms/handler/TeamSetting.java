package com.football.pms.handler;

import java.util.ArrayList;
import java.util.List;
import com.football.pms.domain.LeagueTeam;
import com.football.pms.domain.fieldplay.Kipper;
import com.football.pms.domain.fieldplay.PlayerProfile;
import com.football.pms.util.ProfileSetting;

public class TeamSetting {

  List<LeagueTeam> list;

  public TeamSetting(List<LeagueTeam> list) {
    this.list = list;
  }

  private int teamSize = 16;

  private int teamStriker = 4;
  private int teamMidfielder = 7;
  private int teamDefender = 6;
  private int allRounder = teamStriker + teamMidfielder + teamDefender;
  private int teamKipper = 2;

  public void makeTeam(String tName, String tCoach) {
    LeagueTeam league;

    for (int i = 0; i < teamSize; i++) {
      league = new LeagueTeam();

      league.setTeamCode(i);
      league.setTeamName(ProfileSetting.makeTeamName(i));
      league.setCoachName(ProfileSetting.coachName(i));

      league.setPlayerProfile(makeTeamAllPlayer());

      List<Kipper> kpa = new ArrayList<>();

      for (int y = 0; y < teamKipper; y++) {
        Kipper kp = new Kipper();
        kp.setHeight(kipperHei()); 
        kp.setWeight(ProfileSetting.weight(kp.getHeight())); 
        kp.setName(ProfileSetting.makeRanName()); 
        kp.setAge(ProfileSetting.age()); 
        kp.setPosition("Kip");
        kp.setNation(ProfileSetting.nationality());

        kpa.add(kp);

        league.setKipper(kpa);
      }

      list.add(league);
    }

    league = findByNo(0);
    league.setTeamName(String.format("%s %s", tName, ProfileSetting.SecondTeamName()));
    league.setCoachName(tCoach);
  }

  public List<PlayerProfile> makeTeamAllPlayer() {
    List<PlayerProfile> pp = new ArrayList<>();

    for (int i = 0; i < teamStriker; i++) {
      pp.add(makeTeamPlayer("St"));
    }

    for (int i = teamStriker; i < teamStriker + teamMidfielder; i++) {
      pp.add(makeTeamPlayer("Md"));
    }

    for (int i = teamStriker + teamMidfielder; i < allRounder; i++) {
      pp.add(makeTeamPlayer("Df"));
    }

    return pp;
  }

  public PlayerProfile makeTeamPlayer(String position) {
    PlayerProfile pl = new PlayerProfile();

    pl.setHeight(ProfileSetting.height());
    pl.setWeight(ProfileSetting.weight(pl.getHeight()));
    pl.setName(ProfileSetting.makeRanName()); 
    pl.setAge(ProfileSetting.age());
    pl.setPosition(position);
    pl.setNation(ProfileSetting.nationality());
    pl.setDismissal(0);
    pl.setGoal(0);

    return pl;
  }

  public int kipperHei() {
    int i = 0;
    while(i < 185) {
      i = ProfileSetting.height();
      if (i < 185) {
        continue;
      }
    }
    return i;
  }

  public LeagueTeam findByNo(int No) {
    Object[] list = this.list.toArray();
    for (Object obj : list) {
      LeagueTeam b = (LeagueTeam) obj;
      if (b.getTeamCode() == No) {
        return b;
      }
    }
    return null;
  }

}
