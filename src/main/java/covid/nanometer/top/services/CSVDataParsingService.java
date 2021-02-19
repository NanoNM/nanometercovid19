package covid.nanometer.top.services;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import covid.nanometer.top.dao.COVID19CSSEDAO;
import covid.nanometer.top.entity.CsseCovid19AllReportsDailyUpdate;
import covid.nanometer.top.util.Log4jUTIL;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CSVDataParsingService {
    @Value("${covid19_CSSEGISandData_date_source}")
    String baseCOVID19DateUrl;
    @Autowired
    COVID19CSSEDAO covid19CSSEDAO;

    public String getCovid19DateUrl() {
        SimpleDateFormat formatter= new SimpleDateFormat("MM-dd-yyyy");
        Date date = new Date(System.currentTimeMillis());
        String dateString = formatter.format(date);
        String covid19DateUrl = baseCOVID19DateUrl + dateString + ".csv";
        String bodyDate = null;
        while(true){
            Log4jUTIL.log.info("尝试请求: " + covid19DateUrl);
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(covid19DateUrl)
                    .method("GET", null)
                    .build();
            Response response;
            {
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()){
                        bodyDate = Objects.requireNonNull(response.body()).string();
                        response.close();
                        break;
                    }else{
                        Calendar calendar = new GregorianCalendar();
                        calendar.setTime(date);
                        calendar.add(Calendar.DATE,-1); //把日期往后增加一天,整数  往后推,负数往前移动
                        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
                        dateString = formatter.format(date);
                        covid19DateUrl = baseCOVID19DateUrl + dateString + ".csv";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bodyDate;
    }

    public void analysisOfCSVData(String responseBody){
        ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(responseBody.getBytes());
        CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(tInputStringStream, StandardCharsets.UTF_8))).build();
        int i = 0;
        List<CsseCovid19AllReportsDailyUpdate> stringList = new ArrayList<>();
        for (String[] next : csvReader) {
            int dateHave = covid19CSSEDAO.selectIfDataHave(next[4], next[11]);
            if (dateHave == 0) {
                getData(i, stringList, next);
            }
            i++;
        }
        covid19CSSEDAO.insertCOVIDData(stringList);
        try {
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        GCCUTIL.GCC();
    }

    private void getData(int i, List<CsseCovid19AllReportsDailyUpdate> stringList, String[] next) {
        if (i >= 1) {
            CsseCovid19AllReportsDailyUpdate csseCovid19AllReportsDailyUpdate = new CsseCovid19AllReportsDailyUpdate();
            csseCovid19AllReportsDailyUpdate.setProvinceState(next[2]);
            csseCovid19AllReportsDailyUpdate.setCountryRegion(next[3]);
            csseCovid19AllReportsDailyUpdate.setLastUpdate(next[4]);
            csseCovid19AllReportsDailyUpdate.setConfirmed(Long.parseLong("".equals(next[7]) ? "0" : next[7]));
            csseCovid19AllReportsDailyUpdate.setDeaths(Long.parseLong("".equals(next[8]) ? "0" : next[8]));
            csseCovid19AllReportsDailyUpdate.setRecovered(Long.parseLong("".equals(next[9]) ? "0" : next[9]));
            csseCovid19AllReportsDailyUpdate.setActive(Long.parseLong("".equals(next[10]) ? "0" : next[10]));
            csseCovid19AllReportsDailyUpdate.setCombinedKey(next[11]);
            csseCovid19AllReportsDailyUpdate.setIncidentRate(Double.parseDouble("".equals(next[12]) ? "0.00" : next[12]));
            csseCovid19AllReportsDailyUpdate.setCaseFatalityRatio(Double.parseDouble("".equals(next[13]) ? "0.00" : next[13]));
            stringList.add(csseCovid19AllReportsDailyUpdate);
        }
    }


    public void analysisOfDayCSVData(String responseBody) {
        ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(responseBody.getBytes());
        CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(tInputStringStream, StandardCharsets.UTF_8))).build();
        int i = 0;
        covid19CSSEDAO.deleteAllDailyData();
        List<CsseCovid19AllReportsDailyUpdate> stringList = new ArrayList<>();
        for (String[] next : csvReader) {
            getData(i, stringList, next);
            i++;
        }

        covid19CSSEDAO.insertDayCOVIDData(stringList);
        try {
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        GCCUTIL.GCC();
    }
}


