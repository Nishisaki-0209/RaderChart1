import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Name {
	
	public      Color cor;
	Graphics     g;
	int         cnt;
	int         cx0,cy0;
	double      len,rad;
	String name[] = {
			"筋力", "耐久力", "敏捷", "精神力", "知性"
			};
	//2023 1 30 項目追加
	String new_name[] = {
			"体力","容姿","体格","教養",
			"正気度","幸運","アイデア","知識","HP","MP",
			"職業技能ポイント",
			"趣味技能ポイント"
	};
	String name_Right[] = new String[name.length + new_name.length];
	
	
	public void kisai(Graphics bfg, int r, int x, int y) {
		
		int xl[] = new int[5];
		int yl[] = new int[5];
		g = bfg;
		cnt = 5;
		rad = 360/cnt;
		len = r;
		cx0 = x;
		cy0 = y;
		
		Set_name_Right(name_Right);
		
		g.setColor(Color.black);
		SetTen(xl, yl);
		KisaiName(xl, yl);
		
		RightKisaiName(xl, yl, name_Right);
	}

	private void Set_name_Right(String[] A) {
		// TODO 自動生成されたメソッド・スタブ
		//name "筋力", "耐久力", "敏捷", "精神力", "知性"
		//new_name "体力","容姿","体格","教養",
		//"正気度","幸運","アイデア","知識","HP","MP",
		//"職業技能ポイント",
		//"趣味技能ポイント"追加
		A[0] = name[0];
		A[1] = new_name[0];
		A[2] = name[3];
		A[3] = name[2];
		A[4] = new_name[1];
		A[5] = new_name[2];
		A[6] = name[4];
		A[7] = new_name[3];
		A[8] = new_name[4];
		A[9] = new_name[5];
		A[10] = new_name[6];
		A[11] = new_name[7];
		A[12] = new_name[8];
		A[13] = new_name[9];
		A[14] = new_name[10];
		A[15] = new_name[11];
	}

	private void RightKisaiName(int[] xl, int[] yl,String[] name) {
		// TODO 自動生成されたメソッド・スタブ
		g.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 16));
		
		g.drawLine(xl[0] + 178,28,xl[0] + 178,348);
		
		for(int i = 0; i < name_Right.length - 3; i++) {
			g.drawString(name[i]+":", xl[0] + 180, yl[0] + i * 16 );
		}

		g.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 12));
		g.drawString(name[name_Right.length - 3]+":",
				xl[0] + 180, yl[0] + (name_Right.length - 3) * 16 );
		
		g.drawString(name[name_Right.length - 2]+":",
				xl[0] + 180, yl[0] + (name_Right.length - 2) * 17 );
		
	}

	private void SetTen(int[] xl, int[] yl) {
		
		for(int i=0; i<cnt; i++){   
    		xl[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*(len+10));
          	yl[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*(len+10));
    	}
	}

	private void KisaiName(int[] xl, int[] yl) {
		g.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 12));
		
		g.drawString(name[0], xl[0] - 10, yl[0] );
		g.drawString(name[1], xl[1] - 5, yl[1] + 5);
		g.drawString(name[2], xl[2] - 15, yl[2] + 10);
		g.drawString(name[3], xl[3] - 15, yl[3] + 10);
		g.drawString(name[4], xl[4] - 20, yl[4] + 5);
	}
}
