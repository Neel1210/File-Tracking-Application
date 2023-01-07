/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Neel_Esh
 */
public class JarData implements Serializable
{

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String Email) {
        JarData.Email = Email;
    }

    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        JarData.file = file;
    }
    private static String Email;
    private static File file;
}
