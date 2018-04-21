## java多态
### 向上转型
1. 父类的引用指向子类具体的实例，把子类的对象转成父类，向上转型也称隐式转型，自动转型
2. 向上转型后，可以调用子类重写父类的方法以及父类派生的方法，子类特有的方法不能使用
3. 父类中的静态方法不能被重写，向上转型后的子类只能调用父类的方法。

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
5. result
```java
animal eat food
cat eat fish
dog eat meet
0
cat eat fish
cat run
0.0
```
### instanceof运算符
判断左边部分是不是右边部分的子类
```java

        if(two instanceof Cat){
            Cat cat=(Cat)two;
            cat.eat();
            cat.run();
            System.out.println("two可以转成cat类型");
        }
        if(two instanceof Dog){
            Dog dog=(Dog)two;
            dog.sleep();
            dog.eat();
            System.out.println("two可以转成Dog类型");
        }

        if(two instanceof Animal){
            System.out.println("Animal");
        }

        if(two instanceof Object){
            System.out.println("Object");
        }
        
        //two具有Animal和Object的特征，因为Animal是Cat的父类，Object是Animal的父类
```
result:
```java
cat eat fish
cat run
two可以转成cat类型
Animal
Object
```
two是Cat的子类，不是Dog的子类

### static在子类继承中的应用
1. 如果父类中的一个方法是静态的，那么这个方法就是类共有的，子类不能继承后重写这个方法。
```java
 public static void say(){
        System.out.println("Animal say");
    }
```
假如父类新增say方法，在cat中重写这个方法，注意，如果重写方法时没有@Override标记，那么这个方法代表是子类特有的方法，而不是继承而来的方法。
如果子类在run方法上注明@Override，则代表这是重写父类的方法，那么就会报错。因为父类的static方法是不允许子类重写的，子类只能老老实实继承。
2. 如果子类的run方法没有注明@Override，向上转型子类的也只能调用父类的run方法，如果子类要想调用自己特有的方法，只能向下转型。
### 类型转换案例 
增加master类，master有feed方法，根据传入参数不同，喂养不同的动物。
1. 方案一：编写方法，传入不同的类型，调用各自的方法:动物多时不方便
```java
 public void feed(Cat cat){
        cat.eat();
        cat.run();
    }

    public void feed(Dog dog){
        dog.eat();
        dog.sleep();
    }
```
2. 方案二：编写方法传入动物的父类，方法中通过类型转换，调用指定子类的方法
```java
public void feed(Animal animal){
        if(animal instanceof Cat){
            Cat cat=(Cat)animal;//强制类型转换之后就可以调用子类特有的方法，cat 和animal其实是一个对象，地址相同，可以通过设置断点调试
            cat.eat();
            cat.play();
        }else if(animal instanceof Dog){
            Dog dog=(Dog)animal;
            dog.eat();
            dog.sleep();
        }
    }
```
测试类：
```java
        Master master=new Master();
        Cat cat=new Cat();
        master.feed(cat);
        
        result:
        cat eat fish
        cat play
```
