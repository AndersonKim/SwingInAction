package processbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


/**
 *  点击按钮开始进行耗时操作显示进度条实时反馈进度
 */
public class ToDoFrame extends JFrame {
    JPanel panel;
    JButton button;
    JProgressBar progressBar;

    public ToDoFrame() throws HeadlessException {
        setComponent();
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getTodo();
    }
    //设置组件
    private void setComponent() {
        button=new JButton("todo");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTodo();
            }
        });

        progressBar=new JProgressBar();
        progressBar.setStringPainted(true);

        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button);
        panel.add(progressBar);
        this.getContentPane().add(panel);

    }

    //模拟耗时操作
    private void getTodo() {
        progressBar.setIndeterminate(true);
        progressBar.setString("获取待办中...");

        new SwingWorker<String, Void>() {


            @Override
            protected void done() {
                progressBar.setIndeterminate(false);
                progressBar.setValue(100);
                progressBar.setString("待办获取成功");
                super.done();
            }

            @Override
            protected String doInBackground() throws Exception {
                //模拟获取待办
                Thread.sleep(5000);
                return null;
            }
        }.execute();
    }

    public static void main(String[] args){
        ToDoFrame toDoFrame=new ToDoFrame();
    }
}
