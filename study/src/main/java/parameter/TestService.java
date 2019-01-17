package parameter;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
public class TestService {
    OkHttpClient httpClient= new OkHttpClient();
    String str="/usr/local/src/project/data/homework.xls";
    MyRequest requestlist=new MyRequest(str);
    public void Logresponse(int y) throws IOException, InvalidFormatException {
        Reporter.log(String.valueOf(requestlist.request().get(y).url()));
    }
    @Test
    public void test0() throws IOException, InvalidFormatException {
        Response response=httpClient.newCall(requestlist.request().get(0)).execute();
        Logresponse(0);
        String res=response.body().string();
        Reporter.log("响应数据："+res);
        String str0= (String) requestlist.requestParamlist().get(0).getCheck_template();
        Reporter.log("模板数据"+str0);
        JsonChecker jsonChecker=new JsonChecker(res,str0);
        boolean boo=jsonChecker.checkKeyAndValue();
        System.out.println(boo);
        Assert.assertTrue(boo);

    }
    @Test
    public void test1() throws IOException, InvalidFormatException {
        Response response=httpClient.newCall(requestlist.request().get(1)).execute();
        Logresponse(1);
        String res=response.body().string();
        Reporter.log(res);
        String str1= (String) requestlist.requestParamlist().get(1).getCheck_template();
        Reporter.log("模板数据"+str1);
        JsonChecker jsonChecker=new JsonChecker(res,str1);
        boolean boo=jsonChecker.checkKeyAndValue();
        System.out.println(boo);
        Assert.assertTrue(boo);
    }
}


