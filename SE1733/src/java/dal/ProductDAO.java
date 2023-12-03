/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends DBContext {

    //get all
    public List<Product> getProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT [id]\n"
                + "      ,[name]\n"
                + "      ,[quantity]\n"
                + "      ,[price]\n"
                + "      ,[releaseDate]\n"
                + "      ,[describe]\n"
                + "      ,[image]\n"
                + "      ,[cid]\n"
                + "  FROM [dbo].[Products]";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
            while(rs.next()){
                Product p=new Product();
                p.setId(rs.getString("id"));
                p.setName(rs.getString("name"));
                p.setQuantity(rs.getInt("quantity"));
                p.setPrice(rs.getDouble("price"));
                p.setDescribe("describe");
                p.setReleaseDate(rs.getString("releaseDate"));
                p.setImage(rs.getString("image"));
                p.setCid(rs.getInt("cid"));
                list.add(p);
            }
        } catch (SQLException e) {
        }
        return list;

    }
}
