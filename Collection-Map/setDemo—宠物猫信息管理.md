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

### 添加宠物猫
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
#### 在CatSet写入toString方法
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

#### 添加一个和花花属性相同的猫花花2看输出结果
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
#### hashCode&equals 方法
1. 通过对hashCode()和equals()方法的重写，可以实现判断两个对象是否相等，所以还要在CatSet中添加对这两个方法的重写
2. 哈希表的使用：（详见数据结构）hashCode可以判断元素在哪个位置，而equals方法可以判断元素是否与要求的相同，提高查询效率
##### hashCode方法
```java
@Override
    public int hashCode() {
        final int prime=31;
        int result=1;
        result=prime*result+month;
        result=prime*result+((name==null)?0:name.hashCode());
        result=prime*result+((species==null)?0:species.hashCode());
        return result;
    }
```
##### equals方法
```java
    @Override
    public boolean equals(Object obj) {

        //如果当前对象和传入的obj对象相等，则肯定是同一个对象，如果对象相同则不用比较下面的属性，直接返回true
        if(this==obj)
        {
            return true;
        }
        //判断obj的当前类是不是就是CatSet（反射的应用），obj是object的对象，在这里判断是不是CatSet
        //判断obj是否是CatSet的对象，如果是，强制转换成CatSet类
        if(obj.getClass()==CatSet.class)
        {
            //如果是CatSet对象，就把它强制转换成CatSet类
            CatSet cat=(CatSet)obj;
            //之后看属性是否相同
            //三个都相同则返回true，否则返回false
            return cat.getName().equals(name)&&cat.getMonth()==month&&cat.getSpecies().equals(species);
        }

        //上述条件都不符合，则一定不是相同对象，则返回false
        return false;
    }
```
equals纯代码：
```java
@Override
    public boolean equals(Object obj) {
        if(this==obj)
        {
            return true;
        }
        if(obj.getClass()==CatSet.class)
        {
            CatSet cat=(CatSet)obj;
            return cat.getName().equals(name)&&cat.getMonth()==month&&cat.getSpecies().equals(species);
        }
        return false;
    }
```
###### 结果
```java
CatSet{name='花花', month=12, species='黄猫'}
CatSet{name='凡凡', month=4, species='黑猫'}
添加重复数据之后：***************
CatSet{name='花花', month=12, species='黄猫'}
CatSet{name='凡凡', month=4, species='黑猫'}
```
可以看出花花2添加失败，因为通过hashCode和equlas方法判断以后，花花和花花2有相同的属性，所以无法添加

### 查询宠物猫
先插入花花3，增加元素，以便查找
```java
        CatSet huahua3=new CatSet("花花3",10,"白猫");
        set.add(huahua3);

        System.out.println("添加花花3数据之后：***************");
        it=set.iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
```
接下来通过对象名查找猫，以查找花花为例，如果找到花花了就输出“花花找到了”和花花的信息，没找到就输出没找到.
这里我们调用set中的contains方法来判断花花是否在set中
```java
        System.out.println("在集合中查找花花的信息并输出：***************");
        //使用对象名查找
        if(set.contains(huahua))
        {
            System.out.println("花花找到了");
            System.out.println(huahua);
        }else
        {
            System.out.println("花花没找到");
        }
```
###### 结果
```java
在集合中查找花花的信息并输出：***************
花花找到了
CatSet{name='花花', month=12, species='黄猫'}
```
再通过对象的名字即花花的name来找
```java
       System.out.println("在集合中通过查找花花的名字来判断花花是否存在并输出：***************");
        boolean flag=false;//通过flag来判断花花是否找到，如果为true则找到，否则没有找到
        CatSet c=null;
        while(it.hasNext())
        {
            c=(CatSet)it.next();//注意这里要强制类型转换，因为next得到的是object对象
            if(c.getName().equals("花花"))
            {
                flag=true;//找到花花
                break;
            }
        }
        if(flag){
            System.out.println("huahua找到了");
            System.out.println(c);
        }else
        {
            System.out.println("huahua没有找到");
        }
```
###### 结果
```java
在集合中通过查找花花的名字来判断花花是否存在并输出：***************
huahua没有找到
```
输出了花花没找到！这又是为什么呢？
因为我们用的是先前的it，而在前面的代码中，迭代器已经遍历完了，所以不会再找到花花的信息。所以我们要重新对迭代器it进行初始化
添加
```java
it=set.iterator();
```
即
```java
System.out.println("在集合中通过查找花花的名字来判断花花是否存在并输出：***************");
        boolean flag=false;//通过flag来判断花花是否找到，如果为true则找到，否则没有找到
        CatSet c=null;
        it=set.iterator();
        while(it.hasNext())
        {
            c=(CatSet)it.next();//注意这里要强制类型转换，因为next得到的是object对象
            if(c.getName().equals("花花"))
            {
                flag=true;//找到花花
                break;
            }
        }
        if(flag){
            System.out.println("huahua找到了");
            System.out.println(c);
        }else
        {
            System.out.println("huahua没有找到");
        }
```
所以结果为：
```java
在集合中通过查找花花的名字来判断花花是否存在并输出：***************
huahua找到了
CatSet{name='花花', month=12, species='黄猫'}

```


### 删除宠物猫的信息
删除花花2的信息并重新输出,这里使用增强for循环
```java
 //将集合set中的元素依次取出来放在cat中
        for(CatSet cat:set)
        {
            if("花花3".equals(cat.getName()))
            {
                set.remove(cat);//此时花花3存放在cat中，所以删除cat即可
            }
        }
        //判断是否真的删除
        System.out.println("删除花花3之后的数据：***************");
        for(CatSet cat:set)
        {
            System.out.println(cat);
        }
```
上述代码的意思是如果set中存放对象有姓名为花花2则将其删除，但是运行之后会报错！
```java
Exception in thread "main" java.util.ConcurrentModificationException
```
#### foreach循环更加简洁，与使用iterator接口迭代访问集合元素类似的是，foreach循环中的迭代变量也不是集合元素本身，系统只是依次把集合中的元素值赋给迭代变量，因此在foreach循环中修改迭代变量的值也没有实际意义。使用foreach循环访问集合元素时，集合不能被改变，否则会引发java.util.ConcurrentModificationException异常

### 删除全部宠物猫信息
```java
set.removeAll(set);
```
通过两种方式判断是否删除成功：
1. 设置flag判断，为真则全部删除
```java
        System.out.println("删除集合中所有元素***************");
        boolean flag1=set.removeAll(set);//返回布尔值类型
        if(flag1)//为真则删除成功
        {
            System.out.println("全部删除");
        }else
        {
            System.out.println("没有全部删除");
        }
```
2. 通过isEmpty方法判断
```java
        if(set.isEmpty())
        {
            System.out.println("全部删除");
        }else
        {
            System.out.println("没有全部删除");
        }
```

