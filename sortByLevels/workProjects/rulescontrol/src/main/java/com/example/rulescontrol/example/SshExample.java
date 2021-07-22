package com.example.rulescontrol.example;

import com.jcraft.jsch.*;

import java.io.*;

public class SshExample {

public void ssh(){
    Session session = null;
    ChannelExec channelExec=null;
    InputStream in;
    InputStream err;
    BufferedReader reader;
    try {
        session = new JSch().getSession("user", "192.168.17.97", 22);
        session.setPassword("123123");
        session.setConfig("StrictHostKeyChecking", "no");
        try {
            session.connect();
            ProcessBuilder process=new ProcessBuilder("ls");
            channelExec = (ChannelExec) session.openChannel("sftp");
            reader=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("input command:");
            String command=reader.readLine();
            channelExec.setCommand(command);
            OutputStream out = channelExec.getOutputStream();
            in = channelExec.getInputStream();
            err = channelExec.getErrStream();
            channelExec.connect();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            BufferedReader errReader = new BufferedReader(new InputStreamReader(err));

            String str;
            while ((str = bufferedReader.readLine())!= null) {
                System.out.println(str);
//                    Thread.sleep(1000);
            }
            while ((str = errReader.readLine()) != null) {
                System.out.println(str);
                Thread.sleep(1000);
            }
            channelExec.disconnect();
            session.disconnect();
        } catch (JSchException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    } catch (JSchException e) {
        e.printStackTrace();
    }
}
    public static void main(String[] args) throws InterruptedException {
        SshExample sshExample=new SshExample();
        sshExample.ssh();
    }
}
