import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * @author һ���ͻ��˷���Ϣ��һ���������ˣ����������յ���Ϣ�Ժ�ظ�һ����Ϣ���ͻ���
 *
 */
public class UDPClient {
    public static void main(String[] args) throws IOException {
		//�ͻ��˷�����Ϣ����������
    	String s="�ͻ���˵:�����������ݳɹǸ�����!��";
    	byte[] msg=new byte[1024];
    	msg=s.getBytes();
    	InetAddress inetAddress=InetAddress.getByName("192.168.0.104");
    	//����һ�����ݱ�����һ�����ݣ��ڶ������ݵĳ��ȣ�������ip��ַ�����ĸ�ͨ�Ŷ˿ں�
    	DatagramPacket  datagramPacket=new DatagramPacket(msg, msg.length, inetAddress, 6666);
    	//�������ݱ��׽��ֲ�����󶨵������������κο��õĶ˿�
    	DatagramSocket dataSocket=new DatagramSocket();
    	//�������ݸ�������
    	dataSocket.send(datagramPacket);
    	
    	//�ͻ��˽��շ�����������Ϣ�Ļ�Ӧ
    	byte receiveMsg[]=new byte[1024];
    	datagramPacket=new DatagramPacket(receiveMsg,receiveMsg.length);
    	//������Ϣ�ŵ�datagramPacket����
    	//�Ӵ��׽��ֽ������ݱ��������˷�������ʱ��DatagramPacket �Ļ���������˽��յ����ݡ����ݱ���Ҳ�������ͷ��� IP ��ַ�ͷ��ͷ������ϵĶ˿ںš� 
    	//�˷����ڽ��յ����ݱ�ǰһֱ���������ݱ�������� length �ֶΰ�����������Ϣ�ĳ��ȡ������Ϣ�Ȱ��ĳ��ȳ�������Ϣ�����ض̡�

    	dataSocket.receive(datagramPacket);
    	//�����յ�����Ϣ��ӡ����
    	String str= new String(datagramPacket.getData());
    	System.out.println(str);
    	if(dataSocket!=null)
    		dataSocket.close();
	}
}
