package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> rsl = null;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            rsl = in.lines().filter(i -> i.contains("404")).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<String> list = LogFilter.filter("log.txt");
        for (String l : list) {
            System.out.println(l);
            LogFilter.save(list, "filterLog.txt");
        }
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            out.println(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}