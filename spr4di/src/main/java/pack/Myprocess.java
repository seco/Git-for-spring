package pack;

public class Myprocess {
   private int nai;
   private String name;
   private Testclass class1;
   
   public void setClass1(Testclass class1) {
	      this.class1 = class1;
   }
   
   public void setNai(int nai) {
      this.nai = nai;
   }
   public void setName(String name) {
      this.name = name;
   }
   
   public void showData() {
      System.out.println("이름은 " + name + "나이는 " + nai);
      class1.abc();
      class1.def();
   }
}