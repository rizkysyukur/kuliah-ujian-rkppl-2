/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.model;

/**
 *
 * @author saeful rizky
 */
public class ValidasiLogin {

    private boolean isLoginSuccess;
    private String category;

    public boolean isIsLoginSuccess() {
        return isLoginSuccess;
    }

    public void setIsLoginSuccess(boolean isLoginSuccess) {
        this.isLoginSuccess = isLoginSuccess;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
