/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kazanik.spaceinvaders.utils;

//import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
//import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;

/**
 *
 * @author user
 */
public class ObjectSerializer {
    
    /** Read the object from Base64 string. */
   public static Object fromString( String s ) throws IOException ,
                                                       ClassNotFoundException/*, 
                                                       Base64DecodingException*/ {
        byte [] data = Base64.getDecoder().decode( s );
//       byte [] data = Base64.decode( s );
        ObjectInputStream ois = new ObjectInputStream( 
            new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
   }

    /** Write the object to a Base64 string. */
    public static String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray()); 
//        return Base64.encode(baos.toByteArray()); 
    }
}
