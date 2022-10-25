package com.joyy.androidproject;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * https://api.seniverse.com/v3/weather/daily.json?key=ScDaXQ_rWdohDuz2n&location=beijing&language=zh-Hans&unit=c&start=0&days=5
 */
public class PreWeather {


    @SerializedName("results")
    private List<ResultsDTO> results;

    public List<ResultsDTO> getResults() {
        return results;
    }

    public void setResults(List<ResultsDTO> results) {
        this.results = results;
    }

    public static class ResultsDTO {
        @SerializedName("location")
        private LocationDTO location;
        @SerializedName("daily")
        private List<DailyDTO> daily;
        @SerializedName("last_update")
        private String lastUpdate;

        public LocationDTO getLocation() {
            return location;
        }

        public void setLocation(LocationDTO location) {
            this.location = location;
        }

        public List<DailyDTO> getDaily() {
            return daily;
        }

        public void setDaily(List<DailyDTO> daily) {
            this.daily = daily;
        }

        public String getLastUpdate() {
            return lastUpdate;
        }

        public void setLastUpdate(String lastUpdate) {
            this.lastUpdate = lastUpdate;
        }

        public static class LocationDTO {
            @SerializedName("id")
            private String id;
            @SerializedName("name")
            private String name;
            @SerializedName("country")
            private String country;
            @SerializedName("path")
            private String path;
            @SerializedName("timezone")
            private String timezone;
            @SerializedName("timezone_offset")
            private String timezoneOffset;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCountry() {
                return country;
            }

            public void setCountry(String country) {
                this.country = country;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getTimezone() {
                return timezone;
            }

            public void setTimezone(String timezone) {
                this.timezone = timezone;
            }

            public String getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(String timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }
        }

        public static class DailyDTO {
            @SerializedName("date")
            private String date;
            @SerializedName("text_day")
            private String textDay;
            @SerializedName("code_day")
            private String codeDay;
            @SerializedName("text_night")
            private String textNight;
            @SerializedName("code_night")
            private String codeNight;
            @SerializedName("high")
            private String high;
            @SerializedName("low")
            private String low;
            @SerializedName("rainfall")
            private String rainfall;
            @SerializedName("precip")
            private String precip;
            @SerializedName("wind_direction")
            private String windDirection;
            @SerializedName("wind_direction_degree")
            private String windDirectionDegree;
            @SerializedName("wind_speed")
            private String windSpeed;
            @SerializedName("wind_scale")
            private String windScale;
            @SerializedName("humidity")
            private String humidity;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTextDay() {
                return textDay;
            }

            public void setTextDay(String textDay) {
                this.textDay = textDay;
            }

            public String getCodeDay() {
                return codeDay;
            }

            public void setCodeDay(String codeDay) {
                this.codeDay = codeDay;
            }

            public String getTextNight() {
                return textNight;
            }

            public void setTextNight(String textNight) {
                this.textNight = textNight;
            }

            public String getCodeNight() {
                return codeNight;
            }

            public void setCodeNight(String codeNight) {
                this.codeNight = codeNight;
            }

            public String getHigh() {
                return high;
            }

            public void setHigh(String high) {
                this.high = high;
            }

            public String getLow() {
                return low;
            }

            public void setLow(String low) {
                this.low = low;
            }

            public String getRainfall() {
                return rainfall;
            }

            public void setRainfall(String rainfall) {
                this.rainfall = rainfall;
            }

            public String getPrecip() {
                return precip;
            }

            public void setPrecip(String precip) {
                this.precip = precip;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public String getWindDirectionDegree() {
                return windDirectionDegree;
            }

            public void setWindDirectionDegree(String windDirectionDegree) {
                this.windDirectionDegree = windDirectionDegree;
            }

            public String getWindSpeed() {
                return windSpeed;
            }

            public void setWindSpeed(String windSpeed) {
                this.windSpeed = windSpeed;
            }

            public String getWindScale() {
                return windScale;
            }

            public void setWindScale(String windScale) {
                this.windScale = windScale;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
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
//            "daily":[
//                {
//                    "date":"2022-10-25",
//                    "text_day":"多云",
//                    "code_day":"4",
//                    "text_night":"阴",
//                    "code_night":"9",
//                    "high":"20",
//                    "low":"8",
//                    "rainfall":"0.00",
//                    "precip":"0.00",
//                    "wind_direction":"南",
//                    "wind_direction_degree":"180",
//                    "wind_speed":"8.4",
//                    "wind_scale":"2",
//                    "humidity":"58"
//                },
//                {
//                    "date":"2022-10-26",
//                    "text_day":"阴",
//                    "code_day":"9",
//                    "text_night":"多云",
//                    "code_night":"4",
//                    "high":"16",
//                    "low":"9",
//                    "rainfall":"0.00",
//                    "precip":"0.00",
//                    "wind_direction":"东北",
//                    "wind_direction_degree":"45",
//                    "wind_speed":"8.4",
//                    "wind_scale":"2",
//                    "humidity":"46"
//                },
//                {
//                    "date":"2022-10-27",
//                    "text_day":"多云",
//                    "code_day":"4",
//                    "text_night":"多云",
//                    "code_night":"4",
//                    "high":"14",
//                    "low":"9",
//                    "rainfall":"0.00",
//                    "precip":"0.00",
//                    "wind_direction":"东北",
//                    "wind_direction_degree":"45",
//                    "wind_speed":"3.0",
//                    "wind_scale":"1",
//                    "humidity":"40"
//                }
//            ],
//            "last_update":"2022-10-25T08:00:00+08:00"
//        }
//    ]
//}