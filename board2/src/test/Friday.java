package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Friday {
	public static void main(String[] args) {
		List<Human> hList = new ArrayList<>();
		hList.add(new Human(10, 140));
		hList.add(new Human(23, 185));
		hList.add(new Human(27, 158));
		hList.add(new Human(25, 165));
		hList.add(new Human(55, 160));
		Collections.sort(hList, new Compare<Human>());
		System.out.println(hList);
	}
}