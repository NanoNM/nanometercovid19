package covid.nanometer.top.dao;

import com.opencsv.CSVReader;
import covid.nanometer.top.entity.CsseCovid19AllReportsDailyUpdate;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface COVID19CSSEDAO {

    @Insert({"<script>"  +
            "insert into csse_covid_19_all_reports_daily_update" +
            "(Province_State," +
            "Country_Region," +
            "Last_Update," +
            "Confirmed," +
            "Deaths," +
            "Recovered," +
            "Active," +
            "Combined_Key," +
            "Incident_Rate," +
            "Case_Fatality_Ratio) " +
            "VALUES " +
            "<foreach collection='list' item='stringlist' index='index' separator=','> " +
            "(#{stringlist.provinceState}," +
            "#{stringlist.countryRegion}," +
            "#{stringlist.lastUpdate}," +
            "#{stringlist.confirmed}," +
            "#{stringlist.deaths}," +
            "#{stringlist.recovered}," +
            "#{stringlist.active}," +
            "#{stringlist.combinedKey}," +
            "#{stringlist.incidentRate}," +
            "#{stringlist.caseFatalityRatio}) " +
            "</foreach>" +
            "</script>"})
    Integer insertDayCOVIDData(@Param("list") List<CsseCovid19AllReportsDailyUpdate> list);

    @Insert({"<script>"  +
            "insert into csse_covid_19_all_reports_hestory_daily_update" +
            "(Province_State," +
            "Country_Region," +
            "Last_Update," +
            "Confirmed," +
            "Deaths," +
            "Recovered," +
            "Active," +
            "Combined_Key," +
            "Incident_Rate," +
            "Case_Fatality_Ratio) " +
            "VALUES " +
            "<foreach collection='list' item='stringlist' index='index' separator=','> " +
            "(#{stringlist.provinceState}," +
            "#{stringlist.countryRegion}," +
            "#{stringlist.lastUpdate}," +
            "#{stringlist.confirmed}," +
            "#{stringlist.deaths}," +
            "#{stringlist.recovered}," +
            "#{stringlist.active}," +
            "#{stringlist.combinedKey}," +
            "#{stringlist.incidentRate}," +
            "#{stringlist.caseFatalityRatio}) " +
            "</foreach>" +
            "</script>"})
    Integer insertCOVIDData(@Param("list") List<CsseCovid19AllReportsDailyUpdate> list);
    // 重置每日数据
    @Delete("TRUNCATE csse_covid_19_all_reports_daily_update")
    Integer deleteAllDailyData();

    @Select("select * from csse_covid_19_all_reports_daily_update where Country_Region=#{Country_Region}")
    CsseCovid19AllReportsDailyUpdate[] selectByCountryRegion(String Country_Region);

    @Select("select * from csse_covid_19_all_reports_daily_update where Province_State=#{Province_State}")
    CsseCovid19AllReportsDailyUpdate[] selectByCityRegion(String Province_State);

    @Select("select * from csse_covid_19_all_reports_hestory_daily_update where Country_Region=#{Country_Region}")
    CsseCovid19AllReportsDailyUpdate[] selectByHesCountryRegion(String Country_Region);

    @Select("select * from csse_covid_19_all_reports_hestory_daily_update where Province_State=#{Province_State}")
    CsseCovid19AllReportsDailyUpdate[] selectByHesCityRegion(String Province_State);

//    select isnull((select top(1) 1 from tableName where conditions), 0)
//    SELECT 1 FROM table WHERE a = 1 AND b = 2 LIMIT 1
//    @Select("select COUNT(id) from csse_covid_19_all_reports_daily_update where Last_Update=#{Last_Update} and Combined_Key=#{Combined_Key}")
    @Select("SELECT count(id) FROM csse_covid_19_all_reports_hestory_daily_update WHERE Last_Update=#{Last_Update} AND Combined_Key=#{Combined_Key} LIMIT 1")
//    @Select("select isnull((select top(1) 1 from csse_covid_19_all_reports_daily_update where Last_Update=#{Last_Update} and Combined_Key=#{Combined_Key}), 0)")
    int selectIfDataHave(String Last_Update,String Combined_Key);

}
