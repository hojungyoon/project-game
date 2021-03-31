package com.football.pms.domain.fieldplay;

public class Kipper {
  String name;
  int age ;
  int height;
  int weight;
  String nation;
  String position;
  double ear;

  @Override
  public String toString() {
    return "Kipper [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight
        + ", nation=" + nation + ", position=" + position + ", ear=" + ear + "]";
  }
  public double getEar() {
    return ear;
  }
  public void setEar(double ear) {
    this.ear = ear;
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
}

