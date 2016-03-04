package com.github.snowdream.apps.retirement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by yanghui.yangh on 2016/3/4.
 */
public class MainFragment extends Fragment implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    private TextView mTextViewResult = null;
    private Button mButtonCaculate = null;
    private EditText mEditTextYearOfbirth = null;
    private RadioGroup mRadioGroupType = null;
    private Person.Role mRole = Person.Role.MAN;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTextViewResult = (TextView) view.findViewById(R.id.textview_result);
        mEditTextYearOfbirth = (EditText) view.findViewById(R.id.editText_yearOfbirth);
        mButtonCaculate = (Button) view.findViewById(R.id.button_caculate);
        mButtonCaculate.setOnClickListener(this);
        mRadioGroupType = (RadioGroup) view.findViewById(R.id.radioType);
        mRadioGroupType.setOnCheckedChangeListener(this);

        AdView mAdView = (AdView) view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_caculate) {
            caculateNewRetirementAge();
        }
    }

    /**
     * 计算新的退休年龄
     */
    private void caculateNewRetirementAge() {
        if (!verify()) return;

        Person person = getPerson();
        float newRetirementAge = person.getNewRetirementAge();
        mTextViewResult.setText(String.format("%.2f",newRetirementAge));
    }

    /**
     * 校验输入内容
     *
     * @return
     */
    private boolean verify() {
        if (TextUtils.isEmpty(mEditTextYearOfbirth.getText())) {
            Toast.makeText(getActivity(), R.string.hint_input_yearofbirth, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private Person getPerson() {
        try {
            int yearOfbirth = Integer.parseInt(mEditTextYearOfbirth.getText().toString());

            return new Person(mRole, yearOfbirth);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.radioMale) {
            mRole = Person.Role.MAN;
        } else if (checkedId == R.id.radioFemaleCommon) {
            mRole = Person.Role.WOMAN_COMMON;
        } else {
            mRole = Person.Role.WOMAN_LEADER;
        }
    }
}
