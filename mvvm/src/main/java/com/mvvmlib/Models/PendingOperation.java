package com.mvvmlib.Models;

import java.util.HashMap;

public class PendingOperation {
    private FragmentView fragmentView;
    private HashMap<String, Object> map;
    private boolean applyAfterLayout;

    public PendingOperation(FragmentView framentView, HashMap<String, Object> map) {
        this(framentView, map, true);
    }

    public PendingOperation(FragmentView framentView, HashMap<String, Object> map, boolean applyAfterLayout) {
        this.fragmentView = framentView;
        this.map = map;
        this.applyAfterLayout = applyAfterLayout;
    }

    public FragmentView getFragmentView() {
        return fragmentView;
    }

    public HashMap<String, Object> getMap() {
        return map;
    }

    public boolean isApplyAfterLayout() {
        return applyAfterLayout;
    }
}
