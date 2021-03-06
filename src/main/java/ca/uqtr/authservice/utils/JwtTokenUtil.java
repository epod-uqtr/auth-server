package ca.uqtr.authservice.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class JwtTokenUtil implements Serializable {

    public static String getUsername(String token){
        String[] split_string = token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];

        //System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
        org.apache.tomcat.util.codec.binary.Base64 base64Url = new org.apache.tomcat.util.codec.binary.Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        //System.out.println("JWT Header : " + header);

        //System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        //System.out.println("JWT Body : "+body);
        JSONObject json = new JSONObject(body);
        return json.getString("user_name");
    }

    public static String getId(String token){
        String[] split_string = token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];

        //System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
        org.apache.tomcat.util.codec.binary.Base64 base64Url = new org.apache.tomcat.util.codec.binary.Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        //System.out.println("JWT Header : " + header);

        //System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        //System.out.println("JWT Body : "+body);
        JSONObject json = new JSONObject(body);
        return json.getString("id");
    }

    public static String getRole(String token){
        String[] split_string = token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];

        //System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
        org.apache.tomcat.util.codec.binary.Base64 base64Url = new org.apache.tomcat.util.codec.binary.Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        //System.out.println("JWT Header : " + header);

        //System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        //System.out.println("JWT Body : "+body);
        JSONObject json = new JSONObject(body);
        return json.getString("role");
    }

    public static String getInstitutionCode(String token){
        String[] split_string = token.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];

        //System.out.println("~~~~~~~~~ JWT Header ~~~~~~~");
        org.apache.tomcat.util.codec.binary.Base64 base64Url = new Base64(true);
        String header = new String(base64Url.decode(base64EncodedHeader));
        //System.out.println("JWT Header : " + header);

        //System.out.println("~~~~~~~~~ JWT Body ~~~~~~~");
        String body = new String(base64Url.decode(base64EncodedBody));
        //System.out.println("JWT Body : "+body);
        JSONObject json = new JSONObject(body);
        return json.getString("institution_code");
    }


}
