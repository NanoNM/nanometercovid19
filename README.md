###COVID19 实时监控JavaSpringBoot项目

>数据来源 
>
    https://github.com/CSSEGISandData/COVID-19
    腾讯每日疫情通报
    
>Demo
>
    covid.nanometer.top
    
>api作用
>
    API
    
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
    
    目前Demo数据库中存储的是2021 1 20 号之后的数据
    
    用法
    covid.nanometer.top/tx/getbyp?p=山东
    
    covid.nanometer.top/csse/getbyprovince?p=shandong
    
不要在意单词用法
    
    
  