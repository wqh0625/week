package demo.com.demo01.presenter;

import java.util.List;

import demo.com.demo01.bean.DingdanData;
import demo.com.demo01.bean.Result;
import demo.com.demo01.core.http.DataCall;
import demo.com.demo01.core.http.IRequest;
import demo.com.demo01.core.http.NewWorkHttp;
import io.reactivex.Observable;

/**
 * 作者: Wang on 2019/1/4 14:20
 * 寄语：加油！相信自己可以！！！
 */


public class DingdanPresenter extends BasePresenter {
    public DingdanPresenter(DataCall consumer) {
        super(consumer);
    }

    @Override
    protected Observable observable(Object... args) {
        IRequest iRegister = NewWorkHttp.getNetWorks().create(IRequest.class);
        Observable<Result<List<DingdanData>>> bannerData = iRegister.getDingdanData(
                (int) args[0],
                (String) args[1],
                (int) args[2],
                (int) args[3],
                (int) args[4]);
        return bannerData;
    }
}
