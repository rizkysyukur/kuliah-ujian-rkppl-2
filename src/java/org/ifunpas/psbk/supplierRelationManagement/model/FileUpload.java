/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.model;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "fileUpload")
public class FileUpload {

    private Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String upload() throws IOException {
//        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("images");
//        path = path.substring(0, path.indexOf("\\build"));
//        path = path + "\\web\\resources\\images\\";
//        try {
//            InputStream in = file.getInputStream();
//            byte[] data = new byte[in.available()];
//            in.read(data);
//            FileOutputStream out = new FileOutputStream(new File(path + "demo.jpg"));
//            out.write(data);
//            in.close();
//            out.close();
//        } catch (Exception e) {
//            System.err.println(e);
//        }
        file.write("C:\\Users\\saeful rizky\\Documents\\NetBeansProjects\\Ini Tugas PSBK\\web\\resources\\images" + getFilename(file));
        return "Success";
    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }

//    public static void main(String[] args) {
//        try {
//            ServletContext servletContext = (ServletContext) FacesContext
//                    .getCurrentInstance().getExternalContext().getContext();
//        } catch (Exception e) {
//            System.out.print("Kesalahan");
//        }
//
//    }
}
