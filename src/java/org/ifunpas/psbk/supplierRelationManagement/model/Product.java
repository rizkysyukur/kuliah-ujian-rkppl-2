/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.Part;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "product")
@ApplicationScoped
public class Product {

    private String productId;
    private String productName;
    private String productCategory;
    private int productPrice;
    private String productDescription;
    private Part image;
    private String pathImage = "C:\\Users\\saeful rizky\\Documents\\NetBeansProjects\\Ini Tugas PSBK\\web\\resources\\images\\default.png";

    public Product(String productId, String productName, String productCategory, int productPrice, String productDescription, Part image) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.image = image;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = "C:\\Users\\saeful rizky\\Documents\\NetBeansProjects\\Ini Tugas PSBK\\web\\resources\\images\\" + pathImage;
    }

}
