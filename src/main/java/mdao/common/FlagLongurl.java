package mdao.common;


import java.net.URL;
import java.net.URLConnection;

public class FlagLongurl {
    public static boolean flagLong(String longUrl)  {
        long start = System.currentTimeMillis();
        if (longUrl.substring(0, 8).equals("https://")) {
            long end = System.currentTimeMillis();
            System.out.println("判断短链接用时:" + (end - start));
            return true;
        } else if (longUrl.substring(0, 7).equals("http://")) {
            long end = System.currentTimeMillis();
            System.out.println("判断短链接用时:"+(end-start));
            return true;
        }
        long end = System.currentTimeMillis();
        System.out.println("判断短链接用时:"+(end-start));
        return false;

    }
    public static void main(String[] args)  {
        boolean flag= flagLong("http:/qmsg.mdao.com:8343/auth/login");
        System.out.println(flag);
    }

}
