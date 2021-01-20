package nanometer.covid19.nanometercovid19.configuration;

import nanometer.covid19.nanometercovid19.services.CSVDataParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {

    @Autowired
    CSVDataParsingService cvsDataGetService;

//    @Value("${covid19_date_source_timing_acquisition}")
    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    @Scheduled(fixedDelayString="${covid19_date_source_timing_acquisition}")
    private void gitHubDataTasks() {
        System.out.println("github数据同步");
        String response = cvsDataGetService.getCovid19DateUrl();
        cvsDataGetService.analysisOfDayCSVData(response);
        cvsDataGetService.analysisOfCSVData(response);
        System.out.println("github数据同步完毕");
    }

    @Scheduled(fixedDelayString="${covid19_date_source_timing_acquisition}")
    private void tengXunDataTasks() {
        System.out.println("腾讯疫情数据同步");
        System.out.println("腾讯疫情数据同步完毕");
    }
}
