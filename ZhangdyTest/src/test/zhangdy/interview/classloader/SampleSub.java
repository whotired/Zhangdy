package test.zhangdy.interview.classloader;

import test.zhangdy.interview.classloader.Sample;

public class SampleSub extends Sample {

	void call(){
		this.protectedMethod();
		super.protectedMethod(); 
		this.packageMethod();
		super.packageMethod();
	}
	public static void main(String[] args){
		Sample s = new SampleSub();
		s.protectedMethod();
		s.packageMethod();
	}
}
