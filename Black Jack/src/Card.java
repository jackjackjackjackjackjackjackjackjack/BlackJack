

public class Card
	{
		String Suit;
		String Number;
		int Value;
		public Card (String s, String n, int v)
			{
			Suit = s;
			Number = n;
			Value = v;
			}
		public String getSuit()
			{
				return Suit;
			}
		public void setSuit(String suit)
			{
				this.Suit = Suit;
			}
		public String getNumber()
			{
				return Number;
			}
		public void setNumber(String number)
			{
				this.Number = Number;
			}
		public int getValue()
			{
				return Value;
			}
		public void setValue(int value)
			{
				this.Value = Value;
			}
	}
