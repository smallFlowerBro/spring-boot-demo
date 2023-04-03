package com.wei.demo.office;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/*********************************
 *   @Author WEIYJ
 *   @Description //TODO
 *   @Data 2023/3/31 16:53
 *   海到尽头天作岸 山登绝顶我为峰
 ********************************/
@Data
public class Option {

    private int start;

    private Map params;

    public Option(int start) {
        this.start = start;
        this.params = new HashMap<Integer,Class<?>>();
    }

    public Option add(int index,Class<?> tclass){
        this.params.put(index,tclass);
        return this;
    }
}
