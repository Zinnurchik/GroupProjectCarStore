package db;

import bean.BaseIdBean;
import bean.User;

public interface BaseCrudRepository<T extends BaseIdBean> {
    T add(T bean);

    T get(Integer id);
    Boolean update(T newBean);
    Boolean delete(Integer id);
}
