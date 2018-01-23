package com.cangjie.basetool.mvp.base;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cangjie.basetool.BaseToolStyle;
import com.cangjie.basetool.R;
import com.cangjie.basetool.utils.AnimationHelper;
import com.cangjie.basetool.utils.ToastHelper;

import static com.cangjie.basetool.R.id.iv_base_head_back;
import static com.cangjie.basetool.R.id.view_divide_line;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseHeadFragment extends BaseFragment {

	public View baseView;

    public RelativeLayout rel_contentArea;
    TextView tv_headTitle;

    private FrameLayout fl_back_container;
    ImageView iv_backButton;

    RelativeLayout mLoading;
    RelativeLayout rel_base_headArea;

    private FrameLayout fl_right_container;
    private ImageButton ib_base_head_right_button;
    private TextView tv_base_head_right_button;

    private View view_divide_line;
    public BaseHeadFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
		super.onCreateView(inflater,container,savedInstanceState);
        baseView = inflater.inflate(R.layout.base_head, container, false);
        assignHeadViews(baseView);
        defineHeadStyle();
        return baseView;
    }

    private void assignHeadViews(View baseView) {
        rel_contentArea = (RelativeLayout) baseView.findViewById(R.id.rel_base_contentArea);

        fl_back_container = (FrameLayout) baseView.findViewById(R.id.fl_back);
        iv_backButton = (ImageView) baseView.findViewById(iv_base_head_back);
        tv_headTitle = (TextView) baseView.findViewById(R.id.tv_base_head_title);

        fl_right_container = (FrameLayout) baseView.findViewById(R.id.fl_right_container);
        ib_base_head_right_button = (ImageButton) baseView.findViewById(R.id.ib_base_head_right_button);
        tv_base_head_right_button = (TextView) baseView.findViewById(R.id.tv_base_head_right_button);


        mLoading = (RelativeLayout) baseView.findViewById(R.id.rel_base_loading);
        rel_base_headArea = (RelativeLayout) baseView.findViewById(R.id.rel_base_headArea);

        view_divide_line = baseView.findViewById(R.id.view_divide_line);
    }

    public View setContentView(View view) {
        rel_contentArea.addView(view);
        return baseView;
    }

    protected void hideHeadArea() {
        rel_base_headArea.setVisibility(View.GONE);
    }

    protected void showHeadArea(){
        rel_base_headArea.setVisibility(View.VISIBLE);
    }


    public void showLoading() {
        mLoading.setVisibility(View.VISIBLE);
    }

    public void hideLoading() {
        AnimationHelper.crossfade(mLoading, rel_contentArea, getResources().getInteger(android.R.integer.config_shortAnimTime));
    }

    public void showBackButton() {
        this.showBackButton(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    public void showBackButton(OnClickListener listener) {
        fl_back_container.setOnClickListener(listener);
        fl_back_container.setVisibility(View.VISIBLE);
    }

    public void showTitle(String title) {
        tv_headTitle.setText(title);
    }

    public void hideTitle() {
        tv_headTitle.setVisibility(View.GONE);
    }

    public void showRightImageButton(int drawable, OnClickListener listener){
        ib_base_head_right_button.setBackground(getResources().getDrawable(drawable));
        ib_base_head_right_button.setOnClickListener(listener);
        fl_right_container.setVisibility(View.VISIBLE);
        ib_base_head_right_button.setVisibility(View.VISIBLE);
    }

    /**
     * tv_base_head_right_button  android:maxLength="6"
     */
    public void showRightTextView(String text, int size, int color, boolean isBold, OnClickListener listener){
        tv_base_head_right_button.setText(text);
        tv_base_head_right_button.setOnClickListener(listener);
        tv_base_head_right_button.setTextColor(getResources().getColor(color));
        tv_base_head_right_button.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        if (isBold){
            tv_base_head_right_button.setTypeface(null, Typeface.BOLD);
        }
        fl_right_container.setVisibility(View.VISIBLE);
        tv_base_head_right_button.setVisibility(View.VISIBLE);
    }

    public void disPlay(String s) {
        ToastHelper.showToast(s, mActivity);
    }

    /**
     *
     textView.setTypeface(null, Typeface.BOLD_ITALIC);
     textView.setTypeface(null, Typeface.BOLD);
     textView.setTypeface(null, Typeface.ITALIC);
     textView.setTypeface(null, Typeface.NORMAL);
     */
    private void defineHeadStyle() {
        rel_base_headArea.setBackgroundColor(getResources().getColor(BaseToolStyle.CONTENT_BACKGROUND_COLOR));
        iv_backButton.setBackground(getResources().getDrawable(BaseToolStyle.BACK_BUTTON_DRAWABLE));
        tv_headTitle.setTextColor(getResources().getColor(BaseToolStyle.TITLE_TEXT_COLOR));
        tv_headTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, BaseToolStyle.TITLE_TEXT_SIZE);
        if (BaseToolStyle.TITLE_IS_BOLD){
            tv_headTitle.setTypeface(null, Typeface.BOLD);
        }
    }

    public void showDivideLine(){
        view_divide_line.setVisibility(View.VISIBLE);
    }
    public void showDivideLine(int color){
        view_divide_line.setBackgroundColor(color);
        showDivideLine();
    }

    public void hideDivideLine(){
        view_divide_line.setVisibility(View.GONE);
    }
}
