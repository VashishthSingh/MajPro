package com.status.muni;  
import com.email.durgesh.Email;
public class SendEmail{  
     public static void main(String [] args){   
        try{  
            Email email=new Email("singhshikharmuni@gmail.com","singhmuni27");
            email.setFrom("singhshikharmuni@gmail.com","Muni");
            email.setSubject("Testing email..");
            email.setContent("<h1>Hello just download Tomcat.</h1>","text/html");
            email.addRecipient("singhshikharmuni@gmail.com");
            email.send();
        }catch (Exception e){
        	e.printStackTrace();
        }  
     }  
}  