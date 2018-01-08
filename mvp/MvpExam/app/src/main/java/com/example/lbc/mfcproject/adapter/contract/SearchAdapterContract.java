package com.example.lbc.mfcproject.adapter.contract;

import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lbc on 2018-01-08.
 */

public interface SearchAdapterContract {
    interface View {
        void setOnclickListener(OnItemClickListener onclickListener);

        void notifyAdapter();
    }

    interface Model {
        void addItems(List<Id> ids);

        void clearItem();

        Id getId(int position);
    }

}
