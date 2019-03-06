package com.simon.clipboard.service;

import android.app.Service;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.google.gson.Gson;
import com.simon.clipboard.common.BaseApplication;
import com.simon.clipboard.common.config.AppConfig;
import com.simon.clipboard.common.interfaces.RequestServes;
import com.simon.clipboard.common.util.LogUtil;
import com.simon.clipboard.entity.YdWordInfo;
import com.simon.clipboard.util.WindowUtils;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClipboardService extends Service {
    private static final String TAG = ClipboardService.class.getName();

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind");
        return null;
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        final ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        cm.addPrimaryClipChangedListener(new ClipboardManager.OnPrimaryClipChangedListener() {
            @Override
            public void onPrimaryClipChanged() {
                ClipData data = cm.getPrimaryClip();
                ClipData.Item item = data.getItemAt(0);
                //Log.i(TAG, item.getText().toString());
                /*Intent mIntent = new Intent();
                mIntent.setAction("com.cybertron.dict.ClipBoardReceiver");
                mIntent.putExtra("clipboardvalue", item.getText().toString());
                sendBroadcast(mIntent);*/

                if (null != item.getText() && !"".equals(item.getText().toString())) {
                    String q = item.getText().toString().trim();
                    q = wordWash(q);
                    if (null == q || "".equals(q)) {
                        return;
                    }

                    Retrofit retrofit2 = new Retrofit.Builder().baseUrl(AppConfig.YOUDAO_BASIC_URL)
//retrofit已经把Json解析封装在内部了 你需要传入你想要的解析工具就行了 默认支持Gson解析
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient()).build();
                    RequestServes requestServes2 = retrofit2.create(RequestServes.class);
                    //只获取网易有道的
                    Call<ResponseBody> call2 = requestServes2.jsonApi(2, "", q, "{\"count\":1,\"dicts\":[[\"ec\"]]}", "", "", "", "", "", "", "", "5g", "", "5.1");
                    call2.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            LogUtil.i(TAG, "success");
                            try {
                                //LogUtil.i(TAG, JSON.toJSONString(response.body().string()));
                                Gson gson = new Gson();
                                YdWordInfo wordInfo = gson.fromJson(response.body().string(), YdWordInfo.class);

                                StringBuffer sb = new StringBuffer();

                                if(null == wordInfo){
                                    return;
                                }

                                if (null == wordInfo.getEc()){
                                    return;
                                }

                                List<YdWordInfo.EcBean.WordBean> wordBeans = wordInfo.getEc().getWord();

                                if (wordBeans.size() <= 0) {
                                    return;
                                }
                                String ukphone = wordBeans.get(0).getUkphone();
                                if (null == ukphone) {
                                    ukphone = "";
                                }
                                sb.append("英 /" + ukphone + "/\n");
                                String usphone = wordBeans.get(0).getUsphone();
                                if (null == usphone) {
                                    usphone = "";
                                }
                                sb.append("美 /" + usphone + "/\n");

                                List<YdWordInfo.EcBean.WordBean.TrsBean> trsBeans = wordBeans.get(0).getTrs();
                                for (int i = 0; i < trsBeans.size(); i++) {
                                    sb.append(trsBeans.get(i).getTr().get(0).getL().getI().get(0) + "\n");
                                }

                                WindowUtils.showPopupWindow(BaseApplication.getInstance(), sb.toString());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            LogUtil.e(TAG, "failure");
                        }
                    });
                }
            }
        });
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    /**
     * 单词处理
     *
     * @param q
     * @return
     */
    private String wordWash(String q) {
        q = q.toLowerCase();

        //截取第一个单词
        if (q.indexOf(" ") > 0) {
            q = q.substring(0, q.indexOf(" "));
        }

        //去掉头部非字母内容
        char[] qArr = q.toCharArray();
        int startIndex = 0;
        while (!Character.isLetter(qArr[startIndex])) {
            startIndex++;
        }
        int endIndex = qArr.length - 1;
        while (!Character.isLetter(qArr[endIndex])) {
            endIndex--;
        }

        q = "";
        for (int i = startIndex; i <= endIndex; i++) {
            q += qArr[i];
        }
        //判断是否只有字母
        if (!Pattern.matches("^[a-z]+$", q)) {
            return "";
        }
        return q;
    }
}
