package nanometer.covid19.nanometercovid19.dao;

import nanometer.covid19.nanometercovid19.entity.CsseCovid19AllReportsDailyUpdate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface COVID19CSSEDAO {
    //   插入历史数据
    @Insert("insert into csse_covid_19_all_reports_daily_update " +
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
            "values(#{Province_State}," +
            "#{Country_Region}," +
            "#{Last_Update}," +
            "#{Confirmed}," +
            "#{Deaths}," +
            "#{Recovered}," +
            "#{Active}," +
            "#{Combined_Key}," +
            "#{Incident_Rate}," +
            "#{Case_Fatality_Ratio})")
    Integer insertDayCOVIDData(String Province_State, String Country_Region, String Last_Update, Long Confirmed, Long Deaths, Long Recovered, Long Active, String Combined_Key, Double Incident_Rate, Double Case_Fatality_Ratio);

    //   插入每日数据
    @Insert("insert into csse_covid_19_all_reports_hestory_daily_update" +
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
            "values(#{Province_State}," +
            "#{Country_Region}," +
            "#{Last_Update}," +
            "#{Confirmed}," +
            "#{Deaths}," +
            "#{Recovered}," +
            "#{Active}," +
            "#{Combined_Key}," +
            "#{Incident_Rate}," +
            "#{Case_Fatality_Ratio})")
    Integer insertCOVIDData(String Province_State, String Country_Region, String Last_Update, Long Confirmed, Long Deaths, Long Recovered, Long Active, String Combined_Key, Double Incident_Rate, Double Case_Fatality_Ratio);

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
