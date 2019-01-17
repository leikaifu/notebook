package parameter;

import java.io.InputStream;
import java.util.Map;

/**
 * IHttpHelper.java
 *
 * @Group: youxuepai.com
 * @Author: huangyunhui
 * @Date: 2018/5/23
 */
public interface IHttpHelper {

  IResponse executeRequest(RequestParam param);

  interface IResponse {

    int status();

    String message();

    boolean isSuccessful();

    long costTime();

    long contentLength();

    InputStream inputStream();

    String parseAsString();

    String header(String name);

  }
}

