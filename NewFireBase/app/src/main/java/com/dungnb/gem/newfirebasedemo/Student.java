package com.dungnb.gem.newfirebasedemo;

public class Student {

  String ho_va_ten;
  String dia_chi;
  String nam_sinh;

  public Student() {
  }

  public Student(String ho_va_ten, String dia_chi, String nam_sinh) {
    this.ho_va_ten = ho_va_ten;
    this.dia_chi = dia_chi;
    this.nam_sinh = nam_sinh;
  }

  public String getHo_va_ten() {
    return ho_va_ten;
  }

  public void setHo_va_ten(String ho_va_ten) {
    this.ho_va_ten = ho_va_ten;
  }

  public String getDia_chi() {
    return dia_chi;
  }

  public void setDia_chi(String dia_chi) {
    this.dia_chi = dia_chi;
  }

  public String getNam_sinh() {
    return nam_sinh;
  }

  public void setNam_sinh(String nam_sinh) {
    this.nam_sinh = nam_sinh;
  }
}
