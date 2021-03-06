package com.testeandroidv2.bank.statementScreen;


import java.lang.ref.WeakReference;
import java.util.ArrayList;

interface StatementPresenterInput {
    void presentStatementHeaderData(StatementHeaderResponse response);
//    void processRequestFetchStatement(StatementModel response);
//    void processRequestFetchStatement(StatementList response);
    void processRequestFetchStatement(StatementResponse response);
    void processErrorRequest(String error);
}


public class StatementPresenter implements StatementPresenterInput {

    public static String TAG = StatementPresenter.class.getSimpleName();

    public WeakReference<StatementActivityInput> output;


    @Override
    public void presentStatementHeaderData(StatementHeaderResponse response) {
        StatementHeaderViewModel statementHeaderViewModel = new StatementHeaderViewModel();
        statementHeaderViewModel.name = response.name;
        statementHeaderViewModel.bankAccount = response.bankAccount;
        statementHeaderViewModel.balance = "R$"+response.balance;
        output.get().displayStatementDataHeader(statementHeaderViewModel);
    }

    @Override
    public void processRequestFetchStatement(StatementResponse response) {
//    public void processRequestFetchStatement(StatementList response) {
//        public void processRequestFetchStatement(StatementModel response) {
        StatementViewModel statementViewModel = new StatementViewModel();
        statementViewModel.list = new ArrayList<>();
        if (response.list != null) {
            for(StatementModel sm : response.list) {
                StatementViewModel svm = new StatementViewModel();
                svm.date = sm.getDate();
                svm.desc = sm.getDesc();
                svm.title = sm.getTitle();
                svm.value = sm.getValue();

                statementViewModel.list.add(svm);
            }
            output.get().displayStatementData(statementViewModel);
        }
        else {
            processErrorRequest(null);
        }
    }

    @Override
    public void processErrorRequest(String error) {
        if(null == error) {
            String msg = "Null response from server";
            output.get().callApiError(msg);
        }
        else {
            output.get().callApiError(error);
        }
    }


}
