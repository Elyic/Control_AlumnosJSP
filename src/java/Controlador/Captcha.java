/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONObject;
/**
 *
 * @author 
 */
public class Captcha {
    public static boolean isCaptchaValid(String secretKey, String response) {
    try {
        String url = "https://www.google.com/recaptcha/api/siteverify?"
                + "secret=" + secretKey
                + "&response=" + response;
        InputStream res = new URL(url).openStream();
        BufferedReader rd = new BufferedReader(new InputStreamReader(res, Charset.forName("UTF-8")));

        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        String jsonText = sb.toString();
        res.close();

        JSONObject json = new JSONObject(jsonText);
        return json.getBoolean("success");
    } catch (Exception e) {
        return false;
    }
}
}
