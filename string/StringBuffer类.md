## StringBuffer类
Sting对象的字符序列不可修改，即不能插入删除，但是StringBuffer类的对象实体的内存空间可以自动地改变大小，便于存放一个可变的字符序列
### 构造方法
1. StringBuffer():无参构造方法，分配的初始容量为16即可以容纳16个字符，如果实际存放的容量大于16，则容量自动增加，可以通过length方法获取实际存放的字符串
的长度，capacity方法获取当前实体的实际容量
2. StringBuffer(int size):指定分配初始容量，实际存放字符长度大于size则自动增加
3. StringBuffer(String s):指定分配的初始容量为s的字符序列长度加上16

### 常用方法
1. append():从字符串末尾添加，返回当前对象的引用
2. charAt(int n):获取指定位置的字符。  
3. setCharAt(int n,char ch):将指定位置的字符替换为ch
4. insert(int index,String str):将str插入到index指定的位置，返回当前对象的引用
5. reverse()：将字符串翻转，返回当前对象的引用
6. delete(int startIndex,int ednIndex):从startIndex到endIndex-1位置的字符序列删除，返回当前对象的引用
7. replace(int startIndex,int endIndex,String str):将从startIndex到endIndex-1位置的字符序列替换成str，返回当前对象的引用

### 范例
```java
public class stringBufferText {
    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer("hello java");
        System.out.println("length:"+stringBuffer.length());
        System.out.println("capacity:"+stringBuffer.capacity());

        stringBuffer.append(" android");
        System.out.println("length2:"+stringBuffer.length());
        System.out.println("capacity2:"+stringBuffer.capacity());

        System.out.println("获取字符："+stringBuffer.charAt(3));
        stringBuffer.setCharAt(7,'你');
        System.out.println("stringbuffer:"+stringBuffer);

        stringBuffer.insert(2,'好');
        System.out.println("stringbuffer2:"+stringBuffer);

        stringBuffer.reverse();
        System.out.println("stringbuffer3:"+stringBuffer);

        stringBuffer.delete(3,8);
        System.out.println("stringbudder4:"+stringBuffer);

        stringBuffer.replace(1,5,"Android");
        System.out.println("string buffer5:"+stringBuffer);
    }
}
```
result:
```java

length:10
capacity:26
length2:18
capacity2:26
获取字符：l
stringbuffer:hello j你va android
stringbuffer2:he好llo j你va android
stringbuffer3:diordna av你j oll好eh
stringbudder4:dioav你j oll好eh
string buffer5:dAndroid你j oll好eh
```
