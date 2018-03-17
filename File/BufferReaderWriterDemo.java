import java.io.*;

/*
用字节流读取文本信息模拟从网上读取信息
也可以用FileReader,FileWriter读取信息
用FileReader代替FileInputStream,InputStreanReader;FileWriter代替OutputStreamWriter,OutputStreamSwriter
 */
public class BufferReaderWriterDemo {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream=new FileInputStream("ann.txt");
            InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            FileOutputStream fileOutputStream=new FileOutputStream("1ann.txt");
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

            int n=0;
            char[] c=new char[10];
            while((n=bufferedReader.read(c))!=-1)
            {
                bufferedWriter.write(c,0,n);
            }

            bufferedWriter.flush();
            bufferedReader.close();
            fileInputStream.close();
            fileOutputStream.close();
            inputStreamReader.close();
            outputStreamWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            FileReader fileReader=new FileReader("ann.txt");
            BufferedReader bufferedReader=new BufferedReader(fileReader);

            FileWriter fileWriter=new FileWriter("2ann.txt");
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);

            int n=0;
            char[] chars=new char[10];
            while((n=bufferedReader.read(chars))!=-1)
            {
                bufferedWriter.write(chars);
            }

            bufferedWriter.flush();
            bufferedWriter.close();
            bufferedReader.close();
            fileReader.close();
            fileWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
