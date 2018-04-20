## String字符串
1. String是一个类

### 创建String对象的三种方法
1. 创建一个字符串对象hello1，名为s1
```java
String s1="hello1";
```
2. 创建一个空的字符串对象,名为s2
```java
String s2=new String();
```
3. 创建一个字符串对象hello3，名为s3
```java
String s3=new String("hello3");
```

### 常用方法
```java
1. int length():返回当前字符串的长度
2. int indexOf(int ch):查找ch字符在该字符串中第一次出现的位置
3. int indexOf(String str):查找str字符串在该字符串中第一次出现的位置
4. int lastIndexOf(char ch):查找ch字符在该字符串中最后一次出现的位置
5. int lastIndexOf(String str):查找str字符串在该字符串中最后一次出现的位置
6. String subString(int beginIndex):获取从beginIndex位置开始到结束的子字符串
7. String subString(int beginIndex,int endIndex):获取从beginIndex到endIndex位置的字符串
8. String trim():返回去除了前后空格的字符串
9. String toLowerCase():将字符串转换为小写
10. String toUpperCase():将字符串转换为大写
11. char charAt(int index):获取字符串中指定位置的字符
12. String[] split(String regex,int limit):将字符串分割为子字符串，返回字符串数组
13. byte[] getByte():将字符串转换为byte数组
14. boolean equals(Object obj):若该字符串与指定对象比较，返回true或者false
```
 
