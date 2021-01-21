package covid.nanometer.top.services;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import covid.nanometer.top.dao.COVID19TENGXUNDAO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Objects;


@Service
public class JSONDateParsingService {
    @Value("${covid19_TengXun_date_source}")
    String tengXunCOVID19DateUrl;

    @Value("${covid19_TengXun_history_date_source}")
    String tengXunHisCOVID19DateUrl;

    @Autowired
    COVID19TENGXUNDAO covid19TENGXUNDAO;

    public String getCovid19DateUrl() {
        String jsonDate = null;
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://view.inews.qq.com/g2/getOnsInfo?name=disease_h5")
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            JSONObject tengXunChina = JSON.parseObject(String.valueOf(JSON.parseObject(Objects.requireNonNull(response.body()).string())));
            jsonDate = tengXunChina.getString("data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    return jsonDate;
    }

    public void analysisOfDayCSVData(String response) {
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONArray txcovidOBJS = jsonObject.getJSONArray("areaTree");
        String lastUpdateTime = jsonObject.getString("lastUpdateTime");
        JSONObject areaTreeOBJ = (JSONObject) txcovidOBJS.get(0);
        JSONArray childrenOBJS = areaTreeOBJ.getJSONArray("children");
        covid19TENGXUNDAO.deleteAllDailyData();
        for (Object everyProvince:childrenOBJS) {
            JSONObject everyProvinceJson = (JSONObject) everyProvince;
            covid19TENGXUNDAO.insertDayCOVIDData(
                    everyProvinceJson.getString("name"),
                    everyProvinceJson.getJSONObject("total").getInteger("confirm"),
                    everyProvinceJson.getJSONObject("total").getDouble("healRate"),
                    everyProvinceJson.getJSONObject("total").getInteger("wzz"),
                    everyProvinceJson.getJSONObject("total").getInteger("heal"),
                    everyProvinceJson.getJSONObject("total").getInteger("nowConfirm"),
                    everyProvinceJson.getJSONObject("total").getInteger("dead"),
                    everyProvinceJson.getJSONObject("total").getInteger("suspect"),
                    everyProvinceJson.getJSONObject("total").getDouble("deadRate"),
                    lastUpdateTime,
                    everyProvinceJson.getJSONObject("today").getInteger("confirm"),
                    everyProvinceJson.getJSONObject("today").getInteger("wzz_add")
            );
        }
    }

    public void analysisOfCSVData(String response) {
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONArray txcovidOBJS = jsonObject.getJSONArray("areaTree");
        String lastUpdateTime = jsonObject.getString("lastUpdateTime");
        JSONObject areaTreeOBJ = (JSONObject) txcovidOBJS.get(0);
        JSONArray childrenOBJS = areaTreeOBJ.getJSONArray("children");
        for (Object everyProvince:childrenOBJS) {
            JSONObject everyProvinceJson = (JSONObject) everyProvince;
            if (covid19TENGXUNDAO.selectIfDataHave(lastUpdateTime,everyProvinceJson.getString("name"))>0){
                return;
            }
            covid19TENGXUNDAO.insertHisCOVIDData(
                    everyProvinceJson.getString("name"),
                    everyProvinceJson.getJSONObject("total").getInteger("confirm"),
                    everyProvinceJson.getJSONObject("total").getDouble("healRate"),
                    everyProvinceJson.getJSONObject("total").getInteger("wzz"),
                    everyProvinceJson.getJSONObject("total").getInteger("heal"),
                    everyProvinceJson.getJSONObject("total").getInteger("nowConfirm"),
                    everyProvinceJson.getJSONObject("total").getInteger("dead"),
                    everyProvinceJson.getJSONObject("total").getInteger("suspect"),
                    everyProvinceJson.getJSONObject("total").getDouble("deadRate"),
                    lastUpdateTime,
                    everyProvinceJson.getJSONObject("today").getInteger("confirm"),
                    everyProvinceJson.getJSONObject("today").getInteger("wzz_add")
            );
        }
    }

    public void analysisOfHisDayCityData(String response) {
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONArray txcovidOBJS = jsonObject.getJSONArray("areaTree");
        String lastUpdateTime = jsonObject.getString("lastUpdateTime");
        JSONObject areaTreeOBJ = (JSONObject) txcovidOBJS.get(0);
        JSONArray childrenOBJS = areaTreeOBJ.getJSONArray("children");
        for (Object everyProvince:childrenOBJS) {
            JSONObject everyProvinceJson = (JSONObject) everyProvince;
            JSONArray cityChildrens = everyProvinceJson.getJSONArray("children");
            String master = everyProvinceJson.getString("name");
            for (Object cityChildren:cityChildrens){
                JSONObject cityChildrenJson = (JSONObject) cityChildren;
                Integer pID = covid19TENGXUNDAO.selectByHisMasterID(master, lastUpdateTime);
                if (pID!=null){
                    if (covid19TENGXUNDAO.selectIfCityDataHave(lastUpdateTime,cityChildrenJson.getString("name"),pID)>0){
                        return;
                    }
                    covid19TENGXUNDAO.insertDayCityHisCOVIDData(
                            pID,
                            cityChildrenJson.getString("name"),
                            cityChildrenJson.getJSONObject("total").getInteger("confirm"),
                            cityChildrenJson.getJSONObject("total").getDouble("healRate"),
                            cityChildrenJson.getJSONObject("total").getInteger("wzz"),
                            cityChildrenJson.getJSONObject("total").getInteger("heal"),
                            cityChildrenJson.getJSONObject("total").getInteger("nowConfirm"),
                            cityChildrenJson.getJSONObject("today").getInteger("confirm"),
                            cityChildrenJson.getJSONObject("total").getInteger("dead"),
                            cityChildrenJson.getJSONObject("total").getDouble("deadRate"),
                            cityChildrenJson.getJSONObject("total").getInteger("suspect"),
                            lastUpdateTime
                    );
                }
            }
        }
    }

    public void analysisOfDayCityData(String response) {
        JSONObject jsonObject = JSONObject.parseObject(response);
        JSONArray txcovidOBJS = jsonObject.getJSONArray("areaTree");
        String lastUpdateTime = jsonObject.getString("lastUpdateTime");
        JSONObject areaTreeOBJ = (JSONObject) txcovidOBJS.get(0);
        JSONArray childrenOBJS = areaTreeOBJ.getJSONArray("children");
        covid19TENGXUNDAO.deleteAllHisCityDailyData();
        for (Object everyProvince:childrenOBJS) {
            JSONObject everyProvinceJson = (JSONObject) everyProvince;
            JSONArray cityChildrens = everyProvinceJson.getJSONArray("children");
            String master = everyProvinceJson.getString("name");
            for (Object cityChildren:cityChildrens){
                JSONObject cityChildrenJson = (JSONObject) cityChildren;
                Integer pID = covid19TENGXUNDAO.selectByMasterID(master);
                if (pID!=null){
                    covid19TENGXUNDAO.insertDayCityCOVIDData(
                            pID,
                            cityChildrenJson.getString("name"),
                            cityChildrenJson.getJSONObject("total").getInteger("confirm"),
                            cityChildrenJson.getJSONObject("total").getDouble("healRate"),
                            cityChildrenJson.getJSONObject("total").getInteger("wzz"),
                            cityChildrenJson.getJSONObject("total").getInteger("heal"),
                            cityChildrenJson.getJSONObject("total").getInteger("nowConfirm"),
                            cityChildrenJson.getJSONObject("today").getInteger("confirm"),
                            cityChildrenJson.getJSONObject("total").getInteger("dead"),
                            cityChildrenJson.getJSONObject("total").getDouble("deadRate"),
                            cityChildrenJson.getJSONObject("total").getInteger("suspect"),
                            lastUpdateTime
                    );
                }
            }
        }
    }
}
