package cn.edu.pku.dyacong.bean;

import android.util.Log;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import cn.edu.pku.zhangqixun.miniweather.MainActivity;

/**
 * Created by Administrator on 2018/10/11.
 */

public class TodayWeather {
    private String city;
    private String updatetime;
    private String wendu;
    private String shidu;
    private String pm25;
    private String quality;
    private String fengxiang;
    private String fengli;
    private String date;
    private String high;
    private String low;
    private String type;
    public String getCity(){
        return city;
    }
    public String getUpdatetime() {
        return updatetime;
    }

    public String getWendu() {
        return wendu;
    }

    public String getPm25() {
        return pm25;
    }

    public String getQuality() {
        return quality;
    }
    public String getShidu() {
        return shidu;
    }
    public String getFengxiang() {
        return fengxiang;
    }

    public String getFengli() {
        return fengli;
    }

    public String getDate() {
        return date;
    }

    public String getHigh() {
        return high;
    }

    public String getLow() {
        return low;
    }

    public String getType() {
        return type;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFengli(String fengli) {
        this.fengli = fengli;
    }

    public void setFengxiang(String fengxiang) {
        this.fengxiang = fengxiang;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    @Override
    public String toString() {
        return "TodayWeather{"+
                "city='"+ city +'\''+
                ",updatetime='"+ updatetime+'\''+
                ",wendu='" + wendu+ '\''+
                ",shidu='" + shidu+'\''+
                ",pm25='"+pm25+'\''+
                ",quality='"+ quality+'\''+
                ",fengxiang='"+ fengxiang+'\''+
                ",fengli='"+ fengli+'\''+
                ",date='"+ date+'\''+
                ",high='"+ high+'\''+
                ",low='"+ low+'\''+
                ",type='"+ type+'\''+
                '}';
    }

    private TodayWeather parseXML(String xmldata){
        TodayWeather todayWeather = null;
        int fengxiangCount=0;
        int fengliCount =0;
        int dateCount=0;
        int highCount =0;
        int lowCount=0;
        int typeCount =0;
        try {
            XmlPullParserFactory fac = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = fac.newPullParser();
            xmlPullParser.setInput(new StringReader(xmldata));
            int eventType = xmlPullParser.getEventType();
            Log.d("myWeather", "parseXML");
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
// 判断当前事件是否为文档开始事件
                    case XmlPullParser.START_DOCUMENT:
                        break;
// 判断当前事件是否为标签元素开始事件
                    case XmlPullParser.START_TAG:
                        if(xmlPullParser.getName().equals("resp"
                        )){
                            todayWeather= new TodayWeather();
                        }if (todayWeather != null) {
                        if (xmlPullParser.getName().equals("city")) {
                                eventType = xmlPullParser.next()
                        ;todayWeather.setCity(xmlPullParser.getText());
                    } else if (xmlPullParser.getName().equals("updatetime")) {
                        eventType = xmlPullParser.next()
                        ;todayWeather.setUpdatetime(xmlPullParser.getText());
                    } else if (xmlPullParser.getName().equals("shidu")) {
                        eventType = xmlPullParser.next();
                            todayWeather.setShidu(xmlPullParser.getText());
                    } else if (xmlPullParser.getName().equals("wendu")) {
                        eventType = xmlPullParser.next();
                        todayWeather.setWendu(xmlPullParser.getText());
                    } else if (xmlPullParser.getName().equals("pm25")) {
                        eventType = xmlPullParser.next()
                        ;todayWeather.setPm25(xmlPullParser.getText());
                    } else if (xmlPullParser.getName().equals("quality")) {
                        eventType = xmlPullParser.next()
                        ;todayWeather.setQuality(xmlPullParser.getText());
                    } else if (xmlPullParser.getName().equals("fengxiang") && fengxiangCount == 0) {
                        eventType = xmlPullParser.next()
                        ;todayWeather.setFengxiang(xmlPullParser.getText());
                        fengxiangCount++;
                    } else if (xmlPullParser.getName().equals("fengli") && fengliCount == 0) {
                        eventType = xmlPullParser.next()
                        ;todayWeather.setFengli(xmlPullParser.getText());
                        fengliCount++;
                    } else if (xmlPullParser.getName().equals("date") && dateCount == 0) {
                        eventType = xmlPullParser.next()
                        ;todayWeather.setDate(xmlPullParser.getText());
                        dateCount++;
                    } else if (xmlPullParser.getName().equals("high") && highCount == 0) {
                        eventType = xmlPullParser.next();
                        todayWeather.setHigh(xmlPullParser.getText().substring(2).trim());
                        highCount++;
                    } else if (xmlPullParser.getName().equals("low") && lowCount == 0) {
                        eventType = xmlPullParser.next()
                        ;todayWeather.setLow(xmlPullParser.getText().substring(2).trim());
                        lowCount++;
                    } else if (xmlPullParser.getName().equals("type") && typeCount == 0) {
                        eventType = xmlPullParser.next()
                        ;todayWeather.setType(xmlPullParser.getText());
                        typeCount++;
                    }}break;
// 判断当前事件是否为标签元素结束事件
                case XmlPullParser.END_TAG:
                    break;
            }// 进入下一个元素并触发相应事件
            eventType = xmlPullParser.next();
        }} catch (XmlPullParserException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return todayWeather;

}}




