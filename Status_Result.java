import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Status_Result extends JFrame implements ActionListener{
    JButton mybtn;
    MyPanel mypnl;
    ImageIcon icon1;
    JLabel label1,label2;
    
    int pcct=0;    //paintComponentが呼び出された回数
    int clct=0;    //クリックした回数
    public Status_Result() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("ステータス設定");
        setLayout(new BorderLayout());
        mypnl = new MyPanel(730,380);
        mybtn = new JButton("draw");
        
        //note_1.pngのURL
        //URL url = this.getClass().getResource("note_1.png");
        //BufferedImage img = ImageIO.read(url);
        
        icon1 = new ImageIcon("note_1.png");
        label1 = new JLabel(icon1);//メモ画像の貼り付け
        
        
        mypnl.setLayout(null);
        add(mypnl, BorderLayout.CENTER);
        
        mypnl.add(mybtn);
        mybtn.setBounds(50, 400, 300, 50);
        mybtn.addActionListener(this);
        
        //label1.setBounds(400, 0, 530, 380);
        //mypnl.add(label1);//メモ画像の貼り付け->前面になってしまう
        
        //文字表示
        label2 = new JLabel("テスト");
		label2.setBounds(470, -150, 400, 400);
		//mypnl.add(label2);
		mypnl.add(label1);
        
        
        mypnl.setBackground(new Color(255,255,191));
        //ウィンドウの大きさ
        mypnl.setPreferredSize(new Dimension(500,460));//メモx=730
        pack();
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mybtn) {
           clct++;
           if(clct > 99) {
        	   clct = 1;
           }
           mypnl.repaint();
           mypnl.drawToBuff();
        }
    }
    public static void main(String[] args){
        Status_Result myframe = new Status_Result();
    }

    public class MyPanel extends JPanel{
        BufferedImage buffimg;
        Graphics bfg;
        Color bgcolor = new Color(255,255,191);
        Color smcolor = new Color(255,255,200);
        
        final int x5 = 200, y5 = 200;
        
        public MyPanel(int width, int height){
        	
            setPreferredSize(new Dimension(width,height));
            buffimg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
            bfg = buffimg.createGraphics();
            bfg.setColor(bgcolor);
            bfg.fillRect(0, 0, width, height);
            
            bfg.setColor(Color.WHITE);
       	    bfg.fillRect(15, 28, 470, 320);
            bfg.setColor(smcolor);
            bfg.fillRect(10,4,55,20);
            bfg.setColor(Color.BLACK);
            bfg.drawRect(10,4,55,20);
            
            //ステータス表
            int r = 288;//１８(最大値)×１6(１目盛)
            bfg.setColor(Color.GRAY);
    		((Graphics2D) bfg).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            Gokaku gokaku = new Gokaku();
            gokaku.sen(bfg, r/2, x5, y5);
            bfg.setColor(Color.BLACK);
            Name   name    = new Name();
            name.kisai(bfg, r/2, x5, y5);
            Memori memori = new Memori();
            memori.tansen(bfg, r/2, x5, y5);

            bfg.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 13));//文字の種類と大きさ設定
            bfg.drawString(" "+clct+" 回目",10,20);//左上の回数表示
            //bfg.drawString("筋力",400 , 100);//右メモの名前欄 but note_1.pngの下に表示2022/6/23
        }

	@Override
      public void paintComponent(Graphics myg){
         //super.paintComponent(myg);
         pcct++;
         myg.drawImage(buffimg, 0, 0, this);
      }
	  
      public void drawToBuff(){
    	
    	int r = 288;//１８(最大値)×１6(１目盛)
    	bfg.setColor(Color.WHITE);
    	bfg.fillRect(15, 28, 470, 320);//更新を防ぎ、初期化
    	bfg.setColor(smcolor);
    	bfg.fillRect(10, 4, 55, 20);
        
        bfg.setColor(smcolor);//カウントのマス
        bfg.fillRect(10,4,55,20);
        
        bfg.setColor(Color.BLACK);
        bfg.drawRect(10,4,55,20);
        bfg.drawString(" "+clct+" 回目",10,20);
        
        //五角形とステータス
		((Graphics2D) bfg).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		Gokaku gokaku = new Gokaku();
        gokaku.sen(bfg, r/2, 200, 200);
        Name   name    = new Name();
        name.kisai(bfg, r/2, x5, y5);
        StatusSettei stat_s  = new StatusSettei();
        stat_s.Nouchi(bfg, r/2, 200, 200);
        Memori memori = new Memori();
        memori.tansen(bfg, r/2, x5, y5);
        repaint();
       }
    }
}
