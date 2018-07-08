package com.example.lbc.mfcproject.data.source;

import android.content.Context;

import com.example.lbc.mfcproject.data.Id;
import com.example.lbc.mfcproject.data.source.remote.PointRemoteDataSource;

import java.util.List;

/**
 * Created by lbc on 2018-01-08.
 */

public class PointRepository implements PointDataSource {

    private PointRemoteDataSource pointRemoteDataSource = new PointRemoteDataSource();
    private static PointRepository pointRepository;

    public static PointRepository getInstance() {
        if (pointRepository==null) {
            pointRepository = new PointRepository();
        }
        return pointRepository;
    }

    @Override
    public void findRank(Context context, List<Id> ids, final LoadDataCallBack loadDataCallBack) {
        pointRemoteDataSource.findRank(context, ids, new LoadDataCallBack() {
            @Override
            public void onLoadData(List<Id> ids) {
                loadDataCallBack.onLoadData(ids);
            }

            @Override
            public void onFailData(String errorMsg) {
                loadDataCallBack.onFailData(errorMsg);
            }
        });
    }
}
