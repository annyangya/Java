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

