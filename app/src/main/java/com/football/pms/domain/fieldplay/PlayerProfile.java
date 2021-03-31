package com.football.pms.domain.fieldplay;

public class PlayerProfile {
  String name;
  int age ;
  int height;
  int weight;
  String nation;
  String position;
  int dismissal;
  int goal;
  int assist;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public int getHeight() {
    return height;
  }
  public void setHeight(int height) {
    this.height = height;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }
  public String getNation() {
    return nation;
  }
  public void setNation(String nation) {
    this.nation = nation;
  }
  public String getPosition() {
    return position;
  }
  public void setPosition(String position) {
    this.position = position;
  }
  public int getDismissal() {
    return dismissal;
  }
  public void setDismissal(int dismissal) {
    this.dismissal = dismissal;
  }
  public int getGoal() {
    return goal;
  }
  public void setGoal(int goal) {
    this.goal = goal;
  }
  public int getAssist() {
    return assist;
  }
  public void setAssist(int assist) {
    this.assist = assist;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + assist;
    result = prime * result + dismissal;
    result = prime * result + goal;
    result = prime * result + height;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((nation == null) ? 0 : nation.hashCode());
    result = prime * result + ((position == null) ? 0 : position.hashCode());
    result = prime * result + weight;
    return result;
  }

  @Override
  public String toString() {
    return "PlayerProfile [name=" + name + ", age=" + age + ", height=" + height + ", weight="
        + weight + ", nation=" + nation + ", position=" + position + ", dismissal=" + dismissal
        + ", goal=" + goal + ", assist=" + assist + "]";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PlayerProfile other = (PlayerProfile) obj;
    if (age != other.age)
      return false;
    if (assist != other.assist)
      return false;
    if (dismissal != other.dismissal)
      return false;
    if (goal != other.goal)
      return false;
    if (height != other.height)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (nation == null) {
      if (other.nation != null)
        return false;
    } else if (!nation.equals(other.nation))
      return false;
    if (position == null) {
      if (other.position != null)
        return false;
    } else if (!position.equals(other.position))
      return false;
    if (weight != other.weight)
      return false;
    return true;
  }

}
