## 案例需求
1. 在HashSet中可以添加和显示宠物猫信息
2. 在HashSet中查找某只宠物猫信息并输出
3. 修改宠物猫的信息
4. 删除宠物猫的信息
### 宠物猫
#### 宠物猫的属性
1. name：名字
2. month：年龄
3. species：种类

#### 方法
1. 构造方法
2. 获取和设置属性值的方法
3. 其他方法

##### Demo1
```java
package Collection;

public class CatSet {
    private String name;
    private int month;
    private String species;

    public CatSet(String name, int month, String species) {
        this.name = name;
        this.month = month;
        this.species = species;
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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}

```

Text类
```java
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CatSetText {
    public static void main(String[] args) {
        //定义宠物猫对象
        CatSet huahua=new CatSet("花花",12,"黄猫");
        CatSet fanfan=new CatSet("凡凡",4,"黑猫");
        //将宠物猫放入HashSet中
        Set set=new HashSet();
        set.add(huahua);
        set.add(fanfan);

        //显示宠物猫信息
        Iterator it=set.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }
}

/*
输出结果：
Collection.CatSet@5fe5c6f
Collection.CatSet@6979e8cb
是两只猫的地址，所以想要看到猫的详细信息，需写出其toString方法，这样后面在输出的时候可以自动调用toString方法
*/
```
##### 在CatSet写入toString方法
```java
@Override
    public String toString() {
        return "CatSet{" +
                "name='" + name + '\'' +
                ", month=" + month +
                ", species='" + species + '\'' +
                '}';
    }
```
这样再次运行，结果为
```java
CatSet{name='花花', month=12, species='黄猫'}
CatSet{name='凡凡', month=4, species='黑猫'}
```

##### 添加一个和花花属性相同的猫花花2看输出结果
```java
        CatSet huahua2=new CatSet("花花",12,"黄猫");
        set.add(huahua2);
        //显示猫的信息
        System.out.println("添加重复数据之后：***************");
        Iterator it2=set.iterator();
        while(it2.hasNext())
        {
            System.out.println(it2.next());
        }
```
###### 结果：
```java
CatSet{name='花花', month=12, species='黄猫'}
CatSet{name='凡凡', month=4, species='黑猫'}
添加重复数据之后：***************
CatSet{name='花花', month=12, species='黄猫'}
CatSet{name='凡凡', month=4, species='黑猫'}
CatSet{name='花花', month=12, species='黄猫'}
```
可以看到，花花2的信息和花花信息一样，但是被成功添加进去了，但是set的元素不是应该是无序且不能重复吗？为什么花花2成功添加进去了呢？
如果向set中添加字符串，那么可以很好判断字符串是否相等，但是set中添加的元素是我们定义的类对象，如果要知道是否元素相同，就要判断类对象是否相等。
这就涉及到另外两个方法的使用：
###### hashCode&equals 方法
通过对hashCode()和equals()方法的重写，可以实现判断两个对象是否相等，所以还要在CatSet中添加对这两个方法的重写

        Iterator it2=set.iterator();
