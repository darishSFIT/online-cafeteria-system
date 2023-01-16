/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;


/**
 *
 * @author Acer
 */
public class table {
    public static void main(String args[]){
        try{
//         String userTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),phoneno varchar(10),city varchar(20),password varchar(200), cpassword varchar(200), securityquestion varchar(200),answer varchar(200),status varchar(200),UNIQUE (email))";
//           String admin = "insert into user(name,email,phoneno,city,password,cpassword,securityquestion,answer,status) values('Admin','canteen@sfit.in','9876543210','Borivali','admin@123','admin@123','What is your favourite food?','hotdog','true')";
//         DbOperations.setDataorDelete(userTable, "user table is created..");
//           DbOperations.setDataorDelete(admin, "Admin details added sucesfully..");
//           String categoryTable = "create table category(id int AUTO_INCREMENT primary key, name varchar(200))";
//           DbOperations.setDataorDelete(categoryTable, "Category table created sucessfully....");
//           String productTable = "create table product (id int AUTO_INCREMENT primary key, name varchar(200), category varchar(200),price varchar(200))";
//           DbOperations.setDataorDelete(productTable, "Product table is created...");
             String bilTable = "create table bill (id int primary key, name varchar(200),phoneno varchar(200),email varchar(200),date varchar(200),total varchar(200),createdby varchar(200))";
             DbOperations.setDataorDelete(bilTable, "bil Table created successfully..");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
}
