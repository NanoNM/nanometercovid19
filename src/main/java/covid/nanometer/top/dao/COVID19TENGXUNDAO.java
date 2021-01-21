package covid.nanometer.top.dao;

import covid.nanometer.top.entity.TencentCityHisData;
import covid.nanometer.top.entity.TencentDetailedChinaData;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface COVID19TENGXUNDAO {
    @Insert("insert into tencent_detailed_china_data" +
            "(province," +
            "confirm," +
            "healRate," +
            "wzz," +
            "heal," +
            "nowConfirm," +
            "dead," +
            "suspect," +
            "deadRate," +
            "lastUpdateTime," +
            "todayConfirm," +
            "wzz_add" +
            ") " +
            "values(#{province}," +
            "#{confirm}," +
            "#{healRate}," +
            "#{wzz}," +
            "#{heal}," +
            "#{nowConfirm}," +
            "#{dead}," +
            "#{suspect}," +
            "#{deadRate}," +
            "#{lastUpdateTime}," +
            "#{todayConfirm}," +
            "#{wzz_add})")
    Integer insertDayCOVIDData(String province,Integer confirm,Double healRate,Integer wzz,Integer heal,Integer nowConfirm,Integer dead,Integer suspect,Double deadRate,String lastUpdateTime,Integer todayConfirm,Integer wzz_add);


    @Insert("insert into tencent_detailed_china_his_data" +
            "(province," +
            "confirm," +
            "healRate," +
            "wzz," +
            "heal," +
            "nowConfirm," +
            "dead," +
            "suspect," +
            "deadRate," +
            "lastUpdateTime," +
            "todayConfirm," +
            "wzz_add" +
            ") " +
            "values(#{province}," +
            "#{confirm}," +
            "#{healRate}," +
            "#{wzz}," +
            "#{heal}," +
            "#{nowConfirm}," +
            "#{dead}," +
            "#{suspect}," +
            "#{deadRate}," +
            "#{lastUpdateTime}," +
            "#{todayConfirm}," +
            "#{wzz_add})")
    Integer insertHisCOVIDData(String province,Integer confirm,Double healRate,Integer wzz,Integer heal,Integer nowConfirm,Integer dead,Integer suspect,Double deadRate,String lastUpdateTime,Integer todayConfirm,Integer wzz_add);

    // 重置每日数据
    @Delete("TRUNCATE tencent_detailed_china_data")
    Integer deleteAllDailyData();

    @Select("SELECT count(id) FROM tencent_detailed_china_his_data WHERE lastUpdateTime=#{lastUpdateTime} AND province=#{province} LIMIT 1")
    int selectIfDataHave(String lastUpdateTime,String province);

    @Select("SELECT * FROM tencent_detailed_china_data WHERE province=#{p}")
    TencentDetailedChinaData[] selectByCityRegion(String p);

    @Select("SELECT * FROM tencent_detailed_china_his_data WHERE province=#{p}")
    TencentDetailedChinaData[] selectByHisCityRegion(String p);

    @Select("SELECT id FROM tencent_detailed_china_his_data WHERE province=#{master} and lastUpdateTime=#{l}")
    Integer selectByHisMasterID(String master, String l);

    @Select("SELECT id FROM tencent_detailed_china_data WHERE province=#{master}")
    Integer selectByMasterID(String master);

    @Delete("TRUNCATE tencent_city_data")
    Integer deleteAllHisCityDailyData();

    @Insert("insert into tencent_city_his_data (Province_ID,cityName,confirm,healRate,wzz,heal,nowConfirm,todayConfirm,dead,deadRate,suspect,lastUpdateTime) " +
            "values(#{Province_ID},#{cityName},#{confirm},#{healRate},#{wzz},#{heal},#{nowConfirm},#{todayConfirm},#{dead},#{deadRate},#{suspect},#{lastUpdateTime})")
    Integer insertDayCityHisCOVIDData(Integer Province_ID,String cityName,Integer confirm,Double healRate,Integer wzz,Integer heal,Integer nowConfirm,Integer todayConfirm,Integer dead,Double deadRate,Integer suspect,String lastUpdateTime);

    @Insert("insert into tencent_city_data (Province_ID,cityName,confirm,healRate,wzz,heal,nowConfirm,todayConfirm,dead,deadRate,suspect,lastUpdateTime) " +
            "values(#{Province_ID},#{cityName},#{confirm},#{healRate},#{wzz},#{heal},#{nowConfirm},#{todayConfirm},#{dead},#{deadRate},#{suspect},#{lastUpdateTime})")
    Integer insertDayCityCOVIDData(Integer Province_ID,String cityName,Integer confirm,Double healRate,Integer wzz,Integer heal,Integer nowConfirm,Integer todayConfirm,Integer dead,Double deadRate,Integer suspect,String lastUpdateTime);


    @Select("SELECT count(Province_ID) FROM tencent_city_his_data WHERE lastUpdateTime=#{lastUpdateTime} AND cityName=#{name} AND Province_ID=#{ProvinceID} LIMIT 1")
    int selectIfCityDataHave(String lastUpdateTime,String name,Integer ProvinceID);

    @Select("SELECT * FROM tencent_city_his_data WHERE lastUpdateTime=#{lastUpdateTime} AND Province_ID=#{Province_ID}")
    TencentCityHisData[] selectHisCityData(String lastUpdateTime, long Province_ID);

    @Select("SELECT * FROM tencent_city_data WHERE Province_ID=#{Province_ID}")
    TencentCityHisData[] selectCityData(long ProvinceID);

    @Select("SELECT * FROM tencent_city_data WHERE cityName=#{p}")
    TencentCityHisData[] selectCityByC(String p);

    @Select("SELECT * FROM tencent_city_his_data WHERE cityName=#{p}")
    TencentCityHisData[] selectCityHisByC(String p);
}
