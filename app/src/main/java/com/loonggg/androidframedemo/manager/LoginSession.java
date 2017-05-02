package com.loonggg.androidframedemo.manager;

import android.text.TextUtils;


import com.loonggg.androidframedemo.app.CustomApp;
import com.loonggg.androidframedemo.injection.GlobalModule;
import com.loonggg.androidframedemo.net.rpc.RpcApiError;
import com.loonggg.androidframedemo.net.rpc.UiRpcSubscriber;
import com.loonggg.androidframedemo.net.rpc.model.UserInfo;
import com.loonggg.androidframedemo.net.rpc.service.AuthService;
import com.loonggg.androidframedemo.net.rpc.service.UserService;
import com.loonggg.androidframedemo.ui.serviceinjection.DaggerServiceComponent;
import com.loonggg.androidframedemo.ui.serviceinjection.ServiceModule;
import com.loonggg.androidframedemo.utils.JsonConverter;
import com.loonggg.androidframedemo.utils.preference.CustomAppPreferences;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


public class LoginSession {

    private CustomApp mContext;
    private UserInfo mUserInfo;
    @Inject
    AuthService mAuthService;
    @Inject
    UserService mUserService;

    private CompositeSubscription mSubscriptions = new CompositeSubscription();

    public LoginSession(CustomApp app) {
        mContext = app;
        DaggerServiceComponent.builder().globalModule(new GlobalModule(mContext)).serviceModule(new
                ServiceModule()).build().inject(this);
        switchUserInfo();
    }

    public int getMemberId() {
        return mUserInfo.getMemberId();
    }

    private void switchUserInfo() {
        String userJson = mContext.getGlobalComponent().appPreferences().getString
                (CustomAppPreferences.KEY_USER_INFO, "");
        if (!TextUtils.isEmpty(userJson)) {
            mUserInfo = JsonConverter.jsonToObject(UserInfo.class, userJson);
            return;
        }
        mUserInfo = new UserInfo();
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public void login(UserInfo userInfo) {
        saveUserInfo(userInfo);
        onLoginStatusChanged();
        mContext.getGlobalComponent().getGlobalBus().post(new LoginEvent());
    }

    public Subscription loadUserInfo() {
        Subscription getUserInfoSubscription = mAuthService.getUserInfo(mUserInfo.getMemberId
                (), mUserInfo.getToken()).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new UiRpcSubscriber<UserInfo>
                        (mContext) {
                    @Override
                    protected void onSuccess(UserInfo info) {
                        saveUserInfo(info);
                        switchUserInfo();
                        mContext.getGlobalComponent().getGlobalBus().post(new UserInfoChangedEvent());
                    }

                    @Override
                    protected void onEnd() {

                    }
                });
        mSubscriptions.add(getUserInfoSubscription);
        return getUserInfoSubscription;
    }

    private Subscription updateUserInfo() {

        Subscription updateUserInfoSubscription = mUserService.updateUser(mUserInfo.getMemberId(), mUserInfo.getToken()).subscribeOn
                (Schedulers
                        .newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new UiRpcSubscriber<UserInfo>(mContext) {

            @Override
            protected void onSuccess(UserInfo info) {
                saveUserInfo(info);
                switchUserInfo();
                mContext.getGlobalComponent().getGlobalBus().post(new UserInfoChangedEvent());
            }

            @Override
            public void onApiError(RpcApiError apiError) {
                super.onApiError(apiError);
                mContext.getGlobalComponent().getGlobalBus().post(new UserInfoChangedEvent(false));
            }

            @Override
            protected void onEnd() {

            }

        });
        mSubscriptions.add(updateUserInfoSubscription);
        return updateUserInfoSubscription;
    }

    private void saveUserInfo(UserInfo userInfo) {
        mContext.getGlobalComponent().appPreferences().put(CustomAppPreferences.KEY_USER_INFO,
                JsonConverter
                        .objectToJson(userInfo));
        mContext.getGlobalComponent().appPreferences().put(CustomAppPreferences.KEY_USER_ID, userInfo
                .getMemberId());
        mContext.getGlobalComponent().appPreferences().put(CustomAppPreferences.KEY_USER_TYPE,
                userInfo.getType());
    }

    public void logout() {
        mContext.getGlobalComponent().appPreferences().remove(CustomAppPreferences.KEY_USER_INFO);
        mContext.getGlobalComponent().appPreferences().remove(CustomAppPreferences.KEY_USER_ID);
        mContext.getGlobalComponent().appPreferences().remove(CustomAppPreferences.KEY_USER_TYPE);
        mContext.getGlobalComponent().appPreferences().remove(CustomAppPreferences.KEY_COOKIE_SESSION_ID);
        mContext.getGlobalComponent().getGlobalBus().post(new LogoutEvent());
        onLoginStatusChanged();
    }

    public void onLoginStatusChanged() {
        switchUserInfo();
    }

    public void onDestroy() {
        //mSubscriptions.unsubscribe();
    }

    public UserInfoChangeBuilder userInfoChangeBuilder() {
        return new UserInfoChangeBuilder();
    }

    public class UserInfoChangeBuilder {

        public Subscription update() {
            return updateUserInfo();
        }

        public UserInfoChangeBuilder setPortrait(String avart) {
            mUserInfo.setPortrait(avart);
            return this;
        }


        public UserInfoChangeBuilder setAgeStage(String ageStage) {
            mUserInfo.setAgeStage(ageStage);
            return this;
        }


        public UserInfoChangeBuilder setDevId(String devId) {
            mUserInfo.setDevId(devId);
            return this;
        }


        public UserInfoChangeBuilder setGender(String gender) {
            mUserInfo.setGender(gender);
            return this;
        }


        public UserInfoChangeBuilder setIntroduce(String introduce) {
            mUserInfo.setSignature(introduce);
            return this;
        }

        public UserInfoChangeBuilder setInviteCode(String inviteCode) {
            mUserInfo.setInviteCode(inviteCode);
            return this;
        }


        public UserInfoChangeBuilder setLoginTime(Object loginTime) {
            mUserInfo.setLoginTime(loginTime);
            return this;
        }

        public UserInfoChangeBuilder setMobileNo(String mobileNo) {
            mUserInfo.setMobileNo(mobileNo);
            return this;
        }


        public UserInfoChangeBuilder setMyCity(String myCity) {
            mUserInfo.setMyCity(myCity);
            return this;
        }


        public UserInfoChangeBuilder setPassword(String password) {
            mUserInfo.setPassword(password);
            return this;
        }


        public UserInfoChangeBuilder setRegisterDate(Object registerDate) {
            mUserInfo.setRegisterDate(registerDate);
            return this;
        }


        public UserInfoChangeBuilder setThirdAccount(String thirdAccount) {
            mUserInfo.setThirdAccount(thirdAccount);
            return this;
        }


        public UserInfoChangeBuilder setType(int type) {
            mUserInfo.setType(type);
            return this;
        }

        public UserInfoChangeBuilder setMemberId(int memberId) {
            mUserInfo.setMemberId(memberId);
            return this;
        }

        public UserInfoChangeBuilder setRealName(String realName) {
            mUserInfo.setRealName(realName);
            return this;
        }


        public UserInfoChangeBuilder setNickName(String nickName) {
            mUserInfo.setNickName(nickName);
            return this;
        }

    }
}
