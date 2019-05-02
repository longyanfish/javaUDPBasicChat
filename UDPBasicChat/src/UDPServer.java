import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * 
 * @author 基于UDP的一个服务端和一个客户端的基本通信
 *
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        //接受来自客户端的数据报
		byte[] b=new byte[2000];
		DatagramPacket packet=new DatagramPacket(b,b.length);
		DatagramSocket socket=new DatagramSocket(6666);
		socket.receive(packet);
		//并将接收来的信息打印到控制台
		String strings=new String(packet.getData());
		System.out.println(strings);
		
		//给客户端回复信息
		//返回他自己的端口和ip
		System.out.println("来自自己的端口号"+socket.getPort()+","+"ip地址:"+socket.getInetAddress());
		//返回发送过来机器的的ip地址和端口号
		System.out.println("客户端的ip:"+packet.getAddress()+","+"客户端的端口号:"+packet.getPort());
		byte[] msg=new byte[2000];
		msg="同志你的任务很艰巨啊!要坚持住不能倒下!".getBytes();
		packet=new DatagramPacket(msg,msg.length,packet.getAddress(),packet.getPort());
		socket.send(packet);
		if(socket!=null)
			socket.close();
	}

}
