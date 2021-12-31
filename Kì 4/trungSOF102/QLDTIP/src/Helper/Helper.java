/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import GUI.Main;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.Normalizer;
import java.util.regex.Pattern;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

/**
 *
 * @author ma-user
 */
public class Helper {

    public static Connection connection;

    public static synchronized boolean openConnection() {
        if (connection != null) {
            return true;
        } else {
            try {
                String url = "jdbc:sqlserver://localhost:1433;databaseName=QLDTIP2";
                String u = "sa";
                String p = "123456";
                connection = DriverManager.getConnection(url, u, p);
            } catch (Exception e) {
                connection = null;
                return false;
            }
        }
        return true;
    }

    public static synchronized void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {

            } finally {
                connection = null;
            }
        }
    }

    public static void showInFrame(JInternalFrame o, String title, boolean closePre) {
        try {
            o.setTitle(title);
            if (closePre) {
                for (JInternalFrame chiFrame : Main.rootPanel.getAllFrames()) {
                    chiFrame.dispose();
                }
                for (JInternalFrame chiFrame : Main.rootPanel.getAllFrames()) {
                    chiFrame.dispose();
                }
                o.addInternalFrameListener(new InternalFrameAdapter() {
                    @Override
                    public void internalFrameClosed(InternalFrameEvent e) {
                        Main.showMDI();
                    }
                });
            }
            Main.rootPanel.add(o);
            o.setLocation(Main.rootPanel.getWidth() / 2 - o.getWidth() / 2, (Main.rootPanel.getHeight() - 20) / 2 - o.getHeight() / 2 - 20);
            o.setVisible(true);
        } catch (Exception e) {
            try {
                FileWriter fw = new FileWriter(System.getProperty("user.dir") + "log/log.txt", true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw);
                e.printStackTrace(out);
            } catch (IOException ex) {
            }
        }
    }

    public static void showInFrame(JInternalFrame o, String title) {
        showInFrame(o, title, true);
    }

    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "d");
    }
}
