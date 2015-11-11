package test.zhangdy.interview;

import test.zhangdy.interview.classloader.Sample;

public class SampleSub extends Sample {

	void call(){
		this.protectedMethod();
		super.protectedMethod();
	}
	public static void main(String[] args){
		Sample s = new SampleSub();
		
	}
}
