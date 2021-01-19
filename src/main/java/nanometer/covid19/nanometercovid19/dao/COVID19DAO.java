package nanometer.covid19.nanometercovid19.dao;

import nanometer.covid19.nanometercovid19.entity.CsseCovid19AllReportsDailyUpdate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface COVID19DAO {
    @Insert("insert into csse_covid_19_all_reports_daily_update" +
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

    @Delete("delete from csse_covid_19_all_reports_daily_update")
    Integer deleteAllDailyData();

    @Select("select * from csse_covid_19_all_reports_daily_update where Country_Region=#{Country_Region}")
    CsseCovid19AllReportsDailyUpdate[] selectByCountryRegion(String Country_Region);

    @Select("select * from csse_covid_19_all_reports_daily_update where Province_State=#{Province_State}")
    CsseCovid19AllReportsDailyUpdate[] selectByCityRegion(String Province_State);

    @Select("select COUNT(id) from csse_covid_19_all_reports_daily_update where Last_Update=#{Last_Update} and Combined_Key=#{Combined_Key}")
    int selectIfDataHave(String Last_Update,String Combined_Key);

}
