package com.company;

import com.company.MethodsPackage.ExceptionsMethods;
import com.company.MethodsPackage.WebDriverMethods;
import com.company.MethodsPackage.WriteToFIleMethods;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RetroFmSongsCollect {

    int hoursOnPage=6;
    int countDaysToParse=30;

    String pathToWrite="S:\\Файлы на время\\retroFmlist\\htmls\\";
    String urlFirstPart="https://retrofm.ru/index.php?go=Playlist&date=";
    String urlDate="24.07.2022";
    String urlTime="&time_start=00%3A00&time_stop=06%3A00";

    RetroFmSongsCollect(){
        WebDriver webDriver= WebDriverMethods.ConnectWebDriverParameters(WebDriverMethods.urlFastLoad);

        Calendar lastDate=Calendar.getInstance();
        Calendar firstDate= (Calendar) lastDate.clone();
        firstDate.add(Calendar.HOUR, -6);

        String url="";
        Date currentDatePoint=new Date();
        int daysBetween= (int) ((currentDatePoint.getTime()-lastDate.getTime().getTime() )/1000/60/60/24);
        while (daysBetween <countDaysToParse){
            url=generatelink(firstDate,lastDate);
            webDriver.get(url);
            WebDriverMethods.ScrollBySpeed(webDriver,7);
            String src= null;
            src =webDriver.getPageSource();

            writeHtml(src,firstDate.getTime().toString()+"_to_"+lastDate.getTime().toString());

             lastDate=firstDate;
             firstDate= (Calendar) lastDate.clone();
            firstDate.add(Calendar.HOUR, -6);
            daysBetween= (int) ((currentDatePoint.getTime()-lastDate.getTime().getTime() )/1000/60/60/24);
            try {Thread.sleep(1000);} catch (InterruptedException e) {throw new RuntimeException(e);}
            new String();

        }

    }

    void writeHtml(String srcHTML,String nameFile){
        try {WriteToFIleMethods.writeTXTNoAppend(pathToWrite+nameFile.replaceAll(":","-"),srcHTML);
        } catch (IOException e) {ErrorCritical(e,null);}
    }

    private String generatelink(Calendar firstDate, Calendar lastDate) {

        String urll=urlFirstPart+dateMonthParse(firstDate.getTime())
                +"&time_start="+dateHour(firstDate.getTime())+"%3A"+dateMin(firstDate.getTime())
                +"&time_stop="+dateHour(lastDate.getTime())+"%3A"+dateMin(lastDate.getTime());
        return urll;
    }

     String dateMonthParse(Date ddddd){
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("Ru", "Ru"));
        String dateMonth = simpleDateFormat.format(ddddd);
        return dateMonth;
    }
    String dateHour(Date ddddd){
        String pattern = "HH";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("Ru", "Ru"));
        String dateMonth = simpleDateFormat.format(ddddd);
        return dateMonth;
    }
    String dateMin(Date ddddd){
        String pattern = "mm";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("Ru", "Ru"));
        String dateMonth = simpleDateFormat.format(ddddd);
        return dateMonth;
    }


    public static void main(String[] args) {
        RetroFmSongsCollect retroFmSongsCollect=new RetroFmSongsCollect();
    }

    void ErrorCritical(Exception e,String Comment){
        new String();

    }
}
