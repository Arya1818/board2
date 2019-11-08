package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human {
	private int age;
	private int height;

	public Human(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", height=" + height + "]";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
class Compare<T> implements Comparator<T>{ // <T> 타입이 들어갈 것이라고 정해져있음./타입간의비교->t/key-value->kv/구성원비교->e

	@Override
	public int compare(T o1, T o2) {
		Human h1 = (Human)o1;
		Human h2 = (Human)o2;
		if(h1.getAge()<h2.getAge()) {
			return -1; //비교하는값이 크면 -1, 같으면0, 작으면 1을 반환
		}
		if(h1.getAge()>h2.getAge()) {
			return 1;
		}
		return 0;
	}
	
}
public class Test2 {

	public static void main(String[] args) {
		List<Human> hList = new ArrayList<>();
//		Human h = new Human();
		hList.add(new Human(10, 140));
		hList.add(new Human(23, 185));
		hList.add(new Human(27, 158));
		hList.add(new Human(25, 165));
		hList.add(new Human(55, 160));
		Collections.sort(hList, new Compare<Human>());
		
//		System.out.println(hList);
	}
}