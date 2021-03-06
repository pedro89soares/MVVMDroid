package com.mvvmlib.services;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.mvvmlib.services.interfaces.IDialogService;
import com.soares.pedro.mvvmlib.R;

import java.util.Date;
import java.util.Calendar;

public class DialogService extends BaseService implements IDialogService {

    public DialogService() {
        super();
    }

    /**
     *
     * @return Root View of Current Activity
     */
    private View getCurrentActivityRootView() {
        Activity activity = getCurrentActivity();
        if (activity == null) return null;
        return activity.findViewById(android.R.id.content);
    }

    /**
     *
     * @param text
     */
    @Override
    public void showLongSnackBar(String text) {
        this.showLongSnackBar(text, false);
    }

    /**
     *
     * @param text
     */
    @Override
    public void showShortSnackBar(String text) {
        this.showShortSnackBar(text, false);
    }

    /**
     *
     * @param text
     */
    @Override
    public void showLongToast(String text) {
        this.showLongToast(text, false);
    }

    /**
     *
     * @param text
     */
    @Override
    public void showShortToast(String text) {
        this.showShortToast(text, false);
    }

    /**
     *
     * @param text resource
     */
    @Override
    public void showLongSnackBar(int text) {
        this.showLongSnackBar(text, false);
    }

    /**
     *
     * @param text resource
     */
    @Override
    public void showShortSnackBar(int text) {
        this.showShortSnackBar(text, false);
    }

    /**
     *
     * @param text resource
     */
    @Override
    public void showLongToast(int text) {
        this.showLongToast(text, false);
    }

    /**
     *
     * @param text resource
     */
    @Override
    public void showShortToast(int text) {
        this.showShortToast(text, false);
    }

    /**
     *
     * @param title
     * @param message
     */
    @Override
    public void showDialog(String title, String message) {
        this.showDialog(title, message, false);
    }

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     */
    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction) {
        this.showDialog(title, message, positiveAction, false);
    }

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param positiveText
     */
    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, String positiveText) {
        this.showDialog(title, message, positiveAction, positiveText, false);
    }

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param negativeAction
     */
    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction) {
        this.showDialog(title, message, positiveAction, negativeAction, false);
    }

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
    @Override
    public void showDialog(String title, String message, boolean isCancelable, DialogInterface.OnClickListener positiveAction, DialogInterface.OnClickListener negativeAction, String positiveText, String negativeText) {
        this.showDialog(title, message, isCancelable, positiveAction, negativeAction, positiveText, negativeText, false);
    }

    /**
     *
     * @param action
     */
    @Override
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action) {
        this.showDatePickerDialog(action, false);
    }

    /**
     *
     * @param action
     */
    @Override
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action) {
        this.showTimePickerDialog(action, false);
    }

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showLongSnackBar(String text, boolean forceExecuteOnUIThread) {
        View view = getCurrentActivityRootView();
        if (view == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> Snackbar.make(view, text, Snackbar.LENGTH_LONG).show());
        } else
            Snackbar.make(view, text, Snackbar.LENGTH_LONG).show();
    }

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showShortSnackBar(String text, boolean forceExecuteOnUIThread) {
        View view = getCurrentActivityRootView();
        if (view == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show());
        } else {
            Snackbar.make(view, text, Snackbar.LENGTH_SHORT).show();
        }
    }

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showLongToast(String text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> Toast.makeText(activity, text, Toast.LENGTH_LONG).show());
        } else {
            Toast.makeText(activity, text, Toast.LENGTH_LONG).show();
        }
    }

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showShortToast(String text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> Toast.makeText(activity, text, Toast.LENGTH_SHORT).show());
        } else {
            Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
        }

    }

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showLongSnackBar(int text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showLongSnackBar(getCurrentActivity().getString(text)));
        } else {
            showLongSnackBar(getCurrentActivity().getString(text));
        }
    }

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showShortSnackBar(int text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showShortSnackBar(getCurrentActivity().getString(text)));
        } else {
            showShortSnackBar(getCurrentActivity().getString(text));
        }
    }

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showLongToast(int text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showLongToast(getCurrentActivity().getString(text)));
        } else {
            showLongToast(getCurrentActivity().getString(text));
        }
    }

    /**
     *
     * @param text
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showShortToast(int text, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showShortToast(getCurrentActivity().getString(text)));
        } else {
            showShortToast(getCurrentActivity().getString(text));
        }
    }

    /**
     *
     * @param title
     * @param message
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showDialog(String title, String message, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showDialog(title, message, null));
        } else {
            showDialog(title, message, null);
        }
    }

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener
            positiveAction, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showDialog(title, message, positiveAction, (String) null));
        } else {
            showDialog(title, message, positiveAction, (String) null);
        }
    }

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param positiveText
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener
            positiveAction, String positiveText, boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showDialog(title, message, true, positiveAction, null, positiveText, null));
        } else {
            showDialog(title, message, true, positiveAction, null, positiveText, null);
        }
    }

    /**
     *
     * @param title
     * @param message
     * @param positiveAction
     * @param negativeAction
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showDialog(String title, String message, DialogInterface.OnClickListener
            positiveAction, DialogInterface.OnClickListener negativeAction,
                           boolean forceExecuteOnUIThread) {
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(() -> showDialog(title, message, true, positiveAction, negativeAction, null, null));
        } else {
            showDialog(title, message, true, positiveAction, negativeAction, null, null);
        }
    }

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
    @Override
    public void showDialog(String title, String message, boolean isCancelable,
                           DialogInterface.OnClickListener positiveAction, DialogInterface.
                                   OnClickListener negativeAction,
                           String positiveText, String negativeText, boolean forceExecuteOnUIThread) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(getCurrentActivity());
        dialog.setTitle(title == null ? "" : title);
        dialog.setMessage(message == null ? "" : message);
        dialog.setCancelable(isCancelable);

        if (positiveAction == null && negativeAction == null) {
            dialog.setPositiveButton(getContext()
                    .getResources().getText(R.string.defaultOk), (dialogInterface, i) -> {

            });
        } else {

            if (positiveAction != null) {
                dialog.setPositiveButton(positiveText == null ? getContext().getResources().getText(R.string.defaultOk) : positiveText, positiveAction);
            }
            if (negativeAction != null) {
                dialog.setNegativeButton(negativeText == null ? getContext().getResources().getText(R.string.defaultCancel) : negativeText, negativeAction);
            }
        }
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(dialog::show);
        } else {
            dialog.show();
        }
    }

    /**
     *
     * @param action
     * @param initialDate
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action, Date initialDate, boolean forceExecuteOnUIThread) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(initialDate);

        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        showDatePickerDialog(action, year, month, day, forceExecuteOnUIThread);
    }

    /**
     *
     * @param action
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showDatePickerDialog(DatePickerDialog.OnDateSetListener action,
                                     boolean forceExecuteOnUIThread) {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);

        showDatePickerDialog(action, year, month, day, forceExecuteOnUIThread);
    }

    /**
     *
     * @param action
     * @param year
     * @param month
     * @param day
     * @param forceExecuteOnUIThread
     */
    private void showDatePickerDialog(DatePickerDialog.OnDateSetListener action, int year, int month, int day, boolean forceExecuteOnUIThread) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getCurrentActivity(), action, year, month, day);
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(datePickerDialog::show);
        } else {
            datePickerDialog.show();
        }
    }

    /**
     *
     * @param action
     * @param initialHours
     * @param initialMinutes
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action, int initialHours, int initialMinutes, boolean forceExecuteOnUIThread) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(getCurrentActivity(), action, initialHours, initialMinutes, true);
        Activity activity = getCurrentActivity();
        if (activity == null) return;
        if (forceExecuteOnUIThread) {
            getCurrentActivity().runOnUiThread(timePickerDialog::show);
        } else {
            timePickerDialog.show();
        }
    }

    /**
     *
     * @param action
     * @param forceExecuteOnUIThread
     */
    @Override
    public void showTimePickerDialog(TimePickerDialog.OnTimeSetListener action,
                                     boolean forceExecuteOnUIThread) {

        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int minute = Calendar.getInstance().get(Calendar.MINUTE);

        this.showTimePickerDialog(action, hour, minute, forceExecuteOnUIThread);
    }
}
