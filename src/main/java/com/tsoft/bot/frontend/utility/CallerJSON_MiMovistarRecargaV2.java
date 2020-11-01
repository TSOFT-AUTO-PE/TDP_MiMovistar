package com.tsoft.bot.frontend.utility;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CallerJSON_MiMovistarRecargaV2 {

    private static final String EXCEL_WEB = "excel/TDP_MiMovistar_Recarga_Web/MiMovistar_Recargas.xlsx";
    private static final String RECARGAS_WEB = "Recargas";
    private static final String num = "1";
    private static final String point = ".";
    private static final String s = num+point+num+point+num+point+num;



    public static void API_API_TEST_recargas(){
        try {

            String result = blockIP(s);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, RECARGAS_WEB);
    }

    public static void main(String[] args){
        try {
            String result = blockIP(s);
            System.out.println(result);
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    private static String blockIP(String ip) throws IOException {

        String result;

        HttpPost post = new HttpPost("https://api.us-east.apiconnect.ibmcloud.com/telefonica-del-peru-development/topen/webviews/v1/users/MSISDN-920959103/webviews/external_payment_gateway");

//        post.addHeader("Content-Type", "text/plain");
//        post.addHeader("Content-Length", "<calculated when request is sent>");
//        post.addHeader("Host", "<calculated when request is sent>");
//        post.addHeader("User-Agent", "PostmanRuntime/7.26.2");
//        post.addHeader("Accept ", "*/*");
//        post.addHeader("Accept-Encoding", "gzip, deflate, br");
//        post.addHeader("Connection", "keep-alive");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("X-IBM-Client-Id", "75f1ccf2-3b4d-47d3-8e23-bbb7960b9f6d");
        post.addHeader("X-IBM-Client-Secret", "V4lR5lM4pR1eJ2fG3fM8qF8mH5dD5uY5xR5cB4tH1pS0rA6lS2");
        post.addHeader("x-user-id", "5435");
        post.addHeader("x-client-id", "43543");
        post.addHeader("x-scope", "4535");
        post.addHeader("x-identifier-bound-scope", "435443");
        post.addHeader("x-consents", "4334");
        post.addHeader("x-purpose", "343345");
        post.addHeader("x-authorization-id", "43");
        post.addHeader("x-device-id", "23432");
        post.addHeader("x-activated-roles", "3242");
        post.addHeader("x-token-info", "453443");

        String block = "{\"target\":\"ip\",\"value\":\"" + ip + "\"}";

        StringBuilder entity = new StringBuilder();
        entity.append("{");
        entity.append("\"callback_url\": \"www.movistar.com.pe/recargas\",");
        entity.append("\"nonce\": \"4zg86i78-7060-4590-9f9-4d967f79bf143\",");
        entity.append("\"payload\": {\n" +
                "        \"application\":\t\"Portal\",\n" +
                "\t\t\"amount\":\t\"15.00\",\n" +
                "\t\t\"customerId\":\"57025851\",\n" +
                "\t\t\"accountId\":\"566058585\",\n" +
                "\t\t\"channelId\":\"02500000003\",\n" +
                "\t\t\"itemId\":\"920959901\",\n" +
                "\t\t\"itemType\":\"topUp\",\n" +
                "\t\t\"correlationId\":\"IdNuestro\",\n" +
                "\t\t\"antiFraud2\":\"920959901\",\n" +
                "\t\t\"displayedText\":\"920959901\"\n" +
                "\t}");
        entity.append("}");

        // send a JSON data
        post.setEntity(new StringEntity(entity.toString()));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            result = EntityUtils.toString(response.getEntity());
        }

        String url = result;
        String url1= url.substring(8, url.length() -2);
        String url3 = url1.concat("&aplicationid=c8493f89-41ed-42fc-a704-b8499240964c");
        ExcelReader.writeCellValue(EXCEL_WEB, RECARGAS_WEB, 1, 1, url3);
        return url3;

        
    }

}