## 集合框架的体系结构： 
Collection: 存储类的对象;Map:键值对形式存储

#### List（列表）：
1. 元素是有序并且可以重复的集合，称为序列
2. list可以精确的控制每个元素的插入位置，或删除某个位置的元素
3. list的两个主要实现类是ArrayList（数组）和LinkedList（链表）
#### ArrayList：
1. 底层是由数组实现
2. 长度动态增长，以满足应用程序的要求（内存是一片连续的内存空间）
3. 在列表尾部插入或删除数据非常有效
4. 更适合查找和更新元素
5. ArrayList中的元素可以为null

```java
import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {
        List list1=new ArrayList();
        list1.add("java");
        list1.add("c");
        list1.add("android");
        list1.add("go");

        //循环遍历list中元素
        for(int i=0;i<list1.size();i++)
        {
            System.out.print(list1.get(i)+" ");
        }

        System.out.println();
        list1.remove(2);//移除下标为2的元素
        for(int i=0;i<list1.size();i++)
        {
            System.out.print(list1.get(i)+" ");
        }
/*
结果：java c android go 
     java c go 
*/
    }
}
```

#### set：元素无序且不可以重复的集合，称为集
1. HashSet是Set的一个重要实现类，称为哈希集
2. HashSet中元素无序且不可以重复
3. HashSet中只允许有一个null元素（不允许重复，只允许一个）
4. 具备良好的存取和查找性能
5. hashSet底层是hashMap
6. set是接口，没有构造方法
7. set中插入元素,插入顺序不管，因为set 本身是无序的，而List则是插入末尾
```java
set.add("hello");
```
#####注意
插入重复元素的时候不会报错，也不会成功，因为set本身是无序且不能有重复元素的
##### 迭代器
1. List中通过get方法取得元素，而set中不能通过get取得。set 中通过迭代器获取元素。
2. 迭代器是一个接口，可以以统一的方式对各种集合元素进行遍历
3. hasNext()方法检测集合中是否还要下一个元素：返回值为true则还有下一个元素，返回值为false表示已经遍历完毕
4. next()方法返回集合中的下一个元素
5. 调用方法：

1）通过set调用迭代器的iterator方法，将结果存在Iterator的引用it中
```java
Iterator it=set.iterator();
```
2）遍历迭代器并输出元素,判断迭代器中是否还要元素，如果还有元素则执行循环，在循环中取出元素
```java
while(it.hasNext){
    System.out.print(it.next()+"  ");
  }
```
范例：
```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

//存储字符串到set中
public class setDemo {

    public static void main(String[] args) {
        Set set=new HashSet();//set的引用指向HashSet的对象
        //向集合中添加元素
        set.add("java");
        set.add("android");
        set.add("java ee");
        set.add("java se");

        System.out.println("集合中的元素为：");
        
        Iterator iterator=set.iterator();
        while(iterator.hasNext())
        {
            System.out.print(iterator.next()+"  ");
        }
    }
}

```
#### Map
1. Map中的数据是以键值对（key—value）的形式存储的。比如说，username—王五，这里的username就是key，王五就是value。
2. key-value以Entry类型的对象实例存在，Entry是Map当中的一个接口，把key-value以键值对的形式存储在接口对象当中。
3. 可以通过key值快速查找value的值，比如对于字典，key就是要查找的词，value就是要查找的词的意思，所以可以通过key快速查找value的值。
4. 一个映射不能包含重复的键，即key不能重复，必须唯一。但是value可以重复，一个value可以对应多个key键。
5. 每个键最多只能映射到一个值。

##### HashMap
1. HashMap是基于Map接口的实现，是Map中最常用的实现类。
2. 允许使用null值和null键，即它的值允许为空，因为key值唯一，所以HashMap中null键只能有一个，即只能有一个为空的键。
3. key值不允许重复。
4. HashMap中的Entry对象是无序排列的。Entry是key-value键值对的映射。ArrayList是有序的，Set（HashSet）和Map（HashMap）是无序排列的。

范例：
完成一个类似于字典的功能。
1. 将单词以及单词的注释存储到HashMap中
2. 显示HashMap当中的内容
3. 查找某个单词的注释并显示

这里以键值对的形式存储，并添加泛型
```java
Map<String,String> animalMap=new HashMap<>();
```
因为接下来输入的内容都是String类型的。通过手动输入键值对,put方法可以将数据添加到Map中
``java
        System.out.println("输入三组单词对应的注释，并存放到HashMap中");
        Scanner scanner=new Scanner(System.in);
        //通过循环添加数据
        for(int i=0;i<3;i++)
        {
            System.out.println("请输入key值：(单词)");
            String key=scanner.next();
            System.out.println("请输入value值：（注释）");
            String value=scanner.next();
            animalMap.put(key,value);
        }
```
接下来先打印出所有的value值，这里我们使用迭代器
```java
        System.out.println("使用迭代器打印输出value值");
        Iterator<String> it=animalMap.values().iterator();//values方法返回值是collection，通过迭代器方法可将其存储在迭代器中
        while(it.hasNext())
        {
            System.out.print(it.next()+"   ");
            //打印顺序不一定和输入顺序一样
        }
```
接下来打印所有键值对，我们使用增强 for循环System.out.println("通过entryset打印输出所有键值对");
```java
        //意思是set返回值是entry类对象，entry类key是String类，value是String类
        Set<Map.Entry<String,String>> entryset=animalMap.entrySet();
        //entryset中取出来的值是Map.Entry<String,String>类型
        for(Map.Entry<String,String> entry:entryset)
        {
//            //获取key值
//            entry.getKey();
//            //获取value值
//            entry.getValue();
            System.out.print(entry.getKey()+"-");
            System.out.println(entry.getValue());
        }


```
查看结果
```java
输入三组单词对应的注释，并存放到HashMap中
请输入key值：(单词)
cat
请输入value值：（注释）
猫
请输入key值：(单词)
dog
请输入value值：（注释）
狗
请输入key值：(单词)
bird
请输入value值：（注释）
鸟
********************************
使用迭代器打印输出value值
猫   鸟   狗   ********************************
通过entryset打印输出所有键值对
cat-猫
bird-鸟
dog-狗
```
