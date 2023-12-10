/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

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


    public boolean registerAccount(Admin admin) {
        String sql = "INSERT INTO admin (username, password, role) VALUES (?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, admin.getUsername());
            st.setString(2, admin.getPassword());
            st.setInt(3, admin.getRole());

            // Thực hiện câu lệnh SQL để thêm dữ liệu
            int rowsAffected = st.executeUpdate();

            // Kiểm tra xem có dòng dữ liệu nào bị ảnh hưởng hay không
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
