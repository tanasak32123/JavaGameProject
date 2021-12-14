package entity;

public class Elemental {

	public static String getType(Maincharacter cha) {
		switch (cha.getType()) {
		case fire:
			return "F";
		case glob:
			return "G";
		case water:
			return "W";
		}
		return null;
	}

}
