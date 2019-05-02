import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @author 一个客户端发信息给一个服务器端，服务器端收到信息以后回复一条信息给客户端
 *
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
		//客户端发送消息给服务器端
    	String s="客户端说:“我想立刻瘦成骨感美人!”";
    	byte[] msg=new byte[1024];
    	msg=s.getBytes();
    	InetAddress inetAddress=InetAddress.getByName("192.168.0.104");
    	//构造一个数据报，第一个数据，第二个数据的长度，第三个ip地址，第四个通信端口号
    	DatagramPacket  datagramPacket=new DatagramPacket(msg, msg.length, inetAddress, 6666);
    	//构造数据报套接字并将其绑定到本地主机上任何可用的端口
    	DatagramSocket dataSocket=new DatagramSocket();
    	//发送数据给服务器
    	dataSocket.send(datagramPacket);
    	
    	//客户端接收服务端怼他的消息的回应
    	byte receiveMsg[]=new byte[1024];
    	datagramPacket=new DatagramPacket(receiveMsg,receiveMsg.length);
    	//接收信息放到datagramPacket里面
    	//从此套接字接收数据报包。当此方法返回时，DatagramPacket 的缓冲区填充了接收的数据。数据报包也包含发送方的 IP 地址和发送方机器上的端口号。 
    	//此方法在接收到数据报前一直阻塞。数据报包对象的 length 字段包含所接收信息的长度。如果信息比包的长度长，该信息将被截短。

    	dataSocket.receive(datagramPacket);
    	//将接收到的信息打印出来
    	String str= new String(datagramPacket.getData());
    	System.out.println(str);
    	if(dataSocket!=null)
    		dataSocket.close();
	}
}
