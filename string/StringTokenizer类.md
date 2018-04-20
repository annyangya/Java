## StringTokenizer类

### 构造方法
1. StringTokenizer(String s):为String对象s构造一个分析器，使用默认的分隔标记，即空格符，换行符，回车符，Tab符，进纸符
2. StringTokenizer(String s,String delim):为String对象s构造一个分析器，参数delim的字符序列中的字符的任意排列被作为分隔标记
```java
    StringTokenizer stringTokenizer=new StringTokenizer("you are pretty");
    StringTokenizer stringTokenizer2=new StringTokenizer("askdh##skah#$sd#","#$");
    //#$为分隔标记，#和$的任意排列就是一个分隔标记
```

### 常用方法
1. nextToken():逐个获取String对象的字符序列中的语言符号，每获取一个，字符串分析器中负责计数的变量值自动减一，这个变量初始值等于字符串中的单词数目
2. hasMoreTokens():只要字符序列中还有语言符号，即计数变量的值大于0，这方法就返回true，否则返回false
3. countTokens():得到分析器中计数变量的值

### 范例
方法类：
```java
import java.util.StringTokenizer;

public class PriceToken {
    public double getPriceSum(String ShoppingPrice){
        String regex="[^0123456789.]+";
        //将字符串中所有除了数字，点之外的字符替换成#
        ShoppingPrice=ShoppingPrice.replaceAll(regex,"#");
        //#为分隔符，将数字分割出来
        StringTokenizer stringTokenizer=new StringTokenizer(ShoppingPrice,"#");
        double sum=0;
        while(stringTokenizer.hasMoreTokens()){
            String item=stringTokenizer.nextToken();
            double price=Double.parseDouble(item);
            sum+=price;
        }
        return sum;
    }

    public int getCount(String ShoppintPrice){
        String regex="[^0123456789.]+";
        ShoppintPrice=ShoppintPrice.replaceAll(regex,"#");
        StringTokenizer stringTokenizer=new StringTokenizer(ShoppintPrice,"#");
        int count=stringTokenizer.countTokens();
        return count;
    }

    public double getAverPrice(String ShoppingPrice){
        double priceSum=getPriceSum(ShoppingPrice);
        int count=getCount(ShoppingPrice);
        return priceSum/count;
    }

    StringTokenizer stringTokenizer=new StringTokenizer("you are pretty");
    StringTokenizer stringTokenizer2=new StringTokenizer("askdh##skah#$sd#","#$");
}
```
测试类：
```java
public class StringTokeinerText {
    public static void main(String[] args) {
        String ShoppingPrice="牛奶：8.5元，香蕉 3.6元，酱油：2.8元";
        PriceToken priceToken=new PriceToken();
       double sum=priceToken.getPriceSum(ShoppingPrice);
        double count=priceToken.getCount(ShoppingPrice);
        double ave=priceToken.getAverPrice(ShoppingPrice);
        System.out.println(ShoppingPrice);
        System.out.println("总价格："+sum);
        System.out.println("总数量："+count);
        System.out.println("平均价格："+ave);
    }
}
```
结果：
```java
牛奶：8.5元，香蕉 3.6元，酱油：2.8元
总价格：14.899999999999999
总数量：3.0
平均价格：4.966666666666666
```
