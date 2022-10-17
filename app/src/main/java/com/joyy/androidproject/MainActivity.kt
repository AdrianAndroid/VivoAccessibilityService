package com.joyy.androidproject

import android.icu.text.SimpleDateFormat
import android.os.*
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*

/**
 * https://kalacloud.com/blog/free-weather-api/
 * https://dev.qweather.com/
 * https://dev.qweather.com/docs/android-sdk/weather/android-weather-hourly-forecast/
 *
 * 获取实时天气-天气实况
 * https://seniverse.yuque.com/docs/share/cd531fe7-714d-4bd7-8113-55adeaec54af?#%20%E3%80%8A%E5%A4%A9%E6%B0%94%E5%AE%9E%E5%86%B5%E3%80%8B
 * https://api.seniverse.com/v3/weather/now.json?key=SlZjcr1nW8tuvzvd6&location=beijing&language=zh-Hans&unit=c
 * {"results":[{"location":{"id":"WX4FBXXFKE4F","name":"北京","country":"CN","path":"北京,北京,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"},"now":{"text":"晴","code":"0","temperature":"17"},"last_update":"2022-10-10T17:24:12+08:00"}]}
 *
 * 极速实况
 * https://seniverse.yuque.com/docs/share/6947fcea-eec6-41c4-b7d7-7e9c01a5dc08?#%20%E3%80%8A%E6%9E%81%E9%80%9F%E5%AE%9E%E5%86%B5%E3%80%8B
 * https://api.seniverse.com/v3/pro/weather/grid/moment.json?key=SlZjcr1nW8tuvzvd6&location=29.6024:106.6572&language=zh-Hans&unit=c&advanced=2.1
 *
 * 116.414898,39.928688
 * https://api.seniverse.com/v3/pro/weather/grid/now.json?key=SlZjcr1nW8tuvzvd6&location=39.865927:116.359805
 *
 * 定时任务
 * https://www.jianshu.com/p/67328d9d7b65
 *
 * 知心天气
 */
class MainActivity : AppCompatActivity(), Handler.Callback {

    lateinit var weatherTextView: TextView
    lateinit var btn: Button
    private val timer: Timer = Timer()
    private val handler: Handler = Handler(Looper.myLooper()!!, this)

    @RequiresApi(Build.VERSION_CODES.N)
    private val format: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.ENGLISH)


    override fun onCreate(savedInstanceState: Bundle?) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        window.decorView.apply {
            systemUiVisibility =
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }


        weatherTextView = findViewById(R.id.weather)
        btn = findViewById(R.id.btn)

        timer.schedule(object : TimerTask() {
            override fun run() {
                initButton()
            }
        }, 0, 5000)
        handler.sendEmptyMessage(0)
    }

    private fun initButton() {
        OKHttpUtils.getWeather { weather: Weather ->
            Log.i("MainActivity", weather.toString())
            if (weather.results.isEmpty()) {
                runOnUiThread { weatherTextView.text = "数据为空,可能网络未连接" }
            } else {
                val first: Weather.ResultsDTO = weather.results.first()
                val format = String.format(
                    Locale.ENGLISH,
                    "天气:%s 温度:%s℃",
                    first.now.text,
                    first.now.temperature
                )
                runOnUiThread { weatherTextView.text = format }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun handleMessage(msg: Message): Boolean {
        if (msg.what == 0) {
            btn.text = format.format(Date(System.currentTimeMillis()))
            handler.sendEmptyMessageDelayed(0, 1000)
//            long sysTime = System.currentTimeMillis();//获取系统时间
//            CharSequence sysTimeStr = DateFormat.format("hh:mm:ss", sysTime);//时间显示格式
//            btn.setText(sysTimeStr); //更新时间
        }
        return true
    }
}