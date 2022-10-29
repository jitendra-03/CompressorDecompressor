/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author Rajendra Naidu
 */
public class Decompress {
      public static void method(File file) throws Exception{
        String filed=file.getParent();
        System.out.println(filed);
        FileInputStream fis=new FileInputStream(file);
        FileOutputStream fos=new FileOutputStream(filed+"/decompress.txt");
          GZIPInputStream gzip=new GZIPInputStream(fis);
          byte[] buffer=new byte[1024];
        int len;
        while((len=gzip.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        gzip.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String[] args) throws Exception{
        File path=new File("C:\\Users\\91630\\OneDrive\\Documents\\test\\compressedfile.gz");
        method(path);
    }
}
