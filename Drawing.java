import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
//
public class Drawing {
	
	enum ElementType { NOTSET, SQUARE, RECTANGLE, CIRCLE, ELLIPSE, TRIANGLE, TEXT };
	//声明CShape类，
	public abstract class CShape
	{
		public abstract void Draw(Graphics g);//绘制图元
		public abstract void SetValue(ElementType t,int x,int y,int width,int height);//设置数据成员
		public abstract void GetValue(ElementType t,int x,int y,int width,int height);//获取数据成员的值
		public void SetPen(Color bcolor,int btype,int bwidth) {
			BorderColor=bcolor;
			BorderType=btype;
			BorderWidth=bwidth;
			}
		public void GetPen(Color bcolor,int btype,int bwidth) {
			BorderColor=bcolor;
			BorderType=btype;
			BorderWidth=bwidth;
			}
		public void SetBrush(Color fcolor,int ftype) {
			FillColor=fcolor; 
			FillType=ftype;
			}
		public void GetBrush(Color fcolor,int ftype) {
			fcolor=FillColor; 
			ftype=FillType;
			}

		ElementType Type;//图元类型
		int OrgX;//原点坐标
		int OrgY;
		Color BorderColor;//边界颜色
		int BorderType;//边界线型--实线、虚线、虚点线等
		int BorderWidth;//边界宽度
		Color FillColor;//填充颜色
		int FillType;//填充类型--实心、双对角、十字交叉等
	};
	//=======
	public abstract class CSquare extends CShape
	{
		public CSquare(){}
		public CSquare(int x, int y, int w) 
		{
			OrgX=x;//原点坐标
			OrgY=y;
			BorderColor=Color.BLACK;//边界颜色
			BorderType=BasicStroke.CAP_BUTT;//边界线型--实线、虚线、虚点线等
			BorderWidth=1;//边界宽度
			FillColor=Color.BLACK;//填充颜色
			FillType=BasicStroke.CAP_BUTT;//填充类型--实心、双对角、十字交叉等
			width=w;
		}
		public void Draw(Graphics g)
		{
				g.drawRect(OrgX, OrgY, width, width);
				g.fillRect(OrgX, OrgY, width, width);
				g.setColor(BorderColor);
		}//绘制正方形
		public void SetValue(ElementType t,int X,int Y,int Width,int height)
		{
			Type=t;
			OrgX=X;
			OrgY=Y;
			width=Width;
		}
		public void GetValue(ElementType t,int x,int y,int width,int height)
		{
			t=Type;
			x=OrgX;
			y=OrgY;
		}
		private int width;
	};
	//==========
	public abstract class CRectangle extends CShape
	{
		public CRectangle() {}
		public CRectangle(int x, int y, int w, int l) 
		{
			Type=ElementType.RECTANGLE;
			OrgX=x;//原点坐标 nbb 
			OrgY=y;
		}
		public void Draw(Graphics g)
		{
			g.drawRect(OrgX, OrgY, width, height);
			g.fillRect(OrgY, OrgY, width, height);
			g.setColor(BorderColor);
		}
		public void SetValue(ElementType t,int x,int y,int width,int height) 
		{
			Type=t; 
			OrgX=x;
			OrgY=y;
		}
		public void GetValue(ElementType t,int x,int y,int w,int h) 
		{
			t=Type;
			x=OrgX;
			y=OrgY;
			w=width;
			h=height;
		}
		private int width;
		private int height;
	};
	//=====
	public abstract class CTriangle extends CShape
	{
		public CTriangle() {}
		public CTriangle(int x, int y, int w)
		{
			Type=ElementType.TRIANGLE;
			OrgX=x;//原点坐标
			OrgY=y;
			BorderColor=Color.black;//边界颜色
			BorderType=FillType;//边界线型--实线、虚线、虚点线等
			BorderWidth=1;//边界宽度
			FillColor=Color.blue;//填充颜色
			FillType=BasicStroke.CAP_BUTT;//填充类型--实心、双对角、十字交叉等
		}
		public void Draw(Graphics g) 
		{
			int px1[]={50,400,450};
			int py1[]={50,100,200};
			g.drawPolygon(px1,py1,3);
			g.fillPolygon(px1, py1, 3);
			g.setColor(BorderColor);
		}//绘制三角形    
		public void SetValue(ElementType t,int X,int Y,int W,int height) 
		{
			Type=t; 
			OrgX=X;
			OrgY=Y;
			width=W;
		}
		public void GetValue(ElementType t,int x,int y,int width,int height)
		{
			t=Type;
			x=OrgX;
			y=OrgY;
		}
		private int width;
	};
	
	///========
	public abstract class CCircle extends CShape
	{
	public CCircle() {}
	public CCircle(int x, int y, int r) 
	{
		Type=ElementType.CIRCLE;
		OrgX=x;//原点坐标
		OrgY=y;
	}
	public void Draw(Graphics g)
	{
	   g.drawOval(OrgX, OrgY, radius, radius);
	   g.fillOval(OrgX, OrgY, radius, radius);
	   g.setColor(BorderColor);
	}//绘制圆   
	public void SetValue(ElementType t,int x,int y,int w,int height) 
	{
		Type=t;
		OrgX=x;
		OrgY=y;
		radius=w;
	}
	public void GetValue(ElementType t,int x,int y,int width,int height)
	{
		t=Type;
		x=OrgX;
		y=OrgY;
		width=radius;
	}
	private int radius;
	};
	////===========
	public abstract class CEllipse extends CShape
	{
		public CEllipse() {}
		public CEllipse(int x, int y, int sa, int sb) 
		{
			Type=ElementType.ELLIPSE;
			OrgX=x;//原点坐标
			OrgY=y;
		}
		public void Draw(Graphics g)
		{
			g.drawOval(OrgX, OrgY, width, height);
			g.fillOval(OrgX, OrgY, width, height);
			g.setColor(BorderColor);
		}//绘制椭圆   
		public void SetValue(ElementType t,int x,int y,int w,int h)
		{
			Type=t; OrgX=x;OrgY=y;radiusa=w;radiusb=h;
		}
		public void GetValue(ElementType t,int x,int y,int width,int height) 
		{
			t=Type;x=OrgX;y=OrgY;width=radiusa;height=radiusb;
		}
		private int radiusa;
		private int radiusb;
	};
	//=======
	public abstract class CText extends CShape
	{
		public CText() {};
		public CText(int x, int y, int h, int a, String t)
		{
			Type=ElementType.TEXT;
			OrgX=x;//原点坐标
			OrgY=y;
		}
		public void Draw(Graphics g)
		{
			g.drawString(text, OrgX, OrgY);
			g.setColor(BorderColor);	
		}//绘制文档   
		public void SetValue(ElementType t,int x,int y,int w,int h) 
		{
			Type=t;
			OrgX = x;
			OrgY = y;
			angle = w;
			height = h;
		}
		public void GetValue(ElementType t, int x, int y, int w, int h) 
		{
			t = Type;
			x = OrgX;
			y = OrgY;
			w = angle;
			h = height;
		}
		
		public void GetText(String a) 
		{
			text=a;
		}
		public void SetText(String a) 
		{
			a=text;
		}
		private int height;
		private int angle;
		private String text;
	};
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
