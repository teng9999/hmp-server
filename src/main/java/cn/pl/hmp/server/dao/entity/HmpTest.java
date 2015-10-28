package cn.pl.hmp.server.dao.entity;

import cn.pl.hmp.server.entity.BaseEntity;

public class HmpTest extends BaseEntity {
    /**
     *
     */
    private static final long serialVersionUID = -8784851327759591071L;
                                               
    private Integer           id;
                              
    private String            name;
                              
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
