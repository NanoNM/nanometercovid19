package nanometer.covid19.nanometercovid19.controller;

import nanometer.covid19.nanometercovid19.entity.CsseCovid19AllReportsDailyUpdate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {
    @ResponseBody
    @GetMapping("/")
    String getBase(@RequestParam("c")String country){
        return "covid19CSSEDAO.selectByCountryRegion(country)";
    }
}
