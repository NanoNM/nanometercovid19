package covid.nanometer.top;

import com.alibaba.fastjson.JSONObject;
import covid.nanometer.top.dao.COVID19TENGXUNDAO;
import covid.nanometer.top.services.JSONDateParsingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class Nanometercovid19ApplicationTests {
//    @Value("${covid19_date_source}")
//    String covid19DateUrl;
    @Autowired
    JSONDateParsingService jsonDateParsingService;

    @Autowired
    COVID19TENGXUNDAO covid19TENGXUNDAO;

    @Test
    void testTengXun() throws IOException {

//        JSONObject txcovidOBJ = JSONObject.parseObject();
        jsonDateParsingService.analysisOfDayCityData(jsonDateParsingService.getCovid19DateUrl());
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url("https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5")
//                .method("GET", null)
//                .build();
//        Response response = client.newCall(request).execute();
//        JSONObject tengXunChina = JSON.parseObject(String.valueOf(JSON.parseObject(Objects.requireNonNull(response.body()).string())));
//        JSONArray areaTree = tengXunChina.getJSONArray("areaTree");
    }

    @Test
    void temptest(){
//        System.out.println(cvsDataGetService.getCovid19DateUrl());
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//        SimpleDateFormat formatterM= new SimpleDateFormat("MM");
//        SimpleDateFormat formatterD= new SimpleDateFormat("dd");
//        SimpleDateFormat formatterY= new SimpleDateFormat("yyyy");
//        Date date = new Date(System.currentTimeMillis());
//        String dateString = formatterM.format(date)+"-"+formatterD.format(date)+"-"+formatterY.format(date);
//
//        covid19DateUrl = covid19DateUrl + dateString + ".csv";
//        System.out.println(covid19DateUrl);
    }

    @Test
    void contextLoads() throws IOException {
//        OkHttpClient client = new OkHttpClient().newBuilder()
//                .build();
//        Request request = new Request.Builder()
//                .url("https://raw.fastgit.org/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_daily_reports/01-16-2021.csv")
//                .method("GET", null)
//                .build();
//        Response response = client.newCall(request).execute();
//        System.out.println(response.isSuccessful());
    }

    @Test
    void TestCVS() throws FileNotFoundException {
//        InputStream file = new FileInputStream("D:\\迅雷下载\\01-01-2021.csv");
//        List<String[]> list = new ArrayList<String[]>();
//        int i = 0;
//        try (CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(file,"utf8"))).build()) {
//            Iterator<String[]> iterator = csvReader.iterator();
//            while (iterator.hasNext()) {
//                String[] next = iterator.next();
//                //去除第一行的表头，从第二行开始
//                if(i >= 1) {
//                    list.add(next);
//                    System.out.println(Long.parseLong("".equals(next[7]) ? "0" : next[7]));
////                            Long.parseLong(next[8].equals(next[8])?"0":next[8]),
////                            Long.parseLong(next[9].equals(next[9])?"0":next[9]),
////                            Long.parseLong(next[10].equals(next[10])?"0":next[10]),next[11],
////                            Double.parseDouble(next[12].equals(next[12])?"0.00":next[12]),
////                            Double.parseDouble(next[12].equals(next[13])?"0.00":next[13]),
//                }
//                i++;
//            }
//
//        } catch (Exception e) {
//            System.out.println("CSV文件读取异常");
//        }
    }

}
