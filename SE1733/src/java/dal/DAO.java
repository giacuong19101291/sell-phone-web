/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

/**
 *
 * @author ADMIN
 */
public class DAO extends DBContext{
    //check
    public Admin checkAccount(String username,String password){
        String sql="select * from admin where username=? and password=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs=st.executeQuery();
            if(rs.next()){
                return new Admin(username, password, rs.getInt("role"));
            }
        }catch(SQLException e){
            
        }
        
        return null;
    }
}
