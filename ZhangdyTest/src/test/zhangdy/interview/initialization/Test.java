package test.zhangdy.interview.initialization;


class Super {
	static {System.out.print("Super ");}
}

class One {
	static {System.out.print("One ");}
}

class Two extends Super {
	static {System.out.print("Two ");}
	int i = 100;
	int j = 500;
	Two(){
		this(10000);
		i=1000;
	}
	Two(int x){
		i = x;
	}
}

class Test {
	public static void main(String[] args) {
		One o = null;
		Two t = new Two();
		System.out.println((Object) o == (Object) t);
		System.out.println(t.i);
	}
}
