import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


/**
 * 
 * @author ����UDP��һ������˺�һ���ͻ��˵Ļ���ͨ��
 *
 */
public class UDPServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        //�������Կͻ��˵����ݱ�
		byte[] b=new byte[2000];
		DatagramPacket packet=new DatagramPacket(b,b.length);
		DatagramSocket socket=new DatagramSocket(6666);
		socket.receive(packet);
		//��������������Ϣ��ӡ������̨
		String strings=new String(packet.getData());
		System.out.println(strings);
		
		//���ͻ��˻ظ���Ϣ
		//�������Լ��Ķ˿ں�ip
		System.out.println("�����Լ��Ķ˿ں�"+socket.getPort()+","+"ip��ַ:"+socket.getInetAddress());
		//���ط��͹��������ĵ�ip��ַ�Ͷ˿ں�
		System.out.println("�ͻ��˵�ip:"+packet.getAddress()+","+"�ͻ��˵Ķ˿ں�:"+packet.getPort());
		byte[] msg=new byte[2000];
		msg="ͬ־�������ܼ�ް�!Ҫ���ס���ܵ���!".getBytes();
		packet=new DatagramPacket(msg,msg.length,packet.getAddress(),packet.getPort());
		socket.send(packet);
		if(socket!=null)
			socket.close();
	}

}
