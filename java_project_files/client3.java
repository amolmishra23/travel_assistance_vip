import java.io.*;
import java.net.*;
import java.util.*;

class client3{
	public static void main(String args[]) throws Exception{
		Socket s=new Socket("localhost",3333);
		DataInputStream din=new DataInputStream(s.getInputStream());
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());
		Scanner sc=new Scanner(System.in);
		String str="",str2="";
		while(!str.equals("stop")){
			str=sc.nextLine();
			dout.writeUTF(str);
			str2=din.readUTF();
			System.out.println("Server says: "+str2);
		}
		dout.close();
		din.close();
		s.close();
	}
}