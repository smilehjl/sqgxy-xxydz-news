package sqgxy.xxydz.dto;

import sqgxy.xxydz.enums.DisplayContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xmp
 * @date 2022-11-18 14:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsCategoryQueryAllDTO {

    private Integer id;

    private String name;

    private String newsTypeName;

    private DisplayContent displayContent;
}
