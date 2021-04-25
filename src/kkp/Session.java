/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kkp;

/**
 *
 * @author rezabdullah
 */
public class Session {
    public static String id;
    public static String username;
    public static String fullname;
    public static String email;
    public static String phone;
    public static String role;

    public static void setId(String id)
    {
        Session.id = id;
    }
    
    public static void setUsername(String username)
    {
        Session.username = username;
    }
    
    public static void setFullname(String fullname)
    {
        Session.fullname = fullname;
    }
    
    public static void setEmail(String email)
    {
        Session.email = email;
    }
    
    public static void setPhone(String phone)
    {
        Session.phone = phone;
    }
    public static void setRole(String role)
    {
        Session.role = role;
    }
}
