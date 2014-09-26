package xtu.cie.ldj;

import java.util.ArrayList;

public class MaxPointsOnALine {
	
	static class Point {
		public int x;
		public int y;
		Point() {	x = 0;	y = 0;	}
		Point(int a, int b) {	x = a;	y = b;	}
	}
	
	static class ShapeCount {
		public Point p;
		public int count;
		
		public ShapeCount(Point p) {
			// TODO Auto-generated constructor stub
			this.p = p;
			count = 1;			//添加的Point本身算一个
		}
	}

	public static int maxPoints(Point[] points) {
		if (points.length <= 2) return points.length;
		
		int maxPs = 2;
		for (int i = 0; i < points.length; i++) {
			int theSameP = 1;			// Point本身算一个
			Point p0 = points[i];
			
			ArrayList<ShapeCount> arrayList = new ArrayList<ShapeCount>();
			
			for (int j = i + 1; j < points.length; j++) {
				Point p1 = points[j];
				if (p1.x == p0.x && p1.y == p0.y) {
					theSameP ++;		// 相同的Point的个数+1
					continue;
				}
				
				boolean flag = false;
				for (int k = 0; k < arrayList.size(); k++) {
					// 在链表中找到斜率相同的
					if (isInALine(p0, arrayList.get(k).p, p1)) {
						arrayList.get(k).count += 1;
						flag = true;
						break;
					}
				}
				if (!flag) {
					//链表中没有该斜率的，则将该斜率对应的点添加到链表中
					ShapeCount sc = new ShapeCount(p1);
					arrayList.add(sc);
				}
			}
			
			int max = 0;
			for (int j = 0; j < arrayList.size(); j++) {
				if (max < arrayList.get(j).count) 
					max = arrayList.get(j).count;
			}
			
			if (maxPs < max + theSameP) {
				maxPs = max + theSameP;
			}
		}
		
		return maxPs;
	}

	public static boolean isInALine(Point p1, Point p2, Point p3) {
		
		if ((p1.x == p2.x && p1.y == p2.y) || (p1.x == p3.x && p1.y == p3.y)
				|| (p3.x == p2.x && p3.y == p2.y)) {
			return true;
		}
		
		boolean flag = false;
		//judge k
		if (((p2.y - p1.y) * (p3.x - p1.x)) == ((p3.y - p1.y) * (p2.x - p1.x)))
			//judge b
			if(((p1.y*p2.x - p2.y*p1.x)*(p3.x-p1.x)) == ((p1.y*p3.x-p3.y*p1.x)*(p2.x-p1.x)))
				flag = true;
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test data
		//12
		Point[] p0 = new Point[]{new Point(0,9),new Point(138,429),new Point(115,359),new Point(115,359),
				new Point(-30,-102),new Point(230,709),new Point(-150,-686),new Point(-135,-613),
				new Point(-60,-248),new Point(-161,-481),new Point(207,639),new Point(23,79),
				new Point(-230,-691),new Point(-115,-341),new Point(92,289),new Point(60,336),
				new Point(-105,-467),new Point(135,701),new Point(-90,-394),new Point(-184,-551),
				new Point(150,774)};
		
		//10
		Point[] p1 = new Point[]{new Point(-54,-297),new Point(-36,-222),new Point(3,-2),new Point(30,53),
				new Point(-5,1),new Point(-36,-222),new Point(0,2),new Point(1,3),
				new Point(6,-47),new Point(0,4),new Point(2,3),new Point(5,0),
				new Point(48,128),new Point(24,28),new Point(0,-5),new Point(48,128),
				new Point(-12,-122),new Point(-54,-297),new Point(-42,-247),new Point(-5,0),
				new Point(2,4),new Point(0,0),new Point(54,153),new Point(-30,-197),
				new Point(4,5),new Point(4,3),new Point(-42,-247),new Point(6,-47),
				new Point(-60,-322),new Point(-4,-2),new Point(-18,-147),new Point(6,-47),
				new Point(60,178),new Point(30,53),new Point(-5,3),new Point(-42,-247),
				new Point(2,-2),new Point(12,-22),new Point(24,28),new Point(0,-72),
				new Point(3,-4),new Point(-60,-322),new Point(48,128),new Point(0,-72),
				new Point(-5,3),new Point(5,5),new Point(-24,-172),new Point(-48,-272),
				new Point(36,78),new Point(-3,3)};
		
		//25
		Point[] p2 = new Point[]{new Point(40,-23),new Point(9,138),new Point(429,115),
				new Point(50,-17),new Point(-3,80),new Point(-10,33),new Point(5,-21),
				new Point(-3,80),new Point(-6,-65),new Point(-18,26),new Point(-6,-65),
				new Point(5,72),new Point(0,77),new Point(-9,86),new Point(10,-2),
				new Point(-8,85),new Point(21,130),new Point(18,-6),new Point(-18,26),
				new Point(-1,-15),new Point(10,-2),new Point(8,69),new Point(-4,63),
				new Point(0,3),new Point(-4,40),new Point(-7,84),new Point(-8,7),
				new Point(30,154),new Point(16,-5),new Point(6,90),new Point(18,-6),
				new Point(5,77),new Point(-4,77),new Point(7,-13),new Point(-1,-45),
				new Point(16,-5),new Point(-9,86),new Point(-16,11),new Point(-7,84),
				new Point(1,76),new Point(3,77),new Point(10,67),new Point(1,-37),
				new Point(-10,-81),new Point(4,-11),new Point(-20,13),new Point(-10,77),
				new Point(6,-17),new Point(-27,2),new Point(-10,-81),new Point(10,-1),
				new Point(-9,1),new Point(-8,43),new Point(2,2),new Point(2,-21),
				new Point(3,82),new Point(8,-1),new Point(10,-1),new Point(-9,1),
				new Point(-12,42),new Point(16,-5),new Point(-5,-61),new Point(20,-7),
				new Point(9,-35),new Point(10,6),new Point(12,106),new Point(5,-21),
				new Point(-5,82),new Point(6,71),new Point(-15,34),new Point(-10,87),
				new Point(-14,-12),new Point(12,106),new Point(-5,82),new Point(-46,-45),
				new Point(-4,63),new Point(16,-5),new Point(4,1),new Point(-3,-53),
				new Point(0,-17),new Point(9,98),new Point(-18,26),new Point(-9,86),
				new Point(2,77),new Point(-2,-49),new Point(1,76),new Point(-3,-38),
				new Point(-8,7),new Point(-17,-37),new Point(5,72),new Point(10,-37),
				new Point(-4,-57),new Point(-3,-53),new Point(3,74),new Point(-3,-11),
				new Point(-8,7),new Point(1,88),new Point(-12,42),new Point(1,-37),
				new Point(2,77),new Point(-6,77),new Point(5,72),new Point(-4,-57),
				new Point(-18,-33),new Point(-12,42),new Point(-9,86),new Point(2,77),
				new Point(-8,77),new Point(-3,77),new Point(9,-42),new Point(16,41),
				new Point(-29,-37),new Point(0,-41),new Point(-21,18),new Point(-27,-34),
				new Point(0,77),new Point(3,74),new Point(-7,-69),new Point(-21,18),
				new Point(27,146),new Point(-20,13),new Point(21,130),new Point(-6,-65),
				new Point(14,-4),new Point(0,3),new Point(9,-5),new Point(6,-29),
				new Point(-2,73),new Point(-1,-15),new Point(1,76),new Point(-4,77),
				new Point(6,-29)};
		//3
		Point[] p3 = new Point[]{new Point(1,1),new Point(1,1),new Point(1,1)};
		
		System.out.println("p0 --> 12 -->" + maxPoints(p0));
		System.out.println("p1 --> 30 -->" + maxPoints(p1));
		System.out.println("p2 --> 25 -->" + maxPoints(p2));
		System.out.println("p3 --> 3 -->" + maxPoints(p3));
	}
}
