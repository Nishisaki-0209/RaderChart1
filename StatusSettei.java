import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

public class StatusSettei {
	
	/* 能力値："STR(筋力)","CON(体力)","POW(精神力)", "DEX(敏捷性)",
	 *         "APP(外見)","SIZ(体格)","INT(知性)","EDU(教育)"
	 * */
	
	int STR, CON, POW, DEX, APP, SIZ, INT, EDU,
	    Shunyuu,Zaisan,SAN,Lucky,Idea,Knowledge,HP,MP,ShokuP,HobbyP,DamageP;
	
	public      Color cor;
	Graphics     g;
	int         cnt;
	int         cx0,cy0;
	double      len,rad;
	
	public void Nouchi(Graphics bfg, int r, int x, int y) {
		
		g = bfg;
		cnt = 5;
		rad = 360/cnt;
		len = r;
		cx0 = x;
		cy0 = y;
		
		Random rnd = new Random();
		
		//能力値
		STR = (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1);     //筋力
		CON = (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1);     //体力
		POW = (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1);     //精神力
		DEX = (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1);     //敏捷
		APP = (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1);     //容姿
		SIZ = (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + 6; //体格
		INT = (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + 6; //知性
		EDU = (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + 3; //教養
				
		/*収入
		* 3	年収無し〜150万円以下
		* 4	２００万円,5  ２５０万円,6	３００万円,7  ３５０万円
		* 8	４００万円,9  ４５０万円,10 ５００万円,11 ６００万円
		*12	７００万円,13 ８００万円,14	９００万円,15 １０００万円
		*16	2000万円  ,17 3000万円  ,18  5000万円以上
		* 
	    * これの5倍が財産とする */
		Shunyuu = (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1) + (rnd.nextInt(6) + 1);
		Zaisan  = Shunyuu * 5;
				
		//その他ステータス
		SAN = POW * 5;       //正気度
		Lucky = POW * 5;     //幸運
		Idea = INT * 5;      //アイデア
		Knowledge = EDU * 5; //知識
		HP = (CON+SIZ)/2;    //耐久力
		MP = POW;            //マジックポイント
        ShokuP = EDU * 20;   //職業技能ポイント
        HobbyP = INT * 10;   //趣味技能ポイント
        DamageP= STR + SIZ;  //ダメージボーナス
        
        int xl[] = new int[5];
		int yl[] = new int[5];
		int[] lenArray = {STR, HP, DEX, POW, INT};
		int[] AddlenArray = {
				CON, APP, SIZ, EDU, 
				SAN, Lucky, Idea, Knowledge, HP, MP,
				ShokuP ,HobbyP
				};
		
		SetTen(xl,yl,lenArray);
		ViewKaku(xl,yl);
		SuchiDis(xl,yl,lenArray, AddlenArray);
	}

	private void SuchiDis(int[] xl, int[] yl,int[] lenArray,int[] AddlenArray) {
		
		g.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 16));
		
		String[] name_str = new String[16];
		
		name_str[0] = String.valueOf(lenArray[0]);
		name_str[1] = String.valueOf(AddlenArray[0]);
		name_str[2] = String.valueOf(lenArray[3]);
		name_str[3] = String.valueOf(lenArray[2]);
		name_str[4] = String.valueOf(AddlenArray[1]);
		name_str[5] = String.valueOf(AddlenArray[2]);
		name_str[6] = String.valueOf(lenArray[4]);
		name_str[7] = String.valueOf(AddlenArray[3]);
		name_str[8] = String.valueOf(AddlenArray[4]);
		name_str[9] = String.valueOf(AddlenArray[5]);
		name_str[10] = String.valueOf(AddlenArray[6]);
		name_str[11] = String.valueOf(AddlenArray[7]);
		name_str[12] = String.valueOf(AddlenArray[8]);
		name_str[13] = String.valueOf(AddlenArray[9]);
		name_str[14] = String.valueOf(AddlenArray[10]);
		name_str[15] = String.valueOf(AddlenArray[11]);
		
		g.setColor(Color.black);
		//name "筋力", "耐久力", "敏捷", "精神力", "知性"
		//new_name "体力","容姿","体格","教養",
		//"正気度","幸運","アイデア","知識","HP","MP",
		//"職業技能ポイント",
		//"趣味技能ポイント"
		//->筋力 体力 精神力 敏捷 容姿 体格 知性 教養 正気度 幸運 アイデア 知識
		//耐久力 マジックポイント 職業技能ポイント 趣味技能ポイント
		//for(int i = 0; i < 1; i++) {
			//g.drawString(name_str[i], 460, 45 + i * 16 );
		//}
		
		g.setFont(new Font("ＭＳ ゴシック", Font.PLAIN, 16));
		for(int i = 0; i < name_str.length - 2; i++) {
			g.drawString(name_str[i],460, 48 + i * 16 );
		}

		g.drawString(name_str[name_str.length - 2],457,48 + (name_str.length - 2) * 17 );
		
		g.drawString(name_str[name_str.length -1 ],457,48 + (name_str.length - 1) * 18 );
		
		//System.out.println(name_str);
	}

	private void SetTen(int[] xl, int[] yl, int[] lenArray) {
		
		for(int i=0; i<cnt; i++){   
    		xl[i]= cx0+(int)(Math.sin((rad*i)/180*Math.PI)*len/18*lenArray[i]);
          	yl[i]= cy0-(int)(Math.cos((rad*i)/180*Math.PI)*len/18*lenArray[i]);
    	}
	}

	private void ViewKaku(int[] xl, int[] yl) {
		
		g.setColor(new Color(255, 100, 100, 200));
	    g.fillPolygon(xl,yl,cnt);
	}
}
