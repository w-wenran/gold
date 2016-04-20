package org.nio;

import java.net.InetSocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by wangwr on 2016/4/15.
 */
public class TCPEchoClientNonblocking {

    public static void main(String args[]) throws Exception {


        String server = "wwww.baidu.com";// ServernameorIPaddress

        byte[] argument = "Hello word".getBytes();
        int servPort = 80;
        SocketChannel clntChan = SocketChannel.open();
        clntChan.configureBlocking(false);
        if (!clntChan.connect(new InetSocketAddress(server, servPort))) {
            while (!clntChan.finishConnect()) {
                Thread.sleep(100);
                System.out.println(".");// Dosomethingelse
            }
        }
        ByteBuffer writeBuf = ByteBuffer.wrap(argument);
        ByteBuffer readBuf = ByteBuffer.allocate(argument.length);
        int totalBytesRcvd = 0;// Totalbytesreceivedsofar
        int bytesRcvd;// Bytesreceivedinlastread
        while (totalBytesRcvd < argument.length) {
            if (writeBuf.hasRemaining()) {
                clntChan.write(writeBuf);
            }
            if ((bytesRcvd = clntChan.read(readBuf)) == -1) {
                //throw new SocketException("Connection closed prematurely");
                break;
            }
            totalBytesRcvd += bytesRcvd;
            //System.out.print(".");// Dosomethingelse
        }
        System.out.println("Received:" + // converttoStringperdefaultcharset
                new String(readBuf.array(), 0, totalBytesRcvd));
        clntChan.close();
    }

}
