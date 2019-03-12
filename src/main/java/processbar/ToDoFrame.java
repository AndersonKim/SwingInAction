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

        panel=new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button);
        panel.add(progressBar);
        this.getContentPane().add(panel);

    }

    //模拟耗时操作
    private void getTodo() {
        NumberArrary arrarys = this.new NumberArrary();
        arrarys.execute();
    }
    private class NumberArrary extends SwingWorker<Void, Integer> {
        int[] num={10,20,30,40,50,60,70,80,90,100};
        int index=0;
        protected void process() {
            progressBar.setValue(num[index]);
        }

        @Override
        protected void done() {
            super.done();
            progressBar.setValue(100);
            progressBar.setStringPainted(true);
            progressBar.setString("待办获取成功");
        }

        @Override
        protected Void doInBackground(){
            for(int i=0;i<10;i++){
                process();
                index=i;
                System.out.println("loop "+i);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }


    }
    public static void main(String[] args){
        ToDoFrame toDoFrame=new ToDoFrame();
    }
}
