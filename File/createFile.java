```
import java.io.*;

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

        File file2 = new File("ann/DemoPracitce");
        if (!file2.exists()) {
            file2.mkdirs();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("ann.txt", true);
            int n = 0;
            //byte[] b=new byte[1024];
            fileOutputStream.write('z');
            fileOutputStream.write('y');
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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

```
