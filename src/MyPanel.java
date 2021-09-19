import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

class MyPanel extends JPanel
{
    private int x = 0;
    private int y = 30;
    int[] nowPos;
    int[] nextPos;
    public void setLastPos(int[] list){
        nowPos = list;
    }

    public void setPos(List<Ant> list){
        nowPos = nextPos;
        for (int i = 0; i < 5; i++)
            nextPos[i] = (int)list.get(i).getLocation();
    }

    public void display()
    {
        for(int i = 0; i<5; i++){
            if(nextPos[i]-nowPos[i]>0)
                nowPos[i]++;
            else
                nowPos[i]--;
        }

        //重绘JPanel
        this.repaint();
    }

    /**
     * repaint方法会调用paint方法，并自动获得Graphics对像
     * 然后可以用该对像进行2D画图
     * 注：该方法是重写了JPanel的paint方法
     */
    public void paint(Graphics g)
    {
        //调用的super.paint(g),让父类做一些事前的工作，如刷新屏幕
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.BLACK);//设置画图的颜色
        g2d.fill3DRect(x, y, 300, 5, true);//画一根杆子
        for(int i = 0; i<5; i++)
            g2d.fillOval(nowPos[i], y, 1, 1);
    }
}