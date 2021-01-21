package covid.nanometer.top.controller;

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
