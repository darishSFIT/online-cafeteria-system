/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class UserDao {
    public static void save(User user){
        String query = "insert into user(name,email,phoneno,city,password,cpassword,securityquestion,answer,status) values ('"+user.getName()+"','"+user.getEmail()+"','"+user.getPhoneno()+"','"+user.getCity()+"','"+user.getPassword()+"','"+user.getCpassword()+"','"+user.getSecurityQb()+"','"+user.getAnswer()+"','false')";
        DbOperations.setDataorDelete(query, "Register sucessfully! Wait for admin approval...");
    }
    
    public static User login(String email, String password){
        User user = null;
        try{
            ResultSet rs = DbOperations.getdata("select * from user where email='"+email+"' and password='"+password+"'");
            while(rs.next()){
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
    
    public static User getSecurityQs (String email){
         User user = null;
         try{
             ResultSet rs = DbOperations.getdata("select * from user where email='"+email+"'");
              while(rs.next()){
                user = new User();
                user.setSecurityQb(rs.getString("securityquestion"));
                user.setAnswer(rs.getString("answer"));
            }
         } catch (Exception e){
             JOptionPane.showMessageDialog(null, e);
         }
         return user;
    }
    
    public static void update(String email,String newpassword){
       String query = "update user set password = '"+newpassword+"', cpassword = '"+newpassword+"' where email= '"+email+"' ";   
       DbOperations.setDataorDelete(query, "Password change sucessfully..");
    }
    
    public static ArrayList<User> getAllRecords(String email){
        ArrayList<User> arraylist = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getdata("select *from user where email like'%"+email+"%'");
            while(rs.next()){
               User user = new User();
               user.setId(rs.getInt("id"));
               user.setName(rs.getString("name"));
               user.setEmail(rs.getString("email"));
               user.setPhoneno(rs.getString("phoneno"));
               user.setCity(rs.getString("city"));
               user.setSecurityQb(rs.getString("securityquestion"));
               user.setStatus(rs.getString("status"));
               arraylist.add(user);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
    }
    
    public static void changeStatus(String email, String status){
        String query = "update user set status = '"+status+"' where email ='"+email+"'";
        DbOperations.setDataorDelete(query, "Status updated sucessfully...");
    }
    
    public static void changepassword(String email, String oldpassword, String newpassword){
        try{
            ResultSet rs = DbOperations.getdata("select *from user where email='"+email+"' and password ='"+oldpassword+"'");
            if(rs.next()){
                update(email,newpassword);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer){
        try{
            ResultSet rs = DbOperations.getdata("select *from user where email='"+email+"' and password ='"+password+"'");
            if(rs.next()){
                updateQS(email,securityQuestion,answer);
            }
            else {
                JOptionPane.showMessageDialog(null, "Password is wrong");
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public static void updateQS(String email, String securityQuestion, String answer){
        String query = "update user set securityquestion='"+securityQuestion+"',answer='"+answer+"' where email= '"+email+"'";
        DbOperations.setDataorDelete(query, "Security Question Changed sucessfully..");
    }
}
