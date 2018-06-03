### 查询
```java
Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;

    @Test
    public void textQuery(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM info");
            while (resultSet.next()){
                String id=resultSet.getString(1);
                String name=resultSet.getString(2);
                String age=resultSet.getString(3);
                System.out.println(id+"  "+name+"  "+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }
    结果：
   success
1  ann  100
3  ed  15
4  zhangsan  40
5  lily  12
```
### 插入
```java
@Test
    public void textInsert(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            int result=statement.executeUpdate("insert into info values(6,'lingling',28)");
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
            textQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }
    结果：
    success
1  ann  100
3  ed  15
4  zhangsan  40
5  lily  12
6  lingling  28
```
### 删除
```java
@Test
    public void textDelete(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            int result=statement.executeUpdate("delete from info WHERE name='zhangsan'");
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
            textQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }
    结果
success
1  ann  100
3  ed  15
5  lily  12
6  lingling  28
```
### 更新
```java
@Test
    public void textUpdate(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            int result=statement.executeUpdate("update info SET age=40 WHERE name='ed'");
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
            textQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }
    result:
    success
1  ann  100
3  ed  40
5  lily  12
6  lingling  28
```

### 使用Excuete执行查询
使用excute执行查询与用excuteQuery执行查询略有不同，excute查询返回的是一个布尔类型的值。
```java
@Test
    public void textExcute(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            String sql="select * from info";
            // 执行sql语句，返回boolean判断是否包含ResultSet
            boolean hasResultSet=statement.execute(sql);
            if(hasResultSet){
                //获取结果集
                resultSet=statement.getResultSet();
                // ResultSetMetaData是用于分析结果集的元数据接口
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                //获取该DDL语句影响的表中数据的行数
                int count=resultSetMetaData.getColumnCount();
                while(resultSet.next()){
                    //输出需要的列的数据
                    String id=resultSet.getString(1);
                    String name=resultSet.getString(2);
                    System.out.println(id+"   "+name);
                }
                System.out.println(count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }
    
    结果
1   ann
3   ed
5   lily
6   lingling
3
```

### 源文件
```java
package jdbc1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class textDemo {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;

    @Test
    public void textQuery(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM info");
            while (resultSet.next()){
                String id=resultSet.getString(1);
                String name=resultSet.getString(2);
                String age=resultSet.getString(3);
                System.out.println(id+"  "+name+"  "+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }

    @Test
    public void textInsert(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            int result=statement.executeUpdate("insert into info values(6,'lingling',28)");
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
            textQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }

    @Test
    public void textDelete(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            int result=statement.executeUpdate("delete from info WHERE name='zhangsan'");
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
            textQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }

    @Test
    public void textUpdate(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            int result=statement.executeUpdate("update info SET age=40 WHERE name='ed'");
            if(result>0){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
            textQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }
    
      @Test
    public void textExcute(){
        connection=jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            String sql="select * from info";
            boolean hasResultSet=statement.execute(sql);
            if(hasResultSet){
                resultSet=statement.getResultSet();
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                int count=resultSetMetaData.getColumnCount();
                while(resultSet.next()){
                    String id=resultSet.getString(1);
                    String name=resultSet.getString(2);
                    System.out.println(id+"   "+name);
                }
                System.out.println(count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(connection,statement,resultSet);
        }
    }

}

```
