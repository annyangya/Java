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
