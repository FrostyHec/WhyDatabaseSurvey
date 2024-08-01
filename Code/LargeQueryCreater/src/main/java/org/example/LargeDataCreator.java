package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;


public class LargeDataCreator {
    public static long dataNum = (long) 1e8;//1亿数据量
    public static long count = 0;
    public static String[] firstName = {
            "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈",
            "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "罗", "许",
            "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏",
            "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章",
            "云", "苏", "潘", "葛", "蔡", "范", "彭", "郎", "鲁", "韦",
            "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳",
            "邓", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺",
            "江", "朴", "时", "傅", "皮", "龙", "齐", "康", "伍", "余",
            "元", "季", "顾", "孟", "平", "黄", "和", "穆", "萧", "尹",
            "刘", "胡", "于", "万", "柯", "尹", "崔", "邱", "田", "杜"
    };
    public static String[] lastName = {
            "子璇", "淼", "国栋", "夫子", "瑞堂", "甜", "敏", "尚", "国贤", "贺祥", "民",
            "晨涛", "昊轩", "易轩", "益辰", "益帆", "益冉", "瑾春", "瑾昆", "春齐", "杨",
            "文昊", "东东", "雄霖", "浩晨", "一丹", "熙涵", "溶溶", "冰枫", "欣欣", "宜豪", "欣慧",
            "云", "云龙", "加昕", "司诚", "棠", "炯明", "铭", "昕怡", "睿", "坤", "方遒",
            "建政", "美欣", "淑慧", "原神", "文杰", "欣源", "忠林", "仕", "欣汝", "慧嘉",
            "彦宏", "建林", "亦菲", "林", "冰洁", "佳欣", "涵涵", "禹辰", "淳美", "泽惠",
            "伟洋", "涵越", "润丽", "翔", "淑华", "晶莹", "凌晶", "苒溪", "雨涵", "嘉乐",
            "美欣", "明辉", "欣怡", "祺", "滢滢", "欣欣", "琪", "欣源", "忠林", "欣汝", "志仁",
            "慧嘉", "嘉福", "嘉乐", "涵越", "悦", "翔", "淑华", "原", "凌晶", "苒溪", "雨涵",
            "美欣", "明德", "徐坤", "鑫", "滢滢", "中山", "铭", "诗悦", "日新", "楠", "春林",
            "嘉燃", "美云", "涵泳", "健发", "卫国", "保民", "保国", "求是", "中华", "美华", "美玲", "美丽",
            "世凯", "世民", "世勇", "世忠", "世庆", "世峰", "琳", "琳娜", "琳达", "琳恩", "其坤", "泽",
            "明月", "楠", "琴", "旎", "泽宇", "翰林", "玉婷", "恩来", "恩至", "瑞", "自强",
            "嘉懿", "正熙", "志", "志远", "志浩", "志诚", "志丈", "志强", "志飞", "志学", "莉莉", "安迪", "塔菲", "安娜",
            "安吉", "安妮", "燕妮", "大帝", "旺", "傲天", "逆天", "云天", "天翔", "天佑", "明菲", "国安", "国泰", "盛华",
            "postgresql", "mysql", "myDB", "Oracle", "Excel", "DBMS Performance Evaluation", "JCoder"
    };

    public static void main(String[] args) throws IOException {
        long t1 = System.currentTimeMillis();
        Path path = Paths.get("huge.csv");
        Files.createFile(path);
        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.WRITE, StandardOpenOption.APPEND)) {
            long num = dataNum;
            while (num-- > 0) {
                ByteBuffer buf = ByteBuffer.wrap(rndSql().getBytes(StandardCharsets.UTF_8));
                channel.write(buf);
                if (num % (dataNum / 10) == 0) System.out.println("还剩：" + num + "条");
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println("生成SQL耗时：" + (t2 - t1) + "毫秒");
    }

    public static String rndSql() {
        long id = ++count;
        String studentID = String.valueOf(id);
        String name = getName();
        return id + "," + studentID + "," + name + "\n";
    }

    public static String getName() {
        int fi = new Random().nextInt(firstName.length), li = new Random().nextInt(lastName.length);
        return firstName[fi] + lastName[li];
    }
}
