/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.ifunpas.psbk.supplierRelationManagement.database.ProductDAO;
import org.ifunpas.psbk.supplierRelationManagement.model.Product;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "productController")
@ViewScoped
public class ProductController implements Serializable {

    private List<Product> products;
    private Product product;

    @ManagedProperty("#{productDAO}")
    private ProductDAO productDAO;

//    @PostConstruct
//    public void initProduct() {
//        products = productDAO.getProduct();
//    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

//    public void insert(Product product) {
//        productDAO.insertProduct(product.getProductId(), product.getProductName(), product.getProductPrice(), product.getSupplierId());
//    }
//
//    public void delete(String productId) {
//        productDAO.deleteProduct(productId);
//    }

//    public void update(Product product) {
//        productDAO.updateProduct(product.getProductId(), product.getProductName(), product.getProductPrice(), product.getSupplierId());
//    }

    public String upload(Product product) {
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("images");
        path = path.substring(0, path.indexOf("\\build"));
        path = path + "\\web\\resources\\images\\";
        try {
            InputStream in = product.getImage().getInputStream();
            byte[] data = new byte[in.available()];
            in.read(data);
            FileOutputStream out = new FileOutputStream(new File(path + "demo.jpg"));
            out.write(data);
            in.close();
            out.close();
        } catch (Exception e) {
            System.err.println(e);
        }

        return "Success";
    }
}
