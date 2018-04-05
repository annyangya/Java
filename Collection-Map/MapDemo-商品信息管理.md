### 需求
使用HashMap对商品信息进行管理
1. 其中key为商品编号，value为商品对象
2. 对HashMap中的商品信息进行增删改查

#### 分析商品信息类
属性：
1. 商品编号：id
2. 商品名称：name
3. 商品价格：price
方法：
1. 构造方法
2. 获取和设置属性值的方法
3. 其他方法（toString）

### Goods类
```java
package Collection;

    public class Goods {
    private String id;
    private String name;
    private double price;

    public Goods(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
```

### Text类
```java
package Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class GoodsText {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        //key值唯一，所以用商品信息编号作为key值，Goods 类作为value值
        Map<String,Goods> goodMap=new HashMap<>();
        //接收键盘的数据，存储到hashMap中
        System.out.println("请输入三条商品信息：");
        int i=0;
        while(i<3)
        {
            System.out.println("请输入第"+(i+1)+"条：");
            System.out.println("请输入id");
            String goodsid=scanner.next();
            System.out.println("请输入商品名称：");
            String goodsname=scanner.next();
            System.out.println("请输入商品价格：");
            double goodsPrice=scanner.nextDouble();

            //把商品信息组合到一个商品对象中
            Goods goods=new Goods(goodsid,goodsname,goodsPrice);
            goodMap.put(goodsid,goods);
            i++;
        }

        System.out.println("遍历map输出商品信息");
        //获取value
        Iterator<Goods> it=goodMap.values().iterator();
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
    }

}
```
#### 注意
当我们输入相同的id时，商品信息就没有存储，因为HashMap中key不能相同。并且，我们输入两个key相同的值，最后输入的信息是最后输入的key对应的信息。
所以我们在输入数据的时候，应该写代码对我们提醒，不能输入有相同id的信息，即key相同.在输入id后加入下面代码
```java
            //判断是否存在输入的key
            if(goodMap.containsKey(goodsid))
            {
                System.out.println("该商品编号已经存在，请重新输入！");
                //跳出当前循环
                continue;
            }
```
如果id相同则跳出当前循环重新输入id。
#### 注意
输入格式的判断，比如说输入价格，价格是double类型，如果输入时输入其他类型的字符，就会报错：java.util.InputMismatchException
```java
            double goodsPrice=0;
            System.out.println("请输入商品价格：");
            try{
                goodsPrice=scanner.nextDouble();
            }catch (java.util.InputMismatchException e){
                System.out.println("商品价格格式不正确，请输入数值型");
                continue;
            }
```
此时又有一个问题，当我们输入价格错误以后，提示从新输入商品名称和价格，但是当我们运行出来会发现，商品编号错误，如下：
```java
请输入三条商品信息：
请输入第1条：
请输入id
001
请输入商品名称：
phone
请输入商品价格：
1200
请输入第2条：
请输入id
002
请输入商品名称：
watch
请输入商品价格：
23sda
商品价格格式不正确，请输入数值型
请输入第2条：
请输入id
请输入商品名称：
watch
请输入商品价格：
2000
请输入第3条：
请输入id
003
请输入商品名称：
computer
请输入商品价格：
100000
遍历map输出商品信息
Goods{id='001', name='phone', price=1200.0}
Goods{id='003', name='computer', price=100000.0}
Goods{id='23sda', name='watch', price=2000.0}
```
可以看到第三条商品的id是我们上一次输入的错误价格。
这是因为nextDouble把输入的错误价格又存到下一次next方法里面，导致下一个next方法已经被调用，所以可以看到提示并没有让我们重新输入商品编号。
所以我们在catch里面这样写代码,添加scanner.next();
```java
                System.out.println("商品价格格式不正确，请输入数值型");
                scanner.next();
                continue;
```
