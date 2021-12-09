import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @title: pl1111w
 * @description: socket 发送文件 先启动服务端socketReceiveFile 后启动客户端socketSendFile
 * @author: Kris
 * @date 2021/12/9 15:30
 */
public class test {

    @Test
    public void socketReceiveFile() throws IOException {
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream outputStream = new FileOutputStream("5399 .jpg");
        byte[] data = new byte[1024];
        int len;
        while ((len = inputStream.read(data)) != -1) {
            outputStream.write(data, 0, len);
        }
        System.out.println("file has been received! ");
        outputStream.close();
        inputStream.close();
        serverSocket.close();
    }

    @Test
    public void socketSendFile() {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
            outputStream = socket.getOutputStream();
            inputStream = new FileInputStream("538.jpg");
            byte[] data = new byte[1024];
            int len;
            while ((len = inputStream.read(data)) != -1) {
                outputStream.write(data, 0, len);
            }
            socket.shutdownOutput();
            System.out.println("[file has been sent!] ");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
                if (outputStream != null) outputStream.close();
                if (inputStream != null) inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
