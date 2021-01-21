package nanometer.covid19.nanometercovid19.controller;


import nanometer.covid19.nanometercovid19.dao.COVID19CSSEDAO;
import nanometer.covid19.nanometercovid19.dao.COVID19TENGXUNDAO;
import nanometer.covid19.nanometercovid19.entity.CsseCovid19AllReportsDailyUpdate;
import nanometer.covid19.nanometercovid19.entity.TencentDetailedChinaData;
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
        return covid19TENGXUNDAO.selectByCityRegion(p);
    }
    @ResponseBody
    @GetMapping("/tx/his/getbyp")
    TencentDetailedChinaData[] getTxDateByHesCity(@RequestParam("p")String p){
        return covid19TENGXUNDAO.selectByHisCityRegion(p);
    }
}
