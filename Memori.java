import java.awt.Color;
import java.awt.Graphics;


public class Memori {
	
	public      Color cor;
	Graphics     g;
	int         cx0,cy0,len,bunk;
	
	public void tansen(Graphics bfg, int r, int x5, int y5) {
		
		g = bfg;
		len = r;
		cx0 = x5;
		cy0 = y5;
		bunk = 9;
		
		int yb[] = new int[bunk];
		g.setColor(Color.black);
		yokosen(len, x5, y5, yb);
	}

	private void yokosen(int len, int x, int y, int[] yb) {
		
		for(int i = 0; i < bunk ; i++) {
			yb[i] = y - i * len/bunk;
			//intから文字列へ.
			g.drawString(Integer.toString(0), x + 6, y + 10);
			g.drawString(String.valueOf((i+1) * 2), x + 6, yb[i] - len/bunk + 10);
		}
		
	}
}
