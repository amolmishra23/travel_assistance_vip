import java.io.*;
import java.net.*;
import java.net.Socket;
import java.util.*;
import java.awt.Toolkit;

public class User {
    public DataOutputStream dout;
    public DataInputStream din;
    public String bus_ip[]=new String[4];
    FIRST f1=new FIRST();
    public void connect_bus_stop(String a[],String b[]) throws Exception{
        int i=0;
        Socket s;
        for(i=0;i<a.length;i++){
            try{
                s = TimedSocket.getSocket(a[i], 3333, 4000);
            }
            catch(Exception e){
                if(i==(a.length-1)){
                    i=0;
                }
                continue;
            }
            if(s.isConnected()){
                System.out.println(a[i]);
                textToSpeech obj=new textToSpeech(); obj.dospeak("You are at "+b[i],"kevin16");
                System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                dout=new DataOutputStream(s.getOutputStream());
                din=new DataInputStream(s.getInputStream());
                f1.setVisible(true);
                while(f1.isVisible()){
                   Thread.sleep(1000);
                }
                dout.writeUTF(f1.myValue());
                int ipVar=0;
                String temp;
                while(true){
                    temp=din.readUTF();
                    if(temp.equals("bye")){
                        break;
                    }
                    bus_ip[ipVar]=temp;
                    ipVar++;
                    dout.writeUTF("OK");
                }
                break;
            }
             s.close();  
        }
        for(int z=0;z<bus_ip.length;z++){
                 System.out.println(bus_ip[z]);
             }
        System.out.println(Integer.parseInt(f1.myValue()));
        new User().connect_bus(bus_ip,Integer.parseInt(f1.myValue()));
       
    }
    public void connect_bus(String a[],int x) throws Exception{
        int i=0;
        for(i=0;i<a.length;i++){
            Socket s;
            try{
                
                s = TimedSocket.getSocket(a[i],x, 4000);
            }
            catch(Exception e){
                if(i==(a.length-1)){
                    i=0;
                }
                continue;
            }
            if(s.isConnected()){
                System.out.println(a[i]);
                Toolkit tk = Toolkit.getDefaultToolkit();
                int beep_count=0;
                while(beep_count<=10){
                    tk.beep();
                    beep_count++;
                }   
                break;
            }
        }
    }
    public void connect_bus_stop_name(String a[],String b[]) throws Exception{
        int i=0;
        Socket s;
        for(i=0;i<a.length;i++){
            try{
                s = TimedSocket.getSocket(a[i], 3344, 4000);
            }
            catch(Exception e){
                if(i==(a.length-1)){
                    i=0;
                }
                continue;
            }
            if(s.isConnected()){
                System.out.println(a[i]);
                textToSpeech1 obj=new textToSpeech1(); obj.dospeak("You are at "+b[i],"kevin16");
                System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
            }
        }
    }
    public static void main(String args[]) throws Exception{
        String bus_stop[]={"1.2.3.4","2.3.4.5","192.168.43.203","127.0.0.1"};
        String bus_stop_names[]={"Vellore","Katpadi","Chitoor","Tirupati"};
        //int i=0;
        new User().connect_bus_stop(bus_stop,bus_stop_names);
        while(true){
            new User().connect_bus_stop_name(bus_stop,bus_stop_names);
        }        
    }
}
