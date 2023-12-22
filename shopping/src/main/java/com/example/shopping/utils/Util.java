package com.example.shopping.utils;

public class Util {

  public static boolean validString(String s) {
    if (s.isBlank() || s == null) {
      return false;
    }
    return true;
  }

}
