/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;

/**
 *
 * @author Acer
 */
public class ProductDao {
    public static void save(Product product){
        String query = "insert into product (name,category,price) values ('"+product.getName()+"','"+product.getCategory()+"','"+product.getPrice()+"')";
        DbOperations.setDataorDelete(query, "Product added sucessfully...");
    }
    
    public static ArrayList<Product> getAllRecords(){
        ArrayList<Product> list = new ArrayList<>();
        try{
             ResultSet rs = DbOperations.getdata("select *from product");
            while(rs.next()){
               Product product = new Product();
               product.setId(rs.getInt("id"));
               product.setName(rs.getString("name"));
               product.setCategory(rs.getString("category"));
               product.setPrice(rs.getString("price"));
               list.add(product);
            }
        } catch(Exception e){
             JOptionPane.showMessageDialog(null, e);
        }
        
        return list;
    }
    
    public static void update(Product product){
        String query = "update product set name='"+product.getName()+"',category='"+product.getCategory()+"',price='"+product.getPrice()+"' where id= '"+product.getId()+"'";
        DbOperations.setDataorDelete(query, "Data Updated Sucessfully...");
    }
    
    public static void delete(String id){
        String query = "delete from product where id = '"+id+"'";
        DbOperations.setDataorDelete(query, "Product Deleted Sucessfully...");
    }
    
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> arraylist = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getdata("select *from product where category='"+category+"'");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                arraylist.add(product);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
    }
    
    public static ArrayList<Product> filterProductByName(String name,String category){
        ArrayList<Product> arraylist = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getdata("select *from product where name like'%"+name+"%' and category = '"+category+"'");
            while(rs.next()){
                Product product = new Product();
                product.setName(rs.getString("name"));
                arraylist.add(product);
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arraylist;
    }
    
    public static Product getProductByName(String name){
        Product product = new Product();
        try{
            ResultSet rs = DbOperations.getdata("select *from product where name ='"+name+"'");
            while(rs.next()){
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
