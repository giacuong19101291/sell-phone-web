/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class CategoryDAO extends DBContext {

    //doc toan bo bang ra
    public List<Category> getAll() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[describe]\n"
                + "  FROM [dbo].[Categories]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescribe(rs.getString("describe"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    //xoa 1 ban ghi theo id
    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[Categories]\n"
                + "      WHERE id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {

        }

    }

    //check id da ton tai chua?
    public Category getCategoryById(int id) {
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[describe]\n"
                + "  FROM [dbo].[Categories] where id=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            //set ?
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            //1
            if (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setDescribe(rs.getString("describe"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    //insert into
    public void insert(Category c) {
        String sql = "INSERT INTO [dbo].[Categories]\n"
                + "           ([id]\n"
                + "           ,[name]\n"
                + "           ,[describe])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, c.getId());
            st.setString(2, c.getName());
            st.setString(3, c.getDescribe());
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    //update
    public void update(Category c) {
        String sql = "UPDATE [dbo].[Categories]\n"
                + "   SET [name] = ?\n"
                + "      ,[describe] = ?\n"
                + " WHERE id=?";
        try{
            PreparedStatement st=connection.prepareStatement(sql);
            st.setString(1, c.getName());
            st.setString(2, c.getDescribe());
            st.setInt(3, c.getId());
            st.executeUpdate();
        }catch(SQLException e){
            
        }
    }

    //testing connection
    public static void main(String[] args) {
        CategoryDAO c = new CategoryDAO();
        List<Category> list = c.getAll();
        System.out.println(list.get(0).getName());
    }
}
