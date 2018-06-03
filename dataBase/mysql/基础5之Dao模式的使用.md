#### Dao模式
Data Access Object,数据访问对象

#### 步骤
1.新建一个dao接口，里面声明数据库访问规则
```java
package Dao;
/*
定义操作数据库的方法
 */
public interface infoDao {
    //info表中对应的增删查改方法
    void query();
}
```
2.新建一个dao的实现类，具体实现先前定义的规则
```java
package Impl;

import Dao.infoDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class infoImpl implements infoDao {
    Connection connection=null;
    Statement statement=null;
    ResultSet resultSet=null;
    @Override
    public void query() {
        //1。获取连接对象
        connection=jdbc2.jdbcUtils.getconn();
        //2.创建statement对象
        try {
            statement=connection.createStatement();
            //3.
            String sql="SELECT * FROM info";
            resultSet=statement.executeQuery(sql);
            while(resultSet.next()){
                String id=resultSet.getString(1);
                String name=resultSet.getString(2);
                System.out.println(id+"   "+name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,statement,resultSet);
        }

    }
}
```
3.直接使用实现类
```java
package Text;

import Dao.infoDao;
import Impl.infoImpl;
import org.junit.Test;

public class TextDaoinfoImpl {

    @Test
    public void query(){
        infoDao dao=new infoImpl();
        dao.query();
    }
}
结果：
1   ann
3   ed
5   lily
6   lingling
```
