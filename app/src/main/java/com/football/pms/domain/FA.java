package com.football.pms.domain;

import com.football.pms.domain.fieldplay.Defender;
import com.football.pms.domain.fieldplay.Kipper;
import com.football.pms.domain.fieldplay.Midfielder;
import com.football.pms.domain.fieldplay.Striker;

public class FA {
  public Striker[] striker;
  public Midfielder[] midfielder;
  public Defender[] defender;
  public Kipper[] kipper;

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
}
