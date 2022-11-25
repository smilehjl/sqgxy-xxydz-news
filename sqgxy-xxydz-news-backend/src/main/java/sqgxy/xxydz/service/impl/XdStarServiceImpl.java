package sqgxy.xxydz.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sqgxy.xxydz.dto.XdstarPageDto;
import sqgxy.xxydz.entity.XdStar;
import sqgxy.xxydz.mapper.XdStarMapper;
import sqgxy.xxydz.service.XdStarService;

import java.util.List;

/**
 * @author ljz
 * @date 2022-11-22 16:32
 */
@Service
public class XdStarServiceImpl extends ServiceImpl<XdStarMapper, XdStar> implements XdStarService {


    @Autowired
    XdStarMapper xdstarMapper;

    /**
     * 分页
     * @param currentpage
     * @param pagesize
     * @return
     */
    @Override
    public XdstarPageDto querypage(int currentpage, int pagesize) {
        XdstarPageDto dto = new XdstarPageDto();
        IPage<XdStar> page = new Page<>(currentpage,pagesize);
        //注意如果需要用 Lambda表达式传参的话 必须使用 LambdaQueryWrapper
        LambdaQueryWrapper<XdStar> queryWrapper=new LambdaQueryWrapper<>();
        IPage<XdStar> page1 = xdstarMapper.selectPage(page, queryWrapper);
        dto.setCurrentpage(currentpage);
        dto.setPagesize(pagesize);
        dto.setXdstarList(page1.getRecords());
        dto.setDatalength(page1.getTotal());
        return dto ;
    }

    /**
     * 模糊查询姓名
     * @param name
     * @return
     */
    @Override
    public List<XdStar> LikeByName(String name){
        QueryWrapper<XdStar> wrapper = new QueryWrapper<>();
        wrapper.like("name",name);
        wrapper.lambda().orderByAsc(XdStar::getId);
        return xdstarMapper.selectList(wrapper);
    }

}