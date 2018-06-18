import dataAccess.FakeDBHandler;
import dataSet.EColor;
import dataSet.EFruitType;
import dataSet.Form;

public class Main {

	public static void main(String[] args)
	{
		
		System.out.println("Get fruits heavier than 50:");
		Form forms[] = FakeDBHandler.getInstance().GetFormsByFunc((Form T) -> {return T.getWeight() > 50;});
		
		for (int i = 0; i < forms.length; i++) {
			System.out.println(forms[i].getFruitType() + "	| " + forms[i].getColor() + "	| weight: " + forms[i].getWeight());
		}
		
		System.out.println("\nGet Pears:");
		forms = FakeDBHandler.getInstance().GetFormsByFunc((Form T) -> {return T.getFruitType() == EFruitType.Pear;});
		
		for (int i = 0; i < forms.length; i++) {
			System.out.println(forms[i].getFruitType() + "	| " + forms[i].getColor() + "	| weight: " + forms[i].getWeight());
		}
		
		System.out.println("\nGet Green fruits:");
		forms = FakeDBHandler.getInstance().GetFormsByFunc((Form T) -> {return T.getColor() == EColor.Green;});
		
		for (int i = 0; i < forms.length; i++) {
			System.out.println(forms[i].getFruitType() + "	| " + forms[i].getColor() + "	| weight: " + forms[i].getWeight());
		}
	}
}
