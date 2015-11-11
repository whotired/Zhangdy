package test.zhangdy.interview.classloader;


public class Sample { 
    private Sample instance; 

    public void setSample(Object instance) { 
        this.instance = (Sample) instance; 
    } 
    
    
    protected void protectedMethod(){
    	System.out.println("This is a protected method.");
    }
    void packageMethod(){
    	System.out.println("This is a package-private method.");
    }
 }
