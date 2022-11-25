package sqgxy.xxydz.dto;

import lombok.Data;
import sqgxy.xxydz.entity.XdStar;

import java.util.List;

/**
 * @Author : ljz
 * @data : 2022-11-24 12:39
 * 用于分页
 */

@Data
public class XdstarPageDto extends XdStar {

    private  int currentpage;
    private  int pagesize;
    private  long datalength;
    private List<XdStar> XdstarList;

}
