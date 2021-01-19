package nanometer.covid19.nanometercovid19.services;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import nanometer.covid19.nanometercovid19.dao.COVID19DAO;
import nanometer.covid19.nanometercovid19.util.GCCUTIL;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class CSVDataParsingService {
    @Value("${covid19_CSSEGISandData_date_source}")
    String baseCOVID19DateUrl;
    @Autowired
    COVID19DAO covid19DAO;

    public Response getCovid19DateUrl() {
        SimpleDateFormat formatterM= new SimpleDateFormat("MM");
        SimpleDateFormat formatterD= new SimpleDateFormat("dd");
        SimpleDateFormat formatterY= new SimpleDateFormat("yyyy");
        Date date = new Date(System.currentTimeMillis());
        String dateString = formatterM.format(date)+"-"+formatterD.format(date)+"-"+formatterY.format(date);
        String covid19DateUrl = baseCOVID19DateUrl + dateString + ".csv";
        int index = 0;
        while(true){
            index++;
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
                       return response;
                    }else{
                        dateString = formatterM.format(date)+"-"+(Integer.parseInt(formatterD.format(date))-index)+"-"+formatterY.format(date);
                        covid19DateUrl = baseCOVID19DateUrl + dateString + ".csv";
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void analysisOfCSVData(InputStream in){
        int i = 0;
        try (CSVReader csvReader = new CSVReaderBuilder(new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8))).build()) {
            //            covid19DAO.deleteAllDailyData();
            for (String[] next : csvReader) {
                int dateHave = covid19DAO.selectIfDataHave(next[4], next[11]);
                if (dateHave > 0) {
                    return;
                }
                if (i >= 1) {
                    covid19DAO.insertCOVIDData(next[2], next[3], next[4],
                            Long.parseLong("".equals(next[7]) ? "0" : next[7]),
                            Long.parseLong("".equals(next[8]) ? "0" : next[8]),
                            Long.parseLong("".equals(next[9]) ? "0" : next[9]),
                            Long.parseLong("".equals(next[10]) ? "0" : next[10]), next[11],
                            Double.parseDouble("".equals(next[12]) ? "0.00" : next[12]),
                            Double.parseDouble("".equals(next[13]) ? "0.00" : next[13]));
                }
                i++;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GCCUTIL.GCC();
    }

}
