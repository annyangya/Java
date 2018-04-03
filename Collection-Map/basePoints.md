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
