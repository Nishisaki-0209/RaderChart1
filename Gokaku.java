import java.awt.Color;
import java.awt.Graphics;

public class Gokaku {
	
	public      Color cor;
	Graphics     g;
	int         cnt;
	int         cx0,cy0;
	double      len,rad;
	
	public void sen(Graphics bfg, int r, int x, int y) {
		
		int xl[] = new int[5];int yl[] = new int[5];
		int x1[] = new int[5];int y1[] = new int[5];
		int x2[] = new int[5];int y2[] = new int[5];
		int x3[] = new int[5];int y3[] = new int[5];
		int x4[] = new int[5];int y4[] = new int[5];
		int x5[] = new int[5];int y5[] = new int[5];
		int x6[] = new int[5];int y6[] = new int[5];
		int x7[] = new int[5];int y7[] = new int[5];
		int x8[] = new int[5];int y8[] = new int[5];
		
		g = bfg;
		cnt = 5;
		rad = 360/cnt;
		len = r;
		cx0 = x;
		cy0 = y;

        g.setColor(Color.GRAY);
		SetTen(xl,yl,x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6,x7,y7,x8,y8);
		ViewKaku(xl,yl,x1,y1,x2,y2,x3,y3,x4,y4,x5,y5,x6,y6,x7,y7,x8,y8);
        Viewsen(x,y,xl,yl);
	}

	private void SetTen(int[] xl, int[] yl, int[] x1, int[] y1, int[] x2, int[] y2, int[] x3, int[] y3, int[] x4, int[] y4, int[] x5, int[] y5, int[] x6, int[] y6, int[] x7, int[] y7, int[] x8, int[] y8) {
		
		for(int i=0; i<cnt; i++){   
    		xl[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len);
    		yl[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len);
          	x1[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len/9);
          	y1[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len/9);
          	x2[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len/9*2);
          	y2[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len/9*2);
          	x3[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len/9*3);
          	y3[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len/9*3);
          	x4[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len/9*4);
          	y4[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len/9*4);
          	x5[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len/9*5);
          	y5[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len/9*5);
          	x6[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len/9*6);
          	y6[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len/9*6);
          	x7[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len/9*7);
          	y7[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len/9*7);
          	x8[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len/9*8);
          	y8[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len/9*8);
    	}
	}

	private void ViewKaku(int[] xl, int[] yl, int[] x1, int[] y1, int[] x2, int[] y2, int[] x3, int[] y3, int[] x4, int[] y4, int[] x5, int[] y5, int[] x6, int[] y6, int[] x7, int[] y7, int[] x8, int[] y8) {
		
	    g.drawPolygon(xl,yl,cnt);
	    g.drawPolygon(x1,y1,cnt);
	    g.drawPolygon(x2,y2,cnt);
	    g.drawPolygon(x3,y3,cnt);
	    g.drawPolygon(x4,y4,cnt);
	    g.drawPolygon(x5,y5,cnt);
	    g.drawPolygon(x6,y6,cnt);
	    g.drawPolygon(x7,y7,cnt);
	    g.drawPolygon(x8,y8,cnt);
	}

	private void Viewsen(int x, int y, int[] xl, int[] yl) {
		
		for(int i = 0; i < cnt; i++) {
			g.drawLine(x, y, xl[i], yl[i]);
		}
		
	}
}
