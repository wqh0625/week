package demo.com.demo01.presenter;

import java.util.List;

import demo.com.demo01.bean.Result;
import demo.com.demo01.bean.SearchData;
import demo.com.demo01.core.http.DataCall;
import demo.com.demo01.core.http.IRequest;
import demo.com.demo01.core.http.NewWorkHttp;
import io.reactivex.Observable;

/**
 * 作者: Wang on 2018/12/28 20:09
 * 寄语：加油！相信自己可以！！！
 */


public class SearchActivityPresenter extends BasePresenter {
    public SearchActivityPresenter(DataCall consumer) {
        super(consumer);
    }
    int page ;
    @Override
    protected Observable observable(Object... args) {
        IRequest iRegister = NewWorkHttp.getNetWorks().create(IRequest.class);

        boolean arg = (boolean) args[1];
        if (arg){
            page=1;
        }else{
            page++;
        }
        Observable<Result<List<SearchData>>> bannerData = iRegister.searchData((String) args[0],page,"10");
        return bannerData;
    }
}
