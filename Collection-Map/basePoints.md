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
1. HashSet是Set的一个重要类，称为哈希集
2. HashSet中元素无序且不可以重复
3. HashSet中只允许有一个null元素
4. 具备良好的存取和查找性能

