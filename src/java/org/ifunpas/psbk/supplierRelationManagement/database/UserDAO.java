/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.ifunpas.psbk.supplierRelationManagement.model.ValidasiLogin;

/**
 *
 * @author saefulrizky
 */
public class UserDAO {

    public static ValidasiLogin login(String user, String password) {
        ValidasiLogin vl = null;
        Connection connection = null;
        try {
            connection = DBConnection.connect();

            PreparedStatement ps = connection.prepareStatement("select \"user\" , pass, category from infouser where \"user\" =? and pass=? ");
            ps.setString(1, user);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                vl = new ValidasiLogin();
                vl.setIsLoginSuccess(true);
                vl.setCategory(rs.getString("category"));
            }
        } catch (SQLException e) {
            System.err.println(e);
            return vl;
        } finally {
            DBConnection.close(connection);
        }
        return vl;
    }
    
    public static void main(String[] args) {
        UserDAO aO = new UserDAO();
        ValidasiLogin vl = aO.login("", "");
    }
}
