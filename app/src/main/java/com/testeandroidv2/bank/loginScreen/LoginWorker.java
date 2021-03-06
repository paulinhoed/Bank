package com.testeandroidv2.bank.loginScreen;

import com.testeandroidv2.bank.util.CPFUtil;
import com.testeandroidv2.bank.util.EmailUtil;
import com.testeandroidv2.bank.util.PasswordUtil;

interface LoginWorkerInput {
    int verifyTextFieldsAreCorrect(LoginRequest request);
}

public class LoginWorker implements LoginWorkerInput {

    public int verifyTextFieldsAreCorrect(LoginRequest request) {
        LoginModel lm = new LoginModel();

        if ((null == request.user || request.user.isEmpty())
                && (null == request.password || request.password.isEmpty())) {
            //User empty and password empty
            lm.status = LoginStatusMessageEnum.EMPTY_FIELDS.getValue();
        } else if (null == request.password || request.password.isEmpty()) {
            //Password empty
            lm.status = LoginStatusMessageEnum.PASS_FIELD_EMPTY.getValue();
        } else if ((null == request.user || request.user.isEmpty())) {
            //User empty and password filled
            lm.status = LoginStatusMessageEnum.USER_FIELD_EMPTY.getValue();
        } else {
            if (request.user.contains(("@"))) {
                if (EmailUtil.isEmailValid(request.user)) {
                    if (PasswordUtil.isPasswordStrong(request.password)) {
                        lm.status = LoginStatusMessageEnum.FIELDS_OK.getValue();
                    } else {
                        lm.status = LoginStatusMessageEnum.INVALID_PASSWORD.getValue();
                    }
                } else {
                    //User(email) invalid
                    lm.status = LoginStatusMessageEnum.INVALID_USER_EMAIL.getValue();
                }
            } else {
                if (CPFUtil.isCPF(request.user)) {
                    if (PasswordUtil.isPasswordStrong(request.password)) {
                        lm.status = LoginStatusMessageEnum.FIELDS_OK.getValue();
                    } else {
                        lm.status = LoginStatusMessageEnum.INVALID_PASSWORD.getValue();
                    }
                } else {
                    //User(CPF) invalid
                    lm.status = LoginStatusMessageEnum.INVALID_USER_CPF.getValue();
                }
            }

        }
        return lm.status;
    }
}
