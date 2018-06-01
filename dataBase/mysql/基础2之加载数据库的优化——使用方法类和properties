#### jdbcUtils方法类的使用
在最后关闭Connection链接的时候，不但要关闭Connection，还应该关闭Statement与ResultSet，
每次关闭时都要捕获异常，为了不使代码显得冗长，我们把关闭的方法写在一个方法类里，即jdbcUtils
```java
 public static void close(Connection connection,Statement statement,ResultSet resultSet){
        closeCon(connection);
        closeSt(statement);
        closeRe(resultSet);
    }
    
    public static void closeCon(Connection connection){
        while(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connection=null;
            }
        }
    }
    
    public static void closeSt(Statement statement){
        while (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                statement=null;
            }
        }
    }
    
    public static void closeRe(ResultSet resultSet){
        while(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                resultSet=null;
            }
        }
    }
```
#### properties的使用
java开发中经常将一些易变配置参数放置在xml配置文件或properties配置文件。
解析xml配置文件通常使用dom或sax方式，而读取properties配置文件比较容易，直接使用java.util下的Properties类读取配置文件。
一般读取properties里面的内容有下面两种方式，根据properties文件的位置不同而采取不同的方式。
1. properties文件位于java项目的根目录下，我们通过FileInputStream读取，注意捕获异常
```java
InputStream inputStream= null;
 try {
            inputStream = new FileInputStream("jdbc.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
```
2. properties文件位于src目录下
```java
InputStream inputStream=jdbc1.class.getClassLoader().getResourceAsStream("jdbc.properties");
```
#### 使用properties文件之后的加载步骤
因为在mysql官方文档中，将username等信息通过静态代码块加载，即类一创建就把内容加载进内存，我们也这样操作。
1. properties的内容：包括加载驱动字符串，username，password等
```java
driverClass=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/student
username=root
password=null
```
2. jdbcUtils中，使用静态代码块
```java
static String url=null;
    static String username=null;
    static String password=null;
    static String driver=null;

    static {
        //创建一个属性配置对象
        Properties properties=new Properties();
       // InputStream inputStream=jdbc1.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream inputStream= null;
        try {
            inputStream = new FileInputStream("jdbc.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //导入输入流
            properties.load(inputStream);
            driver=properties.getProperty("driverClass");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```
3. main函数里修改如下代码
```
Class.forName(jdbcUtils.driver);
connection= DriverManager.getConnection(jdbcUtils.url,jdbcUtils.username,jdbcUtils.password);
```
#### 最终代码
1. jdbcUtils.java
```
package jdbc1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class jdbcUtils {
    static String url=null;
    static String username=null;
    static String password=null;
    static String driver=null;

    static {
        //创建一个属性配置对象
        Properties properties=new Properties();
       // InputStream inputStream=jdbc1.class.getClassLoader().getResourceAsStream("jdbc.properties");
        InputStream inputStream= null;
        try {
            inputStream = new FileInputStream("jdbc.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            //导入输入流
            properties.load(inputStream);
            driver=properties.getProperty("driverClass");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close(Connection connection,Statement statement,ResultSet resultSet){
        closeCon(connection);
        closeSt(statement);
        closeRe(resultSet);
    }

    public static void closeCon(Connection connection){
        while(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                connection=null;
            }
        }
    }

    public static void closeSt(Statement statement){
        while (statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                statement=null;
            }
        }
    }

    public static void closeRe(ResultSet resultSet){
        while(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                resultSet=null;
            }
        }
    }
}
```
2. jdbc1.java
```java
package jdbc1;

import java.sql.*;

public class jdbc1 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            Class.forName(jdbcUtils.driver);
            connection= DriverManager.getConnection(jdbcUtils.url,jdbcUtils.username,jdbcUtils.password);
            statement=connection.createStatement();
            String sql="select * from Student";
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                String id=resultSet.getString(1);
                System.out.println(id);
            }
            jdbcUtils.close(connection,statement,resultSet);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
```
