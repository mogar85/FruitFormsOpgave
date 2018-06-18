package dataAccess;

import dataSet.EFruitType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import dataSet.EColor;
import dataSet.Form;

public class FakeDBHandler {
	private static FakeDBHandler instance;
	private Form[] data;

	public  static FakeDBHandler getInstance() {
		if (instance == null)
			instance = new FakeDBHandler();
		return instance;
	}

	public FakeDBHandler() {
		GenerateData();
	}

	private void GenerateData() {
		data = new Form[4];
		
		data[0] = CreateFrom(EFruitType.Apple, EColor.Red, 100);
		data[1] = CreateFrom(EFruitType.Apple, EColor.Green, 75);
		data[2] = CreateFrom(EFruitType.Pear, EColor.Red, 50);
		data[3] = CreateFrom(EFruitType.Pear, EColor.Green, 25);
	}

	private Form CreateFrom(EFruitType fruitType, EColor color, int weight) {
		// Alternatively, a constructor could be added to Form
		Form form = new Form();
		form.setFruitType(fruitType);
		form.setColor(color);
		form.setWeight(weight);
		return form;
	}
 
	public Form[] GetFormsByFunc(Function<Form,Boolean> func)
	{
		List<Form> list = new ArrayList<Form>();
		for	(int i = 0; i < data.length; i++)
		{
			if (func.apply(data[i]))
			{
				list.add(data[i]);
			}
		}
		
		return (Form[]) list.toArray(new Form[list.size()]);
	}
}
