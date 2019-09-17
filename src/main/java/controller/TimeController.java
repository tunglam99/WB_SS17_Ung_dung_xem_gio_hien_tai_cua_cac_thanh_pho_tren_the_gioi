package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {
    @GetMapping("/world_clock")
    public String getTimeByTimezone(ModelMap model, @RequestParam(name = "city", required = false, defaultValue = "Asian/Ho_Chi_Minh") String city){
        //get current time at local
        Date date = new Date();
        //get timezone by the local
        TimeZone local = TimeZone.getDefault();
        //get timezone by the specified city
        TimeZone locale = TimeZone.getTimeZone(city);
       // Tính thời gian hiện tại trong thành phố được chỉ định
        long locale_time = date.getTime()+(locale.getRawOffset() - local.getRawOffset());
        // Đặt lại ngày theo locale_time
        date.setTime(locale_time);
        model.addAttribute("city", city);
        model.addAttribute("date",date);
        return "index";
    }


}
