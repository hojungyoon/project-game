package com.football.pms.domain.fieldplay;

public class Defender {
  String name;
  int age ;
  int height;
  int weight;
  String nation;
  String position;
  int dismissal;
  int goal;
  int assist;

  @Override
  public String toString() {
    return "Defender [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight
        + ", nation=" + nation + ", position=" + position + ", dismissal=" + dismissal + ", goal="
        + goal + ", assist=" + assist + "]";
  }
  public int getAssist() {
    return assist;
  }
  public void setAssist(int assist) {
    this.assist = assist;
  }
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
}
