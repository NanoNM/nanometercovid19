package nanometer.covid19.nanometercovid19.controller;


import nanometer.covid19.nanometercovid19.dao.COVID19CSSEDAO;
import nanometer.covid19.nanometercovid19.entity.CsseCovid19AllReportsDailyUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class dataController extends BaseController{
    @Autowired
    COVID19CSSEDAO covid19CSSEDAO;

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
    @GetMapping("/csse/hes/getbycountry")
    CsseCovid19AllReportsDailyUpdate[] getDateByHesCountry(@RequestParam("c")String country){
        return covid19CSSEDAO.selectByHesCountryRegion(country);
    }
    @ResponseBody
    @GetMapping("/csse/hes/getbyprovince")
    CsseCovid19AllReportsDailyUpdate[] getDateByHesCity(@RequestParam("p")String city){
        return covid19CSSEDAO.selectByHesCityRegion(city);
    }
}
