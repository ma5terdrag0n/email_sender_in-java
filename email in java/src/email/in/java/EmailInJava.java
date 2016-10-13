/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email.in.java;

/**
 *
 * @author Pritish
 */
public class EmailInJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] to  = {"prince.thakkar001@gmail.com"};
        if(Emailsender.sendMail("prince.thakkar001@gmail.com", to, "pinchuuu", "hi this is an automatically generated email")){
            System.out.println("MESSAGE SENT !");
        }
        else System.out.println("NOT");
    }
    
}
