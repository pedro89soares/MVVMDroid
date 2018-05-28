package com.mvvmlib.models;

public class FragmentView {
    private String activity, view;
    private int container;
    private Class type;

    public FragmentView(String activity, String view, int container, Class type) {
        this.activity = activity;
        this.view = view;
        this.container = container;
        this.type = type;
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
}
