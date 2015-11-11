package test.zhangdy.interview;

public class CodeDetecting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 7.
	 * me: "J2EE-and-J2SE\J2SE\javase-specification8.pdf\ 8.3.1.2"
		final 域
		域可以被声明为 final。类和实例变量（static 和 非 static 域）都可以声明为 fianl。
		blank final 类变量必须被明确地赋值，否则发生编译时错误。
		blank final 实例变量必须在类的构造器结束之前被明确地赋值，否则编译错误。
		（总之 final 修饰的类变量和实例变量没有默认值，必须被显式地赋值）
	 */
	final int i;
	public void seven(){
		System.out.println("i = "+ i);//compile-error. The blank final field i may not have been initialized
	}
	
}

/**
 * 11.
 * @author Administrator
 *
 */
interface Playable {
    void play();
}
interface Bounceable {
    void play();
}
interface Rollable extends Playable, Bounceable {
    Ball ball = new Ball("PingPang");
}
class Ball implements Rollable {
    private String name;
    public String getName() {
        return name;
    }
    public Ball(String name) {
        this.name =name;        
    }
   public void play() {
        ball = new Ball("Football");//Compile-erro:The final field Rollable.ball cannot be assigned
        System.out.println(ball.getName());
    }
}