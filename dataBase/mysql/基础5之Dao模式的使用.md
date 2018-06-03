#### Dao模式
Data Access Object,数据访问对象。
DAO模式是标准的J2EE设计模式之一.开发人员使用这个模式把底层的数据访问操作和上层的商务逻辑分开.一个典型的DAO实现有下列几个组件：
1. 一个DAO工厂类；
2. 一个DAO接口；
3. 一个实现DAO接口的具体类；
4. 数据传递对象（有些时候叫做值对象）.
5. 一般的DAO的封装由以下另个原则：
(1). 一个表对应一个表，相应地封装一个DAO类。
(2). 对于DAO接口，必须由具体的类型定义。这样可以避免被错误地调用。


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
