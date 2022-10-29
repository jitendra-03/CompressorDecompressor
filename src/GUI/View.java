/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import Project.Compress;
import Project.Decompress;
import java.io.*;
import java.util.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Rajendra Naidu
 */
public class View extends JFrame implements ActionListener {
    JButton compressButton;
    JButton deCompressButton;
    View(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   this.setLayout(null);
   this.setSize(500, 200);
    
    compressButton =new JButton("selecta a file to compress");
    compressButton.addActionListener(this);
    compressButton.setBounds(20, 100, 200, 30);
    
    deCompressButton =new JButton("selecta a file to decompress");
    deCompressButton.addActionListener(this);
    deCompressButton.setBounds(250, 100, 200, 30);
    
    this.add(compressButton);
    this.add(deCompressButton);
    this.getContentPane().setBackground(Color.black);
    
}
    @Override
    public void actionPerformed(ActionEvent e){
     if(e.getSource()==compressButton){
         JFileChooser chooseFile=new JFileChooser();
         int response=chooseFile.showSaveDialog(null);
         if(response==JFileChooser.APPROVE_OPTION){
             File file=new File(chooseFile.getSelectedFile().getAbsolutePath());
             try{
                 Compress.method(file);
                 JOptionPane.showMessageDialog(rootPane, "successfully compressed");
             }
             catch(Exception ev){
                 JOptionPane.showMessageDialog(rootPane, ev.toString());
             }
         }
     }   
    if(e.getSource()==deCompressButton){
         JFileChooser chooseFile=new JFileChooser();
         int response=chooseFile.showSaveDialog(null);
         if(response==JFileChooser.APPROVE_OPTION){
             File file=new File(chooseFile.getSelectedFile().getAbsolutePath());
              try{
                 Decompress.method(file);
                 JOptionPane.showMessageDialog(rootPane, "successfully decompressed");
             }
             catch(Exception ev){
                 JOptionPane.showMessageDialog(rootPane, ev.toString());
             }
         }
     }   
    }
    
    public static void main(String[] args){
        View frame=new View();
        frame.setVisible(true);
    }
}
