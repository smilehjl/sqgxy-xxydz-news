package sqgxy.xxydz.service;


import com.baomidou.mybatisplus.extension.service.IService;
import sqgxy.xxydz.dto.XdstarPageDto;
import sqgxy.xxydz.entity.XdStar;

import java.util.List;

/**
 * @author lzj
 * @date 2022-11-23 15:59
 */
public interface XdStarService extends IService<XdStar> {

    XdstarPageDto querypage(int currentpage, int pagesize);
    List<XdStar> LikeByName(String name);

}