## java多态
### 向上转型
1. 父类的引用指向子类具体的实例，把子类的对象转成父类，向上转型也称隐式转型，自动转型
2. 向上转型后，可以调用子类重写父类的方法以及父类派生的方法，子类特有的方法不能使用

### 向下转型
1. 子类引用指向父类实例,要求必须进行强制类型转换，这时就可以调用子类特有的方法
2. 向下转型可以调用子类重写父类的方法，父类派生的方法，子类特有的方法

### 范例
1. Animal类，是Cat和Dog的子类
```java
public class Animal {
    private String name;
    private int month;

    public Animal() {
    }

    public Animal(String name, int month) {
        this.name = name;
        this.month = month;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    //吃东西方法
    public  void eat()
    {
        System.out.println("animal eat food");
    }
}
```
2. Cat类，继承Animal，重写eat方法，生成特有的run方法
```java
public class Cat extends Animal {
    private double weight;

    public Cat() {
    }

    public Cat(String name, int month, double weight) {
        super(name, month);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //自己特有方法，重写父类方法
    public void run()
    {
        System.out.println("cat run");
    }
    public void eat(){
        System.out.println("cat eat fish");
    }
}
```
3. Dog类，继承Animal类，重写eat方法，生成特有的sleep方法
```java
public class Dog extends Animal {
    private String sex;

    public Dog(){

    }

    public Dog(String name, int month, String sex) {
//        super(name, month);
//        this.sex = sex;
        this.setName(name);
        this.setMonth(month);
        this.setSex(sex);
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void sleep(){
        System.out.println("dog sleep");
    }

    @Override
    public void eat() {
        System.out.println("dog eat meet");
    }
}
```
4. 测试类
```java
public class AnimalText {
    public static void main(String[] args) {
        Animal one=new Animal();//1
        Animal two=new Cat();//2
        Animal three=new Dog();//3

        one.eat();
        two.eat();
        three.eat();

        System.out.println(two.getMonth());

        //one,two不能调用特有的run，sleep方法

        //向下转型：强制类型转换
        Cat cat1=(Cat)two;
        cat1.eat();
        cat1.run();
        System.out.println(cat1.getWeight());

        //错误，two是cat类型，不能转成Dog类型
//        Dog dog=(Dog)two;
//        dog.eat();
//        dog.sleep();
    }
}
```
