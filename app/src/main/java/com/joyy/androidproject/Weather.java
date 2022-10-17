package com.joyy.androidproject;

import java.util.ArrayList;
import java.util.List;

/**
 * {"results":[{"location":{"id":"WX4FBXXFKE4F","name":"北京","country":"CN","path":"北京,北京,中国","timezone":"Asia/Shanghai","timezone_offset":"+08:00"},"now":{"text":"晴","code":"0","temperature":"17"},"last_update":"2022-10-10T17:24:12+08:00"}]}
 */
public class Weather {

    private List<ResultsDTO> results = new ArrayList<>();

    public List<ResultsDTO> getResults() {
        return results;
    }

    public void setResults(List<ResultsDTO> results) {
        this.results = results;
    }


    @Override
    public String toString() {
        return "Weather{" +
                "results=" + results +
                '}';
    }

    public static class ResultsDTO {
        private LocationDTO location;
        private NowDTO now = new NowDTO();
        private String lastUpdate;

        public NowDTO getNow() {
            return now;
        }

        public void setNow(NowDTO now) {
            this.now = now;
        }

        @Override
        public String toString() {
            return "ResultsDTO{" +
                    "location=" + location +
                    ", now=" + now +
                    ", lastUpdate='" + lastUpdate + '\'' +
                    '}';
        }

        public static class LocationDTO {
            private String id;
            private String name;
            private String country;
            private String path;
            private String timezone;
            private String timezoneOffset;

            @Override
            public String toString() {
                return "LocationDTO{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        ", country='" + country + '\'' +
                        ", path='" + path + '\'' +
                        ", timezone='" + timezone + '\'' +
                        ", timezoneOffset='" + timezoneOffset + '\'' +
                        '}';
            }
        }

        public static class NowDTO {
            private String text; // 晴
            private String code; //code
            private String temperature; // 温度

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            @Override
            public String toString() {
                return "NowDTO{" +
                        "text='" + text + '\'' +
                        ", code='" + code + '\'' +
                        ", temperature='" + temperature + '\'' +
                        '}';
            }
        }
    }
}
//{
//    "results":[
//        {
//            "location":{
//                "id":"WX4FBXXFKE4F",
//                "name":"北京",
//                "country":"CN",
//                "path":"北京,北京,中国",
//                "timezone":"Asia/Shanghai",
//                "timezone_offset":"+08:00"
//            },
//            "now":{
//                "text":"晴",
//                "code":"0",
//                "temperature":"17"
//            },
//            "last_update":"2022-10-10T17:24:12+08:00"
//        }
//    ]
//}
