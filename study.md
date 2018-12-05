/**
     * MultipartBody：用来提交包涵文件的参数
     * 多文件上传
     */
    public void postFileOkhttp2(String path, HashMap<String, String> map, String img, List<String> imgPths, Callback callBack) {
        MultipartBody.Builder requestBody = new MultipartBody.Builder();
        if (map != null && !map.isEmpty()) {

            //上传参数
            for (String key : map.keySet()) {
                requestBody.addFormDataPart(key, map.get(key));
            }
            //遍历paths中所有图片绝对路径到builder，并约定key如“upload”作为后台接受多张图片的key
            if (imgPths != null) {
                for (String string : imgPths) {
                    File file = new File(string);
                    requestBody.addFormDataPart(img, file.getName(), RequestBody.create(MEDIA_TYPE_PNG, file));
                }
            }

            Request request = new Request.Builder()
                    .post(requestBody.build())
                    .url(path)
                    .build();
            Call call = client.newCall(request);
            call.enqueue(callBack);
        }else{
            //遍历paths中所有图片绝对路径到builder，并约定key如“upload”作为后台接受多张图片的key
            if (imgPths != null) {
                for (String string : imgPths) {
                    File file = new File(string);
                    requestBody.addFormDataPart(img, file.getName(), RequestBody.create(MEDIA_TYPE_PNG, file));
                }
            }

            Request request = new Request.Builder()
                    .post(requestBody.build())
                    .url(path)
                    .build();
            Call call = client.newCall(request);
            call.enqueue(callBack);
        }
   }
--------------------- 
作者：zkbilian 
来源：CSDN 
原文：https://blog.csdn.net/m0_37711172/article/details/79724560 
版权声明：本文为博主原创文章，转载请附上博文链接！