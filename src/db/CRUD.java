package db;

import bean.BaseIdBean;

public interface CRUD<T extends BaseIdBean> {
    Integer add(T bean);
    T get(Integer id);
    Boolean update(T newBean);
    Boolean delete(Integer id);
}
