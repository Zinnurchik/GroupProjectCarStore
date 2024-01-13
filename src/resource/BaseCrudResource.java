package resource;
import bean.ApiResponce;
import bean.BaseIdBean;
public interface BaseCrudResource <T extends BaseIdBean> {
    ApiResponce add(T bean);
    ApiResponce get(Integer id);
    ApiResponce update(T newBean);
    ApiResponce delete(Integer id);
}
