package demo.com.demo01.presenter;

import demo.com.demo01.bean.LoginData;
import demo.com.demo01.bean.Result;
import demo.com.demo01.core.http.DataCall;
import demo.com.demo01.core.http.IRequest;
import demo.com.demo01.core.http.NewWorkHttp;
import io.reactivex.Observable;

/**
 * 作者: Wang on 2018/12/28 20:09
 * 寄语：加油！相信自己可以！！！
 */


public class LoginPresenter extends BasePresenter {
    public LoginPresenter(DataCall consumer) {
        super(consumer);
    }

    @Override
    protected Observable observable(Object... args) {
        IRequest iRequest = NewWorkHttp.getNetWorks().create(IRequest.class);
        Observable<Result<LoginData>> loginRequest = iRequest.getLoginRequest((String) args[0], (String) args[1]);
        return loginRequest;
    }
}
