### 注意
1. statement存在安全问题，我们以登录数据库操作为例。info数据库中存有id，name，age，
现在我们输入相应的id和那么，如果有与数据库中id和name匹配的，就可以访问该表中的全部数据。
2. 我们在dao中添加login方法,并且在相应的实现类中实现这个方法
```java
void login(String id,String name);
```
3. 实现类的方法
```java
 @Override
    public void login(String id, String name) {
        connection=jdbc2.jdbcUtils.getconn();
        try {
            statement=connection.createStatement();
            //+是连接符号，单引号里面的内容为id，name，但是不能直接放在单引号里面，否则就变成条件为id=id，name=name
            String sql="SELECT * FROM info WHERE id='"+id+"'and name='"+name+"'";
            resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
              String id1=resultSet.getString(1);
              String name1=resultSet.getString(2);
              System.out.println("登录成功："+id+"-"+name);
            }else {
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbc2.jdbcUtils.close(connection,statement,resultSet);
        }
    }
```
4. 测试类
```java
@Test
    public void textLogin(){
        infoDao infoDao=new infoImpl();
        infoDao.login("3","ann");
        infoDao.login("1","ann");
    }
    
    结果：
    登录失败
    登录成功：1-ann
```
接下来我们更改一下sql语句
```java
String sql="SELECT * FROM info WHERE id='"+id+"'and name='"+name+"'OR 1=1";
```
再次执行，结果为：
```java
登录成功：3-ann
登录成功：1-ann
```
可以看到，即使id和name不匹配，也可以成功登录。这是因为添加的语句or 1=1，这句话永为真，即使前面的不匹配后面为真也可以登录。
