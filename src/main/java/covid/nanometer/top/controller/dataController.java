package covid.nanometer.top.controller;


import covid.nanometer.top.dao.COVID19CSSEDAO;
import covid.nanometer.top.dao.COVID19TENGXUNDAO;
import covid.nanometer.top.entity.TencentCityHisData;
import covid.nanometer.top.entity.TencentDetailedChinaData;
import covid.nanometer.top.entity.CsseCovid19AllReportsDailyUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class dataController extends BaseController{
    @Autowired
    COVID19CSSEDAO covid19CSSEDAO;
    @Autowired
    COVID19TENGXUNDAO covid19TENGXUNDAO;

    @ResponseBody
    @GetMapping("/csse/getbycountry")
    CsseCovid19AllReportsDailyUpdate[] getDateByCountry(@RequestParam("c")String country){
        return covid19CSSEDAO.selectByCountryRegion(country);
    }
    @ResponseBody
    @GetMapping("/csse/getbyprovince")
    CsseCovid19AllReportsDailyUpdate[] getDateByCity(@RequestParam("p")String city){
        return covid19CSSEDAO.selectByCityRegion(city);
    }
    @ResponseBody
    @GetMapping("/csse/his/getbycountry")
    CsseCovid19AllReportsDailyUpdate[] getDateByHesCountry(@RequestParam("c")String country){
        return covid19CSSEDAO.selectByHesCountryRegion(country);
    }
    @ResponseBody
    @GetMapping("/csse/his/getbyprovince")
    CsseCovid19AllReportsDailyUpdate[] getDateByHesCity(@RequestParam("p")String city){
        return covid19CSSEDAO.selectByHesCityRegion(city);
    }


    @ResponseBody
    @GetMapping("/tx/getbyp")
    TencentDetailedChinaData[] getTxDateByCountry(@RequestParam("p")String p){
        TencentDetailedChinaData[] tencentDetailedChinaDatas = covid19TENGXUNDAO.selectByCityRegion(p);
        for (TencentDetailedChinaData tencentDetailedChinaData:tencentDetailedChinaDatas){
            tencentDetailedChinaData.setTencentCityHisData(covid19TENGXUNDAO.selectCityData(tencentDetailedChinaData.getId()));
        }
        return tencentDetailedChinaDatas;
    }
    @ResponseBody
    @GetMapping("/tx/his/getbyp")
    TencentDetailedChinaData[] getTxDateByHesCity(@RequestParam("p")String p){
        TencentDetailedChinaData[] tencentDetailedChinaDatas = covid19TENGXUNDAO.selectByHisCityRegion(p);
        for (TencentDetailedChinaData tencentDetailedChinaData:tencentDetailedChinaDatas){
            tencentDetailedChinaData.setTencentCityHisData(covid19TENGXUNDAO.selectHisCityData(tencentDetailedChinaData.getLastUpdateTime(), tencentDetailedChinaData.getId()));
        }
        return tencentDetailedChinaDatas;
    }
    @ResponseBody
    @GetMapping("/tx/getbyc")
    TencentCityHisData[] getTxDateByC(@RequestParam("c")String p){
        return covid19TENGXUNDAO.selectCityByC(p);
    }
    @ResponseBody
    @GetMapping("/tx/his/getbyc")
    TencentCityHisData[] getTxDateByHisC(@RequestParam("c")String p){
        return covid19TENGXUNDAO.selectCityHisByC(p);
    }
}
