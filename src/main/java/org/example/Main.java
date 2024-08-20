package org.example;

import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.view.swing.BrowserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;

import static com.teamdev.jxbrowser.engine.RenderingMode.HARDWARE_ACCELERATED;

public class Main {

    public static void main(String[] args) {
        // 初始化 Chromium
        EngineOptions options = EngineOptions.newBuilder(HARDWARE_ACCELERATED)
                .licenseKey("OK6AEKNYF232LP3LV7S18BDQPNN8O7BHK8EAANNGDM6XET5ACCBA52NNTFMF00AYHEPG0I9OTVLRJL4DRQ6NCLECTVE5586FYAOS6N972UH1TX2A7M2OU1TUMZO21RCA664TQHVSNED943HGA")
                .build();
        Engine engine = Engine.newInstance(options);

        // 创建一个 Browser 实例
        Browser browser = engine.newBrowser();

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JxBrowser Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // 创建并嵌入 Swing 的 BrowserView 组件以显示网页内容
            BrowserView view = BrowserView.newInstance(browser);
            frame.add(view, BorderLayout.CENTER);

            JButton loadUrlButton = new JButton("查看地图");
            loadUrlButton.addActionListener(e -> {
                // 在按钮点击事件中加载网页
                browser.navigation().loadUrl("http://localhost:5173/");
            });

            frame.add(loadUrlButton, BorderLayout.NORTH);

            frame.setSize(1280, 800);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // 设置窗口关闭时的操作
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    engine.close();
                }
            });
        });    }
}

//            try {
//                File file = new File("../map_baiduAPI.html");
//                URI fileUri = file.toURI();
//                String fileUrl = fileUri.toURL().toString();
//                browser.navigation().loadUrl(fileUrl);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
