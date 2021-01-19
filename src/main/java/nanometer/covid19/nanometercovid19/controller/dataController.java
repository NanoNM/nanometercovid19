package nanometer.covid19.nanometercovid19.controller;


import nanometer.covid19.nanometercovid19.dao.COVID19DAO;
import nanometer.covid19.nanometercovid19.entity.CsseCovid19AllReportsDailyUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class dataController extends BaseController{
    @Autowired
    COVID19DAO covid19DAO;

    @ResponseBody
    @GetMapping("/getbycountry")
    CsseCovid19AllReportsDailyUpdate[] getDateByCountry(@RequestParam("country")String country){
        return covid19DAO.selectByCountryRegion(country);
    }
    @ResponseBody
    @GetMapping("/getbycity")
    CsseCovid19AllReportsDailyUpdate[] getDateByCity(@RequestParam("city")String city){
        return covid19DAO.selectByCityRegion(city);
    }
}
