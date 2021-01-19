package nanometer.covid19.nanometercovid19.configuration;

import nanometer.covid19.nanometercovid19.services.CSVDataParsingService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.InputStream;
import java.util.Objects;

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
        System.out.println("github数据更新");
        Response response = cvsDataGetService.getCovid19DateUrl();
        InputStream inputStream = Objects.requireNonNull(response.body()).byteStream();
        cvsDataGetService.analysisOfCSVData(inputStream);
        Objects.requireNonNull(response.body()).close();
    }

    @Scheduled(fixedDelayString="${covid19_date_source_timing_acquisition}")
    private void tengXunDataTasks() {

    }
}
