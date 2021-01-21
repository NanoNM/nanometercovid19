package nanometer.covid19.nanometercovid19.dao;

import nanometer.covid19.nanometercovid19.entity.TencentDetailedChinaData;
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
}
