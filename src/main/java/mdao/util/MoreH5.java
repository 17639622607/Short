package mdao.util;

import mdao.client.H5Client;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class MoreH5 {
    public static List<Boolean> moreH5(List<String> list,int sleep) throws URISyntaxException {
        H5Client h5Client=new H5Client();
        List<Boolean> lstFlag=new ArrayList<>();
        int n = list.size();
        String url[]=new String[n];
        list.toArray(url);

        for(int i=0;i<n;i++){
            boolean flag=h5Client.long_to_short(url[i]);
            lstFlag.add(flag);
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return  lstFlag;
    }

    public static void main(String[] args) throws URISyntaxException {
        List<String> list=GetExcle.getExcle("D:\\a.xlsx");
        MoreH5 moreH5=new MoreH5();
        moreH5.moreH5(list,100);
    }
}
