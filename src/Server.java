/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amol
 */

import java.net.*;
import java.io.*;
import java.util.*;


public class Server {
    public static void main(String args[]) throws Exception{
		ServerSocket ss=new ServerSocket(1122);
		Socket s=ss.accept();
    }
}
