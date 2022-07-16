public class C extends B {
    public int y = x + 1;

    @Override
    public void m2() {
        System.out.println("Cm2-> " + super.x);
    }

    /**Can not use super.super.*/
    /*public void m4() {
        System.out.println("Cm4-> " + super.super.x);
    }*/
    public void m5() {
        System.out.println("Cm5-> " + y);
    }
}
