package com.soares.pedro.mvvmdroid.Services.Interfaces;

import android.app.DatePickerDialog;
import android.content.DialogInterface;

public interface IDialogService extends IService {

    public void showLongSnackBar(String text);

    public void showShortSnackBar(String text);

    public void showLongToast(String text);

    public void showShortToast(String text);

    public void showLongSnackBar(int text);

    public void showShortSnackBar(int text);

    public void showLongToast(int text);

    public void showShortToast(int text);

    public void showDialog(String title, String message);

    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction);

    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, String positiveText);

    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction);

    public void showDialog(String title, String message, boolean isCancelable,
                           DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction,
                           String positiveText, String negativeText);

    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action);
}
