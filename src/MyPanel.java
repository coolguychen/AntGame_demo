import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义JPanel用于绘图
 */
class MyPanel extends JPanel
{
    //规定杆子在Panel中的坐标
    private static final int x = 140;
    private static final int y = 30;
    List<Ant> antList;

    public void setAntList(List<Ant> list){
        antList = list;
    }

    /**
     * repaint方法会调用paint方法，并自动获得Graphics对像
     * 然后可以用该对像进行2D画图
     * 注：该方法是重写了JPanel的paint方法
     */
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        //调用的super.paint(g),让父类做一些事前的工作，如刷新屏幕
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.BLACK);//设置杆子的颜色
        g2d.fill3DRect(x, y, 300, 5, true);//画一根杆子

        if(antList!=null){
            //遍历蚂蚁并画图
            for(Ant ant: antList){
                int loc = (int)ant.getLocation();
                g2d.setColor(ant.getColor());//根据不同蚂蚁设定不同的颜色
                g2d.fillOval(loc+x, y-10, 10,10);
            }
        }
    }
}