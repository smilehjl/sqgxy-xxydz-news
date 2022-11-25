package sqgxy.xxydz.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xmp
 * @date 2022-11-18 11:01
 * 新闻类型（一级标题）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsTypeDTO {

    private Integer id;

    /**
     * 新闻类型名
     */
    private String name;
}
