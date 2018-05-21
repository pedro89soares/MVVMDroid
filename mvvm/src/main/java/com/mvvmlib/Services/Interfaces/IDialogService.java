package com.mvvmlib.Services.Interfaces;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;

import java.util.Date;

public interface IDialogService extends IService {

    /**
     *
     * @param text
     */
    public void showLongSnackBar(String text);

    /**
     *
     * @param text
     */
    public void showShortSnackBar(String text);

    /**
     *
     * @param text
     */
    public void showLongToast(String text);

    /**
     *
     * @param text
     */
    public void showShortToast(String text);

    /**
     *
     * @param text
     */
    public void showLongSnackBar(int text);

    /**
     *
     * @param text
     */
    public void showShortSnackBar(int text);

    /**
     *
     * @param text
     */
    public void showLongToast(int text);

    /**
     *
     * @param text
     */
    public void showShortToast(int text);

    /**
     *
     * @param title
     * @param message
     */
    public void showDialog(String title, String message);

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     */
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction);

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param positiveText
     */
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, String positiveText);

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param negativeAction
     */
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction);

    /**
     *
     * @param title
     * @param message
     * @param isCancelable
     * @param positiveAction
     * @param negativeAction
     * @param positiveText
     * @param negativeText
     */
    public void showDialog(String title, String message, boolean isCancelable,
                           DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction,
                           String positiveText, String negativeText);

    /**
     *
     * @param action
     */
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action);

    /**
     *
     * @param action
     */
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action);

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    public void showLongSnackBar(String text, boolean forceExecuteOnUIThread);

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    public void showShortSnackBar(String text, boolean forceExecuteOnUIThread);

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    public void showLongToast(String text, boolean forceExecuteOnUIThread);

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    public void showShortToast(String text, boolean forceExecuteOnUIThread);

    /**
     * @param text
     * @param forceExecuteOnUIThread
     */
    public void showLongSnackBar(int text, boolean forceExecuteOnUIThread);

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    public void showShortSnackBar(int text, boolean forceExecuteOnUIThread);

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    public void showLongToast(int text, boolean forceExecuteOnUIThread);

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    public void showShortToast(int text, boolean forceExecuteOnUIThread);

    /**
     *
     * @param title
     * @param message
     * @param forceExecuteOnUIThread
     */
    public void showDialog(String title, String message, boolean forceExecuteOnUIThread);

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param forceExecuteOnUIThread
     */
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, boolean forceExecuteOnUIThread);

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param positiveText
     * @param forceExecuteOnUIThread
     */
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, String positiveText, boolean forceExecuteOnUIThread);

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param negativeAction
     * @param forceExecuteOnUIThread
     */
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction, boolean forceExecuteOnUIThread);

    /**
     *
     * @param title
     * @param message
     * @param isCancelable
     * @param positiveAction
     * @param negativeAction
     * @param positiveText
     * @param negativeText
     * @param forceExecuteOnUIThread
     */
    public void showDialog(String title, String message, boolean isCancelable,
                           DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction,
                           String positiveText, String negativeText, boolean forceExecuteOnUIThread);

    /**
     *
     * @param action
     * @param initialDate
     * @param forceExecuteOnUIThread
     */
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action, Date initialDate, boolean forceExecuteOnUIThread);

    /**
     *
     * @param action
     * @param forceExecuteOnUIThread
     */
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action, boolean forceExecuteOnUIThread);

    /**
     *
     * @param action
     * @param initialHours
     * @param initialMinutes
     * @param forceExecuteOnUIThread
     */
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action, int initialHours, int initialMinutes, boolean forceExecuteOnUIThread);

    /**
     *
     * @param action
     * @param forceExecuteOnUIThread
     */
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action, boolean forceExecuteOnUIThread);
}
