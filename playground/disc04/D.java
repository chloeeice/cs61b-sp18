public class D {
    public static void main (String[] args) {
        //B a0 = new A();
        //a0.m1();
        //a0.m2(16);
        A b0 = new B();           //b0: static type: A; dynamic type: B
        System.out.println(b0.x); //output: 5
        b0.m1();                  //output: Am1-> 5
        b0.m2();                  //output: Bm2-> 5
        //b0.m2(61);              // compile error: b0 has no method called m2.
        B b1 = new B();           // b1: static type == dynamic type == B
        b1.m2(61);             //output: Bm2y-> 61
        b1.m3();                  //output: Bm3-> called
        A c0 = new C();           // c0: static type == A; dynamic type == C
        c0.m2();                  //output: Cm2-> 5
        //C c1 = (A) new C();
        A a1 = (A) c0;            // a1: static type: A; dynamic type: C
        C c2 = (C) a1;
        c2.m3();                  //output: Bm3-> called
        //c2.m4();
        c2.m5();                  //output: Cm5-> 6
        ((C) c0).m3();            //output: Bm3-> called
        /**NOT RUNTIME ERROR This would case the result of what the method returns
         * and it returns void therefore compile-time error*/
        //(C) c0.m3();
        b0.update();              // b0.x = 99
        b0.m1();                  //output: Am1-> 99
    }
}
