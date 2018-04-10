package com.soares.pedro.mvvmdroid.Services.Interfaces;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;

import java.util.Date;

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

    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action);

    public void showLongSnackBar(String text, boolean forceExecuteOnUIThread);

    public void showShortSnackBar(String text, boolean forceExecuteOnUIThread);

    public void showLongToast(String text, boolean forceExecuteOnUIThread);

    public void showShortToast(String text, boolean forceExecuteOnUIThread);

    public void showLongSnackBar(int text, boolean forceExecuteOnUIThread);

    public void showShortSnackBar(int text, boolean forceExecuteOnUIThread);

    public void showLongToast(int text, boolean forceExecuteOnUIThread);

    public void showShortToast(int text, boolean forceExecuteOnUIThread);

    public void showDialog(String title, String message, boolean forceExecuteOnUIThread);

    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, boolean forceExecuteOnUIThread);

    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, String positiveText, boolean forceExecuteOnUIThread);

    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction, boolean forceExecuteOnUIThread);

    public void showDialog(String title, String message, boolean isCancelable,
                           DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction,
                           String positiveText, String negativeText, boolean forceExecuteOnUIThread);

    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action, Date initialDate, boolean forceExecuteOnUIThread);

    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action, boolean forceExecuteOnUIThread);

    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action, int initialHours, int initialMinutes, boolean forceExecuteOnUIThread);

    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action, boolean forceExecuteOnUIThread);
}
