import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameWithAction extends JFrame{

    public FrameWithAction() {

        setBounds(100, 100, 600, 500);
        setBackground(Color.white);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new GridLayout(4, 1,10,10));

        //初始化多个JPanel，用来放置不同的文本和绘制蚂蚁爬杆的动态过程
        MyPanel p1= new MyPanel();
        JPanel p2= new JPanel(new GridLayout(1,3,10,10));
        JPanel p3= new JPanel(new GridLayout(1,3,10,10));
        JPanel p4= new JPanel(new FlowLayout());


        //初始化JPanel内部组件
        JButton button1 = new JButton("点击开始");
        button1.setSize(100, 20);
        button1.setHorizontalAlignment(SwingConstants.CENTER);
        button1.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        //监听按钮的点击事件，用于启动游戏
        button1.addActionListener(e -> {
            PlayRoom playRoom = new PlayRoom(0.5,0,1.0e7);
            try {
                System.out.println("Game Begins");
                playRoom.start(p1, p2, p3);
                System.out.println("Game Ends");
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });

        p2.add(new JLabel("第0轮", JLabel.CENTER));
        p2.add(new JLabel("方向：", JLabel.CENTER));
        p2.add(new JLabel("速度：5cm/s", JLabel.CENTER));
        p3.add(new JLabel("上轮时间：未知", JLabel.CENTER));
        p3.add(new JLabel("最大时间：未知", JLabel.CENTER));
        p3.add(new JLabel("最小时间：未知", JLabel.CENTER));
        p4.add(button1);

        c.add(p2);
        c.add(p3);
        c.add(p4);
        c.add(p1);

        setVisible(true);
    }
    public static void main(String[] args) throws InterruptedException {
        new FrameWithAction();
    }
}

