import java.io.*;

//文件的生成
public class filecreateDemo {
    public static void main(String[] args) {
        File file1 = new File("ann.txt");
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//目录的创建，多级目录mkdirs(),单极目录 mkdir()
        File file2 = new File("ann/DemoPracitce");
        if (!file2.exists()) {
            file2.mkdirs();
        }
//输入输出流，注意最后用close()方法
        try {
            /*
              FileOutputStream fileOutputStream = new FileOutputStream("ann.txt", true);直接在文本末尾添加内容
              
              FileOutputStream fileOutputStream = new FileOutputStream("ann.txt");新添加的内容会覆盖原内容
            */
            FileOutputStream fileOutputStream = new FileOutputStream("ann.txt", true);
            int n = 0;
            fileOutputStream.write('z');
            fileOutputStream.write('y');
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//通过字节输入流输出文档内容
        try {
            FileInputStream fileInputStream = new FileInputStream("ann.txt");
            int n = 0;
            while ((n = fileInputStream.read()) != -1) {
                System.out.print((char) n);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//通过byte数组输出文本内容
        try {
            FileInputStream fileInputStream2=new FileInputStream("ann.txt");
            byte[] b=new byte[1024];
            fileInputStream2.read(b,0,6);
            System.out.print(new String(b));
            fileInputStream2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}

