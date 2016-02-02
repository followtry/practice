/*********--pull������---******************/
pull����xml�ļ�
public static List<WeatherInfo> getWeatherInfos(InputStream inStream){
	XmlPullParser xmlPullParser = Xml.newPullParser();
	List<WeatherInfo> wInfos=null;
	WeatherInfo info=null;
	try {
		xmlPullParser.setInput(inStream, "utf-8");
		int type=xmlPullParser.getEventType();
		while (type!=XmlPullParser.END_DOCUMENT) {
			switch (type) {
			case XmlPullParser.START_TAG:
				if ("infos".equals(xmlPullParser.getName())) {
					wInfos=new ArrayList<WeatherInfo>();
				}else if ("city".equals(xmlPullParser.getName())) {
					info=new WeatherInfo();
					info.setId(Integer.parseInt(xmlPullParser.getAttributeValue(0)));
				}else if ("wind".equals(xmlPullParser.getName())) {
					info.setWind(xmlPullParser.nextText());
				}else if ("weather".equals(xmlPullParser.getName())) {
					info.setWeather(xmlPullParser.nextText());
				}else if ("temp".equals(xmlPullParser.getName())) {
					info.setTemp(xmlPullParser.nextText());
				}else if ("pm".equals(xmlPullParser.getName())) {
					info.setPM(Integer.parseInt(xmlPullParser.nextText()));
				}
				
				break;
			case XmlPullParser.END_TAG :
				if ("city".equals(xmlPullParser.getName())) {
					wInfos.add(info);
					info=null;
				}
				break;

			default:
				break;
			}
			type=xmlPullParser.next();
		}
	} catch (Exception e) {
		wInfos=null;
		e.printStackTrace();
	} 
	return wInfos;
	
}

����������������ļ�
/*** 	MainActivity.class.getClassLoader().getResourceAsStream("weatherinfos.xml") ***/

tvShow = (TextView) findViewById(R.id.tv_show);

List<WeatherInfo> weatherInfos = Weather
		.getWeatherInfos(MainActivity.class.getClassLoader()
				.getResourceAsStream("weatherinfos.xml"));
StringBuffer sBuffer=new StringBuffer();
for (WeatherInfo weatherInfo : weatherInfos) {
	sBuffer.append(weatherInfo.toString());
	sBuffer.append("\n");
}
tvShow.setText(sBuffer.toString());


/****************weatherinfos.xml �ļ�**********************/
<?xml version="1.0" encoding="utf-8"?>
<infos>
    <city id="1">
        <name>����</name>
        <wind>����3-5��</wind>
        <weather>���ն���ת��</weather>
        <temp>2-3��</temp>
        <pm>300</pm>
    </city>
    <city id="2">
        <name>�Ϻ�</name>
        <wind>����3-5��</wind>
        <weather>�����������</weather>
        <temp>12-15��</temp>
        <pm>20</pm>
    </city>
    <city id="3">
        <name>����</name>
        <wind>����6-9��</wind>
        <weather>�����б���</weather>
        <temp>22-23��</temp>
        <pm>100</pm>
    </city>
    <city id="4">
        <name>����</name>
        <wind>����3-5��</wind>
        <weather>���ն���</weather>
        <temp>-2-3��</temp>
        <pm>200</pm>
    </city>
    <city id="5">
        <name>�ൺ</name>
        <wind>����3-5��</wind>
        <weather>������</weather>
        <temp>2-5��</temp>
        <pm>100</pm>
    </city>
</infos>
