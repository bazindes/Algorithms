package com.baz.app.java8.innerclass;

class Hello {
    public Runnable r = new Runnable() {
        public void run() {
          System.out.println(this);
          System.out.println(toString());
        }
      };
  
    public String toString() {
      return "Hello's custom toString()";
    }
}  