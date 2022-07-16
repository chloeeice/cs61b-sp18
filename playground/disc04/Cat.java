public class Cat extends Animal {

    /**如果没有这个constructor的话，会提示错误。
    如果animal有一个no-argument constructor的话，这个constructor应该就不是必须的。
     Since class Animal has a two-argument constructor, we must make an explicit call
     to constructor.(in contrary to the implicit call).
     */
    // create a constructor.
    public Cat(String name, int age) {
        super(name, age);
        this.noise = "Meow!";
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }
}
