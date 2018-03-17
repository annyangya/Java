import java.io.*;
/*
对象流，ObjectInputStream,ObjectOutputStream
对象序列化：将java对象转换成字节序列的过程
对象序列化：
    1）创建一个类，继承Serializable
    2) 创建对象
    3）将对象写入文件
    4）从文件中读取对象信息

使用对象流写入或读入对象时，要保证对象是序列化的
 */
public class StudentObjectText {

    public static void main(String[] args) {
        StudentInfo stu1=new StudentInfo("ann","计算机",18,100);
        try {
            FileOutputStream fileOutputStream=new FileOutputStream("stu.txt");
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stu1);
            objectOutputStream.writeBoolean(false);


            FileInputStream fileInputStream=new FileInputStream("stu.txt");
            ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
            StudentInfo stuRead= (StudentInfo) objectInputStream.readObject();
            System.out.print(stuRead);//toString()方法           （1）
            System.out.print(objectInputStream.readBoolean());   （2）
            /*
            打印文本内容时，要注意写入的先后顺序，先写入为对象信息，后写入布尔值信息
            所以读取的时候要先读对象信息，后读取布尔信息
            即（1）（2）语句先后顺序不能改变
            否则报错，java.io.EOFException
            */

            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
            fileInputStream.close();
            objectInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
