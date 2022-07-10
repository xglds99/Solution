import org.junit.Test;

import java.io.*;

public class test {

    @Test
    public void test() throws IOException {
        File file=new File("B:\\Solution\\Leetcode\\src\\a.txt");
         BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("b.txt"));
         String  str="1、https:<<www.baidu.com/  百度\n" +
                 "2、http:<<www.cuaa.net/      校友会 \n" +
                 "3、https:<<www.xiami.com/   虾米网\n" +
                 "4、https:<<www.tmall.com/  天猫\n" +
                 "5、https:<<www.sina.com.cn/ 新郎\n" +
                 "6、https:<<www.sohu.com/ 搜狐\n" +
                 "7、https:<<www.163.com/ 网易\n" +
                 "8、https:<<www.qq.com/ 腾讯网\n" +
                 "9、https:<<www.taobao.com/ 淘宝\n" +
                 "10、https:<<www.mop.com/ 猫扑网\n" +
                 "11、https:<<www.sogou.com/ 搜狗\n" +
                 "12、https:<<www.126.com/ 网易邮箱\n" +
                 "13、https:<<www.ebay.cn/  ebay网\n" +
                 "14、http:<<www.zsyunyue.com/ 云悦\n" +
                 "15、https:<<www.hao123.com/  hao123\n" +
                 "16、http:<<www.xinhuanet.com/  新华网\n" +
                 "17、https:<<www.pconline.com.cn/  太平洋电脑网\n" +
                 "18、http:<<www.soufun.com/  搜房网\n" +
                 "19、http:<<www.21cn.com/   21cn网\n" +
                 "20、https:<<www.blogchina.com/  博客中国\n" +
                 "21、http:<<www.ynet.com/ 北青网\n" +
                 "22、https:<<www.yisou.com/  一搜网\n" +
                 "23、http:<<www.cnnic.net.cn/  中国互联网信息中心\n" +
                 "24、https:<<www.cctv.com/ 央视网\n" +
                 "25、http:<<www.yesky.com/  天极网\n" +
                 "26、https:<<www.homeway.com.cn/ 和讯网\n" +
                 "27、https:<<www.chinaz.com/ 站长之家\n" +
                 "28、http:<<www.people.com.cn/  人民网\n" +
                 "29、https:<<www.kingsoft.com/  金山网\n" +
                 "30、https:<<www.51job.com/  51job\n" +
                 "31、http:<<www.10086.cn/   中国移动\n" +
                 "32、https:<<www.zol.com.cn/  中关村在线\n" +
                 "33、https:<<www.online.sh.cn/  上海热线\n" +
                 "34、http:<<www.chinahr.com/  中华英才网\n" +
                 "35、https:<<www.onlinedown.net/  华军软件园\n" +
                 "36、http:<<www.skycn.com/  天空下载\n" +
                 "37、http:<<www.chinacars.com/ 中国汽车网\n" +
                 "38、http:<<www.icbc.com.cn/icbc/  中国工商银行\n" +
                 "39、http:<<www.cmbchina.com/  招商银行\n" +
                 "40、http:<<www.hrbeu.edu.cn/ 哈尔滨工程大学\n" +
                 "41、https:<<www.lottery.gov.cn/ 中国体彩网\n" +
                 "42、https:<<www.runoob.com/  菜鸟教程\n" +
                 "43、https:<<www.csdn.net/      csdn\n" +
                 "44、https:<<www.aliyun.com/ 阿里云\n" +
                 "45、https:<<www.liaoxuefeng.com/     廖雪峰\n" +
                 "46、https:<<www.qau.edu.cn/    青岛农业大学\n" +
                 "47、http:<<www.lnpu.edu.cn/  辽宁石油化工大学\n" +
                 "48、https:<<www.hit.edu.cn/  哈尔滨工业大学\n" +
                 "49、https:<<www.tsinghua.edu.cn/ 清华大学\n" +
                 "50、https:<<www.pku.edu.cn/  北京大学\n";
        String string[]=new String[50];
        for (int i = 0; i < 49; i++) {
            int i1 = str.indexOf(i + 1 + "、");
            int i2=str.indexOf(i+2+"、");
            string[i]=str.substring(i1,i2);
            int i3=string[i].indexOf("http");
            int i4=string[i].indexOf(" ");
            string[i]=string[i].substring(i3,i4);
            string[i]=string[i].replace("<<","//");
            System.out.println(string[i]);
        }
        int i5=str.indexOf("50、");
        string[49]=str.substring(i5);
        int i3=string[49].indexOf("http");
        int i4=string[49].indexOf(" ");
        string[49]=string[49].substring(i3,i4);
        string[49]=string[49].replace("<<","//");
        System.out.println(string[49]);

         byte [] c=new byte[200];
         String str1 ="\n" +
                 "for /l %%i in (1,1,100) do (\n" +
                 "echo %%i\n" +
                 "start D:\\QQBrowser\\QQBrowser.exe";
         String str3="timeout /T 35 /NOBREAK\n" +
                 " \n" +
                 "taskkill /f /t /im QQBrowser.exe\n" +
                 ")";


        for (int i = 0; i < 50; i++) {
            bufferedOutputStream.write((str1+"   "+string[i]+"\n"+str3).getBytes());
        }
        bufferedOutputStream.close();
        }
    }

