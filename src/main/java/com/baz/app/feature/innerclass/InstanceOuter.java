package com.baz.app.feature.innerclass;

class InstanceOuter {
    public InstanceOuter(int xx) { x = xx; }
  
    private int x;
  
    class InstanceInner {
      public void printSomething() {
        System.out.println("The value of x in my outer is " + x);
      }
    }
}