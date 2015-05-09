/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.ifunpas.psbk.supplierRelationManagement.model.Supplier;

/**
 *
 * @author saeful rizky
 */
public class SupplierDAO {

    public List<Supplier> getSupplier() {
        List<Supplier> suppliers = null;
        Connection connection = DBConnection.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Supplier\"");
            suppliers = new ArrayList<>();
            while (resultSet.next()) {
                Supplier supplier = new Supplier();
                supplier.setSupplierId(resultSet.getString("sp_id"));
                supplier.setSupplierName(resultSet.getString("sp_name"));
                supplier.setSupplierAddress(resultSet.getString("sp_address"));
                suppliers.add(supplier);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            DBConnection.close(connection);
        }
        return suppliers;
    }
}
