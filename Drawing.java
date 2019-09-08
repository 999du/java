import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
//
public class Drawing {
	
	enum ElementType { NOTSET, SQUARE, RECTANGLE, CIRCLE, ELLIPSE, TRIANGLE, TEXT };
	//����CShape�࣬
	public abstract class CShape
	{
		public abstract void Draw(Graphics g);//����ͼԪ
		public abstract void SetValue(ElementType t,int x,int y,int width,int height);//�������ݳ�Ա
		public abstract void GetValue(ElementType t,int x,int y,int width,int height);//��ȡ���ݳ�Ա��ֵ
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

		ElementType Type;//ͼԪ����
		int OrgX;//ԭ������
		int OrgY;
		Color BorderColor;//�߽���ɫ
		int BorderType;//�߽�����--ʵ�ߡ����ߡ�����ߵ�
		int BorderWidth;//�߽���
		Color FillColor;//�����ɫ
		int FillType;//�������--ʵ�ġ�˫�Խǡ�ʮ�ֽ����
	};
	//=======
	public abstract class CSquare extends CShape
	{
		public CSquare(){}
		public CSquare(int x, int y, int w) 
		{
			OrgX=x;//ԭ������
			OrgY=y;
			BorderColor=Color.BLACK;//�߽���ɫ
			BorderType=BasicStroke.CAP_BUTT;//�߽�����--ʵ�ߡ����ߡ�����ߵ�
			BorderWidth=1;//�߽���
			FillColor=Color.BLACK;//�����ɫ
			FillType=BasicStroke.CAP_BUTT;//�������--ʵ�ġ�˫�Խǡ�ʮ�ֽ����
			width=w;
		}
		public void Draw(Graphics g)
		{
				g.drawRect(OrgX, OrgY, width, width);
				g.fillRect(OrgX, OrgY, width, width);
				g.setColor(BorderColor);
		}//����������
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
			OrgX=x;//ԭ������ nbb 
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
			OrgX=x;//ԭ������
			OrgY=y;
			BorderColor=Color.black;//�߽���ɫ
			BorderType=FillType;//�߽�����--ʵ�ߡ����ߡ�����ߵ�
			BorderWidth=1;//�߽���
			FillColor=Color.blue;//�����ɫ
			FillType=BasicStroke.CAP_BUTT;//�������--ʵ�ġ�˫�Խǡ�ʮ�ֽ����
		}
		public void Draw(Graphics g) 
		{
			int px1[]={50,400,450};
			int py1[]={50,100,200};
			g.drawPolygon(px1,py1,3);
			g.fillPolygon(px1, py1, 3);
			g.setColor(BorderColor);
		}//����������    
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
		OrgX=x;//ԭ������
		OrgY=y;
	}
	public void Draw(Graphics g)
	{
	   g.drawOval(OrgX, OrgY, radius, radius);
	   g.fillOval(OrgX, OrgY, radius, radius);
	   g.setColor(BorderColor);
	}//����Բ   
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
			OrgX=x;//ԭ������
			OrgY=y;
		}
		public void Draw(Graphics g)
		{
			g.drawOval(OrgX, OrgY, width, height);
			g.fillOval(OrgX, OrgY, width, height);
			g.setColor(BorderColor);
		}//������Բ   
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
			OrgX=x;//ԭ������
			OrgY=y;
		}
		public void Draw(Graphics g)
		{
			g.drawString(text, OrgX, OrgY);
			g.setColor(BorderColor);	
		}//�����ĵ�   
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
		// TODO �Զ����ɵķ������

	}

}
