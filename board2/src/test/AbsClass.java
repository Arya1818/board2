package test;

import java.util.ArrayList;
import java.util.List;

class TestClass extends AbsClass{ //추상클래스를 상속받음

	@Override
	public void test() {
		
	}
	
}


public abstract class AbsClass {
	
	public abstract void test(); //나중에 만들려고~ 선언만 할 수 있음.. 메모리생성 안됨..
	
	public static void main(String[] args) {
		AbsClass aa = new TestClass();
		AbsClass ab = new TestClass();
		AbsClass ac = new TestClass();
		
		List<AbsClass> acList = new ArrayList<>(); //메모리생성
		acList.add(new TestClass());
		acList.add(aa);
		acList.add(ab);
		acList.add(ac);
	}
}
