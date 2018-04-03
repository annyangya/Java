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
是两只猫的地址，所以想要看到猫的详细信息，需写出其toString方法
*/
```

