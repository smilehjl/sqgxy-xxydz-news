package sqgxy.xxydz.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sqgxy.xxydz.entity.News;
import sqgxy.xxydz.service.AdminInformationService;
import sqgxy.xxydz.service.NewsCategoryService;
import sqgxy.xxydz.service.NewsService;
import sqgxy.xxydz.service.NewsTypeService;
import sqgxy.xxydz.vo.Result;

import java.util.Date;
import java.util.List;


/**
 * * @author ljz
 * @date 2022-11-30 11:45
 */

@Api(tags = "Echarts图标操作")
@RestController
@RequestMapping("/echarts")
public class EchartsController {

    @Autowired
    private AdminInformationService adminInformationService;

    @Autowired
    NewsService newsService;

    @Autowired
    NewsTypeService newsTypeService;

    @Autowired
    NewsCategoryService newsCategoryService;

    /**
     * 得到用户总数
     *
     * @return
     */
    @GetMapping("/usernums")
    public Result getUserNums() {
        int count = adminInformationService.count();
        return new Result().ok().data(count);
    }

    /**
     * 得到新闻总数
     *
     * @return
     */
    @GetMapping("/newsnums")
    public Result getNewsNums() {
        int count = newsService.count();
        return new Result().ok().data(count);
    }

    /**
     * 得到一级标题的数量
     *
     * @return
     */
    @GetMapping("/h1nums")
    public Result getH1Nums() {
        int count = newsTypeService.count();
        return new Result().ok().data(count);
    }

    /**
     * 得到二级标题的数量
     *
     * @return
     */
    @GetMapping("/h2nums")
    public Result getH2Nums() {
        int count = newsCategoryService.count();
        return new Result().ok().data(count);
    }

    /**
     * 折线图
     * @return
     */
    @GetMapping("line")
    public  Result getLine(){
        List<News> list = newsService.list();
        int MonNums=0;
        int TusNums=0;
        int WedNums=0;
        int ThuNums=0;
        int  FriNums=0;
        int  SatNums=0;
        int  SunNums=0;
        for (News news : list) {
            Date createTime = news.getCreateTime();
            String s = createTime.toString().substring(0,3);
            switch (s){
                case "Mon": MonNums++;  break;
                case "Tus": TusNums++;  break;
                case "Wed": WedNums++;  break;
                case "Thu": ThuNums++;  break;
                case "Fri": FriNums++;  break;
                case "Sat": SatNums++;  break;
                case "Sun": SunNums++;  break;
            }
        }
        int[] array =new int[7];
        array[0]=MonNums;
        array[1]=TusNums;
        array[2]=WedNums;
        array[3]=ThuNums;
        array[4]=FriNums;
        array[5]=SatNums;
        array[6]=SunNums;
        return new Result().ok().data(array);
    }

}
