package com.soares.pedro.mvvmdroid.Models;

public class FragmentView {
    private String activity, view;
    private int container;
    private Class type;
    private boolean applyAfterLayout;

    public FragmentView(String activity, String view, int container, Class type) {
        this(activity, view, container, type, true);
    }

    public FragmentView(String activity, String view, int container, Class type, boolean applyAfterLayout) {
        this.activity = activity;
        this.view = view;
        this.container = container;
        this.type = type;
        this.applyAfterLayout = applyAfterLayout;
    }

    public String getActivity() {
        return activity;
    }

    public String getView() {
        return view;
    }

    public int getContainer() {
        return container;
    }

    public Class getType() {
        return type;
    }

    public boolean isApplyAfterLayout() {
        return applyAfterLayout;
    }
}
