### COVID19 实时监控JavaSpringBoot项目

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
    
    CSSE数据源(英文/全拼)
        @GetMapping("/csse/getbycountry") 获取国家/地区数据c=国家/地区
        @GetMapping("/csse/getbyprovince") 获取省/郡/州数据p=省/郡/州
        @GetMapping("/csse/his/getbycountry") 获取国家/地区历史数据p=国家/地区
        @GetMapping("/csse/his/getbyprovince") 获取省/郡/州历史数据p=省/郡/州
        
    腾讯数据源(中文)
        @GetMapping("/tx/getbyp") 获取中国省数据p=省/自治区
        @GetMapping("/tx/his/getbyp") 获取中国省历史数据p=省/自治区
        @GetMapping("/tx/getbyc") 获取城市数据c=城市
        @GetMapping("/tx/his/getbyc") 获取城市历史数据c=城市
    
    目前Demo数据库中存储的是2021 1 20 号之后的数据
    
    用法
    covid.nanometer.top/tx/getbyp?p=山东
    covid.nanometer.top/csse/getbyprovince?p=shandong
    
不要在意单词用法
    
    
  