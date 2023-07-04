package com.minshengyinyang;

import com.sun.jdi.ArrayReference;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName A
 * @Description TODO
 * @Author xgl
 * @Date 2023/7/4 18:20
 * @Version 1.0
 */
public class A {

    public static int getTimeDifference(String time1, String time2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date1 = format.parse(time1);
            Date date2 = format.parse(time2);
            long difference = Math.abs(date1.getTime() - date2.getTime()) / 1000;
            return (int) difference;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int m = 0;
        List<String []> record = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            String[] tt = s.split(",");
            record.add(tt);
        }
        List<String> res = new ArrayList<>();
        for (var tt: record){
            if (Double.parseDouble(tt[2]) > 10000){
                res.add(tt[0]);
            }
        }
        // 规则2: 60秒内金额相同的交易
        for (int i = 0; i < record.size(); i++) {
            String[] current  = record.get(i);
            for (int j = i + 1; j < record.size(); j++) {
                String[] next = record.get(j);
                if (current[2].equals(next[2]) && Math.abs(getTimeDifference(current[1], next[1])) < 60) {
                    res.add(current[0]);
                    res.add(next[0]);
                }
            }
        }

        // 规则3: 同一张信用卡在短时间内发生了不同地点的交易
        for (int i = 0; i < record.size(); i++) {
            String [] current = record.get(i);
            for (int j = i + 1; j < record.size(); j++) {
                String [] next = record.get(j);
                if (current[3].equals(next[3]) && !current[4].equals(next[4]) && Math.abs(getTimeDifference(current[1], next[1])) < 300) {
                    res.add(current[0]);
                    res.add(current[0]);
                }
            }
        }
        HashSet<String> set = new HashSet<>();
        for(String id: res){
            if(set.contains(id)){
                continue;
            }
            System.out.println(id);
            set.add(id);
        }
        //1213,2020-11-23 09:23:45,100000,123,asc,345,887,1234
        //1214,2020-11-23 09:23:44,1000010,123,

    }
}
