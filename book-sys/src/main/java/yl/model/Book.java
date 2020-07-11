package yl.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@ToString
public class Book extends DictionaryTag {
    private Integer id;
    private String bookName;
    private String author;
    private BigDecimal price;//满足精度要求的,因为double和float都是非精度的，会给你省掉一部分数字
    private Date createTime;
}
