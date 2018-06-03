### 基础知识
当需要向反复执行一条相似语句时，比如向数据库中插入数据，每次都需要执行插入语句，但是插入的值不一样，这种情况就可以用占位符来代替，比如
```java
insert into info values(?,?,?);
```
statement不支持使用占位符，我们就可以用preparedStatement，这是statement的子接口。
```java
@Test
    public void textPreparedStatement(){
        connection=jdbcUtils.getconn();
        String sql="insert into info values(?,?,18)";
        try {
            preparedStatement=connection.prepareStatement(sql);
            for(int i=0;i<10;i++){
            //为占位符代表的参数设置具体的值
                preparedStatement.setString(1,"1"+i);
                preparedStatement.setString(2,"a"+i);
            }
            //执行查询语句，这是前面写的查询方法。
           textQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    结果：
    1  ann  100
3  ed  40
5  lily  12
6  lingling  28
10  a0  18
11  a1  18
12  a2  18
13  a3  18
14  a4  18
15  a5  18
16  a6  18
17  a7  18
18  a8  18
19  a9  18
```
### 解决login问题
```java
@Override
    public void login(String id, String name) {
        connection=jdbc2.jdbcUtils.getconn();
        try {
            String sql="SELECT * FROM info WHERE id=? and name=?";
            //预先对sql语句进行语法检查，？后面不管传入什么内容，都把它当作字符串
            preparedStatement=connection.prepareStatement(sql);
            // ？对应的索引从1开始，下面传入内容时不能搞混了
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,name);
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("登录成功："+id+"-"+name);
            }else{
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,statement,resultSet);
        }
    }
    
    结果：
    登录失败
    登录成功：1-ann
```

#### 查询
接下来像使用statement那样用preparedstatement来进行数据库的增删查改。我们使用Dao模式，将方法写在接口里，并用类去实现这些接口。
我将方法实现的具体过程先展示出来。书写个操作步骤时注意sql语句的书写规范
```java
@Override
    public void query() {
        connection=jdbc2.jdbcUtils.getconn();
        String sql="SELECT * FROM User";
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String id1=resultSet.getString(1);
                String name=resultSet.getString(2);
                System.out.println(id1+"  "+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }
    
    结果：
    1  ann
    3  ed
```

#### 插入
setString方法可以指定占位符具体的参数，仔通过测试类插入具体的值
```java
 @Override
    public void insert(String name, String password) {
        connection=jdbc2.jdbcUtils.getconn();
        //id是主码，将其设置为null就可以实现自增长，表中以及将其设置为自增长
        String sql="INSERT INTO User VALUES (null,?,?)";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            int result=preparedStatement.executeUpdate();
            if(result>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }
    
    结果：
    添加成功
    我们可以看到数据库中已经增加了一行数据
```

#### 删除
```java
@Override
    public void delete(int id) {
        connection=jdbc2.jdbcUtils.getconn();
        String sql="DELETE FROM User WHERE id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int result=preparedStatement.executeUpdate();
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }
```

#### 更新
```java
@Override
    public void update(int id,String name) {
        connection=jdbc2.jdbcUtils.getconn();
        String sql="update User set  name=?  where id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            int result=preparedStatement.executeUpdate();
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }
```

#### 接口
```java
package Dao;

public interface userDao {
    void query();
    void insert(String name,String password);
    void delete(int id);
    //根据id更新具体的用户名
    void update(int id,String name);
}
```

#### 实现类
```java
package Impl;

import Dao.userDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userImpl implements userDao {
    Connection connection=null;
    PreparedStatement preparedStatement=null;
    ResultSet resultSet=null;
    @Override
    public void query() {
        connection=jdbc2.jdbcUtils.getconn();
        String sql="SELECT * FROM User";
        try {
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String id1=resultSet.getString(1);
                String name=resultSet.getString(2);
                System.out.println(id1+"  "+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }

    @Override
    public void insert(String name, String password) {
        connection=jdbc2.jdbcUtils.getconn();
        //id是主码，将其设置为null就可以实现自增长，表中以及将其设置为自增长
        String sql="INSERT INTO User VALUES (null,?,?)";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,password);
            int result=preparedStatement.executeUpdate();
            if(result>0){
                System.out.println("添加成功");
            }else{
                System.out.println("添加失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }

    @Override
    public void delete(int id) {
        connection=jdbc2.jdbcUtils.getconn();
        String sql="DELETE FROM User WHERE id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            int result=preparedStatement.executeUpdate();
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }

    @Override
    public void update(int id,String name) {
        connection=jdbc2.jdbcUtils.getconn();
        String sql="update User set  name=?  where id=?";
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            preparedStatement.setInt(2,id);
            int result=preparedStatement.executeUpdate();
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,preparedStatement,resultSet);
        }
    }
}
```

#### 测试类
```java
package Text;

import Dao.userDao;
import Impl.userImpl;
import org.junit.Test;

public class TextDaoUserImpl {
    @Test
    public void textInsert(){
        userDao dao=new userImpl();
        //dao.query();
        //dao.insert("zhangsan","123456");
        //dao.delete(1);
        dao.update(3,"wangwu");
    }
}
```
