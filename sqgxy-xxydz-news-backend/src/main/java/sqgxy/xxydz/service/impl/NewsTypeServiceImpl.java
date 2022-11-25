package sqgxy.xxydz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import sqgxy.xxydz.dto.NewsTypeDTO;
import sqgxy.xxydz.entity.NewsType;
import sqgxy.xxydz.exception.HintException;
import sqgxy.xxydz.mapper.NewsTypeMapper;
import sqgxy.xxydz.service.NewsTypeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xmp
 * @date 2022-11-19 16:48
 */
@Service
public class NewsTypeServiceImpl extends ServiceImpl<NewsTypeMapper, NewsType> implements NewsTypeService {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public boolean saveNewsType(String name) {
        // 检验 name 唯一
        isExistName(name);
        return save(NewsType.builder().name(name).build());
    }

    @Override
    public boolean removeNewsTypeById(Integer id) {
        return removeById(id);
    }

    @Override
    public boolean updateNewsType(NewsTypeDTO dto) {
        // 检验 name 唯一
        isExistName(dto.getName());
        updateById(modelMapper.map(dto, NewsType.class));
        return false;
    }

    @Override
    public List<NewsTypeDTO> getNewsTypeList() {
        List<NewsType> list = list(new QueryWrapper<NewsType>().select(ID, NAME));
        return modelMapper.map(list, new TypeToken<List<NewsTypeDTO>>(){}.getType());
    }

    /**
     * 检验 name 唯一性
     */
    private void isExistName(String name) {
        int count = count(new QueryWrapper<NewsType>().eq(NAME, name));
        if (count > 0) {
            // name 已经存在
            throw new HintException(name + "已经存在");
        }
    }
}
